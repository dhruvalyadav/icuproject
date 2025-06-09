import { PatientadmissionComponent } from './patientadmission/patientadmission.component';
import { NursesComponent } from './nurses/nurses.component';
import { Component, NgModule, OnInit } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MenuComponent } from './menu/menu.component';
import { HomeComponent } from './home/home.component';
import { AdmittedPatientsComponent } from './admitted-patients/admitted-patients.component';
import { AllPatientsComponent } from './all-patients/all-patients.component';
import { DoctorsComponent } from './doctors/doctors.component';
import { AddPatientComponent } from './add-patient/add-patient.component';
import { BasicPatientsDetailsComponent } from './basic-patients-details/basic-patients-details.component';
import { EditPatientComponent } from './edit-patient/edit-patient.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { VitalComponent } from './vital/vital.component';
import { CvsComponent } from './cvs/cvs.component';
import { QuickAnalysisComponent } from './quick-analysis/quick-analysis.component';
import { CnsComponent } from './cns/cns.component';
import { PupilComponent } from './pupil/pupil.component';
import { IntakeComponent } from './intake/intake.component';
import { OutputComponent } from './output/output.component';
import { AnthropometryComponent } from './anthropometry/anthropometry.component';
import { PatientdaysheetComponent } from './patientdaysheet/patientdaysheet.component';
import { PhysiothearpyComponent } from './physiothearpy/physiothearpy.component';
import { HourlyobservationComponent } from './hourlyobservation/hourlyobservation.component';
import { PatientadditionalscoresComponent } from './patientadditionalscores/patientadditionalscores.component';
import { PatientadditionaltestsComponent } from './patientadditionaltests/patientadditionaltests.component';
import { EmbolismComponent } from './embolism/embolism.component';
import { PatientMedicationChartComponent } from './patient-medication-chart/patient-medication-chart.component';
import { PatientMedicationLogComponent } from './patient-medication-log/patient-medication-log.component';
import { VentilatorModeComponent } from './ventilator-mode/ventilator-mode.component';
import { PatientVentilatorComponent } from './patient-ventilator/patient-ventilator.component';
import { PatientSosMedicationComponent } from './patient-sos-medication/patient-sos-medication.component';
import { PatientlinestubesComponent } from './patientlinestubes/patientlinestubes.component';
import { PatientivfluidComponent } from './patientivfluid/patientivfluid.component';
import { EditlinesTubesComponent } from './editlines-tubes/editlines-tubes.component';
import { EditIVfuildComponent } from './edit-ivfuild/edit-ivfuild.component';
import { ConsultantPatientVisitComponent } from './consultant-patient-visit/consultant-patient-visit.component';
import { ShiftrmonurseComponent } from './shiftrmonurse/shiftrmonurse.component';
import { IcuComponent } from './icu/icu.component';
import { PatientinfusionComponent } from './patientinfusion/patientinfusion.component';
import { RmonurselogComponent } from './rmonurselog/rmonurselog.component';
import { WebClient } from './web-client';
import { menu , submenu , Menudetails } from './entities';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  /*{
    path: "", pathMatch:'full', redirectTo:'/login'
  },
  {
    path : "login" ,component : LoginComponent
  },*/
  {
    path: "",
    component: HomeComponent,
  },
  {path : "home",component : DashboardComponent},
  { path: "dashboard", component: DashboardComponent },
  { path: "quickAnalysis", component: QuickAnalysisComponent },
  { path: "vitals", component: VitalComponent },
  { path: "CVC", component: CvsComponent },
  { path: "CNS", component: CnsComponent },
  { path: "Pupil", component: PupilComponent },
  { path: "Intake", component: IntakeComponent },
  { path: "Output", component: OutputComponent },
  { path: "patient/anthropometry", component: AnthropometryComponent },
  { path: "patient/edit", component: AddPatientComponent },
  { path: "patient/admission", component: PatientadmissionComponent },
  { path: "patient/daysheet", component: PatientdaysheetComponent },
  { path: "physiotheropy", component: PhysiothearpyComponent },
  { path: "daysheet/HourlyObservation", component: HourlyobservationComponent },
  { path: "daysheet/PatientScore", component: PatientadditionalscoresComponent },
  { path: "daysheet/PatientTest", component: PatientadditionaltestsComponent },
  { path: "daysheet/embolism", component: EmbolismComponent },
  { path: "daysheet/PatientMedicationChart", component: PatientMedicationChartComponent },
  { path: "daysheet/PatientMedicationLog", component: PatientMedicationLogComponent },
  { path: "daysheet/VentilatorMode", component: VentilatorModeComponent },
  { path: "daysheet/PatientVentilator", component: PatientVentilatorComponent },
  { path: "daysheet/PatientSOSMedication", component: PatientSosMedicationComponent },
  { path: "patient/Patientlinestubes", component: PatientlinestubesComponent },
  { path: "patient/PatientIVFulid", component: PatientivfluidComponent },
  { path: "patient/ShifttRMOnurse", component: ShiftrmonurseComponent },
  { path: "patient/PatientInfusion", component: PatientinfusionComponent },
  { path: "patient/RMONursely", component: RmonurselogComponent },
  { path: "patient/ConsultantPatientVisit", component: ConsultantPatientVisitComponent },
  { path: "patient/EditLinesTubes", component: EditlinesTubesComponent },
  { path: "patient/IVFluid", component: EditIVfuildComponent },
  { path: "patient/ICU", component: IcuComponent },

  { path : "patientedits/:id",component : AdmittedPatientsComponent},
  { path : "addpatient",component : AllPatientsComponent},
  { path : "patient/admit/:id",component : EditPatientComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule implements OnInit{

  /*constructor(private webclient : WebClient){}
  ngOnInit(): void {
    this.webclient.getAll<Menudetails[]>("getallmenuitems").subscribe(
      (response)=>{
         response.map((res)=>{
           routes.push({path : res.link , component : Component})
         })
      },(error)=>{}
    )
  }*/

  ngOnInit(): void {
    
  }

}

/*{ label: 'Dashboard', link: '/dashboard', icon: 'dashboard' },
    { label: 'Quick Analysis', link: '/dashboard', icon: 'monitor' },
    { label: 'Vitals', link: '/projects', icon: 'monitor_heart' },
    { label: 'CVC', link: '/calendar', icon: 'favorite' },
    { label: 'CNS', link: '/team', icon: 'psychology' },
    { label: 'Pupil', link: '/messages', icon: 'visibility' },
    { label: 'Intake', link: '/settings', icon: 'invert_colors' },
    { label: 'Output', link: '/help', icon: 'device_thermostat' },
    { label: 'Anthropometry', link: '/anthropometry', icon: 'straighten' },
    { label: 'Patient', link: '/patient', icon: 'personal_injury' },
    { label: 'Consultant', link: '/consultant', icon: 'medical_services' },
    { label: 'Staff Nurse', link: '/staff-nurse', icon: 'home' },
    { label: 'RMO Incharge', link: '/rmo', icon: 'supervisor_account' },
    { label: 'Ventilator', link: '/ventilator', icon: 'air' },
    { label: 'Infusion', link: '/infusion', icon: 'IV' },
    { label: 'SOS Medication', link: '/sos-meds', icon: 'emergency' },
    { label: 'Patient Scores', link: '/scores', icon: 'assessment' },
    { label: 'Embolism', link: '/embolism', icon: 'coronavirus' },
    { label: 'IV Fluid', link: '/iv-fluid', icon: 'invert_colors' }*/