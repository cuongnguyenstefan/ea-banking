package edu.mum.ea.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.ea.entity.Customer;
import edu.mum.ea.entity.RequestAccount;
import edu.mum.ea.entity.User;
import edu.mum.ea.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	

	@RequestMapping(value={"/","/list"},method=RequestMethod.GET)
	public String listCustomer(){
		
		return "customerList";
	}
	@RequestMapping(value="/list")
	public String editCustomer(@RequestParam("firstName") String accountNumber, Model model) {
		model.addAttribute("customer", customerService.findByAccount(accountNumber));
			return "customer/edit";
	}
	
	@RequestMapping(value="/edit" , method= RequestMethod.POST)
	public String saveEditedCustomer(@Valid @ModelAttribute("customer") Customer customerEdited, BindingResult result, 
			RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			return "editCustomer";
		}
		customerService.save(customerEdited);
			redirectAttributes.addFlashAttribute("customer",customerEdited);
			redirectAttributes.addFlashAttribute("saved", true);
			return "customerList";	
			}
}
