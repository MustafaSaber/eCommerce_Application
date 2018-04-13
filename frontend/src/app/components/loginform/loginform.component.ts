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
    this._userService.loginUser(this.user).subscribe((user)=>{
      console.log(user);
      console.log("here1");
      this._router.navigate(['/']);
    },(error)=>{
      console.log("here");
      console.log(error);
    })
  }
}