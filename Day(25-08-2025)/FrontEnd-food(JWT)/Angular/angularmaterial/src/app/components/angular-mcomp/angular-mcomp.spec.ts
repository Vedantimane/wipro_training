import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AngularMComp } from './angular-mcomp';

describe('AngularMComp', () => {
  let component: AngularMComp;
  let fixture: ComponentFixture<AngularMComp>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AngularMComp]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AngularMComp);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
