import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VentilatorModeComponent } from './ventilator-mode.component';

describe('VentilatorModeComponent', () => {
  let component: VentilatorModeComponent;
  let fixture: ComponentFixture<VentilatorModeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [VentilatorModeComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VentilatorModeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
