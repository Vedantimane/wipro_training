import { NgClass, NgStyle,  } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-exercise2',
  imports: [NgClass, NgStyle],
  templateUrl: './exercise2.html',
  styleUrl: './exercise2.css'
})
export class Exercise2 {
  flag1 = true;
  flag2 = false;
  color :string ="red";

  getNgClass() {
    return {
      'app1': this.flag1,
      'app2': this.flag2
    };
  }
}
