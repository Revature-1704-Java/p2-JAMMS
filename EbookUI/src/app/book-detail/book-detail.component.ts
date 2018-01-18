import { Component, OnInit, Input } from '@angular/core';  
import { Book } from '../shared/book';
import { BookService } from '../shared/books.service';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs/Observable';

@Component({
  selector: 'app-book-detail',
  templateUrl: './book-detail.component.html',
  styleUrls: ['./book-detail.component.css']
})

export class BookDetailComponent implements OnInit {

  public book: Book;

  constructor(private bookService: BookService, private route: ActivatedRoute) { }

  ngOnInit() {
    let bookId: number = parseInt(this.route.snapshot.params['bookId']);
    this.bookService.getBookById(bookId).subscribe((response) => {
      this.book = response;
    });
   
  }

 


}
