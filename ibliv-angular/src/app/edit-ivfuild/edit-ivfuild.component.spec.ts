import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditIVfuildComponent } from './edit-ivfuild.component';

describe('EditIVfuildComponent', () => {
  let component: EditIVfuildComponent;
  let fixture: ComponentFixture<EditIVfuildComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [EditIVfuildComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditIVfuildComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
