import { Component, OnInit } from '@angular/core';
import{User} from '../../user';
import{Router} from '@angular/router';
import {UserService} from '../../shared-service/user.service';
import{Store} from '../../store';
import{Product} from '../../product';
import { ProductService } from '../../shared-service/product.service';
import { StoreService } from '../../shared-service/store.service';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {
  private user:User;
  private store:Store;
  private product:Product;

  constructor(private _userService:UserService,private _storeService:StoreService,private _productService:ProductService,private _router:Router) {}

  ngOnInit() {
    this.user=this._userService.getter();
    this.store=this._storeService.getter();
    this.product=this._productService.getter();
  }

  addproduct()
  {
    console.log(this.product);
    var ret;
    this.product.storename = this.store.name;
    this._productService.addProduct(this.product).subscribe((ret)=>{ 
    console.log("ret = "+ret);
    if(ret.name == "null")
    {
      window.alert("This store hasn't been approved yet !! ");
      window.alert("You can not add product !! ");
      this._router.navigate(['/addproduct']);
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
