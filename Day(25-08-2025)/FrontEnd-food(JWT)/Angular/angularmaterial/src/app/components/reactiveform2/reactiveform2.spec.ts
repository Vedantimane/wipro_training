import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Reactiveform2 } from './reactiveform2';

describe('Reactiveform2', () => {
  let component: Reactiveform2;
  let fixture: ComponentFixture<Reactiveform2>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Reactiveform2]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Reactiveform2);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
