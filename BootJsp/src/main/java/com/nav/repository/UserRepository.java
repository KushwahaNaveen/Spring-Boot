package com.nav.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nav.model.Users;

@Repository
public interface UserRepository extends CrudRepository<Users, Long> {
	
	Iterable<Users> findAll();

}
