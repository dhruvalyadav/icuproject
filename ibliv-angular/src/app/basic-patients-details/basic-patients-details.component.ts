import { Patient } from './../entities';
import { Component, inject, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
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

  }
  editPatient(id: any)
  {

  }
}
