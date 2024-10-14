package com.Taxi.TaxiBooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Taxi.TaxiBooking.dao.BookingFormCurd;
import com.Taxi.TaxiBooking.model.BookingForm;
@Service
public class BookingFormServiceImpl implements BookingFormService { 
	
	private BookingFormCurd bookingFormCurd;
	
	@Autowired
	public void setBookingFormCurd(BookingFormCurd bookingFormCurd) {
		this.bookingFormCurd = bookingFormCurd;
	}



	@Override
	public BookingForm saveBookingFormService(BookingForm bookingForm) {
		
		return bookingFormCurd.save(bookingForm);
		
	}

	@Override
	public List<BookingForm> readAllBookingsService() {
		
		return bookingFormCurd.findAll();
	}



	@Override
	public void deleteBookingService(String id) {
		
		 bookingFormCurd.deleteById(id);
		
	}

}
