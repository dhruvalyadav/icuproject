import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { WebClient } from '../web-client';
import html2pdf from 'html2pdf.js';
import * as XLSX from 'xlsx';
import * as FileSaver from 'file-saver';



@Component({
  selector: 'app-url',
  standalone: false,

  templateUrl: './url.component.html',
  styleUrls: ['./url.component.scss']
})
export class UrlComponent implements OnInit {
  patientId: number = 0;
  patient: any = null;
  icu: any = null;
  anthropometry: any = null;
  ivFluids: any[] = [];
  shiftrmo: any[] = [];
  shiftMap: { [key: number]: any } = {};
  patientAdmissionData: any=null;
  currentDate: Date = new Date(); 
  calculateDaysBetween(startDate: string | Date, endDate: string | Date): number {
  const start = new Date(startDate);
  const end = new Date(endDate);
  const diff = end.getTime() - start.getTime();
  return Math.ceil(diff / (1000 * 60 * 60 * 24)); 
  
}
hours: string[] = [];
hourlyVitals: any[] = []; 



hourlyVitalsGrouped: { [category: string]: any[] } = {};
groupedCategories: string[] = [];


  constructor(
    private route: ActivatedRoute,
    private webclient: WebClient,
    private cdr: ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get("id");
    this.patientId = id ? +id : 0;

    if (this.patientId > 0) {
      this.fetchPatientDetails(this.patientId);
      this.fetchAnthropometry(this.patientId);
      this.fetchPatientVentilators(this.patientId);
      this.fetchHourlyVitals(this.patientId);
      this.fetchShiftRmoNurseData(this.patientId);
      this.fetchPatientAdditonalScores(this.patientId);
      this.fetchEmbolism(this.patientId);
      this.fetchInfusionChart(this.patientId);
      this.fetchSosMedications(this.patientId);
      this.fetchMedicationLogs(this.patientId);
      this.fetchPatientAdditionalTests(this.patientId);
      this.fetchPatientLineTubes(this.patientId);
      this.fetchIvFluids(this.patientId);
     
    }
     this.hours = Array.from({ length: 24 }, (_, i) => `${i.toString().padStart(2, '0')}:00`);
  }

  fetchPatientDetails(id: number): void {
    this.webclient.get<any>(`getpatientadmissionbypatient/${id}`)
      .then((data: any) => {
        this.patient = data.patient;
         this.icu= data.icu;
           //console.log('ICU ID:', icu?.icuid); 
           this.patientAdmissionData = {
        admissiondate: data.admissiondate,
        icuadmissiondate: data.icuadmissiondate,
        createddate: data.createddate
      };
        if (this.icu?.icuid) {
         // console.log("Calling fetchShiftRmoNurseData with ICU ID:", data.icu.icuid);
          this.fetchShiftRmoNurseData(this.icu.icuid);
        }
      })
      .catch((err: any) => {
        console.error('Error fetching patient data:', err);
      });
  }

anthropometryColumns: { key: string; label: string }[] = [];

fetchAnthropometry(patientId: number): void {
  this.webclient.getObservable<any[]>(`anthropometry/${patientId}`).subscribe({
    next: (data) => {
      if (data.length > 0) {
        this.anthropometry = data[0]; // Only show latest or first entry

        const selectedFields = ['weight', 'height', 'bmi', 'bsaboyd'];
        this.anthropometryColumns = selectedFields.map(key => ({
          key,
          label: this.formatLabel(key)
        }));
      }
    },
    error: (err) => {
      console.error('Error fetching anthropometry data:', err);
    }
  });
}

  //patient ventilators
  patientVentilators: any[] = [];
  ventilatorColumns: { key: string; label: string }[] = [];
  fetchPatientVentilators(patientId: number): void {
  this.webclient.getObservable<any[]>(`getventilatorbypatient/${patientId}`).subscribe({
    next: (data) => {
      this.patientVentilators = data;

      const selectedFields = [
        'fio2', 'peepcpap', 'rate', 'tv', 'ppeak',
        'mv', 'spo2', 'cuffpressure', 'epap', 'peakinsppressure', 'plateaupressure'
      ];

      if (this.patientVentilators.length > 0) {
        this.ventilatorColumns = selectedFields.map(key => ({
          key,
          label: this.formatLabel(key)
        }));
      }
    },
    error: (err) => {
      console.error('Error fetching ventilator data:', err);
    }
  });
}


 fetchShiftRmoNurseData(icuId: number): void {
  //console.log("shift RMO nurse for ICU ID:", icuId);
  this.webclient.getObservable<any[]>(`getbyicu/${icuId}`).subscribe({
    next: (data) => {
      //console.log("shift RMO nurse data:", data);
      this.shiftrmo = data;
      this.shiftMap = {};
      for (let entry of data) {
        //console.log(" entry:", entry);
        if (entry.shift != null) {
          this.shiftMap[entry.shift] = entry;
        }
      }
      //console.log("shiftMap:", this.shiftMap);
    },
    error: (err) => {
      console.error("Error fetching shift RMO nurse data:", err);
    }
  });
}

