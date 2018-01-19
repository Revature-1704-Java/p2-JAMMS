import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Router} from '@angular/router';
import {Http} from '@angular/http';
import {BehaviorSubject} from 'rxjs/BehaviorSubject';
import { Observable } from 'rxjs/Observable';
import {Customer} from './shared/customer'
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
  public Login(username: String, password: String): Observable<Customer>{
    console.log(username);
    console.log(password);
    let user = {username, password};
    let url = `http://localhost:8181/logins/${username}/${password}`;
    let login = this.http.get(url).map(res=> res.json());
  login.subscribe(response =>{
    this.customer = response;
    if (this.customer==null){
      console.log('error');
      this.rout.navigateByUrl('/login');
    }
    else{
    console.log('success');
    sessionStorage.setItem('ID', String(response['id']));
    this.rout.navigateByUrl('');
    }
  }
);
  return login;
  }
}
