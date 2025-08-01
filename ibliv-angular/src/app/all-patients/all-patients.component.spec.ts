import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllPatientsComponent } from './all-patients.component';

describe('AllPatientsComponent', () => {
  let component: AllPatientsComponent;
  let fixture: ComponentFixture<AllPatientsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AllPatientsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AllPatientsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
