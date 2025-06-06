import { Component, inject, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { WebClient } from '../web-client';
import { Patient } from '../entities';

@Component({
  selector: 'app-all-patients',
  standalone: false,

  templateUrl: './all-patients.component.html',
  styleUrl: './all-patients.component.scss'
})
export class AllPatientsComponent implements OnInit{

  patients : any;
  patient : Patient=new Patient();

  constructor(private route:Router,private webclient : WebClient){}

  ngOnInit(): void {
    
  }

  onSave()
  {
    this.patient.active = 1
    this.patient.createdby = 1
    this.webclient.post<Patient,Patient>('add-patient',this.patient).
    then((res)=>{
      alert('Patient added');
      this.route.navigate(["patient/edit"])
    });
  }
}
