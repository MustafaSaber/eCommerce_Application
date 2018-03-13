package com.ecommerce.sw2.Controllers;

import com.ecommerce.sw2.Models.Product;
import com.ecommerce.sw2.Repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Vector;

/**
 * Created by Mina_Yousry on 13/03/2018.
 */
@Controller
public class StoreController {
    @Autowired
    ProductRepo productRepo;

    @RequestMapping("/stats")
    public String getStats(@RequestParam String store,Model model){
        Vector<Product> vp = productRepo.findByStore(store);
        model.addAttribute("sname",store);
        if (vp == null || vp.size() <=0) {
            model.addAttribute("found", "0");
            return "storestats";
        }
        model.addAttribute("found","1");
        model.addAttribute("rows",vp);
        return "storestats";
    }
}
