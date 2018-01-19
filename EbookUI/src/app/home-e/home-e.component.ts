import { Component, OnInit } from '@angular/core';
import { Book } from '../shared/book';
import { BookService } from '../shared/books.service';
import { Review } from '../shared/review';
import { ReviewService } from '../shared/review.service';

@Component({
  selector: 'app-home-e',
  templateUrl: './home-e.component.html',
  styleUrls: ['./home-e.component.css']
})
export class HomeEComponent implements OnInit {

  books: Book[] = [];
  
  reviews: Review[] = [];
  
  constructor(private bookService: BookService, private reviewService: ReviewService) { }

  ngOnInit() {
    //this.books = this.bookService.getBooks();
    this.reviews = this.reviewService.getReviews();
  }

}
