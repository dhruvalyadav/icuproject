import { Component, OnInit } from '@angular/core';
import { WebClient } from '../web-client';
import { Menudetails } from '../entities';

@Component({
  selector: 'app-admin',
  standalone: false,
  
  templateUrl: './admin.component.html',
  styleUrl: './admin.component.scss'
})
export class AdminComponent implements OnInit{
  constructor(private webclient : WebClient){}
  mainspinner : boolean = false
  menudetails : Menudetails[] = []

  ngOnInit(): void {
     this.mainspinner = true
     this.webclient.getAll<Menudetails[]>("getallmenuitemsmenunamebymenuoreder/Admin").subscribe(
      (response)=>{this.menudetails = response},(error)=>{}
     )
  }
  activeTab : number = 0;
  tabname : string = ''
  selectTab(tab : Menudetails) {
    this.activeTab = tab.menuid;
    this.tabname = tab.classname
  }
}
