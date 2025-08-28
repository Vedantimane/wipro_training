import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { AngularMComp } from "./components/angular-mcomp/angular-mcomp";
import { Reactiveform } from "./components/reactiveform/reactiveform";
import { Reactiveform2 } from "./components/reactiveform2/reactiveform2";

@Component({
  selector: 'app-root',
  imports: [MatSlideToggleModule, AngularMComp, Reactiveform, Reactiveform2],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('angularmaterial');
}
