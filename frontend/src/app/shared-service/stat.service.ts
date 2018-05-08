import { Injectable } from '@angular/core';
import {Http,Response, Headers, RequestOptions } from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import { Stat } from '../stat';
import { Store } from '../store';

@Injectable()
export class StatService {

  private baseUrl:string ='http://localhost:8080';
  private headers = new Headers({'Content-Type': 'application/json'});
  private options = new RequestOptions({headers:this.headers});
  private stat:Stat;
  constructor(private _http:Http) {}

  addstat(stat:Stat)
  {
    return this._http.post(this.baseUrl+'/addstat',JSON.stringify(stat),this.options).map((response:Response)=>response.json()).catch(this.errorHandler);
  }
  getAllStat()
  {
    return this._http.get(this.baseUrl+'/getAllStats',this.options).map((response:Response)=>response.json()).catch(this.errorHandler);
  }
  addStoreStat(store:Store,stat:Stat)
  {
    return this._http.post(this.baseUrl+'/addStatisticeToStore/'+store.name,JSON.stringify(stat),this.options).map((response:Response)=>response.json()).catch(this.errorHandler);
  }
  getStoreStat(store:Store)
  {
    return this._http.get(this.baseUrl+'/getStoreStats/'+store.name,this.options).map((response:Response)=>response.json()).catch(this.errorHandler);
  }
  errorHandler(error:Response)
  {
    return Observable.throw(error||"SERVER ERROR");
  }
  setter(stat:Stat)
  {
    this.stat = stat;
  }
  getter(){
    return this.stat;
  }

}
