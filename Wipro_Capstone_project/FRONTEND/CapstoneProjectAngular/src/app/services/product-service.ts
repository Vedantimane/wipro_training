import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../interface/product';



@Injectable({
  providedIn: 'root'
})
export class ProductService {
 private baseUrl = 'http://localhost:8080/product';

  constructor(private http: HttpClient) { }

  // Helper to get Authorization header
  private getAuthHeaders(): HttpHeaders {
    const token = localStorage.getItem('jwt');
    return new HttpHeaders({
      'Authorization': token ? `Bearer ${token}` : ''
    });
  }

  // ------------------ READ ------------------
  getAllProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(this.baseUrl, { headers: this.getAuthHeaders() });
  }

  getProductById(id: number): Observable<Product> {
    return this.http.get<Product>(`${this.baseUrl}/${id}`, { headers: this.getAuthHeaders() });
  }

  getProductsByName(name: string): Observable<Product[]> {
    return this.http.get<Product[]>(`${this.baseUrl}/searchByName?name=${name}`, { headers: this.getAuthHeaders() });
  }

  // ------------------ WRITE ------------------
  createProduct(product: Product): Observable<string> {
    return this.http.post(`${this.baseUrl}`, product, { headers: this.getAuthHeaders(), responseType: 'text' });
  }

  updateProduct(id: number, product: Product): Observable<Product> {
    return this.http.put<Product>(`${this.baseUrl}/${id}`, product, { headers: this.getAuthHeaders() });
  }

  deleteProduct(id: number): Observable<string> {
    return this.http.delete(`${this.baseUrl}/${id}`, { headers: this.getAuthHeaders(), responseType: 'text' });
  }
}