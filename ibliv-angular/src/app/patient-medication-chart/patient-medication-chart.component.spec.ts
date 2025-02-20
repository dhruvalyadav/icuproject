import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientMedicationChartComponent } from './patient-medication-chart.component';

describe('PatientMedicationChartComponent', () => {
  let component: PatientMedicationChartComponent;
  let fixture: ComponentFixture<PatientMedicationChartComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PatientMedicationChartComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PatientMedicationChartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
