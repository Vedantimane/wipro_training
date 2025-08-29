import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { ProductService } from '../../services/product-service';
import { Product } from '../../interface/product';
import { CommonModule, CurrencyPipe } from '@angular/common';
import { FormsModule } from '@angular/forms';

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

  constructor(private productService: ProductService,  private cdr: ChangeDetectorRef) { }

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

}