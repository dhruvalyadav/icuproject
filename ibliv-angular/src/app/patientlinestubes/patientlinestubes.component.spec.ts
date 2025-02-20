import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientlinestubesComponent } from './patientlinestubes.component';

describe('PatientlinestubesComponent', () => {
  let component: PatientlinestubesComponent;
  let fixture: ComponentFixture<PatientlinestubesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PatientlinestubesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PatientlinestubesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
