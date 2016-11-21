package edu.mum.ea.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

	@RequestMapping("/register")
	public String register() {
		return "User/register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPost(Map<String, String> register, Model model) {
		
		return "User/register";
	}

}
