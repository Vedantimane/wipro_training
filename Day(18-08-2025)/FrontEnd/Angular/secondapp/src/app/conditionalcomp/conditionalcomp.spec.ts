import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Conditionalcomp } from './conditionalcomp';

describe('Conditionalcomp', () => {
  let component: Conditionalcomp;
  let fixture: ComponentFixture<Conditionalcomp>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Conditionalcomp]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Conditionalcomp);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
