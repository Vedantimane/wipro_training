import { Component, signal } from '@angular/core';
import { Home } from './home/home';
// import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  imports: [Home],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('taskProject');
}
