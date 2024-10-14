package com.Taxi.TaxiBooking.model;

import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

public class Admin {

	
	@Id
	private String id;
	
	
	private String username;
	private String password;
	
}
