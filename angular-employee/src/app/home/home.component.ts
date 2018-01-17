import { Component, OnInit } from '@angular/core';
import { Book } from '../shared/book';
import { BookService } from '../shared/book.service';
import { Review } from '../shared/review';
import { ReviewService } from '../shared/review.service';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  books: Book[] = [];
  
  reviews: Review[] = [];
  
  constructor(private bookService: BookService, private reviewService: ReviewService) { }

  ngOnInit() {
    this.books = this.bookService.getBooks();
    this.reviews = this.reviewService.getReviews();
  }

}
