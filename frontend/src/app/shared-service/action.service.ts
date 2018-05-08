import { Injectable } from '@angular/core';
import {Http,Response, Headers, RequestOptions } from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import { Store } from '../store';
import { Action } from '../action';

@Injectable()
export class ActionService {
  private baseUrl:string ='http://localhost:8080';
  private headers = new Headers({'Content-Type': 'application/json'});
  private options = new RequestOptions({headers:this.headers});
  private action:Action;
  constructor(private _http:Http) {}

  getactions(store:Store)
  {
    return this._http.get(this.baseUrl+'/viewactions/'+store.name,this.options).map((response:Response)=>response.json()).catch(this.errorHandler);
  }
  undo(id:Number)
  {
    return this._http.get(this.baseUrl+'/undo/'+id,this.options).map((response:Response)=>response.json()).catch(this.errorHandler);
  }
  errorHandler(error:Response)
  {
    return Observable.throw(error||"SERVER ERROR");
  }
  setter(action:Action)
  {
    this.action = action;
  }
  getter(){
    return this.action;
  }
}
