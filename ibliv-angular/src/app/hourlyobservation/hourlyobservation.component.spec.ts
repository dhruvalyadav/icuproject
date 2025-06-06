import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HourlyobservationComponent } from './hourlyobservation.component';

describe('HourlyobservationComponent', () => {
  let component: HourlyobservationComponent;
  let fixture: ComponentFixture<HourlyobservationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [HourlyobservationComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HourlyobservationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
