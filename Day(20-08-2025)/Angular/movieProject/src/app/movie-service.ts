import { Injectable } from '@angular/core';
import { Movie } from './movie';

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  movielist:Movie[]=[
  { movieId: 1, movieName: 'Inception', movieLanguage: 'English', movieIMDBRating: 8.8 },
  { movieId: 2, movieName: '3 Idiots', movieLanguage: 'Hindi', movieIMDBRating: 8.4 },
  { movieId: 3, movieName: 'Parasite', movieLanguage: 'Korean', movieIMDBRating: 8.6 },
  { movieId: 4, movieName: 'Interstellar', movieLanguage: 'English', movieIMDBRating: 8.7 },
  { movieId: 5, movieName: 'Bahubali', movieLanguage: 'Telugu', movieIMDBRating: 8.2 },
  { movieId: 6, movieName: 'The Dark Knight', movieLanguage: 'English', movieIMDBRating: 9.0 },
  { movieId: 7, movieName: 'Dangal', movieLanguage: 'Hindi', movieIMDBRating: 8.3 },
  { movieId: 8, movieName: 'Spirited Away', movieLanguage: 'Japanese', movieIMDBRating: 8.6 },
  { movieId: 9, movieName: 'KGF: Chapter 2', movieLanguage: 'Kannada', movieIMDBRating: 8.4 },
  { movieId: 10, movieName: 'Avatar', movieLanguage: 'English', movieIMDBRating: 7.9 }
];

getMovies(): Movie[]{
  return this.movielist;
}
  
}
