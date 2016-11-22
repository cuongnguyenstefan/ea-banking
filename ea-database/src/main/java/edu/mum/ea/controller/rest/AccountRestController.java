package edu.mum.ea.controller.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mum.ea.entity.Account;
import edu.mum.ea.entity.Customer;
import edu.mum.ea.service.CustomerService;
import edu.mum.ea.service.impl.AccountServiceImpl;

@Controller
@RequestMapping("/account/rest")
public class AccountRestController {

	@Autowired
	private AccountServiceImpl accountService;

	@Autowired
	private CustomerService customerService;

	// /account/rest/{id} -> "" return account object
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Account get(@PathVariable Integer id) {

		Customer customer = getCustomer();
		List<Account> accounts = customer.getAccount();

		for (Account account : accounts) {
			if (account.getId() == id) {
				account.setCustomer(null);
				return account;

			}

		}
		System.out.println(id);
		return null;
	}

	@RequestMapping(value = {"/", ""} , method = RequestMethod.GET)
	public @ResponseBody List<Account> get()
	{
		
		Customer customer = getCustomer();
		List<Account> accounts = customer.getAccount();

		for (Account account : accounts) {
			account.setCustomer(null);
			
		}

		return accounts;
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
