package com.Taxi.TaxiBooking.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Taxi.TaxiBooking.dao.AdminDao;
import com.Taxi.TaxiBooking.model.Admin;
@Service
public class AdminCredentialsServiceImpl implements AdminCredentialsService{
	
	
	private AdminDao adminDao;
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Autowired
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	} 
	
	

	@Override
	public String checkAdminCredentials(String oldusername, String oldpassword) {
		
Optional<Admin> byUsername=	adminDao.findByUsername(oldusername);
		
       if(byUsername.isPresent())
       {
    	   Admin admin =byUsername.get();
    Boolean matches= passwordEncoder.matches(oldpassword, admin.getPassword());
    	   
         if(matches)
         {
        	 return "SUCCESS";
         }
         else
         {
        	 return "Worng OLd Credentilas";
         }
       }else
       {
    	   return "Wrong Old Credentilas";
       }
        
		
	}

	@Override
    public String updateAdminCredentials(String newusername, String newpassword, String oldusername) {
        // Find the admin by the old username
        Optional<Admin> existingAdminOpt = adminDao.findByUsername(oldusername);
        if (existingAdminOpt.isPresent()) {
            Admin existingAdmin = existingAdminOpt.get();
            // Update the username and password
            existingAdmin.setUsername(newusername);
            existingAdmin.setPassword(passwordEncoder.encode(newpassword));
            // Save the updated admin
            adminDao.save(existingAdmin);
            return "CREDENTIALS UPDATED SUCCESSFULLY";
        } else {
            return "FAILED TO UPDATE: Admin not found.";
        }
		
	}

}
