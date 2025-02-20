import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientVentilatorComponent } from './patient-ventilator.component';

describe('PatientVentilatorComponent', () => {
  let component: PatientVentilatorComponent;
  let fixture: ComponentFixture<PatientVentilatorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PatientVentilatorComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PatientVentilatorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
