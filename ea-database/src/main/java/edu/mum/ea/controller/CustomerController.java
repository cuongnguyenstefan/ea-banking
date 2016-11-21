package edu.mum.ea.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.ea.entity.Customer;
import edu.mum.ea.entity.RequestAccount;
import edu.mum.ea.entity.enumtype.AccountType;
import edu.mum.ea.entity.enumtype.RequestStatus;
import edu.mum.ea.service.CustomerService;
import edu.mum.ea.service.RequestService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@Autowired
	RequestService requestService;

	@RequestMapping(value = {"", "/"})
	public String listCustomer(@Valid Model model) {
		Customer customer = getCustomer();
		model.addAttribute("customer", customer);
		return "customer/customer";
	}
	@RequestMapping(value = "/choose")
	public String accountChoos() {
		return "customer/chooseAccount";
	}
	

	@RequestMapping(value="/request", method = RequestMethod.GET)
	public String requestAccount(@Valid @RequestParam String type) {
		Customer customer = getCustomer();
		RequestAccount requestAccount = new RequestAccount();
		requestAccount.setCreatedOn(new Date());
		requestAccount.setCustomer(customer);
		requestAccount.setRequestStatus(RequestStatus.WAITING);
		if ("saving".equals(type)) {
			requestAccount.setAccountType(AccountType.SAVING);
		} else if ("checking".equals(type)) {
			requestAccount.setAccountType(AccountType.CHECKING);
		}
		requestService.saveOrUpdate(requestAccount);
		return "redirect:/customer";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String saveEditedCustomer(@Valid @ModelAttribute("customer") Customer customerEdited, BindingResult result,
			RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "User/register";
		}
		customerService.save(customerEdited);
		redirectAttributes.addFlashAttribute("customer", customerEdited);
		redirectAttributes.addFlashAttribute("saved", true);
		return "customer/customer";
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
