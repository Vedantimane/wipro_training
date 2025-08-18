import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Searchcomp } from './searchcomp';

describe('Searchcomp', () => {
  let component: Searchcomp;
  let fixture: ComponentFixture<Searchcomp>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Searchcomp]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Searchcomp);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
