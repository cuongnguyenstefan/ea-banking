package edu.mum.ea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import edu.mum.ea.service.AccountService;

@Controller
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	
	

}
