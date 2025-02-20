import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientivfluidComponent } from './patientivfluid.component';

describe('PatientivfluidComponent', () => {
  let component: PatientivfluidComponent;
  let fixture: ComponentFixture<PatientivfluidComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PatientivfluidComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PatientivfluidComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
