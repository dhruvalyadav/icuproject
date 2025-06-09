import { Component, OnInit } from '@angular/core';
import {  Router } from '@angular/router';
import { WebClient } from '../web-client';
import { Icu, Patient, Patientadmission ,Admissionstatus} from '../entities';


@Component({
  selector: 'app-patientadmission',
  standalone: false,
  templateUrl: './patientadmission.component.html',
  styleUrl: './patientadmission.component.scss'
})
export class PatientadmissionComponent implements OnInit
{
  
  patients : Patient[] = []
  admittedpatients : Patientadmission[] = []
  icu : Icu[] = []
  mainspinner : boolean = false
  spinner : boolean = true
  viewadmittedpatient : boolean = false
  icupatients : any[] = []
  admits : Patient[] = []
  
  constructor(private route:Router,private webclient : WebClient){}
  ngOnInit(): void
  {
    this.mainspinner = true
    this.webclient.getAll<Patient[]>("patient-list").subscribe(
      (response)=>{
        this.patients=response
        this.webclient.getAll<Patientadmission[]>("getalladmittedpatient").subscribe(
          (response)=>{
            this.admittedpatients = response
            this.mainspinner = false
            this.admits = this.admittedpatients.map((adpat)=>{
              return adpat.patient
            })
          },(error)=>{}
        )
      },(error)=>{this.mainspinner = false}
    )
  }

  viewadmitted(){
    this.viewadmittedpatient = !this.viewadmittedpatient
  }
  routeadmitpatient(id : Number|null)
  {
    this.route.navigate(['patient/admit/'+id])
  }
  onSave()
  {
   
  }
  filterpatient(event : any){
    if (event.target.value!=''){
      this.spinner = false
      this.patients = this.patients.filter((pat)=>{
        return pat.patientname.includes(event.target.value)
      })
      this.spinner = true
    } else {
      this.spinner = true
    }
  }

  filteradmittedpatients(event : any){
    if (event.target.value!=''){
      this.spinner = false
      this.admittedpatients = this.admittedpatients.filter((pat)=>{
        return pat.patient.patientname.includes(event.target.value)
      })
      this.spinner = true
    } else {
      this.spinner = true
    }
  }
}
