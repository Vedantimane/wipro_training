import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PipesCases } from './pipes-cases';

describe('PipesCases', () => {
  let component: PipesCases;
  let fixture: ComponentFixture<PipesCases>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PipesCases]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PipesCases);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
