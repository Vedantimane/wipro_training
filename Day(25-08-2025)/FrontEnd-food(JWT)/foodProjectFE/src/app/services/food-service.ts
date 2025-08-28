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

   getFoods():Observable<foodInterface[]>{
    return this.http.get<foodInterface[]>(this.baseUrl)
  }

  addFoods(foods:foodInterface):Observable<foodInterface>{
    return this.http.post<foodInterface>(this.baseUrl, foods)
  }

  deleteFood(id:number){
    return this.http.delete(`${this.baseUrl}/${id}`)
  }
}