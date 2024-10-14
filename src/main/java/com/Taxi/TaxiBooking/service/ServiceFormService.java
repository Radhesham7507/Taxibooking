package com.Taxi.TaxiBooking.service;

import java.util.List;


import org.springframework.web.multipart.MultipartFile;


import com.Taxi.TaxiBooking.model.ServiceForm;

public interface ServiceFormService {
	
	public ServiceForm addService(ServiceForm serviceForm ,MultipartFile multipartFile) throws Exception;

	  List<ServiceForm> getAllServices();
	
	  public List<ServiceForm> readAllServices();
	  
	  public void deleteService(String id);
}
