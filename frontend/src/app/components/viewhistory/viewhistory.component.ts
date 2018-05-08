import { Component, OnInit } from '@angular/core';
import {UserService} from '../../shared-service/user.service';
import {User} from '../../user';
import {Store} from '../../store';
import{Router} from '@angular/router';
import { StoreService } from '../../shared-service/store.service';
import { Action } from '../../action';
import { ActionService } from '../../shared-service/action.service';

@Component({
  selector: 'app-viewhistory',
  templateUrl: './viewhistory.component.html',
  styleUrls: ['./viewhistory.component.css']
})
export class ViewhistoryComponent implements OnInit {

  private user:User;
  private store:Store;
  private actions:Action[];
  constructor(private _actionService:ActionService,private _storeService:StoreService,private _userService:UserService,private _router:Router) { }

  ngOnInit() {
    this.user=this._userService.getter();
    this.store = this._storeService.getter();
    this._actionService.getactions(this.store).subscribe((ret)=>{
      console.log(ret);
      this.actions = ret;
    },(error)=>{
      console.log(error);
    }) 
  }
  Undo(id:Number)
  {
    console.log(id);
   // this._actionService.undo(id).subscribe((ret)=>{
     // console.log(ret);
      this._router.navigate(['/userhome']);
   // },(error)=>{
    // console.log(error);
    //}) 
  }

}
