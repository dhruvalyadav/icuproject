import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientadditionalscoresComponent } from './patientadditionalscores.component';

describe('PatientadditionalscoresComponent', () => {
  let component: PatientadditionalscoresComponent;
  let fixture: ComponentFixture<PatientadditionalscoresComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PatientadditionalscoresComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PatientadditionalscoresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
