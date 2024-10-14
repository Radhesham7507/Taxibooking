package com.Taxi.TaxiBooking.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.Taxi.TaxiBooking.model.Admin;

public interface AdminDao extends MongoRepository<Admin, String> {

	
	
	Optional<Admin> findByUsername(String username); 
	
	
	
	@Query("{ 'username': ?0 }")
	@Transactional
	public String updateCredentilas(
			
			@Param("newusername") String newusername,
			@Param("newpassword") String newpassword,
			@Param("oldusername") String oldusername
			
			
			
			);
	
}
