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
    this.route.navigate(['/home/edit-patient',id]);
  }

  loadComponent(arg0: string) {
    if (arg0 === 'basicDetails') {
      // Logic to display the basic details page
      this.visible = true;
    }
    if(arg0 === 'add-patient'){
      this.visible = true;
    }
    if(arg0 === 'dashboard'){
      this.visible = true;
    }
    if (arg0 === 'admitted-patients') {
      // Logic to display the basic details page
      this.visible = true;
    }
  }
    visible: boolean = false;
    selectedComponent:string='';

  showComponent(component: string) {
    this.selectedComponent=component;
  }
}
