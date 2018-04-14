import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs/Observable';
import { UserloginserviceService } from './shared-service/userloginservice.service';
import { UserService }        from './shared-service/user.service';

@Injectable()
export class LoginguardGuard implements CanActivate {
  constructor(private userservice:UserService){}

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    return this.userservice.getterUserLoggedIn();
  }
}