import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplayListComp } from './display-list-comp';

describe('DisplayListComp', () => {
  let component: DisplayListComp;
  let fixture: ComponentFixture<DisplayListComp>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DisplayListComp]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DisplayListComp);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
