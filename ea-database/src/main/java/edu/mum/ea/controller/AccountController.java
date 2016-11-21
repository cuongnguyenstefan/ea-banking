package edu.mum.ea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.ea.entity.Account;
import edu.mum.ea.entity.AccountChecking;
import edu.mum.ea.service.AccountService;

@Controller
public class AccountController {

	@Autowired
	private AccountService accountService;
<<<<<<< HEAD

	/*
	 * @RequestMapping( value= "/accountInfo", method = RequestMethod.GET)
	 * public String accountInformation(Model model) { return
	 * "Account/accountInfo"; }
	 */

	@RequestMapping(value = "/accountInfo", method = RequestMethod.GET)
	public String accountInformations(Model model) {
=======
	
	
	@RequestMapping( value= "/account", method = RequestMethod.GET)
	public String accountInformation(Model model, @RequestParam String accountId)
	{
>>>>>>> origin/master
		return "Account/accountInfo";
	}

	@RequestMapping(value = "/accountInfo", method = RequestMethod.POST)
	public String amountDeposit(/* AccountChecking accountChecking */Account account, Model model) {
		
		accountService.create(account);
		model.addAttribute("account", account);

		return "Account/newAccountInfo";
	}

	/*
	 * @RequestMapping( value= "/accountInfo", method = RequestMethod.POST)
	 * public String amountWithdraw( Account account , @PathVariable int
	 * accountId ) {
	 * 
	 * return "Hi"; }
	 */
}
