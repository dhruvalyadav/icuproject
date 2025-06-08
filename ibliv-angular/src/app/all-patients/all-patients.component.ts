import { Component, inject, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { WebClient } from '../web-client';
import { Patient } from '../entities';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-all-patients',
  standalone: false,

  templateUrl: './all-patients.component.html',
  styleUrl: './all-patients.component.scss'
})
export class AllPatientsComponent implements OnInit{

  patient : Patient=new Patient();
  create : boolean = true
  
  message : string = 'Admission done sucessfully'
  alerttype  : 'success' | 'error' | 'warning' | 'info' = 'info'
  alertmode : boolean = false
  constructor(private route:Router,private webclient : WebClient){}

  ngOnInit(): void {
    
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
      this.webclient.post<Patient,Patient>('add-patient',this.patient).
      then((res)=>{
        this.create = false
        this.alertmode = true
        this.message = "Sucessfully Created Patient"
        this.alerttype = 'success'
        this.route.navigate(["patient/edit"])
      });
    }
  }
}
