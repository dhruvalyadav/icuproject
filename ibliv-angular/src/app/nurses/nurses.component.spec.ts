import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NursesComponent } from './nurses.component';

describe('NursesComponent', () => {
  let component: NursesComponent;
  let fixture: ComponentFixture<NursesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [NursesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NursesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
