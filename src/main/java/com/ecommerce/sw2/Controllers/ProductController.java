package com.ecommerce.sw2.Controllers;

import com.ecommerce.sw2.Models.Domain.Action;
import com.ecommerce.sw2.Models.Domain.Cart;
import com.ecommerce.sw2.Models.Domain.EditProduct;
import com.ecommerce.sw2.Models.Domain.Product;
import com.ecommerce.sw2.Models.Repository.ProductRepository;
import com.ecommerce.sw2.Models.Services.ProductService;
import com.ecommerce.sw2.Validators.AddProductFormValidators;
import com.ecommerce.sw2.Validators.EditProductFormValidator;
import com.ecommerce.sw2.Validators.EditProductFormValidator;
import com.ecommerce.sw2.Validators.StoreFormValidator;
import com.ecommerce.sw2.forms.AddProductForm;
import com.ecommerce.sw2.forms.EditProductForm;
import com.ecommerce.sw2.forms.RegisterForm;
import com.ecommerce.sw2.forms.StoreForm;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private AddProductFormValidators addProductFormValidators;

    @Autowired
    private EditProductFormValidator editProductFormValidator;

    @InitBinder("addProductForm")
    public void AddProductFormInitBinder(WebDataBinder binder) { binder.addValidators(addProductFormValidators); }
    @InitBinder("editProduct")
    public void EditProductFormInitBinder(WebDataBinder binder) { binder.addValidators(editProductFormValidator); }


    @RequestMapping(value = "/addproduct" , method = RequestMethod.POST)
    public ResponseEntity<?> AddProduct(@Valid @RequestBody AddProductForm addProductForm , BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", "null");
            return ResponseEntity.ok().body(jsonObject);
        }
        Product product = productService.addProduct(addProductForm);

        if(product ==  null)
        {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", "null");
            return ResponseEntity.ok().body(jsonObject);
        }

        return ResponseEntity.ok().body(product);
    }

    @RequestMapping(value = "/getproducts", method = RequestMethod.POST)
    public Collection<Product> getStores(@RequestBody StoreForm RegisterForm)
    {
        return productService.getProductsByStore(RegisterForm);
    }

    @RequestMapping(value = "/viewproducts", method = RequestMethod.GET)
    public Collection<Product> viewProducts()
    {
        return productService.viewProducts();
    }

    @RequestMapping(value = "/cartproducts/{cartId}", method = RequestMethod.GET)
    public Collection<Product> cartProducts(@PathVariable("cartId") Long cartId)
    {
        return productService.cartProducts(cartId);
    }

    @RequestMapping(value = "/edit" , method = RequestMethod.POST)
    public ResponseEntity<?> edit(@Valid @RequestBody EditProductForm editProductForm, BindingResult bindingResult){
        if (bindingResult.hasErrors())
        {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name","null");
            ResponseEntity.ok().body(jsonObject);
        }
        return ResponseEntity.ok().body(productService.edit(editProductForm));
    }

    @RequestMapping(value = "/viewprod/{id}" , method = RequestMethod.GET)
    public Product view(@PathVariable Long id)
    {
        return productService.viewproduct(id);
    }

    @RequestMapping(value = "/deleteproduct",method = RequestMethod.POST)
    public ResponseEntity<?> delete(@RequestBody Long productid){
        Optional<Product> product = productService.getProduct(productid);
        if (!product.isPresent()){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name","null");
            return ResponseEntity.ok().body(jsonObject);
        }
//        return ResponseEntity.ok().body(productService.delete(productid));
        return ResponseEntity.ok().body("");
    }
}