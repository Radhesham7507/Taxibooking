 package com.Taxi.TaxiBooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Taxi.TaxiBooking.dao.ContactFormCurd;
import com.Taxi.TaxiBooking.model.ContactForm;

@Service
public class ContactFormServiceImpl implements ContactFormService{ 
	
	private ContactFormCurd contactFormCurd;
	
	
    @Autowired
	public void setContactFormCurd(ContactFormCurd contactFormCurd) {
		this.contactFormCurd = contactFormCurd;
	}


	@Override
	public ContactForm saveContactFormService(ContactForm contactForm) {
		
		return contactFormCurd.save(contactForm);
		
	}

	@Override
	public List<ContactForm> readAllContactsService() {
	
		return contactFormCurd.findAll();
	}



	@Override
	public void deleteContactService(String id) {
		
		contactFormCurd.deleteById(id);
	}

}
