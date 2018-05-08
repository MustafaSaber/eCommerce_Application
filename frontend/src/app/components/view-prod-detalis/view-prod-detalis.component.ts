import { Component, OnInit } from '@angular/core';
import {UserService} from '../../shared-service/user.service';
import {User} from '../../user';
import{Router} from '@angular/router';
import { Prod } from '../../prod';
import { ProdService } from '../../shared-service/prod.service';


@Component({
  selector: 'app-view-prod-detalis',
  templateUrl: './view-prod-detalis.component.html',
  styleUrls: ['./view-prod-detalis.component.css']
})
export class ViewProdDetalisComponent implements OnInit {

  private user:User;
  private prod:Prod;
  constructor(private _prodService:ProdService,private _userService:UserService,private _router:Router) { }

  ngOnInit() {
    this.user=this._userService.getter();
    this.prod = this._prodService.getter();
  }
  Home()
  {
    this._router.navigate(["/userhome"]);
  }
}
