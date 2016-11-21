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
import edu.mum.ea.entity.UserRoles;
import edu.mum.ea.entity.enumtype.Role;
import edu.mum.ea.service.CustomerService;
import edu.mum.ea.service.UserRolesService;

@Controller
public class UserController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private UserRolesService userRolesService;

	@RequestMapping("/login")
	public String login(@Valid @RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model,
			@ModelAttribute("newly") Customer customer) {
		if (error != null) {
			model.addAttribute("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addAttribute("msg", "You've been logged out successfully.");
		}
		if (customer != null && customer.getUsername() != null) {
			model.addAttribute("error", "your username is: " + customer.getUsername());
		}
		return "User/login";
	}

	@RequestMapping(value = "/register")
	public String customerRequest(@ModelAttribute Customer customer) {
		return "User/register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String addCustomer(@Valid @ModelAttribute Customer customer, BindingResult result,
			RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			result.getAllErrors();
			return "User/register";
		}
		Customer save = customerService.save(customer);
		
		//set role
		UserRoles roles = new UserRoles();
		roles.setRole(Role.ROLE_USER);
		roles.setUser(save);
		userRolesService.save(roles);
		
		//redirect
		redirectAttributes.addFlashAttribute("newly", save);
		return "redirect:/login";
	}
}
