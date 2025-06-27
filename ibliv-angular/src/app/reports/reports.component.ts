
import { Component,OnInit } from '@angular/core';
import { Patient } from '../entities';
import { Router } from '@angular/router';
import { WebClient } from '../web-client';


@Component({
  selector: 'app-reports',
  standalone: false,
  
  templateUrl: './reports.component.html',
  styleUrl: './reports.component.scss'
})
export class ReportsComponent {
  constructor(private router : Router,private webclient : WebClient){}
  patients : Patient[] = [
  ]

  mainspinner : boolean = false
  ngOnInit(): void {
    this.mainspinner = true
    this.webclient.getAll<Patient[]>("patient-list").subscribe(
      (response)=>{this.patients=response;this.mainspinner = false},(error)=>{this.mainspinner = false}
    )
  }

  spinner : boolean = true
  filterpatients(event : any){
    if (event.target.value!=''){
      this.spinner = false
      this.webclient.getAll<Patient[]>("filterpatient/"+event.target.value).subscribe(
        (response)=>{this.patients = response},(error)=>{this.spinner = false})
    } else {
      this.spinner = true
    }
  }

  showinginput(patientid : number|null){
    this.router.navigate(['report/patient/'+patientid])
  }
}
