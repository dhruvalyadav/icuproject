import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { inject } from '@angular/core';
import { WebClient } from '../web-client';
import { Icu, Patient, Patientadmission } from '../entities';

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
            this.patients.map((pat)=>{
              let admit = this.admittedpatients.filter((ad)=>{return ad.patient == pat})
              this.icupatients.push({patient : pat,admit : admit[0]});
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
  filterpatients(event : any){
    if (event.target.value!=''){
      this.spinner = false
      this.webclient.getAll<Patient[]>("filterpatient/"+event.target.value).subscribe(
        (response)=>{this.patients = response},(error)=>{this.spinner = false})
    } else {
      this.spinner = true
    }
  }
}
