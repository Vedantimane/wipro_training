import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { foodInterface } from '../../interface/foodInterface';
import { FormsModule } from '@angular/forms';
import { CommonModule, CurrencyPipe } from '@angular/common';
import { FoodService } from '../../services/food-service';

@Component({
  selector: 'app-food',
  imports: [FormsModule, CommonModule, CurrencyPipe],
  templateUrl: './food.html',
  styleUrl: './food.css'
})
export class Food implements OnInit{

 foods: foodInterface[] = [];  // array to store food list

  constructor(
    private foodService: FoodService,
    private cdr: ChangeDetectorRef  // inject ChangeDetectorRef
  ) { }

  ngOnInit(): void {
    this.getFoods();  // fetch food list on component load
  }

  // fetch all foods from backend
  getFoods(): void {
    this.foodService.getAllFoods().subscribe({
      next: (data) => {
        this.foods = data;
        this.cdr.detectChanges(); // manually trigger change detection
      },
      error: (err) => console.error('Error fetching foods:', err)
    });
  }
}