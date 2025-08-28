import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductService } from '../product-service';
import { Product } from '../product';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-product-edit',
  imports: [FormsModule],
  templateUrl: './product-edit.html',
  styleUrls: ['./product-edit.css']
})
export class ProductEdit implements OnInit {

  id: string | null = null;

  product: Product = {
    id: '',
    name: '',
    category: '',
    price: 0
  };

  constructor(
    private activatedRoute: ActivatedRoute,
    private productService: ProductService,
    private router: Router,
    private cdr: ChangeDetectorRef  // ✅ Inject ChangeDetectorRef
  ) {}

  ngOnInit() {
    this.id = this.activatedRoute.snapshot.paramMap.get('id');

    if (this.id) {
      this.productService.findProduct(this.id).subscribe(product => {
        this.product = product; // id included
        console.log("Fetched product:", product);

        // ✅ Trigger change detection manually so form updates immediately
        this.cdr.detectChanges();
      });
    }
  }

  save() {
    if (!this.product.id) {
      console.error('Product ID missing, cannot save!');
      return;
    }

    this.productService.saveProduct(this.product).subscribe({
      next: (product) => {
        console.log('Product saved successfully:', product);
        this.router.navigate(['/productList']);
      },
      error: (error) => console.error('Error saving product:', error)
    });
  }
}
