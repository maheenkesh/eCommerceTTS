package com.tts.eCommerceTTS.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.eCommerceTTS.model.Cart;
@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {

}
