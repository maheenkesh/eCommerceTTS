package com.tts.eCommerceTTS.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class MainController {

	  @GetMapping(value = {"/", "/home"})
	  public String home(Model model) {
	    model.addAttribute("products", productService.findAll());
	    model.addAttribute("categories", productService.findCategories());
	    model.addAttribute("brands", productService.findBrands());
	    return "storefront/index";
	  }
	  
	  @GetMapping("/filter")
	  public String filter(@RequestParam(required = false) String category, 
	      @RequestParam(required = false) String brand, Model model) {
	    List<Product> filtered = productService.findByBrandAndOrCategory(brand, category);
	    model.addAttribute("products", filtered);
	    model.addAttribute("categories", productService.findCategories());
	    model.addAttribute("brands", productService.findBrands());
	    return "storefront/index";
	  }
	  
	  @GetMapping("/about")
	  public String about() {
	    return "storefront/about";
	  }
}
