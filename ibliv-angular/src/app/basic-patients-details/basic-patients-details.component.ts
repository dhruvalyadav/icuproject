import { Component, OnInit, Type } from '@angular/core';
import {  Router } from '@angular/router';
import { WebClient } from '../web-client';
import { Menudetails } from '../entities';


@Component({
  selector: 'app-basic-patients-details',
  standalone: false,
  templateUrl: './basic-patients-details.component.html',
  styleUrls: ['./basic-patients-details.component.scss']
})
export class BasicPatientsDetailsComponent implements OnInit
{
  
  constructor(private route:Router,private webclient : WebClient){}
  mainspinner : boolean = false
  menudetails : Menudetails[] = []

  ngOnInit(): void
  {
    this.mainspinner = true
    this.webclient.getAll<Menudetails[]>("getallmenuitemsmenunamebymenuoreder/patient").subscribe(
      (response)=>{this.menudetails=response;this.mainspinner = false},(error)=>{this.mainspinner = false}
    )
  }
  activeTab : number = 0;
  tabname : string = ''
  selectTab(tab : Menudetails) {
    this.activeTab = tab.menuid;
    this.tabname = tab.classname
  }

  get activeComponent() : Type<any>{
    let classnames : any = this.menudetails.filter((menu)=>{return menu.menuid==this.activeTab})[0]
    return classnames.classname
  }
}
