import { Component } from '@angular/core';

@Component({
  selector: 'app-palindrome',
  imports: [],
  templateUrl: './palindrome.html',
  styleUrl: './palindrome.css'
})
export class Palindrome {

    isPalindrome(str: string): boolean {
    if (!str) return false;
    const cleaned = str.toLowerCase().replace(/[^a-z0-9]/g, '');
    return cleaned === cleaned.split('').reverse().join('');
  }
}
