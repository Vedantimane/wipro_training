import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'celuistoFar'
})
export class CeluistoFarPipe implements PipeTransform {

  transform(value: number, ...args: unknown[]): string {
    return  (value * 1.8) + 32 + '°F';
  }

}
