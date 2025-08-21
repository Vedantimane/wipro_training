import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { PipesCases } from "./pipes-cases/pipes-cases";

@Component({
  selector: 'app-root',
  imports: [PipesCases],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('pipeDirDemo');
}
