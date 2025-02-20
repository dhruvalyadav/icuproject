import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ResettokenComponent } from './resettoken.component';

describe('ResettokenComponent', () => {
  let component: ResettokenComponent;
  let fixture: ComponentFixture<ResettokenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ResettokenComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ResettokenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
