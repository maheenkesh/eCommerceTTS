package com.tts.eCommerceTTS.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tts.eCommerceTTS.model.Product;
import com.tts.eCommerceTTS.model.User;
import com.tts.eCommerceTTS.services.ProductService;
import com.tts.eCommerceTTS.services.UserService;

@Controller
@ControllerAdvice
public class CartController {
  @Autowired
  ProductService productService;

  @Autowired
  UserService userService;

  @ModelAttribute("loggedInUser")
  public User loggedInUser() {
      return userService.getLoggedInUser();
  }

  @ModelAttribute("cart")
  public Map<Product, Integer> cart() {
      User user = loggedInUser();
      if(user == null) return null;
      System.out.println("Getting cart");
      return user.getCart();
  }

  @ModelAttribute("list")
  public List<Double> list() {
      return new ArrayList<>();
  }

  @GetMapping("/cart")
  public String showCart() {
      return "cart";
  }

  @PostMapping("/cart")
  public String addToCart(@RequestParam long id) {
      Product p = productService.findById(id);
      setQuantity(p, cart().getOrDefault(p, 0) + 1);
      return "cart";
  }

  @PatchMapping("/cart")
  public String updateQuantities(@RequestParam long[] id, @RequestParam int[] quantity) {
      for(int i = 0; i < id.length; i++) {
          Product p = productService.findById(id[i]);
          setQuantity(p, quantity[i]);
      }
      return "cart";
  }

  @DeleteMapping("/cart")
  public String removeFromCart(@RequestParam long id) {
      Product p = productService.findById(id);
      setQuantity(p, 0);
      return "cart";
  }

  private void setQuantity(Product p, int quantity) {
      if(quantity > 0)
          cart().put(p, quantity);
      else
          cart().remove(p);

      userService.updateCart(cart());
  }
}