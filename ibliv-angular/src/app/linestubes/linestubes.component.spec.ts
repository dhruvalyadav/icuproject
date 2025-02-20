import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LinestubesComponent } from './linestubes.component';

describe('LinestubesComponent', () => {
  let component: LinestubesComponent;
  let fixture: ComponentFixture<LinestubesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [LinestubesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LinestubesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
