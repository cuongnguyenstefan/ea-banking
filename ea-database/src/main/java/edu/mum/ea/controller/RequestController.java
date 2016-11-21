package edu.mum.ea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.ea.entity.RequestAccount;
import edu.mum.ea.entity.User;
import edu.mum.ea.service.CustomerService;
import edu.mum.ea.service.RequestService;

@Controller
@RequestMapping("/request")
public class RequestController {
	/*@Autowired
	RequestService requestService;
	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value = { "/", "/requestForm" })
	public String customerRequest(@ModelAttribute RequestAccount requestAccount) {
		return "customerRequest";
	}

	@RequestMapping(value = "/addRequest", method = RequestMethod.POST)
	public String addCustomer(@ModelAttribute RequestAccount requestAccount, BindingResult result, RedirectAttributes redirectAttributes) {
		// model.addAttribute("user", user);
		// redirectAttributes.addFlashAttribute(requestAccount);
		if (result.hasErrors()) {
			return "customerRequest";
		}
		//requestAccount.getCustomer().setUsername(1234);
		customerService.save(requestAccount.getCustomer());
		requestService.saveOrUpdate(requestAccount);
		return "redirect:list";
	}
*/}
