import { Component, OnInit } from '@angular/core';
import {ServerrequestsService} from '../servicerequests.service';
import {Router} from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
  public username: String;
  public password: String;
  public successful: String;
  constructor(private rout: Router,private logins: ServerrequestsService ) { }

  ngOnInit() {
    if (sessionStorage.getItem('login')==='true'){
      this.rout.navigateByUrl('/home');
    }
  }
  public login(){
    this.logins.Login(this.username, this.password).subscribe(response=>{
      if (response['customerid']==0){
        this.successful = 'invalid login credentials';
        
      }
      else if(response['loggedin']=='true'){
          
      }
      else{
        this.successful = 'invalid login credentials';
      }
    }
    )
  }
}

