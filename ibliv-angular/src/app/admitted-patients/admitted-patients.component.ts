import { Component } from '@angular/core';
import { NgModule } from '@angular/core';
import { Patientadmission } from '../entities';

@Component({
  selector: 'app-admitted-patients',
  standalone: false,
  templateUrl: './admitted-patients.component.html',
  styleUrl: './admitted-patients.component.scss'
})
export class AdmittedPatientsComponent {
    admittedPatient=new Patientadmission;
}
