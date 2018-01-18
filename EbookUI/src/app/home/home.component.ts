import { Component, OnInit } from '@angular/core';
import { Book } from '../shared/book';
import { BookService } from '../shared/books.service';
import {ServerrequestsService} from '../servicerequests.service';
import {Router} from '@angular/router';
import {FilterPipe} from '../filter.pipe';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  providers: [FilterPipe]
})
export class HomeComponent implements OnInit {
  books: Book[] = [];
  constructor(private router: Router, private bookService: BookService, private filter: FilterPipe) { }
  term: any;
  ngOnInit() {
    if (sessionStorage.getItem('login')===null || sessionStorage.getItem('login')==='false'){

    }
    this.books = this.bookService.getBooks();
  }

}
