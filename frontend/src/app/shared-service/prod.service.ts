import { Injectable } from '@angular/core';
import {Http,Response, Headers, RequestOptions } from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import { Prod } from '../prod';

@Injectable()
export class ProdService {

  private baseUrl:string ='http://localhost:8080';
  private headers = new Headers({'Content-Type': 'application/json'});
  private options = new RequestOptions({headers:this.headers});
  private prod:Prod;
  constructor(private _http:Http) {}
 
  viewprod(prod)
  {
    console.log(prod.id);
    return this._http.get(this.baseUrl+'/viewprod/'+prod.id,this.options).map((response:Response)=>response.json()).catch(this.errorHandler);
  }
  errorHandler(error:Response)
  {
    return Observable.throw(error||"SERVER ERROR");
  }
  setter(prod:Prod)
  {
    this.prod = prod;
  }
  getter(){
    return this.prod ;
  }

}
