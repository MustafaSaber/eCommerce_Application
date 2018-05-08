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
import { AddToCart } from '../../add-to-cart';
import { AddToCartService } from '../../shared-service/add-to-cart.service';
import { Product } from '../../product';
import { CartService } from '../../shared-service/cart.service';
import { ProdService } from '../../shared-service/prod.service';

@Component({
  selector:    'app-user-home-page',
  templateUrl: './user-home-page.component.html',
  styleUrls: ['./user-home-page.component.css']
})
export class UserHomePageComponent implements OnInit {

  private user:User; 
  private products:Prod[];
  private addToCart:AddToCart;
  constructor(private _userService:UserService,private _productService:ProductService, 
                private _brandService:BrandserviceService,private _storeService:StoreService,
                     private _modelService:ModelService ,private _addToCartService:AddToCartService
                     ,private _cartService:CartService,private _prodService:ProdService, private _router:Router) {}

  ngOnInit() {
    this.user = this._userService.getter();
    this.addToCart = this._addToCartService.getter();
    this._productService.viewproducts().subscribe((prod)=>{
      console.log(prod);
      this.products=prod;
    },(error)=>{
      console.log(error);
    })
  }
  viewProduct(prod:Prod)
  {
    console.log(prod);
    this._prodService.viewprod(prod).subscribe((ret)=>{
    console.log(ret);
    this._prodService.setter(ret);
    this._router.navigate(['/viewproddetails']);
    },(error)=>{
      console.log(error); 
    })
  }
  viewCart(user)
  {
    console.log(user);
    this._cartService.getMyCart(user).subscribe((ret)=>{
      console.log(ret);
      this._cartService.setter(ret);
      this._router.navigate(['/mycart']);
      
    },(error)=>{
      console.log(error); 
    })

  }
  AddToCart(prod:Prod,user:User)
  {
    this.addToCart.productid = prod.id;
    this.addToCart.username = user.username;
    console.log(this.addToCart);
    this._addToCartService.AddTOCart(this.addToCart).subscribe((ret)=>{
    console.log(ret);
    if(ret.name == "null")
      {
        window.alert("This quantity is not avaiable !!");
        this._router.navigate(['/userhome']);
      }
      else
      {
        window.alert("This product is added successfully !!");
        this._router.navigate(['/userhome']);
      }

    },(error)=>{
      console.log(error); 
    })

     
  }
   
  Admin()
  {
    this._userService.checkAdmin(this.user).subscribe((ret)=>{
      console.log(ret);
      if(ret == true)
      {
        this._router.navigate(['/adminhome']);
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