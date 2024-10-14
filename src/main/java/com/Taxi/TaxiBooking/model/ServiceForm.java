package com.Taxi.TaxiBooking.model;

import org.springframework.data.annotation.Id;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ServiceForm {
    
	@Id
    private String id;	
	private String image;
	private String title;
	private String description;
	
	
}
