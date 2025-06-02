import { PatientadmissionComponent } from './patientadmission/patientadmission.component';
import { NursesComponent } from './nurses/nurses.component';
import { NgModule } from '@angular/core';
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
import { CnsComponent } from './cns/cns.component';
import { PupilComponent } from './pupil/pupil.component';
import { IntakeComponent } from './intake/intake.component';
import { OutputComponent } from './output/output.component';
import { AnthropometryComponent } from './anthropometry/anthropometry.component';
import { ConsultantPatientVisitComponent } from './consultant-patient-visit/consultant-patient-visit.component';

const routes: Routes = [
  {
    path: "", pathMatch:'full', redirectTo:'/login'
  },
  {
    path: "login",
    component: HomeComponent,
  },
  {
    path:'home',
    component:HomeComponent,
    children:
    [
      {
        path: "dashboard",component:DashboardComponent
      },
      {
        path: "admitted-patients",component:AdmittedPatientsComponent
      },
      {
        path:"all-patients",component:AllPatientsComponent
      },
      {
        path:"doctors",component:DoctorsComponent
      },
      {
        path:"nurses",component:NursesComponent
      },
      {
        path:"basic-patient-details", component:BasicPatientsDetailsComponent
      },
      {
        path:"edit-patient/:id",component:AddPatientComponent
      },
      {
        path:"patientadmission/:id",component:PatientadmissionComponent
      }
    ]
  },
  {
    path : "hourly",
    component : HomeComponent,
    children : [
      {path : "vitals",component : VitalComponent},
      {path : "cvs",component : CvsComponent},
      {path : "cns",component : CnsComponent},
      {path : "pupil",component : PupilComponent},
      {path : "Intake",component : IntakeComponent},
      {path : "Output",component : OutputComponent}
    ]
  },
  {
    path : "anthropometry",component : AnthropometryComponent
  },
  {
    path:"add-patient",component:AddPatientComponent
  },
  {
    path:"consultant",component : ConsultantPatientVisitComponent
  },
  {
    path : "staff-nurse",component : NursesComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

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