import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsultantPatientVisitComponent } from './consultant-patient-visit.component';

describe('ConsultantPatientVisitComponent', () => {
  let component: ConsultantPatientVisitComponent;
  let fixture: ComponentFixture<ConsultantPatientVisitComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ConsultantPatientVisitComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConsultantPatientVisitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
