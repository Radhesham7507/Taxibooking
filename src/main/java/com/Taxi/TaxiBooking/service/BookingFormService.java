package com.Taxi.TaxiBooking.service;

import java.util.List;

import com.Taxi.TaxiBooking.model.BookingForm;


public interface BookingFormService {

	
	public BookingForm saveBookingFormService(BookingForm bookingForm);
	
	public List<BookingForm> readAllBookingsService();
	
	public void deleteBookingService(String id);
}
