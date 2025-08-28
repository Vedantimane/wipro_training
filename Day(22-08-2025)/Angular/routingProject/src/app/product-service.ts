import { Injectable } from '@angular/core';
import { Product } from './product';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http: HttpClient) { }

  // Get all products
  getProducts(): Observable<Product[]> {
    return this.http.get<Product[]>("http://localhost:8080/product");
  }

  // Add new product
  addProduct(product: Product): Observable<Product> {
    return this.http.post<Product>("http://localhost:8080/product", product);
  }

  // Get product by ID
  findProduct(id: string): Observable<Product> {
    return this.http.get<Product>(`http://localhost:8080/product/${id}`);
  }

  // // Update product
  // saveProduct(product: Product): Observable<Product> {
  //   return this.http.put<Product>(`http://localhost:8080/product/${product.id}`, product);
  // }

 saveProduct(product: Product): Observable<Product> {
  return this.http.put<Product>(`http://localhost:8080/product/${product.id}`, product);
}


  // Delete product
  deleteProduct(id: string): Observable<void> {
    return this.http.delete<void>(`http://localhost:8080/product/${id}`);
  }
}
