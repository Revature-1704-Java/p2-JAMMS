import { Component, Input } from '@angular/core';
import { Product } from '../shared/product';
import { Book } from '../shared/book';

@Component({
  selector: 'app-product-item',
  templateUrl: './product-item.component.html',
  styleUrls: ['./product-item.component.css']
})
export class ProductItemComponent {

  @Input() product: Book;

}
