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
        path: "patientadmission",
        component:PatientadmissionComponent
      },
      {
        path: "dashboard",
        component:DashboardComponent
      },
      {
        path: "admitted-patients",
        component:AdmittedPatientsComponent
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
        path:"add-patient",component:AddPatientComponent
      },
      {
        path:"basic-patient-details", component:BasicPatientsDetailsComponent
      },
      {
        path:"edit-patient/:id",component:AddPatientComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
