import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { inject } from '@angular/core';
import { WebClient } from '../web-client';
import { Icu, Patient, Patientadmission } from '../entities';

@Component({
  selector: 'app-patientadmission',
  standalone: false,

  templateUrl: './patientadmission.component.html',
  styleUrl: './patientadmission.component.scss'
})
export class PatientadmissionComponent implements OnInit
{
  activatedRoute = inject(ActivatedRoute);
  webClient = inject(WebClient);

  patientadmission = new Patientadmission;//{ icu: { icuid: 1 }, patient: { patientid: 1 } } as Patientadmission;
  id:any;
  icus: any;
  icu=new Icu;
  constructor(private route:Router){}
  ngOnInit(): void
  {
   this.activatedRoute.paramMap.subscribe((params)=>
    {
      if(params.has('id'))
      {
        this.id = params.get('id');
       //fetch patient details from API
        this.webClient.get<Patient>(`/patient/${this.id}`).then
        (
          (res)=>
          {
            this.patientadmission.patient=res;
          }
        )

      }
    }
   );

   this.getIcuList();
  }
  getIcuList()
  {
    this.webClient.getAll<Icu[]>('/icu-list').subscribe((res)=>
      {
        this.icus = res;
      }
    )
  }
  onSave()
  {
    console.log(this.patientadmission.icu.icuid);
    // this.webClient.get<Icu>('/icu/'+this.patientadmission.icu.icuid).
    // then((res)=>
    //   {
    //     this.patientadmission.icu = res;
    //   }
    // );
    console.log(this.patientadmission.patient);
    this.webClient.post<Patientadmission,Patientadmission>('/admit-patient',
      this.patientadmission).
    then((res)=>{
      console.log(res);
      alert('Patient admitted');
      this.route.navigate(['/home/admitted-patients']);
    });
  }
}
