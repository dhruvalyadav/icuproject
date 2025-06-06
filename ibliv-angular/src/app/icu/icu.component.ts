import { Component, OnInit } from '@angular/core';
import { Icu } from '../entities';
import { WebClient } from '../web-client';

@Component({
  selector: 'app-icu',
  standalone: false,

  templateUrl: './icu.component.html',
  styleUrl: './icu.component.scss'
})
export class IcuComponent implements OnInit{
  spinner : boolean = true
  mainspinner : boolean = false
  Icu : Icu[] = []
  icuadd : boolean = false;
  icu : Icu = new Icu()
  constructor(private webclient : WebClient){}
  ngOnInit(): void {
    this.mainspinner = true
    this.webclient.getAll<Icu[]>("getallicu").subscribe(
      (response)=>{this.Icu = response;this.mainspinner = false},(error)=>{}
    )
  }

  addicu(){
    this.icuadd = true
  }
  createicu(){
    this.icu.createddate = new Date()
    this.icu.updateddate = new Date()
    this.icu.createdby = 1
    this.webclient.post<Icu,typeof Icu>("addicu",this.icu)
    .then((res)=>{alert("Icu is created")})
    .catch((res)=>{})
  }
}
