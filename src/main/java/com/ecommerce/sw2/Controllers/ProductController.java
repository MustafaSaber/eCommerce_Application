package com.ecommerce.sw2.Controllers;

import com.ecommerce.sw2.Models.Domain.Product;
import com.ecommerce.sw2.Models.Repository.ProductRepository;
import com.ecommerce.sw2.Models.Services.ProductService;
import com.ecommerce.sw2.Validators.AddProductFormValidators;
import com.ecommerce.sw2.Validators.StoreFormValidator;
import com.ecommerce.sw2.forms.AddProductForm;
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

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private AddProductFormValidators addProductFormValidators;

    @InitBinder("addProductForm")
    public void AddProductFormInitBinder(WebDataBinder binder) { binder.addValidators(addProductFormValidators); }

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

}
