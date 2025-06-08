import { WebClient } from './../web-client';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { Component, OnInit, inject } from '@angular/core';
import { Icu, Patient, Patientadmission } from '../entities';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-edit-patient',
  standalone: false,

  templateUrl: './edit-patient.component.html',
  styleUrl: './edit-patient.component.scss'
})
export class EditPatientComponent implements OnInit
{
  patient : Patient = new Patient()
  mainspinner : boolean = false
  dotspinner : boolean = true
  updatepatient : boolean = false
  icus : Icu[] = []
  alertmode : boolean = false

  constructor(private route:Router,private router : ActivatedRoute,private webclient : WebClient){}

  Patadmission : Patientadmission = new Patientadmission()
  ngOnInit(): void {
     this.mainspinner = true
     const patientid = Number(this.router.snapshot.paramMap.get("id"))     
     this.webclient.getAll<Icu[]>("getallicu").subscribe(
      (response)=>{
        this.icus = response
        this.webclient.get<Patient>("patient/"+patientid)
        .then((res)=>{this.Patadmission.patient = res;this.mainspinner = false})
        .catch((error)=>{})
      },(error)=>{}
     )
  }

  icuid : Number = 0
  message : string = 'Admission done sucessfully'
  alerttype  : 'success' | 'error' | 'warning' | 'info' = 'info'

  updateadmission(form : NgForm){
    if(form.invalid){
      this.alertmode = true
      this.alerttype = 'error'
      this.message = 'Fill all * fields'
    } else {
      this.dotspinner = false
      this.Patadmission.createddate = new Date()
      this.Patadmission.createdby = 1
      this.Patadmission.updatedby = 1
      this.Patadmission.updateddate = new Date()
      this.Patadmission.icu = this.icus.filter((ic)=>{return ic.icuid==this.icuid})[0]
      console.log(this.Patadmission)
      this.webclient.post<Patientadmission,typeof Patientadmission>("saveadmittedpatient",this.Patadmission)
      .then((res)=>{
        this.message = 'Admission done sucessfully';
        this.alerttype = 'success'
        this.alertmode = true
        this.dotspinner = true;this.route.navigate(['patient/admission'])
      })
      .catch((error)=>{console.log(error)})
    }
  }
}
