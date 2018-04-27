import { Injectable } from '@angular/core';
import {Http,Response, Headers, RequestOptions } from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import { Model } from '../model';
@Injectable()

export class ModelService {
  private baseUrl:string ='http://localhost:8080';
  private headers = new Headers({'Content-Type': 'application/json'});
  private options = new RequestOptions({headers:this.headers});
  private model:Model;
  constructor(private _http:Http) {}

  addModel(model:Model)
  {
   //console.log(model.modelname);
    return this._http.post(this.baseUrl+'/addsystemmodel',JSON.stringify(model),this.options).map((response:Response)=>response.json()).catch(this.errorHandler);;
  }
  errorHandler(error:Response)
  {
    return Observable.throw(error||"SERVER ERROR");
  }
  setter(model:Model)
  {
    this.model = model;
  }
  getter(){
    return this.model ;
  }
}
