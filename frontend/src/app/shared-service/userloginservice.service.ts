import { Injectable } from '@angular/core';
import {Http,Response, Headers, RequestOptions } from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import {Userlogin} from '../userlogin';

@Injectable()
export class UserloginserviceService {

  private userlogin:Userlogin;
  private baseUrl:string ='http://localhost:8080';
  private headers = new Headers({'Content-Type': 'application/json'});
  private options = new RequestOptions({headers:this.headers});
  constructor(private _http:Http) {}

  errorHandler(error:Response)
  {
    return Observable.throw(error||"SERVER ERROR");
  }
  setter(userlogin:Userlogin)
  {
    this.userlogin = userlogin;
  }
  getter(){
    return this.userlogin;
  }

}
