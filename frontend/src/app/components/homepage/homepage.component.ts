import { Component, OnInit } from '@angular/core';
import{User} from '../../user';
import{Router} from '@angular/router';
import {UserService} from '../../shared-service/user.service';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {
  private user:User;
  constructor(private _userService:UserService,private _router:Router) { }

  ngOnInit() {
    this.user=this._userService.getter();
  }

  login()
    {
      let user = new User();
      this._userService.setter(user);
      this._router.navigate(['/login']);
    }
    Register()
    {
      let user = new User();
      this._userService.setter(user);
      this._router.navigate(['/op']);
    }

}