  //patient infusion
  infusionList: any[] = [];
  infusionColumns: { key: string; label: string }[] = [];
  
  fetchInfusionChart(patientId: number): void {
  this.webclient.getObservable<any[]>(`patientinfusion/${patientId}`).subscribe({
    next: (data) => {
      this.infusionList = data;
      const field = [{ key: 'fluidname', label: 'Fluid Name' },
        { key: 'fluidvolume', label: 'Fluid Volume (ml)' },
        { key: 'ivmedication', label: 'IV Medication' },
        { key: 'dose', label: 'Dose (mg)' },
        { key: 'rate', label: 'Rate (ml/hr)' },
        { key: 'starttime', label: 'Start Time' },
        { key: 'endtime', label: 'End Time' },
        { key: 'preparedby.name', label: 'Prepared By' }];

    if (this.infusionList.length > 0) {
       this.infusionColumns = field;
      }
    },
    error: (err)=>{
      console.log('Error fetching infsuin chart: ',err)
    }
  });
}
getValue(obj: any, path: string): any {
  return path.split('.').reduce((acc, part) => acc && acc[part], obj);
}

  // patient additonal score
  patientScores: any[] = [];
  scoreColumns: { key: string; label: string }[] = [];
  fetchPatientAdditonalScores(id: Number): void{
    this.webclient.getObservable<any[]>(`patientadditonalscores/${this.patientId}`).subscribe({
      next: (data) => {
        this.patientScores = data;

        const selectedFeilds = ['qsofa', 'mews', 'apacheiv'];

        if (this.patientScores.length > 0){
          this.scoreColumns = selectedFeilds.map(key => ({
            key,
            label: this.formatLabel(key)
          }));
        }
      },
      error: (err) => {
        console.log("Error fetching patient scores:", err);
      }
    });
  }

  //embolism
  embolism: any[] = [];
  embolismColumns: { key: string; label: string }[] = [];
  fetchEmbolism(id: number): void{
    this.webclient.getObservable<any[]>(`embolism/${id}`).subscribe(({
      next: (data) =>{
        this.embolism = data;

        const selectedFields = ['dvtrisk', 'anticoagulation', 'compression'];

        if(this.embolism.length>0){
          this.embolismColumns = selectedFields.map(key =>({
            key,
            label: this.formatLabel(key)
          }));
        }
      },
      error: (err) =>{
        console.log("Error fetching embolism data", err);
      }
    }))
  }

