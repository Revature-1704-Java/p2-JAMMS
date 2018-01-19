import { Component, OnInit } from '@angular/core';
import { Product } from '../shared/product';
import { Book } from '../shared/book';
import { ProductService } from '../shared/product.service';
import { BookService } from '../shared/books.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css']
})
export class ProductDetailComponent implements OnInit {

  product: Book;

  constructor(private bookService: BookService, private route: ActivatedRoute) { }

  ngOnInit() {
    let bookId: number = parseInt(this.route.snapshot.params['productId']);
    this.bookService.getBookById(bookId).subscribe((response) => {
      this.product = response;
    });
  }

}
