import { Component, signal } from '@angular/core';
// import { RouterOutlet } from '@angular/router';
import { Exercise2 } from "./exercise2/exercise2";
import { HomeComp } from "./home-comp/home-comp";

@Component({
  selector: 'app-root',
  imports: [Exercise2, HomeComp],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('project1');
}
