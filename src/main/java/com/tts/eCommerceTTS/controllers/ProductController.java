package com.tts.eCommerceTTS.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tts.eCommerceTTS.model.Product;

public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/products/{productId}")
	public String show(@PathVariable Long id, Model model) {
	  Product product = productService.findById(id);
	  model.addAttribute(product);
	  return "storefront/product";
	}

	@RequestMapping(value = {"/products/new", "/products/{productId}/edit"}, method = {RequestMethod.POST, RequestMethod.PUT })
	public String createOrUpdate(@Valid Product product) {
	  productService.save(product);
	  return "redirect:/storefront/products/" + product.getId();
	}
}
