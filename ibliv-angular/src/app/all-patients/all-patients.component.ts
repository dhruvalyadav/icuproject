import { Component, inject, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { WebClient } from '../web-client';
import { Icu, Patient, Patientadmission } from '../entities';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-all-patients',
  standalone: false,

  templateUrl: './all-patients.component.html',
  styleUrl: './all-patients.component.scss'
})
export class AllPatientsComponent implements OnInit{

  patient : Patient=new Patient();
  patientadmission : Patientadmission = new Patientadmission()
  icu : Icu[] = []
  create : boolean = true
  icuid : number|null=null
  
  message : string = 'Admission done sucessfully'
  alerttype  : 'success' | 'error' | 'warning' | 'info' = 'info'
  alertmode : boolean = false
  constructor(private route:Router,private webclient : WebClient){}

  ngOnInit(): void {
    this.webclient.getAll<Icu[]>("getallicu").subscribe(
      (response)=>{this.icu = response},(error)=>{}
    )
  }

  onSave(patientform : NgForm)
  {
    if(patientform.invalid){
      this.alertmode = true
      this.message = "fill all * mark fields"
      this.alerttype = 'error'
    } else {
      this.create = false
      this.patient.active = 1
      this.patient.createdby = 1
      this.patient.createddate = new Date()
      this.patient.updateddate = new Date()
      this.webclient.post<Patient,Patient>('add-patient',this.patient).
      then((res)=>{
        this.create = false
        this.alertmode = true
        this.message = "Sucessfully Created Patient"
        this.alerttype = 'success'
        this.patientadmission.createddate = new Date()
        this.patientadmission.createdby = 1
        this.patientadmission.updateddate = new Date()
        this.patientadmission.updatedby = 1
        this.patientadmission.icu = this.icu.filter((ic)=>{return ic.icuid==this.icuid})[0]
        this.patientadmission.patient = res
        this.webclient.post<Patientadmission,Patientadmission>("saveadmittedpatient",this.patientadmission)
        .then((res)=>{this.patientadmission = res;this.create = true;this.route.navigate(['patient'])})
        .catch((err)=>{})
      })
      .catch((error)=>{

      })
    }
  }
}
