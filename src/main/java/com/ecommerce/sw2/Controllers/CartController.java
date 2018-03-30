package com.ecommerce.sw2.Controllers;

import com.ecommerce.sw2.Models.Cart;
//import com.ecommerce.sw2.Models.Model;
import com.ecommerce.sw2.Models.NormalUser;
import com.ecommerce.sw2.Models.Product;
import org.springframework.ui.Model;
import com.ecommerce.sw2.Models.User;
import com.ecommerce.sw2.Repositories.CartRepo;
import com.ecommerce.sw2.Repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.management.modelmbean.ModelMBeanAttributeInfo;
import java.util.*;

import static com.sun.deploy.trace.TraceLevel.UI;

/**
 * Created by Mina_Yousry on 28/03/2018.
 */

@Controller
@RequestMapping("/cart")
@SessionAttributes("User")
public class CartController {
    @Autowired
    CartRepo cartRepo;
    @Autowired
    ProductRepo productRepo;
    @Autowired
    ProductController productController;
    @Autowired
    SystemController systemController;

    @RequestMapping(value = "/addtocart", method = RequestMethod.POST)
    public String AddToCart(@RequestParam String modelname, @RequestParam String storename, @RequestParam Integer quantity, Model model,
                          @ModelAttribute("User") User user){
        if (user == null)
            return "redirect:/";
        if (!(user instanceof  NormalUser))
            return "redirect:/";

            Cart cart = cartRepo.findCartByOwner(user.getUsername());
        if (cart == null) {
            cart = new Cart(user.getUsername());
            cartRepo.save(cart);
        }
        Vector<Product> products = productRepo.findByModel_NameAndStoreName(modelname,storename);
        if (products.size() < quantity)
            return "redirect:/home";

        for (int i = 0; i < quantity;i++) {
            cart.AddProduct(products.get(i));
        }
        cartRepo.save(cart);
        model.addAttribute("cart", cart);
        return "cartView";
    }
    @RequestMapping(value = "/view" , method = RequestMethod.POST)
    public String view(@RequestParam String userid, Model model){
        Cart cart = cartRepo.findCartByOwner(userid);
        if (cart == null) {
            cart = new Cart(userid);
            cartRepo.save(cart);
        }
        model.addAttribute("cart", cart);
        return "cartView";
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String remove(@RequestParam("id") Integer id , @RequestParam("cartid") Integer cartid, Model model){
        Cart cart = cartRepo.findByCartID(cartid);
        if (cart != null)
            return "redirect:/";
        cart.removeProduct(id);
        cartRepo.save(cart);



        model.addAttribute("cart", cart);
        return "cartView";
    }

    @RequestMapping(value = "/checkout", method = RequestMethod.POST)
    public String checkout(@RequestParam("cartid") Integer cartid, Model model){
        Cart cart = cartRepo.findByCartID(cartid);
        Iterator<Product> s = cart.getProducts().iterator();
        while (s.hasNext())
            productController.buyProduct(s.next().getProductID());
        cartRepo.save(cart);
        return "redirect:/";//systemController.index(mv);
    }
}
