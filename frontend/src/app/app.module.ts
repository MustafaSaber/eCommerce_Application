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
import { AddToCartService }        from './shared-service/add-to-cart.service';
import { ViewStoresComponent } from './components/view-stores/view-stores.component';
import { ViewProductsComponent } from './components/view-products/view-products.component';
import { AddProductComponent } from './components/add-product/add-product.component';
import { AppStoresComponent } from './components/app-stores/app-stores.component';
import { MyCartComponent } from './components/my-cart/my-cart.component';
import { CartService }        from './shared-service/cart.service';
import { ProdService }        from './shared-service/prod.service';
import { EditproductformService }  from './shared-service/editproductform.service';
import { ViewProdDetalisComponent } from './components/view-prod-detalis/view-prod-detalis.component';
import { EditproductComponent } from './components/editproduct/editproduct.component';
import { AddcollaboratorComponent } from './components/addcollaborator/addcollaborator.component';
import { ViewcollaboratorsComponent } from './components/viewcollaborators/viewcollaborators.component';
import { ViewhistoryComponent } from './components/viewhistory/viewhistory.component';
import { ActionService }        from './shared-service/action.service';
import { AdminhomeComponent } from './components/adminhome/adminhome.component';
import { AddstatComponent } from './components/addstat/addstat.component';
import { StatService }  from './shared-service/stat.service';
import { ViewstorestatComponent } from './components/viewstorestat/viewstorestat.component';
import { AddstorestatComponent } from './components/addstorestat/addstorestat.component';
 
const appRoutes:Routes=[
  {path:'getuser'  ,canActivate:[LoginguardGuard],component:ListuserComponent},
  {path:'op'       ,canActivate:[LoginguardGuard],component:UserformComponent},
  {path:'login'    ,canActivate:[LoginguardGuard],component:LoginformComponent},
  {path:''         ,component:HomepageComponent},
  {path:'addbrand' ,canActivate:[LoginguardGuard],component:AddBrandComponent},
  {path:'userhome' ,canActivate:[LoginguardGuard],component:UserHomePageComponent},
  {path:'addmodel' ,canActivate:[LoginguardGuard],component:AddModelComponent},
  {path:'addstore' ,canActivate:[LoginguardGuard],component:AddStoreComponent},
  {path:'viewproducts',canActivate:[LoginguardGuard],component:ViewProductsComponent},
  {path:'viewstores' ,canActivate:[LoginguardGuard],component:ViewStoresComponent},
  {path:'addproduct' ,canActivate:[LoginguardGuard],component:AddProductComponent},
  {path:'appstores' ,canActivate:[LoginguardGuard],component:AppStoresComponent},
  {path:'mycart' ,canActivate:[LoginguardGuard],component:MyCartComponent},
  {path:'viewproddetails',canActivate:[LoginguardGuard],component:ViewProdDetalisComponent},
  {path:'editproduct',canActivate:[LoginguardGuard],component:EditproductComponent},
  {path:'addcollaborator',canActivate:[LoginguardGuard],component:AddcollaboratorComponent},
  {path:'viewcollaborators',canActivate:[LoginguardGuard],component:ViewcollaboratorsComponent},
  {path:'viewhistory',canActivate:[LoginguardGuard],component:ViewhistoryComponent},
  {path:'adminhome',canActivate:[LoginguardGuard],component:AdminhomeComponent},
  {path:'addstat',canActivate:[LoginguardGuard],component:AddstatComponent},
  {path:"viewstorestat",canActivate:[LoginguardGuard],component:ViewstorestatComponent},
  {path:"addstorestat",canActivate:[LoginguardGuard],component:AddstorestatComponent}
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
   AddProductComponent,
   AppStoresComponent,
   MyCartComponent,
   ViewProdDetalisComponent,
   EditproductComponent,
   AddcollaboratorComponent,
   ViewcollaboratorsComponent,
   ViewhistoryComponent,
   AdminhomeComponent,
   AddstatComponent,
   ViewstorestatComponent,
   AddstorestatComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [UserService,StatService,ActionService,EditproductformService,LoginguardGuard,BrandserviceService,ModelService,StoreService,ProductService,ProdService,CartService,AddToCartService],
  bootstrap: [AppComponent]
})

export class AppModule { }
