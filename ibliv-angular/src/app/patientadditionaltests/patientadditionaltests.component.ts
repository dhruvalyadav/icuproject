import { Component, Input, OnInit } from '@angular/core';
import { Patientadditionaltests, Patientdaysheet, Physiothearpy } from '../entities';
import { Router } from '@angular/router';
import { WebClient } from '../web-client';
import { NgForm } from '@angular/forms';
import { InputFormService } from '../input-form.service';

@Component({
  selector: 'app-patientadditionaltests',
  standalone: false,
  
  templateUrl: './patientadditionaltests.component.html',
  styleUrl: './patientadditionaltests.component.scss'
})
export class PatientadditionaltestsComponent implements OnInit{
  @Input() Patientdaysheets :  Patientdaysheet[] = []
  physiotherpies : Physiothearpy[] = []
  message : string = 'Admission done sucessfully'
   alerttype  : 'success' | 'error' | 'warning' | 'info' = 'info'
   alertmode : boolean = false
   daysheetid : number = 0
   physiotheropyid : number = 0

  Patientadditionaltests : Patientadditionaltests = new Patientadditionaltests()
  mainspinner : boolean = false
  spin : boolean = false
  constructor(private router : Router,private webclient : WebClient){}
  ngOnInit(): void {
    this.mainspinner = true
    this.webclient.getAll<Physiothearpy[]>("getphysiotheripes").subscribe(
      (response)=>{this.physiotherpies = response;this.mainspinner = false},(error)=>{}
    )
  }

  addpatientadditionaltests(form : NgForm){
    if(form.invalid){
       this.alertmode = true
       this.message = "Fill all start(*) marked fields"
       this.alerttype = 'error'
    } else {
       this.spin = true
       this.Patientadditionaltests.physiothearpy = this.physiotherpies.filter((phy)=>{return phy.physiothearpyid==this.physiotheropyid})[0]
       this.Patientadditionaltests.createddate = new Date() 
       this.Patientadditionaltests.patientdaysheet = this.Patientdaysheets.filter((sheet)=>{return sheet.patientdaysheetid==this.daysheetid})[0]
       //InputFormService.completesheet.patienttest = this.Patientadditionaltests
       this.webclient.post<Patientadditionaltests,typeof Patientadditionaltests>("saveadditionalpatienttest",this.Patientadditionaltests)
       .then((res)=>{
        this.spin = false;
        this.message = "Sucessfully Updated Patient Tests details for Date "+this.Patientadditionaltests.patientdaysheet.date
        this.alerttype = 'success'     
        this.alertmode = true  
        this.Patientadditionaltests = new Patientadditionaltests()        
      })
      .catch((err)=>{})
    }
  }
}
