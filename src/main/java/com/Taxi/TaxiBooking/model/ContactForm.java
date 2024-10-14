package com.Taxi.TaxiBooking.model;

import org.springframework.data.annotation.Id;



import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ContactForm {

	@Id
	private String id;
	@NotEmpty(message="Name Cannot be Empty")
	@Size(min=2,max=30,message="Invalid Name Size")
	private String name;
	
	@NotEmpty(message="Email Cannot be Empty")
	@Size(min=5,max=50,message="Invalid Email Size")
	private String email;
	
	@NotNull(message="Phone No Cannot be Empty")
	@Min(value=1000000000,message="Phone No must be at list 10 digits")
	@Max(value=9999999999L,message="Phone No must be at list 10 digits")
	private Long phone;
	
	@NotEmpty(message="Message Cannot be Empty")
	@Size(min=2,max=500,message="Invalid message size")
	private String message;
	
}
