package com.Taxi.TaxiBooking.service;

import java.util.List;


import com.Taxi.TaxiBooking.model.ContactForm;



public interface ContactFormService { 
	
	public ContactForm saveContactFormService(ContactForm contactForm);
	
	public List<ContactForm> readAllContactsService();
	
	public void deleteContactService(String id);
	

}
