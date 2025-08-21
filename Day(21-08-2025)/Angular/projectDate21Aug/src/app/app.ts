import { Component, signal } from '@angular/core';
// import { RouterOutlet } from '@angular/router';
import { Vehicle } from "./vehicle/vehicle";

@Component({
  selector: 'app-root',
  imports: [ Vehicle],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('projectDate21Aug');
}
