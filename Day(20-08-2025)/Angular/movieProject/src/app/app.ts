import { Component, signal } from '@angular/core';
import { MovieList } from "./movie-list/movie-list";
// import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  imports: [MovieList],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('movieProject');
}
