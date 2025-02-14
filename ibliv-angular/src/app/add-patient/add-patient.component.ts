import { Component, inject, OnInit } from '@angular/core';
import { Patient } from '../entities';
import { ActivatedRoute } from '@angular/router';
import { WebClient } from '../web-client';

@Component({
  selector: 'app-add-patient',
  standalone: false,

  templateUrl: './add-patient.component.html',
  styleUrl: './add-patient.component.scss'
})
export class AddPatientComponent implements OnInit {

  activatedRoute=inject(ActivatedRoute);
  webClient=inject(WebClient);

  patient=new Patient;

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((params)=>{
      if(params.has('id'))
      {
        const id=params.get('id');
        //fetch patient details from API
      }
    });
  }

  onSave()
  {
    this.webClient.post<Patient,Patient>('/add-patient',this.patient).then((res)=>{
      alert('Patient added');
    });
  }
}
