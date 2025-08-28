import { Component } from '@angular/core';
import { ProductService } from '../product-service';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-product-add',
  imports: [FormsModule],
  templateUrl: './product-add.html',
  styleUrl: './product-add.css'
})
export class ProductAdd {

  constructor(private productService:ProductService, private router:Router){}
  productName:string='';
    productCategory:string='';
    productPrice:number=0;

  addProduct() {
  console.log('Adding product: ', this.productName, this.productCategory, this.productPrice);

  this.productService.addProduct({
    name: this.productName,
    category: this.productCategory,
    price: this.productPrice
  }).subscribe(response => {
      console.log("Product added", response);
      this.productName = '';
      this.productCategory = '';
      this.productPrice = 0;
      this.router.navigate(['/productList']);
    },
    error => {
      console.log('Error creating product:', error);
    });
}


  

}
