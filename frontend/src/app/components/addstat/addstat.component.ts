import { Component, OnInit } from '@angular/core';
import{User} from '../../user';
import{Router} from '@angular/router';
import {UserService} from '../../shared-service/user.service';
import { Stat } from '../../stat';
import { StatService } from '../../shared-service/stat.service';

@Component({
  selector: 'app-addstat',
  templateUrl: './addstat.component.html',
  styleUrls: ['./addstat.component.css']
})
export class AddstatComponent implements OnInit {
  private user:User; 
  private stat:Stat;

  constructor(private _userService:UserService,private _statService:StatService ,private _router:Router) { }
  
  ngOnInit() {
    this.user=this._userService.getter();
    this.stat=this._statService.getter();
  }

  addstat()
  {
    this.stat.id = 0;
    this._statService.addstat(this.stat).subscribe((ret)=>{
      console.log("ret = "+ret);
      if(ret.name == "null")
      {
        window.alert("You can not add this statistic !! ");
      }
      else
      {
        window.alert("You added this statistic successfully");
        this._router.navigate(['/userhome']);
      }
      },(error)=>{
        console.log(error);
      }) 
  }
}

