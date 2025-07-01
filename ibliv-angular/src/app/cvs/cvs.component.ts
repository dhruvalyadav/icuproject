import { Component, Input, OnInit } from '@angular/core';
import { Hourlyobservation, Patient, Patientdaysheet, Vital } from '../entities';
import { WebClient } from '../web-client';
import { NgForm } from '@angular/forms';
import { Time } from '@angular/common';
import { InputFormService } from '../input-form.service';

@Component({
  selector: 'app-cvs',
  standalone: false,
  
  templateUrl: './cvs.component.html',
  styleUrl: './cvs.component.scss'
})
export class CvsComponent implements OnInit{
   @Input() patient : Patient = new Patient()
   @Input() vitals : Vital[] = []
   @Input() patientdaysheet : Patientdaysheet[] = []
   spinner : boolean = false
   hourlyobservation : Hourlyobservation = new Hourlyobservation()
   mainspinner : boolean = false
   message : string = 'Admission done sucessfully'
   alerttype  : 'success' | 'error' | 'warning' | 'info' = 'info'
   alertmode : boolean = false
   patientdaysheetid : number|null=null
   timeslot : string = ''
   vitalid : number = 0
  
   constructor(private webclient : WebClient){}
   ngOnInit(): void {}
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
    //InputFormService.completesheet.hourlyobservations.push(this.hourlyobservation)
    this.webclient.post<Hourlyobservation,Hourlyobservation>("addhourlyobservation",this.hourlyobservation)
     .then((res)=>{
        this.spinner = false
        this.alertmode = true
        this.message = "Sucessfully Updated Hourly Observation "+this.hourlyobservation.vital.vitalname
        this.alerttype = 'success'     
        this.hourlyobservation = new Hourlyobservation()
      })
     .catch((err)=>{})
    }
   }
}
