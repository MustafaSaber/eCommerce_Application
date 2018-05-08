import { Component, OnInit } from '@angular/core';
import{User} from '../../user';
import{Router} from '@angular/router';
import {UserService} from '../../shared-service/user.service';
import { Brand } from '../../brand';
import { BrandserviceService } from '../../shared-service/brandservice.service';
import { Model } from '../../model';
import { ModelService } from '../../shared-service/model.service';
import { Stat } from '../../stat';
import { StatService } from '../../shared-service/stat.service';

@Component({
  selector: 'app-adminhome',
  templateUrl: './adminhome.component.html',
  styleUrls: ['./adminhome.component.css']
})
export class AdminhomeComponent implements OnInit {

  private user:User; 
   
  constructor(private _userService:UserService,private _brandService:BrandserviceService,
       private _modelService:ModelService ,private _statService:StatService, private _router:Router) {}

  ngOnInit() {
    this.user = this._userService.getter();
  }
  AddBrand()
  {
    let brand = new Brand();
    this._brandService.setter(brand);
    this._router.navigate(['/addbrand']);
    this._router.navigate(['/addbrand']);
     
  }
  AddModel()
  {
    let model = new Model();
    this._modelService.setter(model);
    this._router.navigate(['/addmodel']);
    
  }
  AddStat()
  {
    let stat = new Stat();
    this._statService.setter(stat);
    this._router.navigate(['/addstat']);
  }
}
