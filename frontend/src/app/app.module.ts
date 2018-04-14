import { BrowserModule }       from '@angular/platform-browser';
import { NgModule }            from '@angular/core';
import { RouterModule, Routes} from '@angular/router';
import { HttpModule}           from '@angular/http';
import { FormsModule}          from '@angular/forms';
import { AppComponent }        from './app.component';
import { ListuserComponent }   from './components/listuser/listuser.component';
import { UserformComponent }   from './components/userform/userform.component';
import { UserService }         from './shared-service/user.service';
import { LoginformComponent }  from './components/loginform/loginform.component';
import { HomepageComponent }   from './components/homepage/homepage.component';
import { UserHomePageComponent}from './components/user-home-page/user-home-page.component';
import { LoginguardGuard }     from "./loginguard.guard";
import { AddBrandComponent }   from './components/add-brand/add-brand.component';
import { BrandserviceService}  from './shared-service/brandservice.service';
import { AddModelComponent }   from './components/add-model/add-model.component';
import { ModelService }        from './shared-service/model.service';
import { AddStoreComponent } from './components/add-store/add-store.component';
import { StoreService }        from './shared-service/store.service';
import { ProductService }        from './shared-service/product.service';
import { ViewStoresComponent } from './components/view-stores/view-stores.component';
import { ViewProductsComponent } from './components/view-products/view-products.component';
import { AddProductComponent } from './components/add-product/add-product.component';
 
const appRoutes:Routes=[
  {path:'getuser'  ,component:ListuserComponent},
  {path:'op'       ,component:UserformComponent},
  {path:'login'    ,component:LoginformComponent},
  {path:''         ,component:HomepageComponent},
  {path:'addbrand' ,component:AddBrandComponent},
  {path:'userhome' ,canActivate:[LoginguardGuard],component:UserHomePageComponent},
  {path:'addmodel' ,component:AddModelComponent},
  {path:'addstore' ,component:AddStoreComponent},
  {path:'viewproducts' ,component:ViewProductsComponent},
  {path:'viewstores' ,component:ViewStoresComponent},
  {path:'addproduct' ,component:AddProductComponent}
   
]
@NgModule({
  declarations: [
    AppComponent,
    ListuserComponent,
    UserformComponent,
    LoginformComponent,
    HomepageComponent,
    UserHomePageComponent,
   AddBrandComponent,
   AddModelComponent,
   AddStoreComponent,
   ViewStoresComponent,
   ViewProductsComponent,
   AddProductComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [UserService,LoginguardGuard,BrandserviceService,ModelService,StoreService,ProductService],
  bootstrap: [AppComponent]
})
export class AppModule { }
