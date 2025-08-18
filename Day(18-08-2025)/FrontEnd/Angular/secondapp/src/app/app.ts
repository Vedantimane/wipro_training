import { Component, signal } from '@angular/core';
// import { RouterOutlet } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { Searchcomp } from './searchcomp/searchcomp';
import { Conditionalcomp } from "./conditionalcomp/conditionalcomp";
import { Exercise15 } from "./exercise15/exercise15";

@Component({
  selector: 'app-root',
  imports: [FormsModule, Searchcomp, Conditionalcomp, Exercise15],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {

  protected readonly title = signal('secondapp');


 
 num = 20;
numbers: number[] = [];

constructor() {
  for (let i = 1; i <= this.num; i++) {
    this.numbers.push(i);
  }
}

}
