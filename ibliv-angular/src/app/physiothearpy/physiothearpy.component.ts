import { Component } from '@angular/core';
import { Physiothearpy } from '../entities';
import { Router } from '@angular/router';
import { WebClient } from '../web-client';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-physiothearpy',
  standalone: false,
  
  templateUrl: './physiothearpy.component.html',
  styleUrl: './physiothearpy.component.scss'
})
export class PhysiothearpyComponent{
   physiotherapy : Physiothearpy = new Physiothearpy()
   constructor(private router : Router,private webclient : WebClient){}
   message : string = 'Admission done sucessfully'
   alerttype  : 'success' | 'error' | 'warning' | 'info' = 'info'
   alertmode : boolean = false
   spin : boolean = true


   addphysiotherapy(form : NgForm){
    if(form.invalid){
      this.alertmode = true
      this.message = "Fill all start(*) marked fields"
      this.alerttype = 'error'
   } else {
      this.spin = false
      this.physiotherapy.createddate = new Date()
      this.webclient.post<Physiothearpy,typeof Physiothearpy>("savephysiothearpy",this.physiotherapy)
      .then((res)=>{this.spin = true;window.location.reload()})
      .catch((err)=>{})
    }
   }
}
