import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { OrderRequest } from './order-request';
import { Observable } from 'rxjs';
import { Order } from './order';

@Injectable({
  providedIn: 'root'
})
export class OrderService {
private baseUrl = 'http://localhost:8080/orders';

  constructor(private http: HttpClient) {}

  // Place a new order
  placeOrder(orderRequest: OrderRequest): Observable<Order> {
    return this.http.post<Order>(this.baseUrl, orderRequest);
  }

  // Get all orders
  getOrders(): Observable<Order[]> {
    return this.http.get<Order[]>(this.baseUrl);
  }
}
