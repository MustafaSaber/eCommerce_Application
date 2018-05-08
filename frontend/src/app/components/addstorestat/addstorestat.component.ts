import { Component, OnInit } from '@angular/core';
import {UserService} from '../../shared-service/user.service';
import {User} from '../../user';
import {Store} from '../../store';
import{Router} from '@angular/router';
import { StoreService } from '../../shared-service/store.service';
import { Stat } from '../../stat';
import { StatService } from '../../shared-service/stat.service';

@Component({
  selector: 'app-addstorestat',
  templateUrl: './addstorestat.component.html',
  styleUrls: ['./addstorestat.component.css']
})
export class AddstorestatComponent implements OnInit {
  private user:User;
  private store:Store;
  private stats:Stat[];
  constructor(private _statService:StatService,private _storeService:StoreService,private _userService:UserService,private _router:Router) { }

  ngOnInit() {
    this.user=this._userService.getter();
    this.store = this._storeService.getter();
    this._statService.getAllStat().subscribe((stat)=>{
      console.log(stat);
      this.stats = stat;
    },(error)=>{
      console.log(error);
    })
  }
  AddStoreStat(stat:Stat)
  {
    this._statService.addStoreStat(this.store,stat).subscribe((ret)=>{
      console.log("ret = "+ret);
      if(ret.name == "null")
      {
        window.alert("You can not add this statistic !! ");
      }
      else
      {
        window.alert("You added this statistic successfully");
        this._router.navigate(['/viewstorestat']);
      }
      },(error)=>{
        console.log(error);
      }) 
  }
  
}
