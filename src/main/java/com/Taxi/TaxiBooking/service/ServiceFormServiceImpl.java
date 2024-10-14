package com.Taxi.TaxiBooking.service;

import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.Taxi.TaxiBooking.dao.ServiceFormCurd;
import com.Taxi.TaxiBooking.model.ServiceForm;
@Service	
public class ServiceFormServiceImpl implements ServiceFormService {
	
	private ServiceFormCurd serviceFormCurd;
	
	
    @Autowired
	public void setServiceFormCurd(ServiceFormCurd serviceFormCurd) {
		this.serviceFormCurd = serviceFormCurd;
	}


    @Transactional(rollbackFor = Exception.class)
	@Override
	public ServiceForm addService(ServiceForm serviceForm, MultipartFile multipartFile) throws Exception {
		ServiceForm save=null;
		try {
			
	 save= serviceFormCurd.save(serviceForm);
	 if(save!=null)
	 {
	 String path="/home/radhesham/Desktop/Finalproject/Taxibooking/src/main/resources/static/myserviceimg/"+multipartFile.getOriginalFilename();
			
     byte[]	 bytes= multipartFile.getBytes();
     
     FileOutputStream fos=new FileOutputStream(path);
     fos.write(bytes);
	 }
		} catch (Exception e) {
			save=null;
			throw e;
			
		}
		
		
		return save;
	}


	@Override
	public List<ServiceForm> getAllServices() {
		
		 return serviceFormCurd.findAll();
	}


	@Override
	public List<ServiceForm> readAllServices() {
		
		
		return serviceFormCurd.findAll();
	}


	@Override
	public void deleteService(String id) {
		 serviceFormCurd.deleteById(id);
		
	}

}
