import { Component } from '@angular/core';
import { Vital } from '../entities';
import { NgForm } from '@angular/forms';
import { WebClient } from '../web-client';

@Component({
  selector: 'app-vital',
  standalone: false,
  
  templateUrl: './vital.component.html',
  styleUrl: './vital.component.scss'
})
export class VitalComponent {
   mainspinner : boolean = true
   vital : Vital = new Vital()
   message : string = 'Admission done sucessfully'
  alerttype  : 'success' | 'error' | 'warning' | 'info' = 'info'
  alertmode : boolean = false

   constructor(private webclient : WebClient){}

   onsave(form : NgForm)
   {
      if(form.invalid){
        this.message = "fill all * marks"
        this.alerttype = 'error'
        this.alertmode = true
      } else {
        this.mainspinner = false
        this.vital.createddate = new Date()
        this.vital.categorysortorder = 100
        this.vital.sortorder = 100
        this.webclient.post<Vital,Vital>("savevitals",this.vital)
        .then((res)=>{this.vital = res;this.mainspinner = true;window.location.reload()})
        .catch((err)=>{})
      }
   }
}
