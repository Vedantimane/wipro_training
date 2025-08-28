import { Component } from '@angular/core';
import { FormControl, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-reactiveform',
  imports: [ReactiveFormsModule],
  templateUrl: './reactiveform.html',
  styleUrl: './reactiveform.css'
})
export class Reactiveform {
fname = new FormControl();
  reversed:string = "";

constructor() {
    this.fname.valueChanges.subscribe((value) => {
      if (value) {
        this.reversed = value.split('').reverse().join('');
      } else {
        this.reversed = '';
      }
    });
  }
}
