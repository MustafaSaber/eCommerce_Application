import { Component, OnInit } from '@angular/core';
import {UserService} from '../../shared-service/user.service';
import {User} from '../../user';
import {Store} from '../../store';
import{Router} from '@angular/router';
import { StoreService } from '../../shared-service/store.service';

@Component({
  selector: 'app-app-stores',
  templateUrl: './app-stores.component.html',
  styleUrls: ['./app-stores.component.css']
})
export class AppStoresComponent implements OnInit {

  private user:User;
  private stores:Store[];
  constructor(private _storeService:StoreService,private _userService:UserService,private _router:Router) { }
  ngOnInit() {
    this.user=this._userService.getter();
    this._userService.getAppStores(this.user).subscribe((products)=>{
      console.log(products);
      this.stores=products;
    },(error)=>{
      console.log(error);
    }) 
  }

  App(store:Store)
  {
    this._storeService.setter(store);
    this._storeService.appStore(store).subscribe((products)=>{
      console.log(products);     
    },(error)=>{
      console.log(error);
    }) 
    this._router.navigate(['/userhome']);
  }
}
