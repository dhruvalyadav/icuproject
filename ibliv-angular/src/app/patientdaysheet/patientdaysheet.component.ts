import { Component, Input, OnInit } from '@angular/core';
import { Patient, Patientadmission, Patientdaysheet, User } from '../entities';
import { Router } from '@angular/router';
import { WebClient } from '../web-client';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-patientdaysheet',
  standalone: false,

  templateUrl: './patientdaysheet.component.html',
  styleUrl: './patientdaysheet.component.scss'
})
export class PatientdaysheetComponent implements OnInit{

  mainspinner : boolean = false
  @Input() patient : Patient = new Patient()
  patidaysheet : Patientdaysheet = new Patientdaysheet()
  spinner : boolean = true
  user : User[] = []
  patientadmission : Patientadmission = new Patientadmission()

  consultant1 : Number|null=null
  consultant2 : Number|null=null
  consultant3 : Number|null=null
  intenvisit : number|null=null
  message : string = 'Admission done sucessfully'
  alerttype  : 'success' | 'error' | 'warning' | 'info' = 'info'
  alertmode : boolean = false
  constructor(private route:Router,private webclient : WebClient){}

  ngOnInit(): void {
    this.mainspinner = true
    this.webclient.getAll<User[]>("users").subscribe(
      (response)=>{
        this.user = response;
        this.webclient.get<Patientadmission>("getpatientadmissionbypatient/"+this.patient.patientid)
        .then((res)=>{this.patientadmission = res;this.mainspinner = false})
        .catch((err)=>{})
      },(error)=>{}
    )
  }

  submitpatientdaysheet(form : NgForm)
  { 
     if(form.invalid){
      this.alertmode = true
      this.message = "Fill all start(*) marked fields"
      this.alerttype = 'error'
     } else {
       this.patidaysheet.consultant1 = this.user.filter((us)=>{return us.userid == this.consultant1})[0]
       this.patidaysheet.consultant2 = this.user.filter((us)=>{return us.userid == this.consultant2})[0]
       this.patidaysheet.consultant3 = this.user.filter((us)=>{return us.userid == this.consultant3})[0]
       this.patidaysheet.intensivist = this.user.filter((us)=>{return us.userid == this.intenvisit})[0]
       this.patidaysheet.createddate = new Date()
       this.patidaysheet.updateddate = new Date()
       this.patidaysheet.patientadmission = this.patientadmission
       this.webclient.post<Patientdaysheet,Patientdaysheet>("savepatientdaysheet",this.patidaysheet)
       .then((res)=>{
          this.patidaysheet = res
          this.alertmode = true
          this.message = "Sucessfully Updated Patientdaysheet"
          this.alerttype = 'success'
       })
       .catch((err)=>{

       })
     }
  }

}
