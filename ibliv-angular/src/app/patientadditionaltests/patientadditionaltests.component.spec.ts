import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientadditionaltestsComponent } from './patientadditionaltests.component';

describe('PatientadditionaltestsComponent', () => {
  let component: PatientadditionaltestsComponent;
  let fixture: ComponentFixture<PatientadditionaltestsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PatientadditionaltestsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PatientadditionaltestsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
