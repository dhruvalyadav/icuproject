import { Embolism, Patientadditionalscores, Patientdaysheet } from './../entities';
import { Component, Input, OnInit } from '@angular/core';
import { Patient } from './../entities';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { WebClient } from '../web-client';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-embolism',
  standalone: false,
  
  templateUrl: './embolism.component.html',
  styleUrl: './embolism.component.scss'
})
export class EmbolismComponent implements OnInit{
  @Input() patient : Patient = new Patient()
  patientdaysheets : Patientdaysheet[] = [] 
  embolism : Embolism =new Embolism();
  patientdaysheetid : number|null = null
  constructor(private router : Router,private webclient : WebClient){}
  
  spinner : boolean = true
  mainspinner : boolean = true
  ngOnInit(): void {
    this.mainspinner = true
     this.webclient.getAll<Patientdaysheet[]>("getallpatientdaysheetbypatient/"+this.patient.patientid).subscribe(
      (response)=>{
        this.patientdaysheets = response
        this.mainspinner = false
        console.log(this.patientdaysheets)
      },(error)=>{}
     )
  }

  message : string = 'Admission done sucessfully'
  alerttype  : 'success' | 'error' | 'warning' | 'info' = 'info'
  alertmode : boolean = false
  addpatientscore(form : NgForm){
    if(form.invalid){
       this.alertmode = true
       this.message = "Fill all start(*) marked fields"
       this.alerttype = 'error'
    } else {
      this.embolism.createddate = new Date()
      this.embolism.patientdaysheet = this.patientdaysheets.filter((sheet)=>{return sheet.patientdaysheetid==this.patientdaysheetid})[0]
      this.webclient.post<Embolism,typeof Embolism>("saveembolism",this.embolism)
      .then((res)=>{
        window.location.reload()
      })
      .catch((error)=>{console.log(error)})
    }
  }  
}
