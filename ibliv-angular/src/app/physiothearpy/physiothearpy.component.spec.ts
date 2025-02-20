import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PhysiothearpyComponent } from './physiothearpy.component';

describe('PhysiothearpyComponent', () => {
  let component: PhysiothearpyComponent;
  let fixture: ComponentFixture<PhysiothearpyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PhysiothearpyComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PhysiothearpyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
