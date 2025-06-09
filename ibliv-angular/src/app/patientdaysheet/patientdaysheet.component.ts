import { Component, OnInit } from '@angular/core';
import { Patient, Patientdaysheet } from '../entities';
import { Router } from '@angular/router';
import { WebClient } from '../web-client';

@Component({
  selector: 'app-patientdaysheet',
  standalone: false,

  templateUrl: './patientdaysheet.component.html',
  styleUrl: './patientdaysheet.component.scss'
})
export class PatientdaysheetComponent implements OnInit{
  patientsdaysheet : Patientdaysheet[] = []
  patients : Patient[] = []
  mainspinner : boolean = false
  spinner : boolean = true
  adddaysheet : boolean = false
  constructor(private route:Router,private webclient : WebClient){}

  ngOnInit(): void {
    this.mainspinner = true
    this.webclient.getAll<Patientdaysheet[]>("getallpatientdaysheet").subscribe(
      (response)=>{
        this.patientsdaysheet = response
        this.mainspinner = false
      },(error)=>{}
    )
  }

  filterdaysheet(event : any){
    if (event.target.value!=''){
      this.spinner = false
      this.patientsdaysheet = this.patientsdaysheet.filter((pat)=>{
        return pat.patientadmission.patient.patientname.includes(event.target.value)
      })
      this.spinner = true
    } else {
      this.spinner = true
    }
  }
}
