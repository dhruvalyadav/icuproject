import { Component, OnInit } from '@angular/core';
import { Ventilatormode } from '../entities';
import { Router } from '@angular/router';
import { WebClient } from '../web-client';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-ventilator-mode',
  standalone: false,
  
  templateUrl: './ventilator-mode.component.html',
  styleUrl: './ventilator-mode.component.scss'
})
export class VentilatorModeComponent {
  ventilator : Ventilatormode = new Ventilatormode()
   constructor(private router : Router,private webclient : WebClient){}
   message : string = 'Admission done sucessfully'
   alerttype  : 'success' | 'error' | 'warning' | 'info' = 'info'
   alertmode : boolean = false
   spin : boolean = true


   addventilator(form : NgForm){
    if(form.invalid){
      this.alertmode = true
      this.message = "Fill all start(*) marked fields"
      this.alerttype = 'error'
   } else {
      this.spin = false
      this.ventilator.createddate = new Date()
      this.ventilator.active = 1
      this.webclient.post<Ventilatormode,typeof Ventilatormode>("saveventilator",this.ventilator)
      .then((res)=>{
        this.spin = true
        this.message = "Sucessfully Updated Ventilator details"
        this.alerttype = 'success'     
        this.alertmode = true  
        this.ventilator = new Ventilatormode()
      })
      .catch((err)=>{})
    }
   }
}
