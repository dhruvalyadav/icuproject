import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { Patient } from '../entities';

@Component({
  selector: 'app-edit-patient',
  standalone: false,

  templateUrl: './edit-patient.component.html',
  styleUrl: './edit-patient.component.scss'
})
export class EditPatientComponent implements OnInit
{
  patient = new Patient;
  constructor(
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void
  {
    this.activatedRoute.params.subscribe(params =>
    {
      this.patient.patientid = +params['id']; // The '+' converts the string to a number
    });
    this.getPatientById();
  }
  getPatientById()
  {

  }


  updatePatient()
  {

  }

}
