import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CnsComponent } from './cns.component';

describe('CnsComponent', () => {
  let component: CnsComponent;
  let fixture: ComponentFixture<CnsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CnsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CnsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
