import { DatePipe, LowerCasePipe, TitleCasePipe, UpperCasePipe } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms'; 
import { CeluistoFarPipe } from '../celuisto-far-pipe';
import { Highlightstrikethru } from '../highlightstrikethru';

@Component({
  selector: 'app-pipes-cases',
  imports: [UpperCasePipe, FormsModule, LowerCasePipe, TitleCasePipe, DatePipe, CeluistoFarPipe, Highlightstrikethru],
  templateUrl: './pipes-cases.html',
  styleUrl: './pipes-cases.css'
})
export class PipesCases {

  firstname:string ="";
  date: Date = new Date();
  celius:number =0;
}
