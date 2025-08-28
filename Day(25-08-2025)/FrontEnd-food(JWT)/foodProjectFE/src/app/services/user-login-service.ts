import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../interface/user';
import { TokenData } from '../interface/token-data';

@Injectable({
  providedIn: 'root'
})
export class UserLoginService {
  private baseUrl = 'http://localhost:8080/user';

  constructor(private http: HttpClient) {}

  login(user: User): Observable<TokenData> {
    // Use TokenData type for the response
    return this.http.post<TokenData>(`${this.baseUrl}/login`, user);
  }

   getUser():Observable<User[]>{
    return this.http.get<User[]>(this.baseUrl)
  }

  createUser(user:User):Observable<void>{
    return this.http.post<void>(`${this.baseUrl}/save`, user)
  }
}