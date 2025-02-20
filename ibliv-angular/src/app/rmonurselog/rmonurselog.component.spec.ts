import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RmonurselogComponent } from './rmonurselog.component';

describe('RmonurselogComponent', () => {
  let component: RmonurselogComponent;
  let fixture: ComponentFixture<RmonurselogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [RmonurselogComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RmonurselogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
