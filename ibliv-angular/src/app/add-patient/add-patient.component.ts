
import { Component, Input, Output, EventEmitter,OnInit } from '@angular/core';
import { Patient } from '../entities';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { WebClient } from '../web-client';

@Component({
  selector: 'app-add-patient',
  standalone: false,

  templateUrl: './add-patient.component.html',
  styleUrl: './add-patient.component.scss'
})
export class AddPatientComponent implements OnInit {
  constructor(private router : Router,private webclient : WebClient){}
  patients : any[] = [
  ]

  mainspinner : boolean = false
  ngOnInit(): void {
    this.mainspinner = true
    this.webclient.getAll<Patient[]>("patient-list").subscribe(
      (response)=>{this.patients=response;this.mainspinner = false},(error)=>{this.mainspinner = false}
    )
  }
  onEdit(patient: Patient) {
    this.router.navigate(["patientedits/"+patient.patientid])
  }

  onDelete(patient: Patient) {
     this.webclient.delete<Patient>("deletepatient/"+patient.patientid)
     .then((res)=>{alert("Patient Deleted Sucessfully");window.location.reload()})
     .catch((error)=>{console.log(error)})
  }
  calculateAge(dob: string | Date): number {
    const birthDate = new Date(dob);
    const today = new Date();
    let age = today.getFullYear() - birthDate.getFullYear();
    const monthDiff = today.getMonth() - birthDate.getMonth();
    
    if (monthDiff < 0 || (monthDiff === 0 && today.getDate() < birthDate.getDate())) {
      age--;
    }
    
    return age;
  }

  addpatient(){
    this.router.navigate(["addpatient"])
  }

  spinner : boolean = true
  filterpatients(event : any){
    console.log("jssj")
    if (event.target.value!=''){
      this.spinner = false
      this.webclient.getAll<Patient[]>("filterpatient/"+event.target.value).subscribe(
        (response)=>{this.patients = response},(error)=>{this.spinner = false})
    } else {
      this.spinner = true
    }
  }

}
