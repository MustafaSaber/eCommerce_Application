import { Component, OnInit } from '@angular/core';
import{User} from '../../user';
import{Router} from '@angular/router';
import {UserService} from '../../shared-service/user.service';
import { Model } from '../../model';
import { ModelService } from '../../shared-service/model.service';
 
@Component({
  selector: 'app-add-model',
  templateUrl: './add-model.component.html',
  styleUrls: ['./add-model.component.css']
})

export class AddModelComponent implements OnInit {
  private user:User; 
  private model:Model; 
 
 
  constructor(private _userService:UserService,private _modelService:ModelService ,private _router:Router) { }

  ngOnInit() {
    this.user=this._userService.getter();
    this.model=this._modelService.getter();
  }
  addmodel()
  {
    console.log(this.model.modelname);
    var ret;
    this._modelService.addModel(this.model).subscribe((ret)=>{ 
    console.log("ret = "+ret);
    if(ret.name == "null")
    {
      window.alert("This model is already exists !!");
      this._router.navigate(['/addmodel']);
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