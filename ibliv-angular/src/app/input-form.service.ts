import { Injectable, Input } from '@angular/core';
import { WebClient } from './web-client';
import { 
  completesheet,
  Anthropometry,
  Patientadditionalscores,
  Patientadmission,
  Patientinfusion,
  Patientivfluid,
  Patientlinestubes,
  Patientmedicationlog,
  Patientventilator,
  Patientdaysheet,
  Patientadditionaltests,
  Patientmedicationchart,
  Patient,
  Patientsosmedication,
  Rmonurselog,
  Shiftrmonurse,
  Hourlyobservation,
  Embolism,
  Consultantpatientvisit,
 } from './entities';

@Injectable({
  providedIn: 'root'
})
export class InputFormService {
  public static completesheet : completesheet = new completesheet()
  constructor(private webclient : WebClient){}
  public createsheet(){
    this.webclient.post<Anthropometry,typeof Anthropometry>("updateanthropometry",InputFormService.completesheet.anthropometry)
    .then((res)=>{
      InputFormService.completesheet.anthropometry = new Anthropometry()
    })
    .catch((error)=>{console.log(error)})
    this.webclient.post<Patientdaysheet,Patientdaysheet>("savepatientdaysheet",InputFormService.completesheet.patientdaysheet)
    .then((res)=>{
      InputFormService.completesheet.patientdaysheet = res
    })
    .catch((err)=>{})
    this.webclient.post<Rmonurselog,Rmonurselog>("addrmonurselog",InputFormService.completesheet.rmonurselog)
    .then((res)=>{
      InputFormService.completesheet.rmonurselog = res
    })
    .catch((err)=>{console.log(err)})
    InputFormService.completesheet.shiftnurses.map((shift)=>{
      this.webclient.post<Shiftrmonurse,typeof Shiftrmonurse>("addshiftrmo",shift)
      .then((res)=>{})
      .catch((err)=>{console.log(err)})
    })
    InputFormService.completesheet.hourlyobservations.map((hour)=>{
      this.webclient.post<Hourlyobservation,Hourlyobservation>("addhourlyobservation",hour)
      .then((res)=>{})
      .catch((err)=>{})
    })
    this.webclient.post<Patientadditionalscores,Patientadditionalscores>("saveadditionalpatientscore",InputFormService.completesheet.patientadditionalscore)
    .then((res)=>{
      InputFormService.completesheet.patientadditionalscore = res
    })
    .catch((error)=>{console.log(error)})
    this.webclient.post<Patientadditionaltests,Patientadditionaltests>("saveadditionalpatienttest",InputFormService.completesheet.patienttest)
    .then((res)=>{
      InputFormService.completesheet.patienttest = res
    })
    .catch((err)=>{})
    this.webclient.post<Embolism,Embolism>("saveembolism",InputFormService.completesheet.embolism)
    .then((res)=>{
      InputFormService.completesheet.embolism = res
    })
    .catch((error)=>{console.log(error)})
    InputFormService.completesheet.patientmedicationcharts.map((chart)=>{
      this.webclient.post<Patientmedicationchart,Patientmedicationchart>("savepatientmedicationchart",chart)
      .then((res)=>{})
      .catch((error)=>{})
    })
    InputFormService.completesheet.patientmedicationlog.map((chart)=>{
      this.webclient.post<Patientmedicationlog,typeof Patientmedicationlog>("savepatientmedicationlog",chart)
      .then((res)=>{})
      .catch((error)=>{})
    })
    this.webclient.post<Patientventilator,Patientventilator>("addventilator",InputFormService.completesheet.patientventialtor)
    .then((res)=>{
      InputFormService.completesheet.patientventialtor = res
    })
    .catch((err)=>{})
    InputFormService.completesheet.patientsosmedication.map((sos)=>{
      this.webclient.post<Patientsosmedication,typeof Patientsosmedication>("savesosmedication",sos)
      .then((res)=>{})
      .catch((error)=>{})
    })
    InputFormService.completesheet.patientlines.map((pat)=>{
      this.webclient.post<Patientlinestubes,typeof Patientlinestubes>("savepatientlinestubes",pat)
      .then((res)=>{})
      .catch((err)=>{})
    })
    InputFormService.completesheet.patientivfluid.map((pativ)=>{
      this.webclient.post<Patientivfluid,typeof Patientivfluid>("addpatientivfluid",pativ)
      .then((res)=>{
      })
      .catch((err)=>{})
    })
    InputFormService.completesheet.patientinfusioncharts.map((indusion)=>{
      this.webclient.post<Patientinfusion,typeof Patientinfusion>("addpatientinfusion",indusion)
         .then((res)=>{})
         .catch((err)=>{console.log(err)})
    })
    this.webclient.post<Consultantpatientvisit,Consultantpatientvisit>("addconsultantpatientvisit",InputFormService.completesheet.consults)
    .then((res)=>{
      InputFormService.completesheet.consults = res
    })
    .catch((error)=>{})
  }
}
