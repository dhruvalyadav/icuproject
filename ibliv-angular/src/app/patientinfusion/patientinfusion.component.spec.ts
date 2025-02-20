import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientinfusionComponent } from './patientinfusion.component';

describe('PatientinfusionComponent', () => {
  let component: PatientinfusionComponent;
  let fixture: ComponentFixture<PatientinfusionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PatientinfusionComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PatientinfusionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
