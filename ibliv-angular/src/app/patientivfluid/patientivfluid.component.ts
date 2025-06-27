import { Component, Input, OnInit } from '@angular/core';
import { Patientivfluid, Ivfluid, Patient } from '../entities';
import { Router } from '@angular/router';
import { WebClient } from '../web-client';
import { NgForm } from '@angular/forms';


@Component({
  selector: 'app-patientivfluid',
  standalone: false,
  
  templateUrl: './patientivfluid.component.html',
  styleUrl: './patientivfluid.component.scss'
})
export class PatientivfluidComponent {
  patientivfluid : Patientivfluid = new Patientivfluid()
  constructor(private router : Router,private webclient : WebClient){}
  message : string = 'Admission done sucessfully'
  alerttype  : 'success' | 'error' | 'warning' | 'info' = 'info'
  alertmode : boolean = false
  spin : boolean = false
  ivfluids : Ivfluid[] = []
  ivfluidid : number = 0
  mainspinner : boolean = false
  @Input() pat : Patient = new Patient()

  ngOnInit(): void {
    this.mainspinner = true
    this.webclient.getAll<Ivfluid[]>("getivfluid").subscribe(
     (response)=>{this.ivfluids = response;this.mainspinner = false},(error)=>{}
    )
  }

  addpatietnivfluid(form : NgForm){
   if(form.invalid){
     this.alertmode = true
     this.message = "Fill all start(*) marked fields"
     this.alerttype = 'error'
  } else {
     this.spin = true
     this.patientivfluid.createddate = new Date()
     this.patientivfluid.patient = this.pat
     this.patientivfluid.ivfluid = this.ivfluids.filter((iv)=>{return iv.ivfluidid==this.ivfluidid})[0]
     this.webclient.post<Patientivfluid,typeof Patientivfluid>("addpatientivfluid",this.patientivfluid)
     .then((res)=>{
      this.spin = false;
      this.message = "Sucessfully Updated Patient IV Fluid details"
        this.alerttype = 'success'     
        this.alertmode = true  
        this.patientivfluid = new Patientivfluid()
    })
     .catch((err)=>{})
   }
  }
}
