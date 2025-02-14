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
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';

import Material from '@primeng/themes/material';
import { provideHttpClient, withFetch } from '@angular/common/http';
import { BasicPatientsDetailsComponent } from './basic-patients-details/basic-patients-details.component';
import { EditPatientComponent } from './edit-patient/edit-patient.component';

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
    EditPatientComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    BrowserModule,
    BrowserAnimationsModule,
    ButtonModule,
    DrawerModule,
  ],
  providers: [provideHttpClient(withFetch()), provideAnimationsAsync(), providePrimeNG({ ripple: true, theme: { preset: Material } })],
  bootstrap: [AppComponent]
})
export class AppModule { }
