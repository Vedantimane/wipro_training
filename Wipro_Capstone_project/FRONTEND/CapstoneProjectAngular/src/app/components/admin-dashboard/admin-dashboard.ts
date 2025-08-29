import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { ProductService } from '../../services/product-service';
import { Product } from '../../interface/product';
import { CommonModule, CurrencyPipe } from '@angular/common';
import { FormsModule } from '@angular/forms';


@Component({
  selector: 'app-admin-dashboard',
  imports: [CurrencyPipe, FormsModule, CommonModule],
  templateUrl: './admin-dashboard.html',
  styleUrls: ['./admin-dashboard.css']
})
export class AdminDashboard implements OnInit {

  products: Product[] = [];
  selectedProduct: Product | null = null; // for update
  newProduct: Product = {} as Product;     // for create
  errorMessage: string = '';
  searchTerm: any;

  constructor(private productService: ProductService, private cdr: ChangeDetectorRef) { }

  ngOnInit(): void {
    this.loadProducts();
  }

  loadProducts(): void {
    console.log('Loading products...');
    this.productService.getAllProducts().subscribe({
      next: (res) => {
        console.log('Products from API:', res);
        this.products = res;
        this.cdr.detectChanges();  // Ensure view updates
      },
      error: (err) => {
        this.errorMessage = 'Error loading products: ' + err.message;
        console.error(this.errorMessage);
      }
    });
  }

  selectProduct(product: Product): void {
    console.log('Selected product for edit:', product);
    this.selectedProduct = { ...product }; // clone object for editing
  }

  createProduct(): void {
    console.log('Creating product:', this.newProduct);
    this.productService.createProduct(this.newProduct).subscribe({
      next: () => {
        alert('Product created successfully');
        this.newProduct = {} as Product;
        this.loadProducts();
      },
      error: (err) => {
        console.error('Error creating product:', err);
        alert('Error creating product: ' + err.message);
      }
    });
  }

  updateProduct(): void {
    if (!this.selectedProduct || this.selectedProduct.productId === undefined) {
      alert('Cannot update: Product ID is missing!');
      return;
    }

    console.log('Updating product:', this.selectedProduct);
    this.productService.updateProduct(this.selectedProduct.productId, this.selectedProduct).subscribe({
      next: () => {
        alert('Product updated successfully');
        this.selectedProduct = null;
        this.loadProducts();
      },
      error: (err) => {
        console.error('Error updating product:', err);
        alert('Error updating product: ' + err.message);
      }
    });
  }

  deleteProduct(id?: number): void {
    if (id === undefined) {
      alert('Cannot delete: Product ID is missing!');
      return;
    }

    if (!confirm('Are you sure you want to delete this product?')) return;

    console.log('Deleting product with ID:', id);
    this.productService.deleteProduct(id).subscribe({
      next: () => {
        alert('Product deleted successfully');
        this.loadProducts();
      },
      error: (err) => {
        console.error('Error deleting product:', err);
        alert('Error deleting product: ' + err.message);
      }
    });
  }

  cancelEdit(): void {
    console.log('Cancel editing');
    this.selectedProduct = null;
  }

  get filteredProducts(): Product[] {
  if (!this.searchTerm) return this.products;
  return this.products.filter(p =>
    p.productName.toLowerCase().startsWith(this.searchTerm.toLowerCase())
  );
}
}