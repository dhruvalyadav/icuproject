import { Component } from '@angular/core';
import { NgModule } from '@angular/core';
import { Patient, Patientadmission } from '../entities';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admitted-patients',
  standalone: false,
  templateUrl: './admitted-patients.component.html',
  styleUrl: './admitted-patients.component.scss'
})
export class AdmittedPatientsComponent {

    patientAdmissions:any;

}
