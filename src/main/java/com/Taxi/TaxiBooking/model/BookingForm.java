package com.Taxi.TaxiBooking.model;

import java.time.LocalDate;

import java.time.LocalTime;

import org.springframework.data.annotation.Id;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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

public class BookingForm {

	@Id
	private String id;
	
	@NotEmpty(message="Name Cannot be Empty")
	@Size(min=2,max=30,message="Invalid Name length")
	@NotBlank(message="name cant be blank")
	@Pattern(regexp = "^[A-Z a-z]+$" ,message="name must contain only alphabet")
	private String name;
	
	@NotEmpty(message="Source Cannot be Empty")
	@NotBlank(message="source cant be blank")
	@Size(min=2,max=100,message="Invalid Name length")
	private String source;
	
	@NotEmpty(message="Email Cannot be Empty")
	@Size(min=7,max=50,message="Invalid Email Size")
	@NotBlank(message="email cant be blank")
	private String email;
	
	@NotEmpty(message="Destination Cannot be Empty")
	@NotBlank(message="Destination cant be blank")
	@Size(min=2,max=100,message="Invalid Name length")
	private String destination;
	
	@NotNull(message="Time Cannot be Empty")
	private LocalTime time;
	
	@NotNull(message="Date Cannot be Empty")
	private LocalDate date;
	
	@NotEmpty(message="Comfort Cannot be Empty")
	private String comfort;
	
	@Min(value=1,message="adult can be at least 1")
	@Max(value=4,message="adult can be at most 4")
	private int adult;
	
	@Max(value=3,message="children can be at most 3")
	private int  children;
	
	
	@NotEmpty(message="message Cannot be Empty")
	@Size(min=2,max=500,message="Invalid message length")
	@NotBlank(message="message cant be blank")
	private String message;
	
	
}
