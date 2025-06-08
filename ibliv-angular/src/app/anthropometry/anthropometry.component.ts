import { Anthropometry } from './../entities';
import { Component } from '@angular/core';
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
  anthropometry=new Anthropometry;
  constructor(private router : Router,private webclient : WebClient){}
  anthropometries : Anthropometry[] = [
  ]
  ngOnInit(): void {
    this.mainspinner = true
      this.webclient.getAll<Anthropometry[]>("getanthropometry").subscribe(
        (response)=>{this.anthropometries=response;this.mainspinner = false},(error)=>{}
      )
  }
  
  updatepatient : boolean = false
  
  message : string = 'Admission done sucessfully'
  alerttype  : 'success' | 'error' | 'warning' | 'info' = 'info'
  alertmode : boolean = false
  onanthropometryedit(ant: Anthropometry,index : number) {
    this.mainspinner = true
    this.updatepatient = true
    this.anthropometry = ant
    this.mainspinner = false
  }

  updateant(anthropometry : NgForm){
    if(anthropometry.invalid){
       this.alertmode = true
       this.message = "Fill all start(*) marked fields"
       this.alerttype = 'error'
    } else {
      this.anthropometry.height = this.anthropometry.height / 100
      this.anthropometry.bmi = this.anthropometry.weight / (this.anthropometry.height * this.anthropometry.height)
      this.anthropometry.createddate = new Date()
      this.anthropometry.updateddate = new Date()
      this.anthropometry.createdby = 1
      this.anthropometry.updatedby = 1
      this.webclient.put<Anthropometry,typeof Anthropometry>("updateanthropometry",this.anthropometry)
      .then((res)=>{window.location.reload()})
      .catch((error)=>{console.log(error)})
    }
  }

  spinner : boolean = true
  mainspinner : boolean = true
  filterpatients(event : any){
    if (event.target.value!=''){
      this.webclient.getAll<Anthropometry[]>("filteranthropometry/"+event.target.value).subscribe(
        (response)=>{this.anthropometries = response;this.spinner = false},(error)=>{})
    } else {
      this.spinner = true
    }
  }
  
}
