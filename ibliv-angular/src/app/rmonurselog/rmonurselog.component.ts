import { Component, Input, OnInit } from '@angular/core';
import { Icu, Patientdaysheet, Rmonurselog, Shiftrmonurse, User } from '../entities';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { WebClient } from '../web-client';


@Component({
  selector: 'app-rmonurselog',
  standalone: false,
  
  templateUrl: './rmonurselog.component.html',
  styleUrl: './rmonurselog.component.scss'
})
export class RmonurselogComponent {
  rmonurselog : Rmonurselog = new Rmonurselog()
  @Input() patientdaysheets : Patientdaysheet[] = []
  patientdaysheetid : number = 0
  users : User[] = []
  spinner : boolean = true
  rmonurse : number = 0
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
      this.mainspinner = false
    },(error)=>{}
    )
  }
  addrmonurselog(form : NgForm){
      if(form.invalid){
       this.alertmode = true
       this.message = "Fill all start(*) marked fields"
       this.alerttype = 'error'
      } else {
         this.spinner = false
         this.rmonurselog.createddate = new Date()
         this.rmonurselog.rmonurse = this.users.filter((shift)=>{return shift.userid==this.rmonurse})[0]
         this.rmonurselog.patientdaysheet = this.patientdaysheets.filter((sheet)=>{return sheet.patientdaysheetid==this.patientdaysheetid})[0]    
         this.webclient.post<Rmonurselog,typeof Rmonurselog>("addrmonurselog",this.rmonurselog)
         .then((res)=>{this.spinner = true;window.location.reload()})
         .catch((err)=>{console.log(err)})
      }
  }
}
