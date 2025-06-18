import { Component, OnInit, Type } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { WebClient } from '../web-client';
import { Menudetails, Patient, Patientdaysheet } from '../entities';


@Component({
  selector: 'app-basic-patients-details',
  standalone: false,
  templateUrl: './basic-patients-details.component.html',
  styleUrls: ['./basic-patients-details.component.scss']
})
export class BasicPatientsDetailsComponent implements OnInit
{
  
  constructor(private route:Router,private webclient : WebClient,private rou : ActivatedRoute){}
  mainspinner : boolean = false
  menudetails : Menudetails[] = []
  patientid : Number = 0
  patient : Patient = new Patient()
  patientdaysheets : Patientdaysheet[] = []
  ngOnInit(): void
  {
    this.patientid = Number(this.rou.snapshot.paramMap.get("id"))     
    this.mainspinner = true
    this.webclient.getAll<Menudetails[]>("getallmenuitemsmenunamebymenuoreder/patient").subscribe(
      (response)=>{
        this.menudetails=response;
        this.mainspinner = false
        this.webclient.get<Patient>("patient/"+this.patientid)
        .then((res)=>{
          this.patient = res
          this.webclient.getAll<Patientdaysheet[]>("getallpatientdaysheetbypatient/"+this.patient.patientid).subscribe(
            (response)=>{
              this.patientdaysheets = response
              this.mainspinner = false
            },(error)=>{}
           )
        })
        .catch((err)=>{})
      },(error)=>{this.mainspinner = false}
    )
  }
  activeTab : number = 0;
  tabname : string = ''
  selectTab(tab : Menudetails) {
    this.activeTab = tab.menuid;
    this.tabname = tab.classname
  }
}
