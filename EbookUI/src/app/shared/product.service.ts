import { Injectable } from '@angular/core';
import { Product } from './product';

@Injectable()
export class ProductService {

  getProducts(): Product[] {
    return products;
  }

  getProductById(productId: number): Product {
    return products.find(p => p.id === productId);
  }

}

const products = [
  {id: 15, title: 'The Last Unicorn', author: 'Peter S. Beagle', published: 1968, price: 2.18},
  {id: 16, title: 'The Silmarillion', author: 'J. R. R. Tolkien', published: 1977, price: 3.65},
  {id: 11, title: 'Neuromancer', author: 'William Gibson', published: 1984, price: 2.71},
  {id: 12, title: 'Snow Crash', author: 'Neal Stephenson', published: 1992, price: 4.80},
  {id: 14, title: 'His Majesty\'s Dragon', author: 'Naomi Novik', published: 2006, price: 3.56},
  {id: 13, title: 'The Martian', author: 'Andy Weir', published: 2011, price: 3.69}
]