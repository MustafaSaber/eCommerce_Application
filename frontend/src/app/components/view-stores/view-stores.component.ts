import { Component, OnInit } from '@angular/core';
import {UserService} from '../../shared-service/user.service';
import {User} from '../../user';
import {Store} from '../../store';
import{Router} from '@angular/router';
import { StoreService } from '../../shared-service/store.service';


@Component({
  selector: 'app-view-stores',
  templateUrl: './view-stores.component.html',
  styleUrls: ['./view-stores.component.css']
})
export class ViewStoresComponent implements OnInit {
  private user:User;
  private stores:Store[];
  constructor(private _storeService:StoreService,private _userService:UserService,private _router:Router) { }


  ngOnInit() {
    this.user=this._userService.getter();
    this._userService.getStores(this.user).subscribe((products)=>{
      console.log(products);
      this.stores=products;
    },(error)=>{
      console.log(error);
    }) 
  }

  View(store:Store)
  {
    this._router.navigate(['/viewproducts']);
  }
}