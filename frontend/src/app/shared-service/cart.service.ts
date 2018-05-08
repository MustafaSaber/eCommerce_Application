import { Injectable } from '@angular/core';
import {Http,Response, Headers, RequestOptions } from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import { Cart } from '../cart';
import { User } from '../user';

@Injectable()
export class CartService {
  private baseUrl:string ='http://localhost:8080';
  private headers = new Headers({'Content-Type': 'application/json'});
  private options = new RequestOptions({headers:this.headers});
  private mycart:Cart;
  constructor(private _http:Http) {}

  checkOut(mycart)
  {
    console.log(mycart.CartID);
    return this._http.get(this.baseUrl+'/checkout/'+mycart.CartID,this.options).map((response:Response)=>response.json()).catch(this.errorHandler);
  }
  getMyCart(user:User)
  {
    return this._http.post(this.baseUrl+'/viewcart',JSON.stringify(user),this.options).map((response:Response)=>response.json()).catch(this.errorHandler);
  }
  errorHandler(error:Response)
  {
    return Observable.throw(error||"SERVER ERROR");
  }
  setter( mycart:Cart)
  {
    this.mycart = mycart;
  }
  getter(){
    return this.mycart ;
  }

}