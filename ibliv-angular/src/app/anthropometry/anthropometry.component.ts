import { Anthropometry } from './../entities';
import { Component, Input } from '@angular/core';
import { Patient } from './../entities';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { WebClient } from '../web-client';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-anthropometry',
  standalone: false,

  templateUrl: './anthropometry.component.html',
  styleUrl: './anthropometry.component.scss'
})
export class AnthropometryComponent {

  @Input() patient : Patient = new Patient()
  anthropometry=new Anthropometry;
  constructor(private router : Router,private webclient : WebClient){}
  
  spinner : boolean = true
  mainspinner : boolean = true
  ngOnInit(): void {
    this.mainspinner = false
  }
  
  message : string = 'Admission done sucessfully'
  alerttype  : 'success' | 'error' | 'warning' | 'info' = 'info'
  alertmode : boolean = false


  updateant(anthropometry : NgForm){
    if(anthropometry.invalid){
       this.alertmode = true
       this.message = "Fill all start(*) marked fields"
       this.alerttype = 'error'
    } else {
      this.anthropometry.height = this.anthropometry.height / 100
      this.anthropometry.bmi = this.anthropometry.weight / (this.anthropometry.height * this.anthropometry.height)
      this.anthropometry.patient = this.patient
      this.webclient.put<Anthropometry,typeof Anthropometry>("updateanthropometry",this.anthropometry)
      .then((res)=>{
        window.location.reload()
      })
      .catch((error)=>{console.log(error)})
    }
  }  
}
