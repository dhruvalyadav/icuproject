import { Anthropometry } from './../entities';
import { Component } from '@angular/core';
import { Patient } from './../entities';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { WebClient } from '../web-client';

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
  onanthropometryedit(ant: Anthropometry,index : number) {
    this.mainspinner = true
    this.updatepatient = true
    this.anthropometry = ant
    this.mainspinner = false
  }

  updateant(){
    this.anthropometry.height = this.anthropometry.height / 100
    this.anthropometry.bmi = this.anthropometry.weight / (this.anthropometry.height * this.anthropometry.height)
    this.anthropometry.createddate = new Date()
    this.anthropometry.updateddate = new Date()
    this.anthropometry.createdby = 1
    this.anthropometry.updatedby = 1
    this.webclient.put<Anthropometry,typeof Anthropometry>("updateanthropometry",this.anthropometry)
    .then((res)=>{alert("Anthropometry created sucessfully");window.location.reload()})
    .catch((error)=>{console.log(error)})
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
