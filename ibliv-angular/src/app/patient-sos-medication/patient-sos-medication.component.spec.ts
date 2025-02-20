import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientSosMedicationComponent } from './patient-sos-medication.component';

describe('PatientSosMedicationComponent', () => {
  let component: PatientSosMedicationComponent;
  let fixture: ComponentFixture<PatientSosMedicationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PatientSosMedicationComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PatientSosMedicationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
