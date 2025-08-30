import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CartModel, CartDTO } from '../interface/cart';
import { Order, OrderDTO } from '../interface/order';

@Injectable({
  providedIn: 'root'
})
export class OrderService {
   private baseUrl = 'http://localhost:8080'; // backend URL

  constructor(private http: HttpClient) {}

  // Use the key 'jwt' since login component stores it as 'jwt'
  private getAuthHeaders(): HttpHeaders {
    const token = localStorage.getItem('jwt'); 
    return new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });
  }

  // CART METHODS
  addToCart(cartDTO: CartDTO): Observable<CartModel> {
    return this.http.post<CartModel>(`${this.baseUrl}/cart`, cartDTO, { headers: this.getAuthHeaders() });
  }

  getCartByUserId(userId: number): Observable<CartModel> {
    return this.http.get<CartModel>(`${this.baseUrl}/cart/${userId}`, { headers: this.getAuthHeaders() });
  }

  removeFromCart(userId: number, productId: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/cart/${userId}/${productId}`, { headers: this.getAuthHeaders() });
  }

  clearCart(userId: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/cart/${userId}`, { headers: this.getAuthHeaders() });
  }

  // // ORDER METHODS
  // placeOrder(orderDTO: OrderDTO): Observable<Order> {
  //   return this.http.post<Order>(`${this.baseUrl}/order`, orderDTO, { headers: this.getAuthHeaders() });
  // }

  getOrdersByUserId(userId: number): Observable<Order[]> {
    return this.http.get<Order[]>(`${this.baseUrl}/order/user/${userId}`, { headers: this.getAuthHeaders() });
  }



  placeOrder(orderDTO: OrderDTO): Observable<Order> {
    return this.http.post<Order>(`${this.baseUrl}/order`, orderDTO, { headers: this.getAuthHeaders() });
  }

  confirmOrder(orderId: number): Observable<Order> {
    return this.http.put<Order>(`${this.baseUrl}/order/${orderId}/confirm`, {}, { headers: this.getAuthHeaders() });
  }
  // Get all orders (for admin)
getAllOrders(): Observable<Order[]> {
  return this.http.get<Order[]>(`${this.baseUrl}/order/admin/all`, { headers: this.getAuthHeaders() });
}

cancelOrder(orderId: number): Observable<string> {
  return this.http.put<string>(`${this.baseUrl}/order/${orderId}/cancel`, {}, { headers: this.getAuthHeaders() });
}


}