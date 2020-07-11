package com.tts.eCommerceTTS.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.tts.eCommerceTTS.model.Product;
import com.tts.eCommerceTTS.services.ProductService;

public class MainController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/")
    public String main() {
        return "storefront/storeFront";
    }

    @ModelAttribute("products")
    public List<Product> products() {
        return productService.findAll();
    }

    @ModelAttribute("categories")
    public List<String> categories() {
        return productService.findCategories();
    }

    @ModelAttribute("brands")
    public List<String> brands() {
        return productService.findBrands();
    }
	
	@GetMapping(value = {"/", "/home"})
	  public String home(Model model) {
	    model.addAttribute("products", productService.findAll());
	    model.addAttribute("categories", productService.findCategories());
	    model.addAttribute("brands", productService.findBrands());
	    return "storefront/storeFront";
	  }
	  
	  @GetMapping("/filter")
	  public String filter(@RequestParam(required = false) String category, 
	      @RequestParam(required = false) String brand, Model model) {
	    List<Product> filtered = productService.findByBrandAndOrCategory(brand, category);
	    model.addAttribute("products", filtered);
	    model.addAttribute("categories", productService.findCategories());
	    model.addAttribute("brands", productService.findBrands());
	    return "storefront/storeFront";
	  }
	  
	  @GetMapping("/about")
	  public String about() {
	    return "storefront/about";
	  }
}
