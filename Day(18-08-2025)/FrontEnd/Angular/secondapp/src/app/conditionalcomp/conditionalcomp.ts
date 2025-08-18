import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-conditionalcomp',
  imports: [FormsModule],
  templateUrl: './conditionalcomp.html',
  styleUrl: './conditionalcomp.css'
})
export class Conditionalcomp {

   name:String = "vedanti";

color: string="";
   greet(){
    console.log(` hello ${this.name}`)
   }


    flag:boolean=true;
toggle() {
  this.flag=!this.flag;

}

countries: string[] = ["India", "Japan", "Russia", "Finland"];
loadedCountries: string[] = [];

loadCountries() {
  this.loadedCountries = this.countries;
}

}
