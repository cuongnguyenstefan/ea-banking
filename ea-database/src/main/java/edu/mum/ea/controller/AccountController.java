package edu.mum.ea.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String accountInformation(@Valid Model model, @RequestParam String accountId, @ModelAttribute("error") String error) {

		Customer customer = getCustomer();
		int id = Integer.parseInt(accountId);
		List<Account> accounts = customer.getAccount();
		for (Account account : accounts) {
			if (account.getId() == id) {

				model.addAttribute("account", account);
				if (error != null && error != "") {
					model.addAttribute("error", error);
				}
				return "Account/accountInfo";
			}
		}
		return "/";

	}

	@RequestMapping(value = "/deposit", method = RequestMethod.POST)
	public String amountDeposit(@RequestParam Integer accountId, @RequestParam String amount, RedirectAttributes redirectAttributes) {

		Customer customer = getCustomer();
		try {
			double parseDouble = Double.parseDouble(amount);

			List<Account> accounts = customer.getAccount();
			for (Account account : accounts) {
				if (account.getId() == accountId) {
					accountService.deposit(accountId, parseDouble);
					return "redirect:/customer";
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", "Wrong input!");
		}
		
		return "redirect:/account?accountId="+accountId;
	}

	@RequestMapping(value = "/withdraw", method = RequestMethod.POST)
	public String amountWithdraw(@Valid Model model, @RequestParam Integer accountId, @RequestParam String amount, RedirectAttributes redirectAttributes) {

		Customer customer = getCustomer();
		double amountWithdraw = 0;
		try {
			amountWithdraw = Double.parseDouble(amount);
			List<Account> accounts = customer.getAccount();
			
			for (Account account : accounts) {
				if (account.getId() == accountId) {
					
					if(account.getAmount() >= amountWithdraw){
						accountService.withdraw(accountId, amountWithdraw);
						return "redirect:/customer";
					}	
					
					redirectAttributes.addFlashAttribute("error", "Actual Account is less than Withdraw amount.");
					break;
					
				}
				
			}
			
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", "Invalid input");
		}

		return "redirect:/account?accountId="+accountId;

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
