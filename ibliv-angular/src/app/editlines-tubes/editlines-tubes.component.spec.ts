import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditlinesTubesComponent } from './editlines-tubes.component';

describe('EditlinesTubesComponent', () => {
  let component: EditlinesTubesComponent;
  let fixture: ComponentFixture<EditlinesTubesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [EditlinesTubesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditlinesTubesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
