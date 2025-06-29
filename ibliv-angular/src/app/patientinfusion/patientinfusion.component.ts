import { Component, Input, OnInit } from '@angular/core';
import { Patientinfusion, Patientdaysheet, User, Patient } from '../entities';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { WebClient } from '../web-client';


@Component({
  selector: 'app-patientinfusion',
  standalone: false,
  
  templateUrl: './patientinfusion.component.html',
  styleUrl: './patientinfusion.component.scss'
})
export class PatientinfusionComponent {
  patientinfusion : Patientinfusion = new Patientinfusion()
  @Input() patientdaysheets : Patientdaysheet[] = []
  @Input() patient : Patient = new Patient()
  patientdaysheetid : number = 0
  users : User[] = []
  infusionList: Patientinfusion[] = []
  infusionTableColumns: { key: string; label: string }[] = [];
  preparedby : number = 0
  spinner : boolean = true
  rmonurse : number = 0
  mainspinner : boolean = false
  message : string = 'Admission done sucessfully'
  alerttype  : 'success' | 'error' | 'warning' | 'info' = 'info'
  alertmode : boolean = false
  constructor(private router : Router,private webclient : WebClient){}
  formatLabel(key: string): string {
  return key
    .replace(/([a-z])([A-Z])/g, '$1 $2')      
    .replace(/_/g, ' ')                       
    .replace(/\b\w/g, l => l.toUpperCase());  
}
  
  ngOnInit(): void {
    this.mainspinner = true
    this.webclient.getAll<User[]>("users").subscribe(
     (response)=>{
      this.users = response;
      this.mainspinner = false
    },(error)=>{}
    )
    if (this.patient?.patientid) {
    this.webclient.getAll<Patientinfusion[]>(`patientinfusion?patientid=${this.patient.patientid}`).subscribe(
      (data) => {
        this.infusionList = data;
        if (data.length > 0) {
      this.infusionTableColumns = Object.keys(data[0])
        .filter(key => !['patient', 'preparedby'].includes(key))
        .map(key => ({
          key,
          label: this.formatLabel(key)
        }));
    }
      },
      (error) => {
        console.error("Failed to fetch infusion data", error);
      }
    );}
    
  }
  addpatientinfusion(form : NgForm){
      if(form.invalid){
       this.alertmode = true
       this.message = "Fill all start(*) marked fields"
       this.alerttype = 'error'
      } else {
         this.spinner = false
         this.patientinfusion.createddate = new Date()
         this.patientinfusion.patient = this.patient
         this.patientinfusion.preparedby = this.users.filter((us)=>{return us.userid=this.preparedby})[0]
         this.patientinfusion.time = this.patientdaysheets.filter((sheet)=>{return sheet.patientdaysheetid==this.patientdaysheetid})[0].date 
         this.webclient.post<Patientinfusion,typeof Patientinfusion>("addpatientinfusion",this.patientinfusion)
         .then((res)=>{
          this.spinner = true;
          this.message = "Sucessfully Updated Patient Infusion details"
          this.alerttype = 'success'     
          this.alertmode = true  
          this.patientinfusion = new Patientinfusion()
        })
         .catch((err)=>{console.log(err)})
      }
  }
}
