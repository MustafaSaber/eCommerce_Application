import { Component, OnInit } from '@angular/core';
import{User} from '../../user';
import{Router} from '@angular/router';
import {UserService} from '../../shared-service/user.service';

@Component({
  selector: 'app-loginform',
  templateUrl: './loginform.component.html',
  styleUrls: ['./loginform.component.css']
})
export class LoginformComponent implements OnInit {
  private user:User; //
 
  constructor(private _userService:UserService,private _router:Router) { }

  ngOnInit() {
    this.user=this._userService.getter();
  }
  
  login()
  {
    var ret;
    this._userService.loginUser(this.user).subscribe((ret)=>{

    console.log(ret);
    if(ret == null)
    {
      console.log("wrong username or password");
      window.alert("wrong username or password");
      this._router.navigate(['/login']);
    }
   else
    {
      this._userService.setterUserLoggedIn();
      this._router.navigate(['/userhome']);
    }
      
    },(error)=>{
      console.log(error);
    })
  }
}