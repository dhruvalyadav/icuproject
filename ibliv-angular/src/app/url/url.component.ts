import { Component, OnInit,TemplateRef } from '@angular/core';
import { Router,ActivatedRoute } from '@angular/router';
import { WebClient } from '../web-client';
import { Anthropometry, Hourlyobservation, Patient, Patientadmission, Patientdaysheet, Rmonurselog, Shiftrmonurse, Singlesheet, Vital, Hourrecord, Hourrecords, Patientadditionalscores, Embolism, Patientivfluid, Patientadditionaltests, Patientventilator, Patientlinestubes, Patientsosmedication, Patientinfusion, Patientmedicationchart } from '../entities';

interface Column {
  header: string;
  field: string;
  sortable? : boolean;
  template : TemplateRef<any>;
}
@Component({
  selector: 'app-url',
  standalone: false,
  
  templateUrl: './url.component.html',
  styleUrl: './url.component.scss'
})
export class UrlComponent implements OnInit{
  patientid : Number = 0
  patient : Patient = new Patient()
  patientadmission : Patientadmission = new Patientadmission()
  patientdaysheetid : number|null=null
  mainspinner : boolean = false
  completesheet : Singlesheet = new Singlesheet()
  currentdaysheet : Patientdaysheet = new Patientdaysheet()
  uniquevitals : String[] = []
  hourrecords : Hourrecords[] = []
  constructor(private route:Router,private router : ActivatedRoute,private webclient : WebClient){}

  ngOnInit(): void {
    this.patientid = Number(this.router.snapshot.paramMap.get("id"))     
    this.mainspinner = true
    this.mainspinner = false
    this.webclient.get<Patient>("patient/"+this.patientid)
    .then((res)=>{
      this.patient = res
      this.webclient.get<Patientadmission>("getpatientadmissionbypatient/"+this.patientid)
      .then((res)=>{
        this.patientadmission = res
        this.webclient.getAll<Patientdaysheet[]>("getallpatientdaysheetbypatient/"+this.patient.patientid).subscribe(
          (response)=>{




            this.completesheet.patientdaysheet = response
            this.patientdaysheetid = this.completesheet.patientdaysheet[0].patientdaysheetid
            this.currentdaysheet = this.completesheet.patientdaysheet[0]
            this.webclient.getAll<Anthropometry>("getanthropometrybypatientdaysheet/"+this.patientdaysheetid).subscribe(
              (response)=>{
                 this.completesheet.anthropometry = response
              },(error)=>{}
            )
            this.webclient.getAll<Shiftrmonurse[]>("getshiftrmonurssebypatientdaysheetid/"+this.patientdaysheetid).subscribe(
              (response)=>{this.completesheet.shiftnurses = response},(error)=>{}
            )
            this.webclient.getAll<Rmonurselog[]>("getrmonurselogbypatientdaysheet/"+this.patientdaysheetid).subscribe(
              (response)=>{
                 this.completesheet.rmonurselog = response
              },(error)=>{}
            )
            this.webclient.getAll<Hourlyobservation[]>("gethourlyobservationbysheetid/"+this.patientdaysheetid).subscribe(
              (response)=>{
                 this.completesheet.hourlyobservations = response
                 this.findminmax()
                 this.createRange(this.completesheet.starttimeofhourlyobservation,this.completesheet.endtimeofhourlyobservation)
                 this.webclient.getAll<Hourlyobservation[]>("getByPatientdaysheetGroupByvital/"+this.patientdaysheetid).subscribe(
                  (response)=>{
                    response.map((res)=>{
                      this.completesheet.vitals.push(res.vital)
                    })
                    this.hourrecords = this.separetecatgory(this.completesheet.hourlyobservations)
                  },(error)=>{}
                )
              },(error)=>{}
            )
            this.webclient.get<Patientadditionalscores>("getpatientadditionalscorebypatientdaysheetid/"+this.patientdaysheetid)
            .then((patientscore)=>{
                this.completesheet.patientadditionalscore = patientscore
            })
            .catch((err)=>{})
            this.webclient.get<Embolism>("getembolismbypatientdaysheetid/"+this.patientdaysheetid)
            .then((patientscore)=>{
                this.completesheet.embolism = patientscore
            })
            .catch((err)=>{})
            let date = this.completesheet.patientdaysheet.filter((day)=>{return day.patientdaysheetid == this.patientdaysheetid})[0].date
            this.webclient.getAll<Patientivfluid[]>(
              `getpatientivfluidbydate/${date}/${this.patient.patientid}`).subscribe(
              (response)=>{
                this.completesheet.patientivfluid = response
              },(error)=>{}
            )
            this.webclient.get<Patientadditionaltests>("getpatientadditionaltestbypatientdaysheetid/"+this.patientdaysheetid)
            .then((res)=>{
                this.completesheet.patienttest = res
            })
            .catch((err)=>{})
            this.webclient.get<Patientventilator>("getpatientventilatorbypatientdaysheetid/"+this.patientdaysheetid)
            .then((res)=>{
                this.completesheet.patientventialtor = res
            })
            .catch((err)=>{})
            this.webclient.getAll<Patientlinestubes[]>("getpatientlinesandtubesbypatientdaysheetid/"+this.patientdaysheetid).subscribe(
              (response)=>{
                 this.completesheet.patientlines = response
              },(error)=>{}
            )
            this.webclient.getAll<Patientsosmedication[]>("getpatientsosmedicationbydateandpatientid/"+date+"/"+this.patient.patientid).subscribe(
              (response)=>{
                  this.completesheet.patientsosmedication = response
              },(error)=>{}
            )
            this.webclient.getAll<Patientinfusion[]>("getpatientindusionbydate/"+date+"/"+this.patient.patientid).subscribe(
              (response)=>{
                this.completesheet.patientinfusioncharts = response
              },(error)=>{}
            )
            this.webclient.getAll<Patientmedicationchart[]>("getpatientmedicationchartbydate/"+date+"/"+this.patient.patientid).subscribe(
              (response)=>{
                 this.completesheet.patientmedicationcharts = response
              },(error)=>{}
            )

          },(error)=>{}
        )
      })
      .catch((err)=>{})
    })
    .catch((err)=>{})
  }

