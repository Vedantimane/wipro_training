import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { OrderService } from '../../services/order-service';
import { ProductService } from '../../services/product-service';
import { Router } from '@angular/router';
import { Product } from '../../interface/product';
import { CartModel } from '../../interface/cart';
import { CommonModule, CurrencyPipe } from '@angular/common';
import { FormsModule } from '@angular/forms';

interface CartProduct {
  productId: number;
  name: string;
  price: number;
  quantity: number;
  subtotal: number;
}

@Component({
  selector: 'app-cart',
  imports:[CurrencyPipe, FormsModule, CommonModule],
  templateUrl: './cart.html',
  styleUrls: ['./cart.css'],
})
export class Cart implements OnInit {
  cart: CartModel = { cartId: 0, userId: 0, productQuantityMap: {}, totalAmount: 0 };
  products: CartProduct[] = [];

  constructor(
    private orderService: OrderService,
    private productService: ProductService,
    private router: Router,
    private cdr: ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    const userId = 6; // replace with actual logged-in user id
    this.loadCart(userId);
  }

  loadCart(userId: number): void {
    this.orderService.getCartByUserId(userId).subscribe({
      next: (data) => {
        const cartData: CartModel = data ?? {
          cartId: 0,
          userId,
          productQuantityMap: {},
          totalAmount: 0,
        };
        this.cart = cartData;

        const entries: [string, number][] = Object.entries(cartData.productQuantityMap || {});
        this.products = [];

        if (entries.length === 0) {
          this.cart.totalAmount = 0;
          this.cdr.detectChanges();
          return;
        }

        let processed = 0;

        entries.forEach(([productIdStr, quantity]) => {
          const productId = Number(productIdStr);
          const qty: number = quantity ?? 0;

          this.productService.getProductById(productId).subscribe({
            next: (product: Product) => {
              if (product && product.productId !== undefined) {
                this.products.push({
                  productId: product.productId,
                  name: product.productName,
                  price: product.productPrice,
                  quantity: qty,
                  subtotal: qty * product.productPrice,
                });

                processed++;
                if (processed === entries.length) {
                  this.updateTotal();
                  this.cdr.detectChanges();
                }
              }
            },
            error: (err) => console.error(`Error fetching product ${productId}`, err),
          });
        });
      },
      error: (err) => console.error('Error loading cart', err),
    });
  }

  private updateTotal(): void {
    this.cart.totalAmount = this.products.reduce((sum, item) => sum + item.subtotal, 0);
  }

  increaseQuantity(item: CartProduct): void {
    item.quantity++;
    item.subtotal = item.quantity * item.price;
    this.cart.productQuantityMap[item.productId] = item.quantity;
    this.updateTotal();
  }

  decreaseQuantity(item: CartProduct): void {
    if (item.quantity > 1) {
      item.quantity--;
      item.subtotal = item.quantity * item.price;
      this.cart.productQuantityMap[item.productId] = item.quantity;
      this.updateTotal();
    }
  }

  removeProduct(productId: number): void {
    const userId = 6; // replace with actual logged-in user id
    this.orderService.removeFromCart(userId, productId).subscribe({
      next: () => this.loadCart(userId),
      error: (err) => console.error(err),
    });
  }

placeOrder(): void {
  const orderDTO = {
    userId: this.cart.userId,
    productQuantityMap: this.cart.productQuantityMap,
    totalAmount: this.cart.totalAmount,
    status: 'PENDING'
  };

  this.orderService.placeOrder(orderDTO).subscribe({
    next: (order) => {
      // Redirect to Payment component with orderId and cart info
      this.router.navigate(['/payment'], {
        state: { orderId: order.orderId, cart: this.cart }
      });
    },
    error: (err) => console.error('Error placing order', err)
  });
}

}
