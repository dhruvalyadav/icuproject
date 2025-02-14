import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BasicPatientsDetailsComponent } from './basic-patients-details.component';

describe('BasicPatientsDetailsComponent', () => {
  let component: BasicPatientsDetailsComponent;
  let fixture: ComponentFixture<BasicPatientsDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [BasicPatientsDetailsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BasicPatientsDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
