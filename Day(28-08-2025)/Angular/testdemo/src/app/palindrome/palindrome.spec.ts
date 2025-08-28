import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Palindrome } from './palindrome';

describe('Palindrome', () => {
  let component: Palindrome;
  let fixture: ComponentFixture<Palindrome>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Palindrome]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Palindrome);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

 it('should check if a string is palindrome', () => {
    expect(component.isPalindrome('madam')).toBeTrue();
    expect(component.isPalindrome('racecar')).toBeTrue();
    expect(component.isPalindrome('hello')).toBeFalse();
    expect(component.isPalindrome('A man a plan a canal Panama')).toBeTrue(); // case + spaces
  });
});