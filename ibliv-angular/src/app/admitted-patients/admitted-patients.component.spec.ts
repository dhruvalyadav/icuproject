import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdmittedPatientsComponent } from './admitted-patients.component';

describe('AdmittedPatientsComponent', () => {
  let component: AdmittedPatientsComponent;
  let fixture: ComponentFixture<AdmittedPatientsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AdmittedPatientsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdmittedPatientsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
