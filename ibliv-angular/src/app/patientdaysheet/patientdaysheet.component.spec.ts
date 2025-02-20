import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientdaysheetComponent } from './patientdaysheet.component';

describe('PatientdaysheetComponent', () => {
  let component: PatientdaysheetComponent;
  let fixture: ComponentFixture<PatientdaysheetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PatientdaysheetComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PatientdaysheetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
