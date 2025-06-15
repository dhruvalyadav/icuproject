import { Component, OnInit } from '@angular/core';
import { Icu } from '../entities';
import { WebClient } from '../web-client';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-icu',
  standalone: false,

  templateUrl: './icu.component.html',
  styleUrl: './icu.component.scss'
})
export class IcuComponent implements OnInit{
  spinner : boolean = false
  mainspinner : boolean = false
  Icu : Icu[] = []
  icuadd : boolean = false;
  icu : Icu = new Icu()
  message : string = 'Admission done sucessfully'
  alerttype  : 'success' | 'error' | 'warning' | 'info' = 'info'
  alertmode : boolean = false

  constructor(private webclient : WebClient){}
  ngOnInit(): void {
    this.mainspinner = true
    this.webclient.getAll<Icu[]>("getallicu").subscribe(
      (response)=>{this.Icu = response;this.mainspinner = false},(error)=>{}
    )
  }

  onEdit(ic : Icu){
   this.icuadd = true
   this.icu = ic
  }
  onDelete(icu : Icu){

  }

  addicu(){
    this.icuadd = true
  }
  createicu(form : NgForm){
    if(form.invalid){
      this.message = "fill all * marks"
      this.alerttype = 'error'
      this.alertmode = true
    } else {
      this.spinner = true
      this.icu.updateddate = new Date()
      this.icu.createddate = new Date()
      this.icu.createdby = 1
      this.webclient.post<Icu,typeof Icu>("addicu",this.icu)
      .then((res)=>{alert("Icu is created");this.spinner=false;window.location.reload()})
      .catch((res)=>{})
    }
  }
}
