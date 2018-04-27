import { Injectable } from '@angular/core';
import {Http,Response, Headers, RequestOptions } from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import { Brand } from '../brand';

@Injectable()
export class BrandserviceService {
  private baseUrl:string ='http://localhost:8080';
  private headers = new Headers({'Content-Type': 'application/json'});
  private options = new RequestOptions({headers:this.headers});
  private brand:Brand;
  constructor(private _http:Http) {}

  addBrand(brand:Brand)
  {
    return this._http.post(this.baseUrl+'/addbrand',JSON.stringify(brand),this.options).map((response:Response)=>response.json()).catch(this.errorHandler);;
  }
  errorHandler(error:Response)
  {
    return Observable.throw(error||"SERVER ERROR");
  }
  setter(brand:Brand)
  {
    this.brand = brand;
  }
  getter(){
    return this.brand;
  }

}
