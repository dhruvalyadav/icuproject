import { Component, Input, OnInit } from '@angular/core';
import { Patientinfusion, Patientdaysheet, User, Patient } from '../entities';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { WebClient } from '../web-client';

@Component({
  selector: 'app-patientinfusion',
  standalone: false,
  templateUrl: './patientinfusion.component.html',
  styleUrl: './patientinfusion.component.scss'
})
export class PatientinfusionComponent implements OnInit {
  patientinfusion: Patientinfusion = new Patientinfusion();
  @Input() patientdaysheets: Patientdaysheet[] = [];
  @Input() patient: Patient = new Patient();
  patientdaysheetid: number = 0;
  users: User[] = [];
  preparedby: number = 0;

  spinner: boolean = true;
  mainspinner: boolean = false;

  message: string = 'Admission done successfully';
  alerttype: 'success' | 'error' | 'warning' | 'info' = 'info';
  alertmode: boolean = false;

  constructor(private router: Router, private webclient: WebClient) {}

  ngOnInit(): void {
    this.mainspinner = true;
    this.webclient.getAll<User[]>("users").subscribe(
      (response) => {
        this.users = response;
        this.mainspinner = false;
      },
      (error) => {
        console.error("Failed to fetch users", error);
        this.mainspinner = false;
      }
    );
  }

  addpatientinfusion(form: NgForm): void {
    if (form.invalid) {
      this.alertmode = true;
      this.message = "Fill all start(*) marked fields";
      this.alerttype = 'error';
    } else {
      this.spinner = false;
      this.patientinfusion.createddate = new Date();
      this.patientinfusion.patient = this.patient;
      this.patientinfusion.preparedby = this.users.find(user => user.userid === this.preparedby) || new User();
      this.patientinfusion.time = this.patientdaysheets.find(sheet => sheet.patientdaysheetid === this.patientdaysheetid)?.date || new Date();

      this.webclient.post<Patientinfusion, typeof Patientinfusion>("addpatientinfusion", this.patientinfusion)
        .then((res) => {
          this.spinner = true;
          this.message = "Successfully Updated Patient Infusion details";
          this.alerttype = 'success';
          this.alertmode = true;
          this.patientinfusion = new Patientinfusion();
        })
        .catch((err) => {
          console.error("Failed to save patient infusion", err);
        });
    }
  }
}
