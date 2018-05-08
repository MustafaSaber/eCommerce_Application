import { Injectable, Input } from '@angular/core';
import {Http,Response, Headers, RequestOptions } from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import {User} from '../user';
import { Store } from '../store';

@Injectable()
export class UserService {

  private baseUrl:string ='http://localhost:8080';
  private headers = new Headers({'Content-Type': 'application/json'});
  private options = new RequestOptions({headers:this.headers});
  private user:User;
  private isUserLoggedIn:boolean;
  constructor(private _http:Http) {
    this.isUserLoggedIn = false;
  }
  setterUserLoggedIn()
  {
    this.isUserLoggedIn = true; 
  }
  getterUserLoggedIn()
  {
    return this.isUserLoggedIn; 
  }
  getcoll(store:Store)
  {
    console.log(store);
    return this._http.get(this.baseUrl+'/viewcollaborators/'+store.name,this.options).map((response:Response)=>response.json()).catch(this.errorHandler);
  }
  addColl(name,store)
  {
    console.log(name+" "+ store);
    return this._http.get(this.baseUrl+'/addcollaborator/'+name+'/'+store,this.options).map((response:Response)=>response.json()).catch(this.errorHandler);
  }
  getStores(user:User)
  {
    return this._http.post(this.baseUrl+'/getstores',JSON.stringify(user),this.options).map((response:Response)=>response.json()).catch(this.errorHandler);
  }
  getAppStores(user:User)
  {
    return this._http.post(this.baseUrl+'/getappstores',JSON.stringify(user),this.options).map((response:Response)=>response.json()).catch(this.errorHandler);
  }
  checkAdmin(user:User)
  {
    return this._http.post(this.baseUrl+'/checkAdmin',JSON.stringify(user),this.options).map((response:Response)=>response.json()).catch(this.errorHandler);;
  }
  createUser(user:User){
    return this._http.post(this.baseUrl+'/create',JSON.stringify(user),this.options).map((response:Response)=>response.json()).catch(this.errorHandler);
  }

  getUsers(){
    return this._http.get(this.baseUrl+'/getusers',this.options).map((response:Response)=>response.json()).catch(this.errorHandler);
  }
  loginUser(user:User)
  {
    return this._http.post(this.baseUrl+'/login',JSON.stringify(user),this.options).map((response:Response)=>response.json()).catch(this.errorHandler);
  }

  /*
  getUser(id:Number){
    return this._http.get(this.baseUrl+'/user/'+id,this.options).map((response:Response)=>response.json()).catch(this.errorHandler);
  }
  deleteUser(id:Number){
    return this._http.delete(this.baseUrl+'/user/'+id,this.options).map((response:Response)=>response.json()).catch(this.errorHandler);
  }
  createUser(user:User){
    return this._http.post(this.baseUrl+'/user',JSON.stringify(user),this.options).map((response:Response)=>response.json()).catch(this.errorHandler);
  }
  updateUser(user:User){
    return this._http.put(this.baseUrl+'/user',JSON.stringify(user),this.options).map((response:Response)=>response.json()).catch(this.errorHandler);
  }
  */
  errorHandler(error:Response)
  {
    return Observable.throw(error||"SERVER ERROR");
  }
  setter(user:User)
  {
    this.user = user;
  }
  getter(){
    return this.user;
  }
}