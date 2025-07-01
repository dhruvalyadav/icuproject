import { Patientadditionalscores, Patientdaysheet } from './../entities';
import { Component, Input } from '@angular/core';
import { Patient } from './../entities';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { WebClient } from '../web-client';
import { NgForm } from '@angular/forms';
import { InputFormService } from '../input-form.service';

@Component({
  selector: 'app-patientadditionalscores',
  standalone: false,
  
  templateUrl: './patientadditionalscores.component.html',
  styleUrl: './patientadditionalscores.component.scss'
})
export class PatientadditionalscoresComponent {
  @Input() patient : Patient = new Patient()
  @Input() patientdaysheets : Patientdaysheet[] = [] 
  patientadditionalscore : Patientadditionalscores =new Patientadditionalscores();
  patientdaysheetid : number|null = null
  constructor(private router : Router,private webclient : WebClient){}
  
  spinner : boolean = true
  mainspinner : boolean = false
  ngOnInit(): void {}
    
  message : string = 'Admission done sucessfully'
  alerttype  : 'success' | 'error' | 'warning' | 'info' = 'info'
  alertmode : boolean = false
  addpatientscore(form : NgForm){
    if(form.invalid){
       this.alertmode = true
       this.message = "Fill all start(*) marked fields"
       this.alerttype = 'error'
    } else {
      this.patientadditionalscore.createddate = new Date()
      this.patientadditionalscore.patientdaysheet = this.patientdaysheets.filter((sheet)=>{return sheet.patientdaysheetid==this.patientdaysheetid})[0]
      //InputFormService.completesheet.patientadditionalscore = this.patientadditionalscore
      this.webclient.post<Patientadditionalscores,typeof Patientadditionalscores>("saveadditionalpatientscore",this.patientadditionalscore)
      .then((res)=>{
        this.message = "Sucessfully Updated Patient Score details for Date "+this.patientadditionalscore.patientdaysheet.date
        this.alerttype = 'success'   
        this.alertmode = true  
        this.patientadditionalscore = new Patientadditionalscores()     
      })
      .catch((error)=>{console.log(error)})
    }
  }  
}