  changesheet(){

  }

  findminmax(){
    let min = 24
    let max = 0
    for(let i=0;i<this.completesheet.hourlyobservations.length;i++){
      if(this.completesheet.hourlyobservations[i].timeslot < min){
        min = this.completesheet.hourlyobservations[i].timeslot
      } else if(this.completesheet.hourlyobservations[i].timeslot > max){
        max = this.completesheet.hourlyobservations[i].timeslot
      }
    }
    this.completesheet.starttimeofhourlyobservation = min
    this.completesheet.endtimeofhourlyobservation = max
  }
  createRange(start: number, end: number) {
    this.completesheet.arryarange = Array(end - start + 1).fill(0).map((_, idx) => start + idx);
    //return Array(end - start + 1).fill(0).map((_, idx) => start + idx);
  }

  separetecatgory(data: any[]) : Hourrecords[]{
    if (!data || data.length === 0) return [];

    // First determine the time range
    const timeslots = data.map(obs => obs.timeslot);
    const startTime = Math.min(...timeslots);
    const endTime = Math.max(...timeslots);
    const arrayLength = endTime - startTime + 1;

    // Group by category and vital name
    const categoryMap = new Map<string, {
      vitals: Map<string, string[]>,
      startTime: number,
      endTime: number
    }>();

    data.forEach(observation => {
      const category = observation.vital.vitalcategory;
      const name = observation.vital.vitalname;
      const value = observation.value.toString(); // Convert to string
      const timeslot = observation.timeslot;
      const index = timeslot - startTime; // Calculate position in array

      if (!categoryMap.has(category)) {
        categoryMap.set(category, {
          vitals: new Map<string, string[]>(),
          startTime,
          endTime
        });
      }

      const categoryData = categoryMap.get(category)!;

      if (!categoryData.vitals.has(name)) {
        // Initialize array with '-' for all positions
        categoryData.vitals.set(name, new Array(arrayLength).fill('-'));
      }

      // Set the value at the correct position
      categoryData.vitals.get(name)![index] = value;
    });

    // Convert to Hourrecords array
    const result: Hourrecords[] = [];
    
    categoryMap.forEach((categoryData, category) => {
      const hourRecords = new Hourrecords();
      hourRecords.vitalcategory = category;
      this.completesheet.starttimeofhourlyobservation = categoryData.startTime;
      this.completesheet.endtimeofhourlyobservation = categoryData.endTime;
      hourRecords.observationundercategory = [];

      categoryData.vitals.forEach((values, name) => {
        const hourRecord = new Hourrecord();
        hourRecord.vitalname = name;
        hourRecord.values = values;
        hourRecords.observationundercategory.push(hourRecord);
      });

      result.push(hourRecords);
    });

    return result;

  }
}
 