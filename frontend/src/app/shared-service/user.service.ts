import { Injectable, Input } from '@angular/core';
import {Http ,Response, Headers, RequestOptions } from '@angular/http';
//import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Base64 } from 'js-base64';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import {User} from '../user';
import { Router } from '@angular/router';

@Injectable()
export class UserService {

  private baseUrl:string ='http://localhost:8080';
  private headers = new Headers({'Content-Type': 'application/json'});
  private FormHeaders =  new Headers({'Content-Type': 'application/form-data'});
  private options = new RequestOptions({headers:this.headers});
  private FormOptions = new RequestOptions({headers:this.FormHeaders});
  private user:User;
  constructor(private _http:Http) {}

  createUser(user:User){
    console.log(user.password);
    return this._http.post(this.baseUrl+'/create',JSON.stringify(user),this.options).map((response:Response)=>response.json()).catch(this.errorHandler);
  }
   
  getUsers(){
    return this._http.get(this.baseUrl+'/getusers',this.options).map((response:Response)=>response.json()).catch(this.errorHandler);
  }
  
  loginUser(user:User)
  {
    console.log(user.username)
    console.log(user.password)
    
    //var body = 'username='+user.username+'&password='+user.passwordHash;
    //var headers = new Headers();
    //headers.append('Content-Type', 'application/x-www-form-urlencoded');
    //headers.append("Authorization", "Basic " + Base64.encode(user.username + ':' + user.passwordHash));
    //headers.append('Content-Type', 'application/json');
    //headers.append("Access-Control-Allow-Origin", "*");

    /*return this._http
      .post(this.baseUrl+'/login',
        body, {
          headers: headers// ,
          //withCredentials: true 
        }).map((response:Response)=>response.json()).catch(this.errorHandler);*/
    //return this._http.post(this.baseUrl+'/login', { username : user.username , password:user.passwordHash },this.options);//.map((response:Response)=>response.json()).catch(this.errorHandler);
    return this._http.post(this.baseUrl+'/login' ,JSON.stringify(user),this.options).map((response:Response)=>response.json()).catch(this.errorHandler);
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

