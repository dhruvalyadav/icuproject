import { Component, Input, OnInit, Type } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { WebClient } from '../web-client';
import { Patient, Vital } from '../entities';

@Component({
  selector: 'app-hourlyobservation',
  standalone: false,
  
  templateUrl: './hourlyobservation.component.html',
  styleUrl: './hourlyobservation.component.scss'
})
export class HourlyobservationComponent implements OnInit{
  constructor(private route:Router,private webclient : WebClient,private rou : ActivatedRoute){}
  mainspinner : boolean = false
  vitals : Vital[] = []
  innervitals : Vital[] = []
  @Input() patient : Patient = new Patient()

  ngOnInit(): void
  {
    this.mainspinner = true
    this.webclient.getAll<Vital[]>("vitalsbygroup").subscribe(
      (response)=>{
        this.vitals=response;
        this.mainspinner = false
      },(error)=>{this.mainspinner = false}
    )
  }

  activeTab : number|null=null;
  tabname : string = ''
  selectedvital : Vital = new Vital()
  selectTab(tab : Vital) {
    this.activeTab = tab.vitalid
    this.tabname = tab.vitalname
    this.selectedvital = tab
    this.webclient.getAll<Vital[]>("vitalbycategory/"+tab.vitalcategory).subscribe(
      (response)=>{this.innervitals = response},(error)=>{}
    )
  }
}
