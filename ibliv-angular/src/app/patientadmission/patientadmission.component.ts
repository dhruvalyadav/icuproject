import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { inject } from '@angular/core';
import { WebClient } from '../web-client';
import { Patient, Patientadmission } from '../entities';

@Component({
  selector: 'app-patientadmission',
  standalone: false,

  templateUrl: './patientadmission.component.html',
  styleUrl: './patientadmission.component.scss'
})
export class PatientadmissionComponent {
    activatedRoute=inject(ActivatedRoute);
    webClient=inject(WebClient);
    patient = new Patient;
    patientadmission = new Patientadmission;

  onSave() {
    this.webClient.get<Patient>(`/fetch-patient/{patientname}`).then((res)=>{
      this.patient = res;
      console.log(this.patient);
    });

    this.patientadmission.patient=this.patient;

    this.webClient.post<Patientadmission,Patientadmission>('/save-patientadmission',this.patientadmission).
          then((res)=>{
            alert("patient admitted");
            console.log(this.patientadmission);
          });
  }
}
