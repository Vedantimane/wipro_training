import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { foodInterface } from '../../interface/foodInterface';
import { FormsModule } from '@angular/forms';
import { CommonModule, CurrencyPipe } from '@angular/common';
import { FoodService } from '../../services/food-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-food',
  imports: [FormsModule, CommonModule, CurrencyPipe],
  templateUrl: './food.html',
  styleUrl: './food.css'
})
export class Food implements OnInit{

 foods: foodInterface[] = [];  // array to store food list

 

  constructor(private router: Router,
    private foodService: FoodService,
    private cdr: ChangeDetectorRef
  ){}

  ngOnInit(){
    this.foodService.getFoods().subscribe((data)=>{
      let tokendata:any=localStorage.getItem("token");
      // console.log(data)
      this.foods = data;
      this.cdr.detectChanges()
    }, (error)=>{
      alert("Error while fetching food data")
      console.log(error)
    })
  }

  logout(){
    localStorage.removeItem('token')
    this.router.navigate(['/login'])
    
  }



}