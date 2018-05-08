import { Component, OnInit } from '@angular/core';
import{User} from '../../user';
import{Router} from '@angular/router';
import {UserService} from '../../shared-service/user.service';
import { StoreService } from '../../shared-service/store.service';

@Component({
  selector: 'app-addcollaborator',
  templateUrl: './addcollaborator.component.html',
  styleUrls: ['./addcollaborator.component.css']
})

export class AddcollaboratorComponent implements OnInit {
  private user:User; 
  private username:string;

  constructor(private _userService:UserService ,private _storeService:StoreService,private _router:Router) { }

  ngOnInit() {
    this.user=this._userService.getter();
  }
  addcoll()
  {
    var store = this._storeService.getter().name;
    console.log("name: "+ this.username);
    this._userService.addColl(this.username,store).subscribe((ret)=>{
    console.log("ret = "+ret);
    if(ret.name == "null")
    {
      window.alert("You can not add this collaborator !! ");
    }
    else
    {
      window.alert("You added this collaborator successfully");
      this._router.navigate(['/userhome']);
    }
    },(error)=>{
      console.log(error);
    }) 
  }

}
