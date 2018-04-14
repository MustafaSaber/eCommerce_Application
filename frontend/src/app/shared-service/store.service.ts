import { Injectable } from '@angular/core';
import {Http,Response, Headers, RequestOptions } from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import {Store} from '../store';

@Injectable()
export class StoreService {

  private baseUrl:string ='http://localhost:8080';
  private headers = new Headers({'Content-Type': 'application/json'});
  private options = new RequestOptions({headers:this.headers});
  private store:Store;
  constructor(private _http:Http) {}

  addStore(store:Store)
  {
    console.log(store);
    return this._http.post(this.baseUrl+'/addstore',JSON.stringify(store),this.options).map((response:Response)=>response.json()).catch(this.errorHandler);;
  }
  getProducts(store:Store)
  {
    return this._http.post(this.baseUrl+'/getproducts',JSON.stringify(store),this.options).map((response:Response)=>response.json()).catch(this.errorHandler);
  }
  errorHandler(error:Response)
  {
    return Observable.throw(error||"SERVER ERROR");
  }
  setter(store:Store)
  {
    this.store = store;
  }
  getter(){
    return this.store ;
  }
}