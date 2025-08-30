import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { ProductService } from '../../services/product-service';
import { Product } from '../../interface/product';
import { CommonModule, CurrencyPipe } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';


@Component({
  selector: 'app-admin-dashboard',
  imports: [CurrencyPipe, FormsModule, CommonModule],
  templateUrl: './admin-dashboard.html',
  styleUrls: ['./admin-dashboard.css']
})
export class AdminDashboard implements OnInit {

  
  
  products: Product[] = [];
  errorMessage: string = '';
  searchTerm: string = '';

  constructor(
    private productService: ProductService,
    private cdr: ChangeDetectorRef,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loadProducts();
  }

  loadProducts(): void {
    this.productService.getAllProducts().subscribe({
      next: (res) => {
        this.products = res;
        this.cdr.detectChanges();
      },
      error: (err) => {
        this.errorMessage = 'Error loading products: ' + err.message;
        console.error(this.errorMessage);
      }
    });
  }

  deleteProduct(id?: number): void {
    if (!id) return alert('Cannot delete: Product ID missing!');
    if (!confirm('Are you sure you want to delete this product?')) return;

    this.productService.deleteProduct(id).subscribe({
      next: () => this.loadProducts(),
      error: (err) => alert('Error deleting product: ' + err.message)
    });
  }

  editProduct(id: number): void {
    this.router.navigate(['/admin/product-form', id]); // redirect to edit page
  }

  addProduct(): void {
    this.router.navigate(['/admin/product-form']); // redirect to add page
  }

  get filteredProducts(): Product[] {
    if (!this.searchTerm) return this.products;
    return this.products.filter(p =>
      p.productName.toLowerCase().startsWith(this.searchTerm.toLowerCase())
    );
  }
  viewAllOrders(): void {
  this.router.navigate(['/admin/orders']); // navigate to admin orders page
}

}