import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductService } from '../product-service';

@Component({
  selector: 'app-product-delete',
  imports: [],
  templateUrl: './product-delete.html',
  styleUrl: './product-delete.css'
})
export class ProductDelete {

  id:string | null = null;
  constructor(private activeRoute:ActivatedRoute,private userService:ProductService,private router:Router) {
   }
   ngOnInit() {
         this.id = this.activeRoute.snapshot.paramMap.get('id');
         console.log("product to be deleted has id:", this.id);
         this.userService.deleteProduct(this.id!).subscribe(response => {
           console.log('product deleted successfully');
           this.router.navigate(['/productList']); // Navigate to the user list after deletion
           // Logic to navigate back to user list or show a success message
         }  , error => {
           console.error('product deleting user:', error);
           // Logic to handle error, e.g., show an error message
         }  );
   }

}
