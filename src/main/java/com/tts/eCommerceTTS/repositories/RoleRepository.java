package com.tts.eCommerceTTS.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.eCommerceTTS.model.Role;
@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

	public Role findByRole(String role);
}