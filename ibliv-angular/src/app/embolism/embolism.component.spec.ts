import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmbolismComponent } from './embolism.component';

describe('EmbolismComponent', () => {
  let component: EmbolismComponent;
  let fixture: ComponentFixture<EmbolismComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [EmbolismComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EmbolismComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
