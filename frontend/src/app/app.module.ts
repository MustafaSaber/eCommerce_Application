import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HttpModule} from '@angular/http';
import {FormsModule} from '@angular/forms';
import { AppComponent } from './app.component';
import { ListuserComponent } from './components/listuser/listuser.component';
import { UserformComponent } from './components/userform/userform.component';
import { UserService } from './shared-service/user.service';
import { LoginformComponent } from './components/loginform/loginform.component';
import { HomepageComponent } from './components/homepage/homepage.component';
 


const appRoutes:Routes=[
  {path:'getuser',component:ListuserComponent},
  {path:'op',component:UserformComponent},
  {path:'login',component:LoginformComponent},
  {path:'',component:HomepageComponent}
]
@NgModule({
  declarations: [
    AppComponent,
    ListuserComponent,
    UserformComponent,
    LoginformComponent,
    HomepageComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
