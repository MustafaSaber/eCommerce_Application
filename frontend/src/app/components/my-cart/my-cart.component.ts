import { Component, OnInit } from '@angular/core';
import{Router} from '@angular/router';
import { Cart } from '../../cart';
import { User } from '../../user';
import { CartService } from '../../shared-service/cart.service';
import {UserService} from '../../shared-service/user.service';
import { Prod } from '../../prod';

@Component({
  selector: 'app-my-cart',
  templateUrl: './my-cart.component.html',
  styleUrls: ['./my-cart.component.css']
})
export class MyCartComponent implements OnInit {
  private mycart:Cart;
  private user:User;

  constructor(private _cartService:CartService, private _userService:UserService,private _router:Router) { }

  ngOnInit() {
    this.user=this._userService.getter();
    this.mycart = this._cartService.getter();
    console.log(this.mycart);
  }

   CheckOut(mycart)
   {
    this._cartService.checkOut(mycart).subscribe((ret)=>{ 
    console.log("ret = "+ret);
    if(ret.name == "null")
    {
      window.alert("You can not check out !! ");
    }
    else
    {
      window.alert("You check out successfully");
      this._router.navigate(['/userhome']);
    }
      
    },(error)=>{
      console.log(error);
    })
   }
}