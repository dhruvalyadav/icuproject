import { Component, Input, OnInit } from '@angular/core';
import { Linestubes, Patient, Patientdaysheet, Patientlinestubes } from '../entities';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { WebClient } from '../web-client';

@Component({
  selector: 'app-patientlinestubes',
  standalone: false,

  templateUrl: './patientlinestubes.component.html',
  styleUrl: './patientlinestubes.component.scss'
})
export class PatientlinestubesComponent implements OnInit{
   patlinestubes : Patientlinestubes = new Patientlinestubes()
   linestubeid : number = 0
   @Input() patientdaysheets : Patientdaysheet[] = []
   @Input() Patient : Patient = new Patient()
   linestubes : Linestubes[] = []
   patientdaysheetid : number = 0
   spinner : boolean = true
   linetubeid : number = 0
   mainspinner : boolean = false
   message : string = 'Admission done sucessfully'
  alerttype  : 'success' | 'error' | 'warning' | 'info' = 'info'
  alertmode : boolean = false
   constructor(private router : Router,private webclient : WebClient){}

   ngOnInit(): void {
     this.mainspinner = true
     this.webclient.getAll<Linestubes[]>("getalllinestubes").subscribe(
      (response)=>{this.linestubes = response;this.mainspinner = false},(error)=>{}
     )
   }
   addpatientlinesandtubes(form : NgForm){
       if(form.invalid){
        this.alertmode = true
        this.message = "Fill all start(*) marked fields"
        this.alerttype = 'error'
       } else {
          this.spinner = false
          this.patlinestubes.createddate = new Date()
          this.patlinestubes.linestubes = this.linestubes.filter((lt)=>{return lt.linestubesid==this.linestubeid})[0]
          this.patlinestubes.patientdaysheet = this.patientdaysheets.filter((sheet)=>{return sheet.patientdaysheetid==this.patientdaysheetid})[0]    
          this.webclient.post<Patientlinestubes,typeof Patientlinestubes>("savepatientlinestubes",this.patlinestubes)
          .then((res)=>{
            this.spinner = true;
            this.message = "Sucessfully Updated Patient Lines Tubes details"
            this.alerttype = 'success'   
            this.alertmode = true    
            this.patlinestubes = new Patientlinestubes()
          })
          .catch((err)=>{})
       }
   }
}
