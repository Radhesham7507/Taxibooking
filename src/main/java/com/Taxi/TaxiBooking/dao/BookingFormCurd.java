package com.Taxi.TaxiBooking.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.Taxi.TaxiBooking.model.BookingForm;

@Repository
public interface BookingFormCurd extends MongoRepository<BookingForm, String> {
	
	@Override
	public <S extends BookingForm> S save(S entity) ;

}
