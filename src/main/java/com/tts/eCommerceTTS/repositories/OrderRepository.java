package com.tts.eCommerceTTS.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.eCommerceTTS.model.Order;
@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

}