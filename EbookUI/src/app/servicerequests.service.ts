import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Router} from '@angular/router';
import {BehaviorSubject} from 'rxjs/BehaviorSubject';
import { Observable } from 'rxjs/Observable';
@Injectable()
export class ServerrequestsService {
  private login = new BehaviorSubject<boolean>(false);
  constructor(private http: HttpClient, private rout: Router) { 
  }
  public logout(): void{
    sessionStorage.clear();
    this.login.next(false);
    this.rout.navigateByUrl('/login');
  }
  public Login(email: String, password: String): Observable<any>{
    let login = this.http.post('http://localhost:8080/ServletDemo4/LoginServlet',
    {
      'email': email,
      'password': password
    },
    {
    headers: {
      'Content-Type': 'application/json'
    }
  }
  );
  login.subscribe(response =>{
    sessionStorage.setItem('ID', String(response['customerid']));
    sessionStorage.setItem('type', String (response['Type']));
  }
);
  return login;
  }
}
