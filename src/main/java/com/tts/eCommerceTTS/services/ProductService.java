package com.tts.eCommerceTTS.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tts.eCommerceTTS.model.Product;
import com.tts.eCommerceTTS.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> findAll() {
	  return productRepository.findAll();
	}

	public Product findById(long id) {
	  return productRepository.findById(id);
	}

	public List<String> findBrands() {
	  return productRepository.findDistinctBrands();
	}

	public List<String> findCategories() {
	  return productRepository.findDistinctCategories();
	}

	public void save(Product product) {
	  productRepository.save(product);
	}

	public void deleteById(long id) {
	  productRepository.deleteById(id);
	}

	public List<Product> findByBrandAndOrCategory(String brand, String category) {
	  List<Product> products = new ArrayList<>();
	  if(category == null && brand == null) {
	    products = productRepository.findAll();
	  } else if(category == null) {
	    products = productRepository.findByBrand(brand);
	  } else if(brand == null) {
	    products = productRepository.findByCategory(category);
	  } else {
	    products = productRepository.findByBrandAndCategory(brand, category);
	  }
	  return products;
	}

}