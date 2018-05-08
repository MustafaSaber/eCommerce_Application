import { Injectable } from '@angular/core';
import {Http,Response, Headers, RequestOptions } from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import { EditProductForm } from '../edit-product-form';

@Injectable()
export class EditproductformService {

  private baseUrl:string ='http://localhost:8080';
  private headers = new Headers({'Content-Type': 'application/json'});
  private options = new RequestOptions({headers:this.headers});
  private editproduct:EditProductForm;
  constructor(private _http:Http) {}

  EditProduct()
  {
    return this._http.post(this.baseUrl+'/edit',JSON.stringify(this.editproduct),this.options).map((response:Response)=>response.json()).catch(this.errorHandler);
  }
  errorHandler(error:Response)
  {
    return Observable.throw(error||"SERVER ERROR");
  }
  setter(editproduct:EditProductForm)
  {
    this.editproduct = editproduct;
  }
  getter(){
    return this.editproduct;
  }

}
