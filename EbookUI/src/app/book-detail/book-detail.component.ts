import { Component, OnInit } from '@angular/core';  
import { Book } from '../shared/book';
import { BookService } from '../shared/books.service';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-book-detail',
  templateUrl: './book-detail.component.html',
  styleUrls: ['./book-detail.component.css']
})
export class BookDetailComponent implements OnInit {

  book: Book;
  constructor(private bookService: BookService, private route: ActivatedRoute) { }

  ngOnInit() {
    let bookId: number = parseInt(this.route.snapshot.params['bookId'])
    this.book = this.bookService.getBookbyId(bookId);
    

 


}
