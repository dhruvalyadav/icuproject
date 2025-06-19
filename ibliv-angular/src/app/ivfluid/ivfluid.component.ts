import { Component } from '@angular/core';
import { Ivfluid, Physiothearpy } from '../entities';
import { Router } from '@angular/router';
import { WebClient } from '../web-client';
import { NgForm } from '@angular/forms';


@Component({
  selector: 'app-ivfluid',
  standalone: false,
  
  templateUrl: './ivfluid.component.html',
  styleUrl: './ivfluid.component.scss'
})
export class IvfluidComponent {
   ivfluid : Ivfluid = new Ivfluid()
   constructor(private router : Router,private webclient : WebClient){}
   message : string = 'Admission done sucessfully'
   alerttype  : 'success' | 'error' | 'warning' | 'info' = 'info'
   alertmode : boolean = false
   spin : boolean = true
   mainspinner : boolean = false


   addphysiotherapy(form : NgForm){
    if(form.invalid){
      this.alertmode = true
      this.message = "Fill all start(*) marked fields"
      this.alerttype = 'error'
   } else {
      this.spin = false
      this.ivfluid.createddate = new Date()
      this.webclient.post<Ivfluid,typeof Ivfluid>("saveivfluid",this.ivfluid)
      .then((res)=>{this.spin = true;window.location.reload()})
      .catch((err)=>{})
    }
   }
}
