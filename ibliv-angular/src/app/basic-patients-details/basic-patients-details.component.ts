import { Patient } from './../entities';
import { Component, inject, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { WebClient } from '../web-client';


@Component({
  selector: 'app-basic-patients-details',
  standalone: false,
  templateUrl: './basic-patients-details.component.html',
  styleUrls: ['./basic-patients-details.component.scss']
})
export class BasicPatientsDetailsComponent implements OnInit
{
  patients: any;

  activatedRoute = inject(ActivatedRoute);
  webClient = inject(WebClient);

  constructor(private route:Router){}

  ngOnInit(): void
  {
    this.getAllPatients();
  }
  getAllPatients()
  {
  this.webClient.getAll<Patient[]>('/patient-list').subscribe((res)=>
  {
    this.patients=res;
    console.log('patient list ',res);
  });
  }
  deletePatient(id: any)
  {
    this.activatedRoute.paramMap.subscribe((params)=>{
      if(params.has('id'))
      {
        const id=params.get('id');
        //fetch patient details from API
        this.webClient.get<Patient>(`/patient/${id}`).then((res)=>{
          this.patients=res;
        })
      }
    });
    this.webClient.delete<Patient>(`/delete/${id}`).then((res)=>{
      alert("patient deleted");
      this.getAllPatients();
    })

  }
  editPatient(id: any)
  {
    console.log(id);
    this.route.navigate(['/home/edit-patient',id]);
  }
  admitPatient(id:any)
  {
    this.route.navigate(['/home/patientadmission',id]);
  }
}
