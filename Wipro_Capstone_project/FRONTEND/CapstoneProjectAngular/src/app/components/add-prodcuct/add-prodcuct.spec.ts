import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddProdcuct } from './add-prodcuct';

describe('AddProdcuct', () => {
  let component: AddProdcuct;
  let fixture: ComponentFixture<AddProdcuct>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddProdcuct]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddProdcuct);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
