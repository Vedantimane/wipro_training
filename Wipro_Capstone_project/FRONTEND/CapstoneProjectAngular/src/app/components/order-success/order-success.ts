import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Order } from '../../interface/order';
import { OrderService } from '../../services/order-service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { ProductService } from '../../services/product-service';

@Component({
  selector: 'app-order-success',
  imports: [FormsModule, CommonModule],
  templateUrl: './order-success.html',
  styleUrl: './order-success.css'
})
export class OrderSuccess implements OnInit {
  orders: Order[] = [];
  orderProductsMap: { [orderId: number]: { productId?: number, productName: string, productPrice: number, quantityOrdered: number }[] } = {};
  errorMessage: string = '';

  constructor(
    private orderService: OrderService,
    private productService: ProductService,
    private cdr: ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    const userId = Number(localStorage.getItem('userId'));
    if (!userId) {
      this.errorMessage = 'User not logged in';
      return;
    }

    // Fetch only this user's orders
    this.orderService.getOrdersByUserId(userId).subscribe({
      next: (res) => {
        this.orders = res;
        console.log('Fetched orders:', this.orders);

        // Map products for each order
        this.orders.forEach(order => {
          const productsArray = Object.keys(order.productQuantityMap).map(productId => ({
            productId: Number(productId),
            productName: 'Loading...', // temporary, will fetch real name
            productPrice: 0,
            quantityOrdered: order.productQuantityMap[Number(productId)]
          }));

          this.orderProductsMap[order.orderId] = productsArray;

          // Fetch real product details
          productsArray.forEach((item, index) => {
            this.productService.getProductById(item.productId!).subscribe(prod => {
              if (prod) {
                this.orderProductsMap[order.orderId][index].productName = prod.productName;
                this.orderProductsMap[order.orderId][index].productPrice = prod.productPrice;
                this.cdr.detectChanges();
              }
            });
          });
        });
      },
      error: (err) => {
        this.errorMessage = 'Error fetching orders: ' + err.message;
        console.error(err);
      }
    });
  }

  cancelOrder(orderId: number): void {
    if (!confirm('Are you sure you want to cancel this order?')) return;

    this.orderService.cancelOrder(orderId).subscribe({
      next: () => {
        alert('Order cancelled successfully');
        console.log(`Order ${orderId} cancelled`);

        // Update order status locally
        this.orders = this.orders.map(o =>
          o.orderId === orderId ? { ...o, orderStatus: 'CANCELLED' } : o
        );
        this.cdr.detectChanges();
      },
      error: (err) => {
        alert('Error cancelling order: ' + err.message);
        console.error('Cancel order error:', err);
      }
    });
  }

  objectKeys(obj: any): number[] {
    return Object.keys(obj).map(key => +key);
  }
}