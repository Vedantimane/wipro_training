import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../interface/user';

@Injectable({
  providedIn: 'root'
})
export class UserLoginService {
private baseUrl = 'http://localhost:8080/users';

  constructor(private http: HttpClient) {}

  login(userEmail: string, userPassword: string): Observable<User> {
    return this.http.get<User>(`${this.baseUrl}/login`, {
      params: { userEmail, userPassword }
    });
  }

  
}