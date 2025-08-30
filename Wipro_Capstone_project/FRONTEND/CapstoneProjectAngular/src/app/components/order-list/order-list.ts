import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Order } from '../../interface/order';
import { OrderService } from '../../services/order-service';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { DatePipe } from '@angular/common';
import { CommonModule } from '@angular/common'; 

@Component({
  selector: 'app-order-list',
  imports: [FormsModule, CommonModule, DatePipe],
  templateUrl: './order-list.html',
  styleUrl: './order-list.css'
})
export class OrderList implements OnInit {

  orders: Order[] = [];
  errorMessage: string = '';

  constructor(
    private orderService: OrderService,
    private cdr: ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    this.getAllOrders();
  }

  getAllOrders(): void {
    this.orderService.getAllOrders().subscribe({
      next: (res) => {
        this.orders = res;
        this.cdr.detectChanges();
      },
      error: (err) => {
        console.error('Error fetching orders', err);
        this.errorMessage = 'Error fetching orders: ' + err.message;
      }
    });
  }

  cancelOrder(orderId: number): void {
    if (!confirm('Are you sure you want to cancel this order?')) return;

    this.orderService.cancelOrder(orderId).subscribe({
      next: () => {
        alert('Order cancelled successfully');
        this.getAllOrders(); // refresh the list
      },
      error: (err) => {
        console.error('Error cancelling order', err);
        alert('Error cancelling order: ' + err.message);
      }
    });
  }

}
