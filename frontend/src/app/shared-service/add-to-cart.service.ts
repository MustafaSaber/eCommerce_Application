import { Injectable } from '@angular/core';
import {Http,Response, Headers, RequestOptions } from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import { AddToCart } from '../add-to-cart';

@Injectable()
export class AddToCartService {

  private baseUrl:string ='http://localhost:8080';
  private headers = new Headers({'Content-Type': 'application/json'});
  private options = new RequestOptions({headers:this.headers});
  private addToCart:AddToCart;
  constructor(private _http:Http) {}

  AddTOCart(addToCart:AddToCart)
  {
    return this._http.post(this.baseUrl+'/addtocart',JSON.stringify(this.addToCart),this.options).map((response:Response)=>response.json()).catch(this.errorHandler);
  }

  errorHandler(error:Response)
  {
    return Observable.throw(error||"SERVER ERROR");
  }
  setter(addToCart:AddToCart)
  {
    this.addToCart = addToCart;
  }
  getter(){
    return this.addToCart;
  }
}
