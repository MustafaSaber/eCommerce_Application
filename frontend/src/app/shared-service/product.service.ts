import { Injectable } from '@angular/core';
import {Http,Response, Headers, RequestOptions } from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import { Product } from '../product';

@Injectable()
export class ProductService {
  private baseUrl:string ='http://localhost:8080';
  private headers = new Headers({'Content-Type': 'application/json'});
  private options = new RequestOptions({headers:this.headers});
  private product:Product;
  constructor(private _http:Http) {}

  addProduct(product:Product)
  {
    console.log(product);
    return this._http.post(this.baseUrl+'/addproduct',JSON.stringify(product),this.options).map((response:Response)=>response.json()).catch(this.errorHandler);;
  }
  viewproducts()
  {
    return this._http.get(this.baseUrl+'/viewproducts',this.options).map((response:Response)=>response.json()).catch(this.errorHandler);
  }
  deleteProduct(id:Number)
  {
    console.log("id" + id);
    return this._http.post(this.baseUrl+'/deleteproduct',JSON.stringify(id),this.options).map((response:Response)=>response.json()).catch(this.errorHandler);
  }
  errorHandler(error:Response)
  {
    return Observable.throw(error||"SERVER ERROR");
  }
  setter(product:Product)
  {
    this.product = product;
  }
  getter(){
    return this.product ;
  }
}