import { Injectable } from '@angular/core';
import { Book } from './book';
import { Http } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

@Injectable()
export class BookService {

  constructor(private http: Http) { }
  
  getBooks(): Observable<any> {
    return this.http.get('http://52.23.192.48:8181/books/').map(res => res.json());
  }
  
  getBookById(bookId: number) : Observable<Book>{  
    console.log(bookId);
    const url = `http://52.23.192.48:8181/books/${bookId}`;   
    return this.http.get(url).map(res => res.json());
  }
  
  purchaseBook(bookId: number) {  
    console.log('Purchased Book: ' + bookId);
    const url = `http://52.23.192.48:8181/purchase/${bookId}`;
    return this.http.get(url).map(res => res.json());
  }

}
