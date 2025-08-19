import { Component } from '@angular/core';
import { DisplayListComp } from "../display-list-comp/display-list-comp";
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-home-comp',
  imports: [DisplayListComp, CommonModule],
  templateUrl: './home-comp.html',
  styleUrl: './home-comp.css'
})
export class HomeComp {

remove(fruitName: string) {

  console.log("remove button clicked "+fruitName);
  this.fruits=this.fruits.filter(fruit => fruit.name !==fruitName);
}

  fruits= [
  {
    name: 'Strawberry',
    description: 'A bright red, heart-shaped fruit with a sweet flavor. Rich in antioxidants and perfect for desserts.',
    imageUrl: 'https://tse3.mm.bing.net/th/id/OIP.dIS48kcncMqFeZtd2pKVwgHaFj?pid=Api&P=0&h=180',
    price: 180
  },
  {
    name: 'Banana',
    description: 'A soft, sweet fruit with a yellow peel. High in potassium and great for energy.',
    imageUrl: 'https://tse2.mm.bing.net/th/id/OIP.GlrD0S0Md5wTtDi8_FqhtQHaE8?pid=Api&P=0&h=180',
    price: 60
  },
  {
    name: 'Pomegranate',
    description: 'A round fruit with red seeds that are juicy, sweet, and packed with antioxidants.',
    imageUrl: 'https://tse3.mm.bing.net/th/id/OIP.IbReqAEEPblCMU383nAoewHaEo?pid=Api&P=0&h=180',
    price: 220
  },
  {
    name: 'Kiwi',
    description: 'A small brown fruit with bright green flesh. Tangy, sweet, and full of vitamin C.',
    imageUrl: 'https://tse1.mm.bing.net/th/id/OIP.0afdpzymuaRRdK5pZDktUgHaFe?pid=Api&P=0&h=180',
    price: 120
  },
  {
    name: 'Grapes',
    description: 'Small, sweet, and juicy fruits that grow in clusters. Can be eaten fresh or used to make wine.',
    imageUrl: 'https://tse1.mm.bing.net/th/id/OIP.gMCJvU6MEwfkltxdmScNrgHaFG?pid=Api&P=0&h=180',
    price: 150
  },
  {
    name: 'Mango',
    description: 'A tropical fruit with sweet and juicy golden flesh. Known as the king of fruits.',
    imageUrl: 'https://tse3.mm.bing.net/th/id/OIP.xqz1jRaGy6Q_HdunXFJplAHaEo?pid=Api&P=0&h=180',
    price: 250
  },
  {
    name: 'Orange',
    description: 'A juicy citrus fruit known for its tangy flavor and rich vitamin C content.',
    imageUrl: 'https://tse2.mm.bing.net/th/id/OIP.M-ulLuHQjRaaaM2vNWNXjwHaE8?pid=Api&P=0&h=180',
    price: 80
  },
  {
    name: 'Apple',
    description: 'A crisp and juicy fruit that comes in red, green, and yellow varieties. Rich in fiber and vitamins.',
    imageUrl: 'https://tse2.mm.bing.net/th/id/OIP.uqRZIogdATy5Hi9gQQ1x6wHaE8?pid=Api&P=0&h=180',
    price: 120
  },
  {
    name: 'Watermelon',
    description: 'A large green fruit with sweet, juicy red flesh. Refreshing and perfect for summer.',
    imageUrl: 'https://tse2.mm.bing.net/th/id/OIP.eigzaJUdGGj5hpoyMtYpwQHaFj?pid=Api&P=0&h=180',
    price: 90
  },
  {
    name: 'Pineapple',
    description: 'A tropical fruit with a spiky skin and sweet, tangy flesh. Perfect for juices and desserts.',
    imageUrl: 'https://tse3.mm.bing.net/th/id/OIP.mnLLvPo1ifzRE0Pz-BaNWQHaE7?pid=Api&P=0&h=180',
    price: 180
  },
  {
    name: 'Lichi',
    description: 'A tropical fruit with a rough red shell and sweet, fragrant white flesh inside.',
    imageUrl: 'https://tse4.mm.bing.net/th/id/OIP.1e7nNcPEoWjAzaffxPYB1AHaFj?pid=Api&P=0&h=180',
    price: 200
  },
  {
    name: 'Papaya',
    description: 'A soft, orange-fleshed tropical fruit, rich in enzymes and vitamins.',
    imageUrl: 'https://tse4.mm.bing.net/th/id/OIP._E7vO0DtjDOF8OOEg0A7ygHaHa?pid=Api&P=0&h=180',
    price: 140
  }
];
}
