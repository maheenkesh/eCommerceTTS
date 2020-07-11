package com.tts.eCommerceTTS.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tts.eCommerceTTS.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
		public List<Product> findAll();
		public Product findById(long id);
		public List<Product> findByBrand(String brand);
		public List<Product> findByCategory(String category);
		public List<Product> findByBrandAndCategory(String brand, String category);

		@Query("SELECT DISTINCT p.brand FROM Product p")
		public List<String> findDistinctBrands();

		@Query("SELECT DISTINCT p.category FROM Product p")
		public List<String> findDistinctCategories();
}
