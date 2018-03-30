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
import java.util.Vector;

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
    String viewProduct(@RequestParam String modelname, @RequestParam String storename, Model model,
                       @ModelAttribute("User") User user) {
        Vector<Product> products = productRepo.findByModel_NameAndStoreName(modelname,storename);
        if (products == null
                || products.size() <= 0) {
            model.addAttribute("header", "Product missing");
            model.addAttribute("body", "We didn't found product: " + modelname);
            return "ProductError";
        }
        int views = 0;
        int sold = 0;
        for (Product p: products) {
            views+=p.getNo_of_views();
            sold +=p.getNo_of_sold_out();
        }
        Product product = products.get(0);
        product.setNo_of_views(product.getNo_of_views() + 1);
        productRepo.save(product);
        model.addAttribute("product", product);
        model.addAttribute("views",views);
        model.addAttribute("sold",sold);
        model.addAttribute("quantity",products.size());
        return "ProductInfo";
    }


    @PostMapping("/buy")
    public void buyProduct(@RequestParam Integer id) {
        Product product = productRepo.findByProductID(id);
        product.setNo_of_sold_out(product.getNo_of_sold_out()+1);
    }
}
