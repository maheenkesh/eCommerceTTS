package com.tts.eCommerceTTS.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.eCommerceTTS.model.User;
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}