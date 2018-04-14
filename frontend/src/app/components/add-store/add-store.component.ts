import { Component, OnInit } from '@angular/core';
import{User} from '../../user';
import{Router} from '@angular/router';
import {UserService} from '../../shared-service/user.service';
import { Store } from '../../store';
import { StoreService } from '../../shared-service/store.service';

@Component({
  selector: 'app-add-store',
  templateUrl: './add-store.component.html',
  styleUrls: ['./add-store.component.css']
})
export class AddStoreComponent implements OnInit {
  private user:User; 
  private store:Store;
  constructor(private _userService:UserService,private _storeService:StoreService ,private _router:Router) { }

  ngOnInit() {
    this.user=this._userService.getter();
    this.store=this._storeService.getter();
  }
  addstore()
  {
    console.log(this.store);
    var ret;
    this.store.store_owner_name = this.user.username;
    this._storeService.addStore(this.store).subscribe((ret)=>{ 
    console.log("ret = "+ret);
    if(ret.name == "null")
    {
      window.alert("This store is already exists !!");
      this._router.navigate(['/addstore']);
    }
    else
    {
      this._router.navigate(['/userhome']);
    }
     
    },(error)=>{
      console.log(error);
    })
  }
}