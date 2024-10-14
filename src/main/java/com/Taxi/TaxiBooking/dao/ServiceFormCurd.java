package com.Taxi.TaxiBooking.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.Taxi.TaxiBooking.model.ServiceForm;

@Repository
public interface ServiceFormCurd extends MongoRepository<ServiceForm, String> {

	@Override
	public <S extends ServiceForm> S save(S entity);
	
	@Override
	public List<ServiceForm> findAll() ;
	
	@Override
	public void delete(ServiceForm entity);
}
