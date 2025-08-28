import { Component } from '@angular/core';
import { OrderRequest } from '../order-request';
import { OrderService } from '../order-service';
import { Product } from '../product';
import { ProductService } from '../product-service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-place-order',
  imports: [CommonModule,  FormsModule],
  templateUrl: './place-order.html',
  styleUrl: './place-order.css'
})
export class PlaceOrder {
 products: Product[] = [];
  selectedProductId!: string;
  quantity!: number;

  constructor(
    private productService: ProductService,
    private orderService: OrderService
  ) {}

  ngOnInit(): void {
    this.loadProducts();
  }

  loadProducts(): void {
    this.productService.getProducts().subscribe(products => this.products = products);
  }

  placeOrder(): void {
    if (!this.selectedProductId || !this.quantity) {
      alert('Please select a product and enter quantity.');
      return;
    }

    const selectedProduct = this.products.find(p => p.id === this.selectedProductId);
    if (!selectedProduct) return;

    if (this.quantity > selectedProduct.quantity) {
      alert('Quantity exceeds available stock!');
      return;
    }

    const orderRequest: OrderRequest = {
      productId: this.selectedProductId,
      quantity: this.quantity
    };

    this.orderService.placeOrder(orderRequest).subscribe(order => {
      alert('Order placed successfully!');
      this.loadProducts(); // update product stock
    });
  }
}