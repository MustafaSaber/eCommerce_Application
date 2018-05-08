import { Component, OnInit } from '@angular/core';
import {UserService} from '../../shared-service/user.service';
import {User} from '../../user';
import {Store} from '../../store';
import{Router} from '@angular/router';
import { StoreService } from '../../shared-service/store.service';
import { Product } from '../../product';
import { ProductService } from '../../shared-service/product.service';
import { EditProductForm } from '../../edit-product-form';
import { EditproductformService } from '../../shared-service/editproductform.service';

@Component({
  selector: 'app-view-products',
  templateUrl: './view-products.component.html',
  styleUrls: ['./view-products.component.css']
})
export class ViewProductsComponent implements OnInit {

  private user:User;
  private store:Store;
  private products:Product[];
  constructor(private _productService:ProductService,private _editProductService:EditproductformService,private _storeService:StoreService,private _userService:UserService,private _router:Router) { }

  ngOnInit() {
    this.user=this._userService.getter();
    this.store = this._storeService.getter();
    this._storeService.getProducts(this.store).subscribe((products)=>{
      console.log(products);
      this.products = products;
    },(error)=>{
      console.log(error);
    }) 
  }
  AddProduct()
  {
    let product = new Product();
    this._productService.setter(product);
    this._router.navigate(['/addproduct']);
  }
  EditProduct(id:Number)
  {
    console.log(id);
    let editProduct = new EditProductForm;
    editProduct.id = id;
    this._editProductService.setter(editProduct);
    this._router.navigate(['/editproduct']);
  }
  DeleteProduct(id:Number)
  {
    console.log(id);
    /*this._productService.deleteProduct(id).subscribe((ret)=>{
    
    if(ret.name == "null")
    {
      window.alert("You can not delete this product !!");
    }
    else
    {
      window.alert("This product is deleted successfully !!");
      this._router.navigate(['/userhome']);
    }
    },(error)=>{
      console.log(error);
    }) */
  }
  AddCollaborator()
  {
    this._router.navigate(['/addcollaborator']);
  }
  ViewCollaborator()
  {
    this._storeService.setter(this.store);
    this._router.navigate(['/viewcollaborators'])
  }
  ViewHistory()
  {
    this._storeService.setter(this.store);
    this._router.navigate(['/viewhistory'])
  }
  AddStat()
  {
    this._storeService.setter(this.store);
    this._router.navigate(['/addstorestat'])
  }
  ViewStat()
  {
    this._storeService.setter(this.store);
    this._router.navigate(['/viewstorestat'])
  }
}