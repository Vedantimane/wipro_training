import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { ProductService } from '../product-service';
import { Router, RouterModule } from '@angular/router';
import { Product } from '../product';

@Component({
  selector: 'app-productlist',
  imports: [RouterModule],
  templateUrl: './productlist.html',
  styleUrl: './productlist.css'
})
export class Productlist implements OnInit {


  
  constructor( private productService:ProductService, private router:Router,private cdr: ChangeDetectorRef){}

  products:Product[]=[];
  
  ngOnInit() {
    console.log("product component initilized");

    this.productService.getProducts().subscribe((productData:Product[])=>{
      this.products=productData;
      this.cdr.detectChanges();
      console.log("productfetch: ",productData);
    },(error) => {
      console.error('Error fetching products:', error);
    });
  
    
  }

  addProduct() {
this.router.navigate(['/addProduct'])
}


}
