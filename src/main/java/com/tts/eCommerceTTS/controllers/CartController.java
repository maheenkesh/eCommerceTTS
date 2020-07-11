package com.tts.eCommerceTTS.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tts.eCommerceTTS.model.Cart;
import com.tts.eCommerceTTS.model.Product;
import com.tts.eCommerceTTS.services.CartService;
import com.tts.eCommerceTTS.services.ProductService;
import com.tts.eCommerceTTS.services.UserService;

public class CartController {

	//these two are also questionable
	@Autowired
	private ProductService productService;
	@Autowired
	private UserService userService;
	@Autowired
	private CartService cartService;
	
	@GetMapping("/storefront/cart")
	public String showCart(Cart cart, Model model) {
	  model.addAttribute("cart", cart);
	  return "storefront/cart";
	}
	 
	@PostMapping("/storefront/cart")
	public String addToCart(@RequestParam Long productId, Cart cart, @RequestParam Integer quantity, Model model) {
	cart = cartService.addLineItemToCart(cart, productId, quantity);
	  model.addAttribute("cart", cart);
	  return "storefront/cart";
	}

	@PostMapping("/storefront/cart")
	public String changeCartLineItemQuantity(@RequestParam Long productId, Cart cart, @RequestParam Integer quantity, Model model) {
	  cart = cartService.updateLineItemQuantity(cart, productId, quantity);
	  model.addAttribute("cart", cart);
	  return "storefront/cart";
	}

//	@DeleteMapping("/cart")
//	public String removeFromCart(@RequestParam long id) {
//	  Product product = productService.findById(id);
//	  setQuantity(product, 0);
//	  return "storefront/cart";
//	}
//
//	private void setQuantity(Product p, Cart cart, int quantity) {
//	  if(quantity > 0){
//	    cart.put(p, quantity);
//	  } else {
//	    cart.remove(p);
//	  }
//	  userService.updateCart(cart());
//	}
}
