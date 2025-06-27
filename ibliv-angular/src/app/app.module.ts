import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ButtonModule } from 'primeng/button';
import { SidebarModule } from 'primeng/sidebar';
// import { SlideMenuModule } from 'primeng/slidemenu';
import { HomeComponent } from './home/home.component';
import { AdmittedPatientsComponent } from './admitted-patients/admitted-patients.component';
import { AllPatientsComponent } from './all-patients/all-patients.component';
import { DoctorsComponent } from './doctors/doctors.component';
import { NursesComponent } from './nurses/nurses.component';
import { AddPatientComponent } from './add-patient/add-patient.component';
import { providePrimeNG } from 'primeng/config';
import { DrawerModule } from 'primeng/drawer';
import { ToolbarModule } from 'primeng/toolbar';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';

import Material from '@primeng/themes/material';
import { provideHttpClient, withFetch } from '@angular/common/http';
import { BasicPatientsDetailsComponent } from './basic-patients-details/basic-patients-details.component';
import { EditPatientComponent } from './edit-patient/edit-patient.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { AnthropometryComponent } from './anthropometry/anthropometry.component';
import { ConsultantPatientVisitComponent } from './consultant-patient-visit/consultant-patient-visit.component';
import { DivisionComponent } from './division/division.component';
import { RoleComponent } from './role/role.component';
import { UserRoleComponent } from './user-role/user-role.component';
import { RoleAccessComponent } from './role-access/role-access.component';
import { MenudetailsComponent } from './menudetails/menudetails.component';
import { EmbolismComponent } from './embolism/embolism.component';
import { IcuComponent } from './icu/icu.component';
import { IvfluidComponent } from './ivfluid/ivfluid.component';
import { LinestubesComponent } from './linestubes/linestubes.component';
import { PatientadditionalscoresComponent } from './patientadditionalscores/patientadditionalscores.component';
import { PatientadditionaltestsComponent } from './patientadditionaltests/patientadditionaltests.component';
import { PatientadmissionComponent } from './patientadmission/patientadmission.component';
import { PatientdaysheetComponent } from './patientdaysheet/patientdaysheet.component';
import { PatientinfusionComponent } from './patientinfusion/patientinfusion.component';
import { PatientivfluidComponent } from './patientivfluid/patientivfluid.component';
import { PatientlinestubesComponent } from './patientlinestubes/patientlinestubes.component';
import { PatientMedicationChartComponent } from './patient-medication-chart/patient-medication-chart.component';
import { PatientMedicationLogComponent } from './patient-medication-log/patient-medication-log.component';
import { PatientSosMedicationComponent } from './patient-sos-medication/patient-sos-medication.component';
import { PatientVentilatorComponent } from './patient-ventilator/patient-ventilator.component';
import { PhysiothearpyComponent } from './physiothearpy/physiothearpy.component';
import { ResettokenComponent } from './resettoken/resettoken.component';
import { RmonurselogComponent } from './rmonurselog/rmonurselog.component';
import { ShiftrmonurseComponent } from './shiftrmonurse/shiftrmonurse.component';
import { UserComponent } from './user/user.component';
import { UserTokenComponent } from './user-token/user-token.component';
import { VentilatorModeComponent } from './ventilator-mode/ventilator-mode.component';
import { VitalComponent } from './vital/vital.component';
import { FooterComponent } from './footer/footer.component';
import { CvsComponent } from './cvs/cvs.component';
import { CnsComponent } from './cns/cns.component';
import { PupilComponent } from './pupil/pupil.component';
import { IntakeComponent } from './intake/intake.component';
import { OutputComponent } from './output/output.component';
import { QuickAnalysisComponent } from './quick-analysis/quick-analysis.component';
import { HourlyobservationComponent } from './hourlyobservation/hourlyobservation.component';
import { EditlinesTubesComponent } from './editlines-tubes/editlines-tubes.component';
import { EditIVfuildComponent } from './edit-ivfuild/edit-ivfuild.component';
import { UrlComponent } from './url/url.component';
import { AlertComponent } from './alert/alert.component';
import { LoginComponent } from './login/login.component';
import { AdminComponent } from './admin/admin.component';
import { ReportsComponent } from './reports/reports.component';

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    HomeComponent,
    AdmittedPatientsComponent,
    AllPatientsComponent,
    DoctorsComponent,
    NursesComponent,
    AddPatientComponent,
    BasicPatientsDetailsComponent,
    EditPatientComponent,
    DashboardComponent,
    AnthropometryComponent,
    ConsultantPatientVisitComponent,
    DivisionComponent,
    RoleComponent,
    UserRoleComponent,
    RoleAccessComponent,
    MenudetailsComponent,
    EmbolismComponent,
    IcuComponent,
    IvfluidComponent,
    LinestubesComponent,
    PatientadditionalscoresComponent,
    PatientadditionaltestsComponent,
    PatientadmissionComponent,
    PatientdaysheetComponent,
    PatientinfusionComponent,
    PatientivfluidComponent,
    PatientlinestubesComponent,
    PatientMedicationChartComponent,
    PatientMedicationLogComponent,
    PatientSosMedicationComponent,
    PatientVentilatorComponent,
    PhysiothearpyComponent,
    ResettokenComponent,
    RmonurselogComponent,
    ShiftrmonurseComponent,
    UserComponent,
    UserTokenComponent,
    VentilatorModeComponent,
    VitalComponent,
    FooterComponent,
    CvsComponent,
    CnsComponent,
    PupilComponent,
    IntakeComponent,
    OutputComponent,
    QuickAnalysisComponent,
    HourlyobservationComponent,
    EditlinesTubesComponent,
    EditIVfuildComponent,
    UrlComponent,
    AlertComponent,
    LoginComponent,
    AdminComponent,
    ReportsComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    BrowserModule,
    BrowserAnimationsModule,
    ButtonModule,
    DrawerModule,
    ToolbarModule
  ],
  providers: [provideHttpClient(withFetch()), provideAnimationsAsync(), providePrimeNG({ ripple: true, theme: { preset: Material } })],
  bootstrap: [AppComponent]
})
export class AppModule { }
