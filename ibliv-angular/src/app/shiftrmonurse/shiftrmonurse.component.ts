import { Component, Input, OnInit } from '@angular/core';
import { Icu, Patientdaysheet, Shiftrmonurse, User } from '../entities';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { WebClient } from '../web-client';
import { InputFormService } from '../input-form.service';

@Component({
  selector: 'app-shiftrmonurse',
  standalone: false,
  
  templateUrl: './shiftrmonurse.component.html',
  styleUrl: './shiftrmonurse.component.scss'
})
export class ShiftrmonurseComponent {

  shiftrmonurse : Shiftrmonurse = new Shiftrmonurse()
  @Input() patientdaysheets : Patientdaysheet[] = []
  patientdaysheetid : number = 0
  icus : Icu[] = []
  users : User[] = []
  rmo : number = 0
  nurse : number = 0
  icuid : number = 0
  spinner : boolean = true
  mainspinner : boolean = false
  message : string = 'Admission done sucessfully'
  alerttype  : 'success' | 'error' | 'warning' | 'info' = 'info'
  alertmode : boolean = false
  constructor(private router : Router,private webclient : WebClient){}

  ngOnInit(): void {
    this.mainspinner = true
    this.webclient.getAll<User[]>("users").subscribe(
     (response)=>{
      this.users = response;
      this.webclient.getAll<Icu[]>("getallicu").subscribe(
        (response)=>{
          this.icus = response
        },(error)=>{}
      )
      this.mainspinner = false
    },(error)=>{}
    )
  }
  addshiftrmonursely(form : NgForm){
      if(form.invalid){
       this.alertmode = true
       this.message = "Fill all start(*) marked fields"
       this.alerttype = 'error'
      } else {
         this.spinner = false
         this.shiftrmonurse.createddate = new Date()
         this.shiftrmonurse.nurse = this.users.filter((shift)=>{return shift.userid==this.nurse})[0]
         this.shiftrmonurse.rmo = this.users.filter((shift)=>{return shift.userid==this.rmo})[0]
         this.shiftrmonurse.icu = this.icus.filter((ic)=>{return ic.icuid==this.icuid})[0]
         this.shiftrmonurse.createdby = 1
         this.shiftrmonurse.date = this.patientdaysheets.filter((sheet)=>{return sheet.patientdaysheetid==this.patientdaysheetid})[0].date    
         //InputFormService.completesheet.shiftnurses.push(this.shiftrmonurse)
         this.webclient.post<Shiftrmonurse,typeof Shiftrmonurse>("addshiftrmo",this.shiftrmonurse)
         .then((res)=>{
          this.spinner = true;
          this.message = "Sucessfully Updated Shift RMO Nurse details"
          this.alerttype = 'success'    
          this.alertmode = true  
          this.shiftrmonurse = new Shiftrmonurse()
        })
       .catch((err)=>{console.log(err)})
      }
  }
}
