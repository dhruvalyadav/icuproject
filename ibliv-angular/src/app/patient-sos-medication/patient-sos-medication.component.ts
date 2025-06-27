import { Patientdaysheet, Patientmedicationchart, Patientsosmedication, User } from './../entities';
import { Component, Input, OnInit } from '@angular/core';
import { Patient } from './../entities';
import { Router } from '@angular/router';
import { WebClient } from '../web-client';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-patient-sos-medication',
  standalone: false,
  
  templateUrl: './patient-sos-medication.component.html',
  styleUrl: './patient-sos-medication.component.scss'
})
export class PatientSosMedicationComponent implements OnInit{
  @Input() patient : Patient = new Patient()
  patientsosmedication : Patientsosmedication =new Patientsosmedication();
  user : User[] = []
  administeredby : number = 0 
  orderedbydoctor : number = 0
  constructor(private router : Router,private webclient : WebClient){}
  

  mainspinner : boolean = false
  spin : boolean = false
  ngOnInit(): void {
    this.webclient.getAll<User[]>("users").subscribe(
      (response)=>{
        this.user = response
      },(error)=>{}
    )
  }
    
  message : string = 'Admission done sucessfully'
  alerttype  : 'success' | 'error' | 'warning' | 'info' = 'info'
  alertmode : boolean = false
  addpatientsosmedication(form : NgForm){
    if(form.invalid){
       this.alertmode = true
       this.message = "Fill all start(*) marked fields"
       this.alerttype = 'error'
    } else {
      this.spin = true
      this.patientsosmedication.createddate = new Date()
      this.patientsosmedication.patient = this.patient
      this.patientsosmedication.administeredby = this.user.filter((us)=>{return us.userid==this.administeredby})[0]
      this.patientsosmedication.orderedbydoctor = this.user.filter((us)=>{return us.userid==this.orderedbydoctor})[0]
      this.webclient.post<Patientsosmedication,typeof Patientsosmedication>("savesosmedication",this.patientsosmedication)
      .then((res)=>{
        this.spin = false
        this.message = "Sucessfully Updated Patient SOS Medication details for Time "+this.patientsosmedication.time+" By "+this.patientsosmedication.administeredby
        this.alerttype = 'success'  
        this.alertmode = true  
        this.patientsosmedication = new Patientsosmedication()     
      })
      .catch((error)=>{})
    }
  }  
}
