package edu.mum.ea.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mum.ea.entity.Account;
import edu.mum.ea.entity.Customer;
import edu.mum.ea.service.impl.CustomerServiceImpl;

@Controller
@RequestMapping("/customer/rest")
public class CustomerRestController {
	
	@Autowired CustomerServiceImpl customerService;
	@RequestMapping(value = {"/" , ""} , method = RequestMethod.GET)
	
	public @ResponseBody Customer get()
	{
		Customer customer = getCustomer();
		customer.setRoles(null);
		customer.setAccount(null);
		
		
		
		return  customer ;
	}
	
	private Customer getCustomer() {
		// Authentication auth =
		// SecurityContextHolder.getContext().getAuthentication();
		// UserDetails userDetail = (UserDetails) auth.getPrincipal();
		// String username = userDetail.getUsername();
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Integer id = Integer.parseInt(user.getUsername());
		Customer customer = customerService.findById(id);
		return customer;
	}

	
}
