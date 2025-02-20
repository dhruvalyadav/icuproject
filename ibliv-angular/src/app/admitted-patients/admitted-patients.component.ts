import { Component } from '@angular/core';
import { NgModule } from '@angular/core';
import { Patientadmission } from '../entities';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admitted-patients',
  standalone: false,
  templateUrl: './admitted-patients.component.html',
  styleUrl: './admitted-patients.component.scss'
})
export class AdmittedPatientsComponent {
  constructor(private route:Router){}

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
}
  visible: boolean = false;
    admittedPatient=new Patientadmission;
}
