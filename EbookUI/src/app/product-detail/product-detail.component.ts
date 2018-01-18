import { Component, OnInit } from '@angular/core';
import { Book } from '../shared/book';
import { BookService } from '../shared/books.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css']
})
export class ProductDetailComponent implements OnInit {

  book: Book;
  yearPublished: number;

  constructor(private bookService: BookService, private route: ActivatedRoute) { }

  ngOnInit() {
   // this.book = this.bookService.getBookById(bookId);
    //this.yearPublished = this.book.publishedDate.getFullYear();
    let bookId: number = parseInt(this.route.snapshot.params['productId']);
    this.bookService.getBookById(bookId).subscribe((response) => {
      this.book = response;
    });
  }

}
