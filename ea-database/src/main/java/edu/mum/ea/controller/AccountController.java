package edu.mum.ea.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.ea.entity.Account;
import edu.mum.ea.entity.Customer;
import edu.mum.ea.service.AccountService;
import edu.mum.ea.service.CustomerService;

@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String accountInformation(@Valid Model model, @RequestParam String accountId) {

		Customer customer = getCustomer();
		int id = Integer.parseInt(accountId);
		List<Account> accounts = customer.getAccount();
		for (Account account : accounts) {
			if (account.getId() == id) {

				model.addAttribute("account", account);

				return "Account/accountInfo";
			}
		}
		return "/";

	}

	@RequestMapping(value = "/deposit", method = RequestMethod.POST)
	public String amountDeposit(@Valid Model model, @RequestParam Integer accountId, @RequestParam String amount) {

		Customer customer = getCustomer();
		double parseDouble = Double.parseDouble(amount);

		List<Account> accounts = customer.getAccount();
		for (Account account : accounts) {
			if (account.getId() == accountId) {
				accountService.deposit(accountId, parseDouble);
				return "redirect:/customer";
			}
		}
		return "/";
	}

	@RequestMapping(value = "/withdraw", method = RequestMethod.POST)
	public String amountWithdraw(@Valid Model model, @RequestParam Integer accountId, @RequestParam String amount) {

		Customer customer = getCustomer();
		double ammountWithdraw = Double.parseDouble(amount);

		List<Account> accounts = customer.getAccount();

		for (Account account : accounts) {
			if (account.getId() == accountId) {
				accountService.withdraw(accountId, ammountWithdraw);
				return "redirect:/customer";
			}

		}
		return "/";

	}

	private Customer getCustomer() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		String username = userDetail.getUsername();
		Integer id = Integer.parseInt(username);
		Customer customer = customerService.findById(id);
		return customer;
	}

}
