import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { ProductService } from '../../services/product-service';
import { Product } from '../../interface/product';
import { CommonModule, CurrencyPipe } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { OrderService } from '../../services/order-service';
import { CartDTO } from '../../interface/cart';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-dashboard',
  imports: [CurrencyPipe, CommonModule, FormsModule],
  templateUrl: './user-dashboard.html',
  styleUrl: './user-dashboard.css'
})
export class UserDashboard implements OnInit {

  products: Product[] = [];
  errorMessage: string = '';
  searchTerm: any;
 userId: number = 6;

  constructor(private productService: ProductService, 
     private orderService: OrderService,
     private cdr: ChangeDetectorRef,
     private router: Router
    ) { }

  ngOnInit(): void {
    this.loadProducts();
  }

  loadProducts(): void {
  this.productService.getAllProducts().subscribe({
    next: (res) => {
      console.log('Products from API:', res);
      this.products = res;
      this.cdr.detectChanges();   
    },
   error: (err) => {
        this.errorMessage = 'Error loading products: ' + err.message;
        this.cdr.detectChanges();   // 👈 force UI update on error too
      }
    });
}

get filteredProducts(): Product[] {
  if (!this.searchTerm) return this.products;
  return this.products.filter(p =>
    p.productName.toLowerCase().startsWith(this.searchTerm.toLowerCase())
  );
}

addToCart(product: Product): void {
  const userId = Number(localStorage.getItem('userId'));
  const cartDTO: CartDTO = {
    userId: userId,
    productQuantityMap: { [product.productId!]: 1 }, // productId -> quantity
    totalAmount: product.productPrice
  };

  this.orderService.addToCart(cartDTO).subscribe({
    next: (cart) => {
      console.log('Cart updated:', cart);
      alert(`${product.productName} added to cart!`);
      this.router.navigate(['/cart', userId]); // redirect to cart
    },
    error: (err) => {
      console.error('Error adding to cart:', err);
      alert('Failed to add to cart. Make sure you are logged in.');
    }
  });
}


}