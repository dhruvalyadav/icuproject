import { Component, Input, OnInit } from '@angular/core';
import { Patientdaysheet, Patientventilator, Ventilatormode } from '../entities';
import { Router } from '@angular/router';
import { WebClient } from '../web-client';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-patient-ventilator',
  standalone: false,
  
  templateUrl: './patient-ventilator.component.html',
  styleUrl: './patient-ventilator.component.scss'
})
export class PatientVentilatorComponent implements OnInit{
   patientventilator : Patientventilator = new Patientventilator()
   constructor(private router : Router,private webclient : WebClient){}
   message : string = 'Admission done sucessfully'
   alerttype  : 'success' | 'error' | 'warning' | 'info' = 'info'
   alertmode : boolean = false
   spin : boolean = false
   ventilators : Ventilatormode[] = []
   sheetid : number = 0
   ventilatorid : number = 0
   mainspinner : boolean = false
   @Input() patientdaysheets : Patientdaysheet[] = []

   ngOnInit(): void {
     this.mainspinner = true
     this.webclient.getAll<Ventilatormode[]>("getventilator").subscribe(
      (response)=>{this.ventilators = response;this.mainspinner = false},(error)=>{}
     )
   }

   addventilator(form : NgForm){
    if(form.invalid){
      this.alertmode = true
      this.message = "Fill all start(*) marked fields"
      this.alerttype = 'error'
   } else {
      this.spin = true
      this.patientventilator.createddate = new Date()
      this.patientventilator.patientdaysheet = this.patientdaysheets.filter((sheet)=>{return sheet.patientdaysheetid==this.sheetid})[0]
      this.patientventilator.ventilatormode = this.ventilators.filter((ven)=>{return ven.ventilatormodeid==this.ventilatorid})[0]
      this.webclient.post<Patientventilator,typeof Patientventilator>("addventilator",this.patientventilator)
      .then((res)=>{
        this.spin = false;
        this.message = "Sucessfully Updated Patient Ventilator details for Date "+this.patientventilator.patientdaysheet.date
        this.alerttype = 'success'    
        this.alertmode = true   
        this.patientventilator = new Patientventilator()     
      })
      .catch((err)=>{})
    }
   }
}
