import { Anthropometry, Patientdaysheet } from './../entities';
import { Component, Input } from '@angular/core';
import { Patient } from './../entities';
import { Router } from '@angular/router';
import { WebClient } from '../web-client';
import { NgForm } from '@angular/forms';
import { InputFormService } from '../input-form.service';

@Component({
  selector: 'app-anthropometry',
  standalone: false,

  templateUrl: './anthropometry.component.html',
  styleUrl: './anthropometry.component.scss'
})
export class AnthropometryComponent {

  @Input() patient : Patient = new Patient()
  @Input() patientdaysheet : Patientdaysheet[] = []
  anthropometry=new Anthropometry;
  patientdaysheetid : number = 0
  constructor(private router : Router,private webclient : WebClient){}
  
  spinner : boolean = true
  mainspinner : boolean = true
  ngOnInit(): void {
    this.mainspinner = false
  }
  
  message : string = 'Admission done sucessfully'
  alerttype  : 'success' | 'error' | 'warning' | 'info' = 'info'
  alertmode : boolean = false


  updateant(anthropometry : NgForm){
    if(anthropometry.invalid){
       this.alertmode = true
       this.message = "Fill all start(*) marked fields"
       this.alerttype = 'error'
    } else {
      this.anthropometry.height = this.anthropometry.height / 100
      this.anthropometry.bmi = this.anthropometry.weight / (this.anthropometry.height * this.anthropometry.height)
      this.anthropometry.patient = this.patient
      this.anthropometry.createddate = this.patientdaysheet.filter((sheet)=>{return sheet.patientdaysheetid==this.patientdaysheetid})[0].date
      this.anthropometry.patientdaysheet = this.patientdaysheet.filter((sheet)=>{return sheet.patientdaysheetid==this.patientdaysheetid})[0]
      //InputFormService.completesheet.anthropometry = this.anthropometry
      this.webclient.put<Anthropometry,typeof Anthropometry>("updateanthropometry",this.anthropometry)
      .then((res)=>{
        this.anthropometry = new Anthropometry()
        this.alertmode = true
        this.message = "Sucessfully Updated Anthoropometry"
        this.alerttype = 'success'
      })
      .catch((error)=>{console.log(error)})
    }
  }  
}
