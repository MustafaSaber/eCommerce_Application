import { Component, OnInit } from '@angular/core';
import{User} from '../../user';
import{Router} from '@angular/router';
import {UserService} from '../../shared-service/user.service';
import { EditProductForm } from '../../edit-product-form';
import { EditproductformService } from '../../shared-service/editproductform.service';

@Component({
  selector: 'app-editproduct',
  templateUrl: './editproduct.component.html',
  styleUrls: ['./editproduct.component.css']
})
export class EditproductComponent implements OnInit {
  private editproduct:EditProductForm;
  private user:User;
  constructor(private _userService:UserService,private _editproductService:EditproductformService,private _router:Router) {}

  ngOnInit() {
    this.user = this._userService.getter();
    this.editproduct = this._editproductService.getter();
    console.log(this.editproduct);
  }
  editProduct()
  {
    this._editproductService.setter(this.editproduct);
    console.log(this.editproduct);
    this._editproductService.EditProduct().subscribe((ret)=>{ 
      console.log("ret = "+ret);
      if(ret.name == "null")
      {
        window.alert("You can not edit this product !! ");
        this._router.navigate(['/editproduct']);
      }
      else
      {
        window.alert("You have edited this product successfully !! ");
        this._router.navigate(['/userhome']);
      }
       
      },(error)=>{
        console.log(error);
      })
    }

}
