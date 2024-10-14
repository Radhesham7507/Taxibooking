package com.Taxi.TaxiBooking.Controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Taxi.TaxiBooking.model.BookingForm;
import com.Taxi.TaxiBooking.model.ContactForm;
import com.Taxi.TaxiBooking.model.ServiceForm;
import com.Taxi.TaxiBooking.service.BookingFormService;
import com.Taxi.TaxiBooking.service.ContactFormService;
import com.Taxi.TaxiBooking.service.ServiceFormService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
public class MyController {
	
	
	private ContactFormService contactFormService;
	
	private BookingFormService bookingFormService;
	
	private ServiceFormService serviceFormService;
	
	
	@Autowired
	public void setServiceFormService(ServiceFormService serviceFormService) {
		this.serviceFormService = serviceFormService;
	}

	@Autowired
	public void setBookingFormService(BookingFormService bookingFormService) {
		this.bookingFormService = bookingFormService;
	}

	@Autowired
	public void setContactFormService(ContactFormService contactFormService) {
		this.contactFormService = contactFormService;
	}

	@GetMapping(path= {"/","home","index"})
	public String welcomeView(HttpServletRequest req,Model m)
	{
		String requestURI=req.getRequestURI();
		m.addAttribute("mycurrentpage",requestURI);
		m.addAttribute("bookingForm",new BookingForm());
		return "index";
	}
	
	@GetMapping("about")
	public String aboutView(HttpServletRequest req,Model m)
	{
		String requestURI=req.getRequestURI();
		m.addAttribute("mycurrentpage",requestURI);
		return "about";
	}
	
	@GetMapping("cars")
	public String carsView(HttpServletRequest req,Model m)
	{String requestURI=req.getRequestURI();
	m.addAttribute("mycurrentpage",requestURI);
		return "cars";
	}
	
	@GetMapping("service")
	public String serviceView(HttpServletRequest req,Model m)
	{
		String requestURI=req.getRequestURI();
		m.addAttribute("mycurrentpage",requestURI);
		List<ServiceForm> services = serviceFormService.getAllServices();
        m.addAttribute("services", services);
		return "service";
	}
	
	 
	
	
	
	
	
	
	@GetMapping("contacts")
	public String contactsView(HttpServletRequest req,Model m)
	{
		String requestURI=req.getRequestURI();
		m.addAttribute("mycurrentpage",requestURI);
		m.addAttribute("contactForm",new ContactForm());		
		return "contacts";
	}
	
	
	@PostMapping("contactform")
	public String contactForm(@Valid @ModelAttribute ContactForm contactForm,BindingResult bindingResult 
			,RedirectAttributes redirectAttributes ,Model m)
	{
		if(bindingResult.hasErrors())
		{
			m.addAttribute("bindingResult",bindingResult);
			return "contacts";
		}
       ContactForm saveContactFormService=contactFormService.saveContactFormService(contactForm);
    if(saveContactFormService!=null)
    {
    	redirectAttributes.addFlashAttribute("message","Message Send Successfully!");
    	
    }else
    {
    	redirectAttributes.addFlashAttribute("message","Something Went Wrong!"); 	
    }
  
		return "redirect:/contacts";
	}
	
	
	
	@PostMapping("bookingform")
	public String bookingForm(@Valid @ModelAttribute BookingForm bookingForm,BindingResult bindingResult 
			,RedirectAttributes redirectAttributes ,Model m)
	{
		if(bindingResult.hasErrors())
		{
			m.addAttribute("bindingResult",bindingResult);  
			return "index";
		}else if(bookingForm.getAdult()+bookingForm.getChildren()>4)
		{
			m.addAttribute("message"," The Toatal number of adult and children is exceed 4");
			return "index";
		}
      

	 BookingForm saveBookingFormService=bookingFormService.saveBookingFormService(bookingForm);
    
	 if(saveBookingFormService!=null)
	    {
	    	redirectAttributes.addFlashAttribute("message","Booking Send Successfully!");
	    	
	    }else
	    {
	    	redirectAttributes.addFlashAttribute("message","Something Went Wrong!"); 	
	    }
	 
		return "redirect:/index";
	}

	
	
}
