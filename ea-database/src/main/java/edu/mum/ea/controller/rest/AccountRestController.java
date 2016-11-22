package edu.mum.ea.controller.rest;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mum.ea.entity.Account;

@Controller
@RequestMapping("/account/rest")
public class AccountRestController {

	// /account/rest/{id} -> "" return account object 
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Account get(@PathVariable Integer id) {
		System.out.println(id);
		return null;
	}
}
