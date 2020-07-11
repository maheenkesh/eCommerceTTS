package com.tts.eCommerceTTS.services;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tts.eCommerceTTS.model.Cart;
import com.tts.eCommerceTTS.model.Product;

@Service
public class CartService {
	
	@Autowired
	private ProductService productService;
	
	public Cart addLineItemToCart(Cart cart, Long productId, Integer quantity) {
		  Product productToAdd = productService.findById(productId);
		  HashMap<Product, Integer> lineItemToAdd = new HashMap<>();
		  lineItemToAdd.put(productToAdd, quantity);
		  List<HashMap<Product, Integer>> cartItems = cart.getLineItems();
		  cartItems.add(lineItemToAdd);
		  cart.setLineItems(cartItems);
		  return cart;
		}

		public Cart updateLineItemQuantity(Cart cart, Long productId, Integer quantity){
		  Product productToUpdate = productService.findById(productId);
		  List<HashMap<Product, Integer>> cartItems = cart.getLineItems();
		  for (HashMap<Product, Integer> cartItem : cartItems){
		    cartItem.replace(productToUpdate, quantity);
		  }
		  cart.setLineItems(cartItems);
		  return cart;
		}
}
