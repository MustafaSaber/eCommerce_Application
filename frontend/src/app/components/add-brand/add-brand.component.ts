import { Component, OnInit } from '@angular/core';
import{User} from '../../user';
import{Router} from '@angular/router';
import {UserService} from '../../shared-service/user.service';
import { Brand } from '../../brand';
import { BrandserviceService } from '../../shared-service/brandservice.service';

@Component({
  selector: 'app-add-brand',
  templateUrl: './add-brand.component.html',
  styleUrls: ['./add-brand.component.css']
})

export class AddBrandComponent implements OnInit {
  private user:User; 
  private brand:Brand;
  
  constructor(private _userService:UserService,private _brandService:BrandserviceService ,private _router:Router) { }
  
  ngOnInit() {
    this.user=this._userService.getter();
    this.brand=this._brandService.getter();
  }
  addbrand()
  {
    console.log(this.brand.name);
    var ret;
    this._brandService.addBrand(this.brand).subscribe((ret)=>{
    console.log("ret = "+ret);
    if(ret.name == "null")
    {
      window.alert("This brand is already exists !!");
      this._router.navigate(['/addbrand']);
    }
    else
    {
      this._router.navigate(['/userhome']);
    }
    },(error)=>{
      console.log(error);
    })
  }
}