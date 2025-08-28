import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { foodInterface } from '../interface/foodInterface';

@Injectable({
  providedIn: 'root'
})
export class FoodService {
  private baseUrl = 'http://localhost:8080/foods'; 

  constructor(private http: HttpClient) { }

  getAllFoods(): Observable<foodInterface[]> {
    return this.http.get<foodInterface[]>(`${this.baseUrl}`);
  }

  getFoodById(id: number): Observable<foodInterface> {
    return this.http.get<foodInterface>(`${this.baseUrl}/${id}`);
  }

  saveFood(food: foodInterface): Observable<foodInterface> {
    return this.http.post<foodInterface>(`${this.baseUrl}`, food);
  }

  updateFood(food: foodInterface): Observable<foodInterface> {
    return this.http.put<foodInterface>(`${this.baseUrl}`, food);
  }

  deleteFood(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
}