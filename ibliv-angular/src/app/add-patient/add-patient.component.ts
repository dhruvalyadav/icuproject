
import { Component, inject, OnInit } from '@angular/core';
import { Patient } from '../entities';
import { ActivatedRoute, Router } from '@angular/router';
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

  patient : Patient=new Patient();
  patients:any;

  constructor(private route:Router){}

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((params)=>{
      if(params.has('id'))
      {
        const id=params.get('id');
        console.log(id);
        //fetch patient details from API
        this.webClient.get<Patient>('/patient/'+id).then((res)=>{
          this.patient=res;
          console.log(this.patient);
        })
      }
    });
  }

  onSave()
  {
    this.webClient.post<Patient,Patient>('/add-patient',this.patient).
    then((res)=>{
      alert('Patient added');
      this.route.navigate(['/home/basic-patient-details']);
    });
  }
}
