import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-searchcomp',
  imports: [FormsModule],
  templateUrl: './searchcomp.html',
  styleUrl: './searchcomp.css'
})
export class Searchcomp {

searchText: string = '';

  names: string[] = [
    'Jayanta',
    'Jayaram',
    'Vedanti',
    'Ryan',
    'Alice',
    'Alex',
    'Alexa'
  ];

  filteredNames(): string[] {
  let result: string[] = [];
  for (let i = 0; i < this.names.length; i++) {
    let Namelist = this.names[i].toLowerCase();
    let searchName = this.searchText.toLowerCase();

    if (Namelist.startsWith(searchName)) {
      result.push(this.names[i]);
    }
  }
  return result;
}

}
