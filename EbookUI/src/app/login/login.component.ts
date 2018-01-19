import { Component, OnInit } from '@angular/core';
import {ServerrequestsService} from '../servicerequests.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
  public username: string;
  public password: string;
  public successful: String;
  constructor(private rout: Router,private logins: ServerrequestsService ) { }
  ngOnInit() {
    if (sessionStorage.getItem('login')==='true'){
      this.rout.navigateByUrl('/home');
    }
  }
  public login(){
    console.log("hello");
    this.logins.Login(this.username, this.password).subscribe((response) => {
      let customer = response;
      console.log(customer);
      if (customer==null){
        console.log('error');
        this.successful = 'Error Logging In';
      }
      else{
        console.log('success');
        sessionStorage.setItem('ID', String(response['id']));
        this.rout.navigateByUrl('');

        if (response['customerid']==0){
          this.successful = 'invalid login credentials';
        }
        else if(response['loggedin']=='true'){
          this.rout.navigateByUrl('');
        }
        else{
          this.successful = 'invalid login credentials';
        }
      }
    });
  }
}

