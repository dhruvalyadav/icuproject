
import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { WebClient } from '../web-client';

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
  ventilators: any[] = [];
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
      this.fetchVentilators(this.patientId);
       this.fetchHourlyVitals(this.patientId);
     
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

  fetchAnthropometry(id: number): void {
    this.webclient.getObservable<any[]>(`getanthropometrybypatient/${id}`).subscribe({
      next: (data) => {
        this.anthropometry = data.length > 0 ? data[data.length - 1] : null;
      },
      error: (err) => {
        console.error('Error fetching anthropometry:', err);
      }
    });
  }

  fetchVentilators(id: number): void {
    this.webclient.getObservable<any[]>(`getventilatorbypatientdaysheet/${id}`).subscribe({
      next: (data) => this.ventilators = data,
      error: (err) => console.error('Error fetching ventilator data:', err)
    });
  }

 fetchShiftRmoNurseData(icuId: number): void {
  //console.log("shift RMO nurse for ICU ID:", icuId);

  this.webclient.getObservable<any[]>(`shiftrmonurse/getbyicu/${icuId}`).subscribe({
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


 

}

/*import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { WebClient } from '../web-client';

@Component({
  selector: 'app-url',
  standalone: false,

  templateUrl: './url.component.html',
  styleUrls: ['./url.component.scss']
})
export class UrlComponent implements OnInit {
  patientid: number=0;

  constructor(private route: ActivatedRoute, private webclient: WebClient) {}

  formatLabel(key: string): string {
  return key
      .replace(/([a-z])([A-Z])/g, '$1 $2')
      .replace(/_/g, ' ')
      .replace(/\b\w/g, l => l.toUpperCase());
  }

  ngOnInit(): void {
  this.route.paramMap.subscribe(params => {
    const idParam = params.get('id');
    const patientId = idParam ? +idParam : 0;
      
    if (patientId > 0) {
      this.loadInfusionTable();
      this.loadScoreTable();
    }
  });
  }

  // infusion Table 
  infusionData: any[]=[];
  infusionColumns: {key:string; label: string}[] = [];
  loadInfusionTable(): void {
    this.webclient.getAll<any[]>(`patientinfusion?patientid=${this.patientid}`).subscribe(data => {
      this.infusionData = data;
      if (data.length > 0) {
        this.infusionColumns = Object.keys(data[0])
          .filter(key => typeof data[0][key] !== 'object')
          .map(key => ({
            key,
            label: this.formatLabel(key)
          }));
      }
    });
  }
  isValid(data : any[]): boolean {
    return Array.isArray(data) && data.length > 0;
  }

  //patient additional scores
  scoreData: any[]=[];
  scoreColumns: {key: string; label:string }[]= [];
  scoreDisplayColumns: string[] = [ 'qsofa', 'mews', 'apacheiv'];

  loadScoreTable(): void {
    this.webclient.getAll<any[]>(`patientadditionalscores?patientid=${this.patientid}`).subscribe(data => {
      this.scoreData = data;
      if (data.length > 0) {
        this.scoreColumns = this.scoreDisplayColumns.map(key => ({
          key,
          label: this.formatLabel(key)
        }));
      }
    });
  }

  getValue(obj: any, path: string): any {
    return path.split('.').reduce((acc, part) => acc && acc[part], obj);
  }

}
  */
