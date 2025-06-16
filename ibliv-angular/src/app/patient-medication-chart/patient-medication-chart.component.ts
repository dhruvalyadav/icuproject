import { Patientadditionalscores, Patientdaysheet, Patientmedicationchart } from './../entities';
import { Component, Input, OnInit } from '@angular/core';
import { Patient } from './../entities';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { WebClient } from '../web-client';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-patient-medication-chart',
  standalone: false,
  
  templateUrl: './patient-medication-chart.component.html',
  styleUrl: './patient-medication-chart.component.scss'
})
export class PatientMedicationChartComponent implements OnInit{
  @Input() patient : Patient = new Patient()
  patientdaysheets : Patientdaysheet[] = [] 
  patientmedicationchart : Patientmedicationchart =new Patientmedicationchart();
  patientdaysheetid : number|null = null
  constructor(private router : Router,private webclient : WebClient){}
  
  mainspinner : boolean = false
  spin : boolean = true
  ngOnInit(): void {
    this.mainspinner = true
     this.webclient.getAll<Patientdaysheet[]>("getallpatientdaysheetbypatient/"+this.patient.patientid).subscribe(
      (response)=>{
        this.patientdaysheets = response
        this.mainspinner = false
      },(error)=>{}
     )
  }
    
  message : string = 'Admission done sucessfully'
  alerttype  : 'success' | 'error' | 'warning' | 'info' = 'info'
  alertmode : boolean = false
  addpatientmedication(form : NgForm){
    if(form.invalid){
       this.alertmode = true
       this.message = "Fill all start(*) marked fields"
       this.alerttype = 'error'
    } else {
      this.spin = false
      this.patientmedicationchart.createddate = new Date()
      this.patientmedicationchart.patientadmission = this.patientdaysheets[0].patientadmission
      this.patientmedicationchart.date = this.patientdaysheets.filter((sheet)=>{return sheet.patientdaysheetid==this.patientdaysheetid})[0].date
      this.webclient.post<Patientmedicationchart,typeof Patientmedicationchart>("savepatientmedicationchart",this.patientmedicationchart)
      .then((res)=>{
        this.spin = true
        window.location.reload()
      })
      .catch((error)=>{})
    }
  }  
}
