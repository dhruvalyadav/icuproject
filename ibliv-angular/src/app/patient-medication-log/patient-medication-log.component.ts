import { Patientmedicationlog, Patientdaysheet ,Patientmedicationchart, User, Userrole } from './../entities';
import { Component, Input, OnInit } from '@angular/core';
import { Patient } from './../entities';
import { Router } from '@angular/router';
import { WebClient } from '../web-client';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-patient-medication-log',
  standalone: false,
  
  templateUrl: './patient-medication-log.component.html',
  styleUrl: './patient-medication-log.component.scss'
})
export class PatientMedicationLogComponent implements OnInit{
   @Input() patient : Patient = new Patient()
   mainspinner : boolean = false

   message : string = 'Admission done sucessfully'
   alerttype  : 'success' | 'error' | 'warning' | 'info' = 'info'
   alertmode : boolean = false
   patientdaysheetid : number = 0
   patientmedicationcharts : Patientmedicationchart[] = []

   patientlogmedication : Patientmedicationlog = new Patientmedicationlog()
   patientmedicationchartid : number = 0
   userid : number = 0
   admintime : string = ''
   @Input() patientdaysheets : Patientdaysheet[] = []
   spin : boolean = false
   userroles : Userrole[] = []
   constructor(private router : Router,private webclient : WebClient){}
   ngOnInit(): void {
     this.mainspinner = true
     this.webclient.getAll<Patientmedicationchart[]>("getpatientmedicationchartbypatient/"+this.patient.patientid).subscribe(
      (response)=>{
        this.patientmedicationcharts = response;
        this.webclient.getAll<Userrole[]>("userrolebyrole/Adminstrative").subscribe(
          (response)=>{ this.userroles = response;this.mainspinner = false},(error)=>{}
        )
      },(error)=>{}
     )
   }

   private convertTimeToDate(timeString: string): Date {
    if (!timeString) return new Date();
    
    const [hours, minutes] = timeString.split(':').map(Number);
    const date = new Date();
    date.setHours(hours, minutes, 0, 0);
    return date;
   }

   addpatientmedication(form : NgForm){
    if(form.invalid){
       this.alertmode = true
       this.message = "Fill all start(*) marked fields"
       this.alerttype = 'error'
    } else {
      this.spin = false
      this.patientlogmedication.createddate = new Date()
      this.patientlogmedication.createdby = 1
      this.patientlogmedication.administrationtime = this.convertTimeToDate(this.admintime)
      this.patientlogmedication.administeredby = this.userroles.filter((use)=>{return use.userroleid==this.userid})[0].user
      this.patientlogmedication.patientmedicationchart = this.patientmedicationcharts.filter((med)=>{return med.patientmedicationchartid==this.patientmedicationchartid})[0]
      this.patientlogmedication.date = this.patientdaysheets.filter((sheet)=>{return sheet.patientdaysheetid==this.patientdaysheetid})[0].date
      console.log(this.patientlogmedication)
      this.webclient.post<Patientmedicationlog,typeof Patientmedicationlog>("savepatientmedicationlog",this.patientlogmedication)
      .then((res)=>{
        this.spin = true
        window.location.reload()
      })
      .catch((error)=>{})
    }
  }  
}
