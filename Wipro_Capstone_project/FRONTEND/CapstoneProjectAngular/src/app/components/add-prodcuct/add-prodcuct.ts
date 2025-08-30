import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { ProductService } from '../../services/product-service';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from '../../interface/product';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-add-prodcuct',
  imports: [CommonModule, FormsModule],
  templateUrl: './add-prodcuct.html',
  styleUrl: './add-prodcuct.css'
})
export class AddProdcuct implements OnInit {

  product: Product = {} as Product;  // Form model
  isEditMode: boolean = false;       // True if updating a product
  errorMessage: string = '';

  constructor(
    private productService: ProductService,
    private router: Router,
    private route: ActivatedRoute,
    private cd: ChangeDetectorRef       // Inject ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    console.log('Editing product ID:', id); 
    if (id) {
      this.isEditMode = true;
      this.productService.getProductById(+id).subscribe({
        next: (res) => {
          console.log('Product BEFORE edit:', res);  // Log fetched product
          this.product = res;
          this.cd.detectChanges();  // Force Angular to update the view
        },
        error: (err) => this.errorMessage = 'Error loading product: ' + err.message
      });
    }
  }

  saveProduct(): void {
  if (this.isEditMode && this.product.productId) {
    // Update existing product
    console.log('Product BEFORE update:', this.product); // Log before update
    this.productService.updateProduct(this.product.productId, this.product).subscribe({
      next: (res) => {
        console.log('Product AFTER update (response from API):', res); // Log after update
        alert('Product updated successfully');
        this.router.navigate(['/admin-dashboard']);
      },
      error: (err) => alert('Error updating product: ' + err.message)
    });
  } else {
    // Add new product
    console.log('Product BEFORE add:', this.product); // Log before adding
    this.productService.createProduct(this.product).subscribe({
      next: (res) => {
        console.log('Product AFTER add (response from API):', res); // Log after adding
        alert('Product added successfully');
        this.router.navigate(['/admin-dashboard']);
      },
      error: (err) => alert('Error adding product: ' + err.message)
    });
  }
}

  cancel(): void {
    this.router.navigate(['/admin-dashboard']);
  }
}
