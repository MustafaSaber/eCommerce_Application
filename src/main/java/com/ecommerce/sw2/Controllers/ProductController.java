package com.ecommerce.sw2.Controllers;

import com.ecommerce.sw2.Models.Product;
import com.ecommerce.sw2.Repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductRepo productRepo;

    String ViewProduct(){
        return "ViewProductFunction";
    }

    @RequestMapping("/view")
    String viewProduct(@RequestParam  Integer ID,Model model) {
        Product product = productRepo.findByProductID(ID);
        if (product == null) {
            model.addAttribute("header", "Product missing");
            model.addAttribute("body", "We didn't found product: " + ID.toString());
            return "ProductError";
        }
        int views = product.getNo_of_views();
        product.setNo_of_views(views+1);
        productRepo.save(product);
        model.addAttribute("product", product);
        model.addAttribute("name", "" + product.getModel());
        model.addAttribute("price", "" + product.getPrice().toString());
        model.addAttribute("id", "" + product.getProductID().toString());
        model.addAttribute("brand", "" + product.getBrand());
        model.addAttribute("store", "" + product.getStore());
        model.addAttribute("views", "" + product.getNo_of_views());
        model.addAttribute("sold", "" + product.getNo_of_sold_out());
        return "ProductInfo";
    }
}
