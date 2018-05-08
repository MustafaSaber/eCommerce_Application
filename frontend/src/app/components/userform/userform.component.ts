import { Component, OnInit, Input } from '@angular/core';
import{User} from '../../user';
import{Router} from '@angular/router';
import {UserService} from '../../shared-service/user.service';
@Component({
  selector: 'app-userform',
  templateUrl: './userform.component.html',
  styleUrls: ['./userform.component.css']
})
export class UserformComponent implements OnInit {
  @Input() user:User;
  constructor(private _userService:UserService,private _router:Router) { }

  ngOnInit() {
    this.user=this._userService.getter();
  }

  processForm(){
    this._userService.createUser(this.user).subscribe((user)=>{
      console.log(user);
      let userr = new User();
      this._userService.setter(userr);
      this._router.navigate(['/login']);
    },(error)=>{
      console.log(error);
    })

  }
}
