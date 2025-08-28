import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Palindrome } from './palindrome/palindrome';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Palindrome],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('testdemo');

    word: string = '';
  reversed: string = '';
  result: string = '';

  checkPalindrome() {
    if (!this.word) {
      this.result = 'Please enter a word';
      this.reversed = '';
      return;
    }

    // Clean word: lowercase only alphabets/numbers
    const cleaned = this.word.toLowerCase().replace(/[^a-z0-9]/g, '');

    // Reverse using built-in methods
    this.reversed = cleaned.split('').reverse().join('');

    this.result = (cleaned && cleaned === this.reversed) 
      ? 'Palindrome ✅' 
      : 'Not Palindrome ❌';
  }
}

