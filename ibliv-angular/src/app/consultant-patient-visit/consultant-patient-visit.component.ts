import { Patientmedicationlog, Patientdaysheet ,Patientmedicationchart, User, Userrole, Consultantpatientvisit } from './../entities';
import { Component, Input, OnInit } from '@angular/core';
import { Patient } from './../entities';
import { Router } from '@angular/router';
import { WebClient } from '../web-client';
import { NgForm } from '@angular/forms';
import { InputFormService } from '../input-form.service';


@Component({
  selector: 'app-consultant-patient-visit',
  standalone: false,
  
  templateUrl: './consultant-patient-visit.component.html',
  styleUrl: './consultant-patient-visit.component.scss'
})
export class ConsultantPatientVisitComponent {


   mainspinner : boolean = false
   message : string = 'Admission done sucessfully'
   alerttype  : 'success' | 'error' | 'warning' | 'info' = 'info'
   alertmode : boolean = false
   patientdaysheetid : number = 0

   consultantpatient : Consultantpatientvisit = new Consultantpatientvisit()
   userid : number = 0
   datetime : string = ''
   @Input() patientdaysheets : Patientdaysheet[] = []
   spin : boolean = true
   userroles : Userrole[] = []
   constructor(private router : Router,private webclient : WebClient){}
   ngOnInit(): void {
     this.mainspinner = true
     this.webclient.getAll<Userrole[]>("userrolebyrole/doctor").subscribe(
      (response)=>{
        this.userroles = response;
        this.mainspinner = false
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

   addconsultantpatient(form : NgForm){
    if(form.invalid){
       this.alertmode = true
       this.message = "Fill all start(*) marked fields"
       this.alerttype = 'error'
    } else {
      this.spin = false
      this.consultantpatient.createddate = new Date()
      this.consultantpatient.datetime = this.convertTimeToDate(this.datetime)
      this.consultantpatient.doctor = this.userroles.filter((use)=>{return use.userroleid==this.userid})[0].user
      this.consultantpatient.patientdaysheet = this.patientdaysheets.filter((sheet)=>{return sheet.patientdaysheetid==this.patientdaysheetid})[0]
      //InputFormService.completesheet.consults = this.consultantpatient
      //InputFormService
      this.webclient.post<Consultantpatientvisit,typeof Consultantpatientvisit>("addconsultantpatientvisit",this.consultantpatient)
      .then((res)=>{
        this.spin = true
        this.consultantpatient = new Consultantpatientvisit()
        this.alertmode = true
        this.message = "Sucessfully Updated Consultantpatientvisit"
        this.alerttype = 'success'
      })
      .catch((error)=>{})
    }
  } 
}
