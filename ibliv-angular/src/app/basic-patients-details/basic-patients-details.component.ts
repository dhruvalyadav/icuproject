import { Component, OnInit } from '@angular/core';
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
  tabs = [
    { id: 1, label: 'Dashboard', icon: 'bx-home' },
    { id: 2, label: 'Patients', icon: 'bx-user' },
    { id: 3, label: 'Appointments', icon: 'bx-calendar' },
    { id: 4, label: 'Medications', icon: 'bx-capsule' },
    { id: 5, label: 'Reports', icon: 'bx-file' },
    { id: 6, label: 'Settings', icon: 'bx-cog' }
  ];
  
  activeTab : Number = 1;
  
  selectTab(tabId: any) {
    this.activeTab = tabId;
  }
}
