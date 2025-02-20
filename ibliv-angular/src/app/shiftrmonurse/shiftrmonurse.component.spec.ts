import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShiftrmonurseComponent } from './shiftrmonurse.component';

describe('ShiftrmonurseComponent', () => {
  let component: ShiftrmonurseComponent;
  let fixture: ComponentFixture<ShiftrmonurseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ShiftrmonurseComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ShiftrmonurseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
