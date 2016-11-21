package edu.mum.ea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.ea.entity.Account;
import edu.mum.ea.service.AccountService;

@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String accountInformation(Model model, @RequestParam String accountId) {
		int id = Integer.parseInt(accountId);
		Account account = accountService.get(id);
		model.addAttribute("account", account);

		return "Account/accountInfo";
	}

	@RequestMapping(value = "/deposit", method = RequestMethod.POST)
	public String amountDeposit(Model model, @RequestParam Integer accountId, @RequestParam String amount) {
		double parseDouble = Double.parseDouble(amount);
		accountService.deposit(accountId, parseDouble);

		return "redirect:/customer";
	}

	@RequestMapping(value = "/withdraw", method = RequestMethod.POST)
	public String amountWithdraw(Model model, @RequestParam Integer accountId, @RequestParam String amount) {
		double ammountWithdraw = Double.parseDouble(amount);

		accountService.withdraw(accountId, ammountWithdraw);
		return "redirect:/customer";

	}

}
