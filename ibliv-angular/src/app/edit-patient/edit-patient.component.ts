import { WebClient } from './../web-client';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit, inject } from '@angular/core';
import { Patient } from '../entities';

@Component({
  selector: 'app-edit-patient',
  standalone: false,

  templateUrl: './edit-patient.component.html',
  styleUrl: './edit-patient.component.scss'
})
export class EditPatientComponent implements OnInit
{
  activatedRoute=inject(ActivatedRoute);
  webClient=inject(WebClient);

  patient=new Patient;

  ngOnInit(): void
  {
    this.activatedRoute.paramMap.subscribe((params)=>{
      if(params.has('id'))
      {
        const id=params.get('id');
        //fetch patient details from API
      }
    });
    this.getPatientById();
  }
  getPatientById()
  {
    this.webClient.get<Patient>('/patient/{id}').then((res)=>{
      this.patient=res;
    })
  }

  readData(){

  }
  updatePatient()
  {
    this.webClient.put('/update-patient',this.patient).then((res)=>{
      alert("patient updated");
    })
  }

}
