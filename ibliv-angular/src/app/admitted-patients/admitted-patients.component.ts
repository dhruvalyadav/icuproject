import { Component, OnInit } from '@angular/core';
import { NgModule } from '@angular/core';
import { Patient, Patientadmission } from '../entities';
import { ActivatedRoute, Router } from '@angular/router';
import { WebClient } from '../web-client';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-admitted-patients',
  standalone: false,
  templateUrl: './admitted-patients.component.html',
  styleUrl: './admitted-patients.component.scss'
})
export class AdmittedPatientsComponent implements OnInit{

    patientAdmissions:any;

    mainspinner : boolean = false
    constructor(private route:Router,private router : ActivatedRoute,private webclient : WebClient){}
    patientid : number = 0
    patient : Patient = new Patient()
    dob : string = ''
    ngOnInit(): void {
      this.mainspinner = true
      this.patientid = Number(this.router.snapshot.paramMap.get("id"))     
      this.webclient.get<Patient>("patient/"+this.patientid)
      .then((res)=>{
        this.dob = res.dob.toString().split('T')[0]
        this.patient = res
        this.mainspinner = false
      })
      .catch((error)=>{this.mainspinner = false})
    }

    formatDateForInput(date: Date): string {
      const year = date.getFullYear();
      const month = String(date.getMonth() + 1).padStart(2, '0');
      const day = String(date.getDate()).padStart(2, '0');
      return `${day}-${month}-${year}`;
    }

    update(){
      this.patient.dob = new Date(this.dob)
      this.webclient.put<Patient,typeof Patient>("update-patient",this.patient)
      .then((res)=>{
        alert("patient edit sucessfully")
        this.route.navigate(["patient/edit"])
      })
      .catch((error)=>{})
    }
}
