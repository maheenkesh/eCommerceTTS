package com.tts.eCommerceTTS.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.eCommerceTTS.model.Product;
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}
