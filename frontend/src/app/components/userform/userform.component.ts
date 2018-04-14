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
      this._router.navigate(['/getuser']);
    },(error)=>{
      console.log(error);
    })
    /*
    if(this.user.id==undefined)
    {
      this._userService.createUser(this.user).subscribe((user)=>{
        console.log(user);
        this._router.navigate(['/']);
      },(error)=>{
        console.log(error);
      })
    }else{
      this._userService.updateUser(this.user).subscribe((user)=>{
        console.log(user);
        this._router.navigate(['/']);
      },(error)=>{
        console.log(error);
      })
    }*/
  }
}
