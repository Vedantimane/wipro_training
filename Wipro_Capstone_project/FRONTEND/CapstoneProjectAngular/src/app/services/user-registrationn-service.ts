import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserInterface } from '../interface/user-interface';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserRegistrationnService {
  
   private baseUrl = 'http://localhost:8080/user';

  constructor(private http: HttpClient) {}

  registerUser(user: UserInterface): Observable<string> {
return this.http.post<string>(`${this.baseUrl}/saveuser`, user);
  }
}
