import { AfterViewInit, ChangeDetectorRef, Component } from '@angular/core';
import { CartModel } from '../../interface/cart';
import { Router } from '@angular/router';
import { OrderService } from '../../services/order-service';
import { Product } from '../../interface/product';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ProductService } from '../../services/product-service';

interface PaymentProduct {
  productId: number;
  name: string;
  price: number;
  quantity: number;
  subtotal: number;
}

@Component({
  selector: 'app-payment',
  imports: [FormsModule, CommonModule],
  templateUrl: './payment.html',
  styleUrls: ['./payment.css']
})
export class Payment implements AfterViewInit {
   cart!: CartModel;
  orderId!: number;
  products: Product[] = [];
  paymentProducts: PaymentProduct[] = [];

  constructor(
    private router: Router,
    private orderService: OrderService,
    private productService: ProductService,
    private cdr: ChangeDetectorRef
  ) {
    const state = this.router.getCurrentNavigation()?.extras.state;
    this.cart = state?.['cart'];
    this.orderId = state?.['orderId'];
  }

  ngAfterViewInit(): void {
    if (!this.cart) return;

    const productIds = Object.keys(this.cart.productQuantityMap).map(id => +id);
    const productObservables = productIds.map(id => this.productService.getProductById(id));

    Promise.all(productObservables.map(obs => obs.toPromise()))
      .then(products => {
        this.products = products.filter((p): p is Product => !!p);
        this.buildPaymentProducts();
        this.cdr.detectChanges();
      })
      .catch(err => console.error('Error loading products', err));
  }

  buildPaymentProducts(): void {
    this.paymentProducts = this.products.map(prod => {
      const quantity = this.cart.productQuantityMap[prod.productId!] ?? 0;
      const price = prod.productPrice ?? 0;
      return {
        productId: prod.productId!,
        name: prod.productName,
        price: price,
        quantity: quantity,
        subtotal: quantity * price
      };
    });
  }

  getTotal(): number {
    return this.paymentProducts.reduce((sum, item) => sum + item.subtotal, 0);
  }

  payNow(): void {
    if (!this.orderId) {
       console.log('JWT Token:', localStorage.getItem('jwt'));
      alert('Order not found. Please place the order first.');
      return;
    }

    this.orderService.confirmOrder(this.orderId).subscribe({
      next: (order) => {
        alert('Payment successful! Order confirmed.');
        this.router.navigate(['/ordersuccess']);
      },
      error: (err) => console.error('Error confirming order', err)
    });
  }
}