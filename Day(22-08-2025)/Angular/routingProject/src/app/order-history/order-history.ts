import { Component } from '@angular/core';
import { OrderService } from '../order-service';
import { Order } from '../order';

@Component({
  selector: 'app-order-history',
  imports: [],
  templateUrl: './order-history.html',
  styleUrl: './order-history.css'
})
export class OrderHistory {

  orders: Order[] = [];

  constructor(private orderService: OrderService) { }

  ngOnInit(): void {
    this.orderService.getOrders().subscribe(data => {
      this.orders = data;
    });
  }
}

  loadOrders(): void {
    this.orderService.getOrders().subscribe(orders => this.orders = orders);
  }
}
