import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Router} from '@angular/router'
import {Observable} from 'rxjs/Observable';
import {BehaviorSubject} from 'rxjs';
@Injectable()
export class GetBooksService {

  constructor(private http: HttpClient, private rout: Router) { }
  public getBooks(){
    //var x = sessionStorage.getItem('ID');
    //var y = sessionStorage.getItem('Type');
    

  }

}
