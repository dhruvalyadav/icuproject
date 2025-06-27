import { Component } from '@angular/core';
import { Linestubes } from '../entities';
import { WebClient } from '../web-client';
import { NgForm } from '@angular/forms';


@Component({
  selector: 'app-linestubes',
  standalone: false,
  
  templateUrl: './linestubes.component.html',
  styleUrl: './linestubes.component.scss'
})
export class LinestubesComponent{
  mainspinner : boolean = false
  spinner : boolean = true
  message : string = 'Admission done sucessfully'
  alerttype  : 'success' | 'error' | 'warning' | 'info' = 'info'
  alertmode : boolean = false
  linestube : Linestubes = new Linestubes()
  constructor(private webclient : WebClient){}
  createlinetube(form : NgForm){
    if(form.invalid){
      this.message = "fill all * marks"
      this.alerttype = 'error'
      this.alertmode = true
    } else {
      this.linestube.createddate = new Date()
      this.linestube.active = 1
      this.webclient.post<Linestubes,typeof Linestubes>("savelinetube",this.linestube)
      .then((res)=>{
        this.alertmode = true
        this.message = "Sucessfully Updated Linestubes "+this.linestube.linestubesname
        this.alerttype = 'success'     
        this.linestube = new Linestubes()
      })
      .catch((res)=>{})
    }
  }
}
