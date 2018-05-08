import { Component, OnInit } from '@angular/core';
import {UserService} from '../../shared-service/user.service';
import {User} from '../../user';
import {Store} from '../../store';
import{Router} from '@angular/router';
import { StoreService } from '../../shared-service/store.service';

@Component({
  selector: 'app-viewcollaborators',
  templateUrl: './viewcollaborators.component.html',
  styleUrls: ['./viewcollaborators.component.css']
})
export class ViewcollaboratorsComponent implements OnInit {

  private user:User;
  private store:Store;
  private users:User[];
  constructor(private _storeService:StoreService,private _userService:UserService,private _router:Router) { }

  ngOnInit() {
    this.user=this._userService.getter();
    this.store = this._storeService.getter();
    this._userService.getcoll(this.store).subscribe((ret)=>{
      console.log(ret);
      this.users = ret;
    },(error)=>{
      console.log(error);
    }) 
  }
  AddCollaborator()
  {
    this._router.navigate(['/addcollaborator']);
  }

}
