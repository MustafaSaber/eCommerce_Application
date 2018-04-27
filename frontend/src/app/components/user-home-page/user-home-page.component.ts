import { Component, OnInit } from '@angular/core';
import{User} from '../../user';
import{Router} from '@angular/router';
import {UserService} from '../../shared-service/user.service';
import { Brand } from '../../brand';
import { BrandserviceService } from '../../shared-service/brandservice.service';
import { Model } from '../../model';
import { ModelService } from '../../shared-service/model.service';
import { StoreService } from '../../shared-service/store.service';
import { Store } from '../../store';
import { Prod } from '../../prod';
import { ProductService } from '../../shared-service/product.service';

@Component({
  selector:    'app-user-home-page',
  templateUrl: './user-home-page.component.html',
  styleUrls: ['./user-home-page.component.css']
})
export class UserHomePageComponent implements OnInit {

  private user:User; 
  private products:Prod[];
  constructor(private _userService:UserService,private _productService:ProductService, 
                private _brandService:BrandserviceService,private _storeService:StoreService,
                     private _modelService:ModelService ,private _router:Router) {}

  ngOnInit() {
    this.user = this._userService.getter();
    this._productService.viewproducts().subscribe((prod)=>{
      console.log(prod);
      this.products=prod;
    },(error)=>{
      console.log(error);
    })
  }
  viewProduct(p:Prod,user:User)
  {
    console.log(p);
    console.log(user);
    this._router.navigate(['/userhome']);
  }
  buyProduct(p:Prod,user:User)
  {
    console.log(p);
    console.log(user);
    this._router.navigate(['/userhome']);
  }
  AddBrand()
  {
    var ret;
    this._userService.checkAdmin(this.user).subscribe((ret)=>{
      console.log(ret);
      if(ret == true)
      {
        let brand = new Brand();
        this._brandService.setter(brand);
        this._router.navigate(['/addbrand']);
      }
      else
      {
        window.alert("You can not use this option !!");
        this._router.navigate(['/userhome']);
      }
    },(error)=>{
      console.log(error); 
    })
  }
  AddModel()
  {
    var ret;
    this._userService.checkAdmin(this.user).subscribe((ret)=>{
      console.log(ret);
      if(ret == true)
      {
        let model = new Model();
        this._modelService.setter(model);
        this._router.navigate(['/addmodel']);
      }
      else
      {
        window.alert("You can not use this option !!");
        this._router.navigate(['/userhome']);
      }
    },(error)=>{
      console.log(error); 
    })
  }
  AddStore()
  {
    let store = new Store();
    this._storeService.setter(store);
    this._router.navigate(['/addstore']);
  }
  ViewStores()
  {
    this._router.navigate(['/viewstores']);  
  }
  AppStores()
  {    
    var ret;
    this._userService.checkAdmin(this.user).subscribe((ret)=>{
      console.log(ret);
      if(ret == true)
      {
        this._router.navigate(['/appstores']);
      }
      else
      {
        window.alert("You can not use this option !!");
        this._router.navigate(['/userhome']);
      }
    },(error)=>{
      console.log(error); 
    })
  }
}