  //patient sos medication
  sosMedications: any[] = [];
sosColumns: { key: string; label: string }[] = [];
 fetchSosMedications(patientId: number): void {
  this.webclient.getObservable<any[]>(`sosmedication/${patientId}`).subscribe({
    next: (data) => {
      this.sosMedications = data;

      if (this.sosMedications.length > 0) {
        this.sosColumns = [
          { key: 'indication', label: 'Indication' },
          { key: 'drug', label: 'Drug' },
          { key: 'dose', label: 'Dose' },
          { key: 'route', label: 'Route' },
          { key: 'time', label: 'Time' },
          { key: 'telephoneverbal', label: 'Verbal/Phone' },
          { key: 'administeredby.name', label: 'Administered By' },
          { key: 'orderedbydoctor.name', label: 'Ordered By' }
        ];
      }
    },
    error: (err) => {
      console.error('Error fetching SOS medication data:', err);
    }
  });
}

// patient medication chart
medicationLogs: any[] = [];
medicationLogColumns: { key: string; label: string }[] = [];
fetchMedicationLogs(patientId: number): void {
  this.webclient.getObservable<any[]>(`medicationlog/${patientId}`).subscribe({
  next: (data) => {
    this.medicationLogs = data;
    this.medicationLogColumns = [
      { key: 'drug', label: 'Drug' },
      { key: 'dose', label: 'Dose' },
      { key: 'route', label: 'Route' },
      { key: 'administrationtime', label: 'Administration Time' },
      { key: 'administeredby.name', label: 'Signature' }
    ];
  },
  error: (err) => {
    console.error('Error fetching medication logs:', err);
  }
});
}

// ivfliuds
patientAdditionalTests: any[] = [];
additionalTestColumns: { key: string; label: string }[] = [];

fetchPatientAdditionalTests(patientId: number): void {
  this.webclient.getObservable<any[]>(`additionaltest/${patientId}`).subscribe({
    next: (data) => {
      this.patientAdditionalTests = data;

      this.additionalTestColumns = [
        { key: 'physiothearpy.physiothearpy', label: 'Physiotherapy' },
        { key: 'ambulation', label: 'Ambulation' },
        { key: 'incentivespirometry', label: 'Incentivespirometry' },
        { key: 'belt', label: 'Belt' },
        { key: 'dressing', label: 'Dressing'},
        { key: 'trachettsectretion', label: 'trachettsectretion'},
      ];
    },
    error: (err) => {
      console.error('Error fetching patient additional tests:', err);
    }
  });
}

// patientlines and tubes
patientLineTubes: any[] = [];
lineTubeColumns: { key: string; label: string }[] = [];

fetchPatientLineTubes(patientId: number): void {
  this.webclient.getObservable<any[]>(`linestubes/${patientId}`).subscribe({
    next: (data) => {
      this.patientLineTubes = data;

      this.lineTubeColumns = [
        { key: 'linestubes.linestubesname', label: 'Line/Tube Name' },
        { key: 'site', label: 'Site' },
        { key: 'dateofinsertion', label: 'Insertion Date' }
      ];
    },
    error: (err) => {
      console.error('Error fetching line/tube data:', err);
    }
  });
}

// ivfliuds
fetchIvFluids(patientId: number): void {
  this.webclient.getObservable<any[]>(`getivfluidsbypatient/${patientId}`).subscribe({
    next: (data) => {
      this.ivFluids = data;
    },
    error: (err) => {
      console.error("Error fetching IV Fluids:", err);
    }
  });
}

fetchHourlyVitals(id: number): void {
  this.webclient.getObservable<any[]>(`gethourlyvitalsbypatient/${id}`).subscribe({
    next: (data) => {
      // Ensure each vital has a data map
      this.hourlyVitals = data.map(vital => ({
        ...vital,
        data: vital.data || {} // fallback in case API gives null/undefined
      }));

      // Group vitals by category
     this.hourlyVitalsGrouped = this.hourlyVitals.reduce((acc: { [key: string]: any[] }, item: any) => {
  const category = item.vitalcategory || 'Uncategorized';
  if (!acc[category]) acc[category] = [];
  acc[category].push(item);
  return acc;
}, {});
      // Store the list of categories
    this.groupedCategories = Object.keys(this.hourlyVitalsGrouped);
    },
    error: (err) => {
      console.error("Error fetching hourly vitals:", err);
    }
  });
}

formatLabel(key: string): string {
  return key
    .replace(/([a-z])([A-Z])/g, '$1 $2')
    .replace(/_/g, ' ')
    .replace(/\b\w/g, l => l.toUpperCase());
}


// Download in pdf fromat

downloadPdf(): void{
  const element = document.getElementById('report-content');
  if(element){
    const opt = {
      margin: 0.5,
      filename: `Patient-report-${this.patient.patientname || 'unknown'}.pdf`,
      image:{ type: 'jpeg', quality: 0.98 },
      html2canvas:{ scale: 4 },
      jsPDF:{ unit: 'in', format: 'a4', orientation: 'landscape' }
    };
    html2pdf().set(opt).from(element).save();
  }else{
    console.error('Report content not found');
  }
}
exportToExcel(): void {
  const reportName = `Patient_Report_${this.patient?.patientname || 'Unknown'}`;

  // Combine all tables into a single workbook
  const workbook = XLSX.utils.book_new();

  const addSheet = (data: any[], title: string) => {
    if (data && data.length > 0) {
      const flatData = data.map(row => {
        const flatRow: any = {};
        for (const key in row) {
          if (typeof row[key] === 'object' && row[key] !== null) {
            for (const subKey in row[key]) {
              flatRow[`${key}.${subKey}`] = row[key][subKey];
            }
          } else {
            flatRow[key] = row[key];
          }
        }
        return flatRow;
      });
      const worksheet = XLSX.utils.json_to_sheet(flatData);
      XLSX.utils.book_append_sheet(workbook, worksheet, title);
    }
  };

  addSheet(this.patientAdmissionData, 'Admission Data');
  addSheet(this.infusionList, 'Infusion');
  addSheet(this.patientScores, 'Additional Scores');
  addSheet(this.embolism, 'Embolism');
  addSheet(this.sosMedications, 'SOS Medication');
  addSheet(this.medicationLogs, 'Medication Chart');
  addSheet(this.patientAdditionalTests, 'Additional Tests');
  addSheet(this.patientLineTubes, 'Lines & Tubes');
  addSheet(this.patientVentilators, 'Ventilators');
  addSheet(this.ivFluids, 'IV Fluids');
  addSheet(this.shiftrmo, 'Shift RMO');
  addSheet(this.hourlyVitals, 'Hourly Charts');

  const excelBuffer = XLSX.write(workbook, { bookType: 'xlsx', type: 'array' });
  const blob = new Blob([excelBuffer], { type: 'application/octet-stream' });

  FileSaver.saveAs(blob, `${reportName}.xlsx`);
}


}


