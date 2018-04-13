package com.ecommerce.sw2.Models.Services;

import com.ecommerce.sw2.Models.Domain.Product;
import com.ecommerce.sw2.forms.AddProductForm;

public interface ProductService {

    Product addProduct(AddProductForm addProductForm);

}
