import { Component, Input, OnInit } from '@angular/core';
import { Hourlyobservation, Patient, Patientdaysheet, Vital } from '../entities';
import { WebClient } from '../web-client';
import { NgForm } from '@angular/forms';
import { Time } from '@angular/common';

@Component({
  selector: 'app-cvs',
  standalone: false,
  
  templateUrl: './cvs.component.html',
  styleUrl: './cvs.component.scss'
})
export class CvsComponent implements OnInit{
   @Input() patient : Patient = new Patient()
   @Input() vitals : Vital[] = []
   spinner : boolean = false
   hourlyobservation : Hourlyobservation = new Hourlyobservation()
   patientdaysheet : Patientdaysheet[] = []
   mainspinner : boolean = false
   message : string = 'Admission done sucessfully'
   alerttype  : 'success' | 'error' | 'warning' | 'info' = 'info'
   alertmode : boolean = false
   patientdaysheetid : number|null=null
   timeslot : string = ''
   vitalid : number = 0
  
   constructor(private webclient : WebClient){}
   ngOnInit(): void {
     this.mainspinner = true
     this.webclient.getAll<Patientdaysheet[]>("getallpatientdaysheetbypatient/"+this.patient.patientid).subscribe(
      (response)=>{
        this.patientdaysheet = response
        this.mainspinner = false
      },(error)=>{}
     )
   }
   onsave(form : NgForm){
    if(form.invalid){
      this.message = "fill all * marks"
      this.alerttype = 'error'
      this.alertmode = true
    } else {
    this.spinner = true
    this.hourlyobservation.patientdaysheet = this.patientdaysheet.filter((patday)=>{return patday.patientdaysheetid==this.patientdaysheetid})[0]
    this.hourlyobservation.vital = this.vitals.filter((vit)=>{return vit.vitalid==this.vitalid})[0]
    this.hourlyobservation.createddate = new Date()
    this.hourlyobservation.timeslot = parseInt(this.timeslot?.split(":")[0],10)
    this.webclient.post<Hourlyobservation,Hourlyobservation>("addhourlyobservation",this.hourlyobservation)
     .then((res)=>{
        this.spinner = false
        window.location.reload()
     })
     .catch((err)=>{})
    }
   }
}
