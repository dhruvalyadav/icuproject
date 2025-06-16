import { Patientadditionalscores, Patientdaysheet } from './../entities';
import { Component, Input } from '@angular/core';
import { Patient } from './../entities';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { WebClient } from '../web-client';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-patientadditionalscores',
  standalone: false,
  
  templateUrl: './patientadditionalscores.component.html',
  styleUrl: './patientadditionalscores.component.scss'
})
export class PatientadditionalscoresComponent {
  @Input() patient : Patient = new Patient()
  patientdaysheets : Patientdaysheet[] = [] 
  patientadditionalscore : Patientadditionalscores =new Patientadditionalscores();
  patientdaysheetid : number|null = null
  constructor(private router : Router,private webclient : WebClient){}
  
  spinner : boolean = true
  mainspinner : boolean = true
  ngOnInit(): void {
    this.mainspinner = false
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
  addpatientscore(form : NgForm){
    if(form.invalid){
       this.alertmode = true
       this.message = "Fill all start(*) marked fields"
       this.alerttype = 'error'
    } else {
      this.patientadditionalscore.createddate = new Date()
      this.patientadditionalscore.patientdaysheet = this.patientdaysheets.filter((sheet)=>{return sheet.patientdaysheetid==this.patientdaysheetid})[0]
      this.webclient.post<Patientadditionalscores,typeof Patientadditionalscores>("saveadditionalpatientscore",this.patientadditionalscore)
      .then((res)=>{
        window.location.reload()
      })
      .catch((error)=>{console.log(error)})
    }
  }  
}
