package com.ecommerce.sw2.Controllers;

import com.ecommerce.sw2.Models.Product;
import com.ecommerce.sw2.Models.User;
import com.ecommerce.sw2.Repositories.ProductRepo;
import jdk.internal.org.objectweb.asm.commons.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/product")
@SessionAttributes("User")
public class ProductController {
    @Autowired
    ProductRepo productRepo;

    String ViewProduct() {
        return "ViewProductFunction";
    }

    @PostMapping(value = "/view")
    String viewProduct(@RequestParam Integer ID, Model model,
                       @ModelAttribute("User") User user) {
        Product product = productRepo.findByProductID(ID);
        if (product == null) {
            model.addAttribute("header", "Product missing");
            model.addAttribute("body", "We didn't found product: " + ID.toString());
            return "ProductError";
        }
        int views = product.getNo_of_views();
        product.setNo_of_views(views + 1);
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


    @PostMapping("/buy")
    public void buyProduct(@RequestParam Integer id) {
        Product product = productRepo.findByProductID(id);
        product.setNo_of_sold_out(product.getNo_of_sold_out()+1);
    }
}
