import { Component, OnInit } from '@angular/core';
import {UserService} from '../../shared-service/user.service';
import {User} from '../../user';
import {Store} from '../../store';
import{Router} from '@angular/router';
import { StoreService } from '../../shared-service/store.service';
import { Product } from '../../product';
import { ProductService } from '../../shared-service/product.service';

@Component({
  selector: 'app-view-products',
  templateUrl: './view-products.component.html',
  styleUrls: ['./view-products.component.css']
})
export class ViewProductsComponent implements OnInit {

  private user:User;
  private store:Store;
  private products:Product[];
  constructor(private _productService:ProductService,private _storeService:StoreService,private _userService:UserService,private _router:Router) { }

  ngOnInit() {
    this.user=this._userService.getter();
    this.store = this._storeService.getter();
    this._storeService.getProducts(this.store).subscribe((products)=>{
      console.log(products);
      this.products=products;
    },(error)=>{
      console.log(error);
    }) 
  }
  AddProduct()
  {
    let product = new Product();
    this._productService.setter(product);
    this._router.navigate(['/addproduct']);
  }

}