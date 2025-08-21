import { Directive, ElementRef } from '@angular/core';

@Directive({
  selector: '[appHighlightstrikethru]'
})
export class Highlightstrikethru {

    constructor(private el: ElementRef) {
    this.el.nativeElement.style.backgroundColor = 'yellow';              
    this.el.nativeElement.style.textDecoration = 'line-through';   
    this.el.nativeElement.style.textDecorationColor = 'black'; 
  }

}
