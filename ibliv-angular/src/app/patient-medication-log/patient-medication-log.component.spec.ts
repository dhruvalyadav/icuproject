import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientMedicationLogComponent } from './patient-medication-log.component';

describe('PatientMedicationLogComponent', () => {
  let component: PatientMedicationLogComponent;
  let fixture: ComponentFixture<PatientMedicationLogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PatientMedicationLogComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PatientMedicationLogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
