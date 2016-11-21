package edu.mum.ea.controller;

import java.util.Map;

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
import edu.mum.ea.service.CustomerService;
import edu.mum.ea.service.RequestService;

@Controller
public class UserController {

	@RequestMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {
		if (error != null) {
			model.addAttribute("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addAttribute("msg", "You've been logged out successfully.");
		}
		return "User/login";
	}

	/*@RequestMapping("/register")
	public String register() {
		return "User/register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPost(Map<String, String> register, Model model) {
		
		return "User/register";
	}
*/
	@Autowired
	RequestService requestService;
	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value = "/register" )
	public String customerRequest(@ModelAttribute Customer customer) {
		return "User/register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String addCustomer(@ModelAttribute Customer customer, BindingResult result, RedirectAttributes redirectAttributes) {
		// model.addAttribute("user", user);
	    redirectAttributes.addFlashAttribute(customer);
		if (result.hasErrors()) {
			return "User/register";
		}
		//requestAccount.getCustomer().setUsername(1234);
		customerService.save(customer);
		return "redirect:customer/list";
	}
	}
