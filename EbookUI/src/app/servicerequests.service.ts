import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Http, Headers, RequestOptions } from '@angular/http';
import { HttpHeaders, HttpClientModule } from '@angular/common/http';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';
import { Observable } from 'rxjs/Observable';
import { Customer } from './shared/customer';
import 'rxjs/add/operator/map';

@Injectable()
export class ServerrequestsService {
  private login = new BehaviorSubject<boolean>(false);
  private customer: Customer;
  constructor(private http: Http, private rout: Router, ) { 
  }
  public logout(): void{
    sessionStorage.clear();
    this.login.next(false);
    this.rout.navigateByUrl('/login');
  }
  public Login(loginName: string, loginPass: string): Observable<Customer>{
    console.log(loginName);
    console.log(loginPass);
    let url = `http://52.23.192.48:8181/login`;

    let body = new URLSearchParams();
    body.set('username', loginName);
    body.set('password', loginPass);

    console.log(body);
    console.log(JSON.stringify(body));
    console.log(body.toString());
    // return this.http.post(url, JSON.stringify(body)).map(res => res.json());
    return this.http.post(url, body.toString()).map(res => res.json());
  }
}
