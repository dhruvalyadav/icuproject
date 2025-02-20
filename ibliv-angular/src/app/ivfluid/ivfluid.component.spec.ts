import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IvfluidComponent } from './ivfluid.component';

describe('IvfluidComponent', () => {
  let component: IvfluidComponent;
  let fixture: ComponentFixture<IvfluidComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [IvfluidComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(IvfluidComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
