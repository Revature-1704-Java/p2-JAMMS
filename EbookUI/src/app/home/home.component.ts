import { Component, OnInit } from '@angular/core';
import { Product } from '../shared/product';
import { ProductService } from '../shared/product.service';
import { Book} from '../shared/book';
import { BookService } from '../shared/books.service';
import {ServerrequestsService} from '../servicerequests.service';
import { Http} from '@angular/http';
import {FilterPipe} from '../filter.pipe';
import { Observable } from 'rxjs/Observable';
import {Router} from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  providers: [FilterPipe]
})
export class HomeComponent implements OnInit {
  public books: Observable<any>;
  constructor(private router: Router, private bookService: BookService, private filter: FilterPipe) { }
  term: any;
  
  ngOnInit() {
    this.getBooks();
    
   
    }
    getBooks(): void{
      this.bookService.getBooks().subscribe((response) => {
        this.books = response;
    });

  
  }
}
