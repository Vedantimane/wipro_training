import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Exercise15 } from './exercise15';

describe('Exercise15', () => {
  let component: Exercise15;
  let fixture: ComponentFixture<Exercise15>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Exercise15]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Exercise15);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
