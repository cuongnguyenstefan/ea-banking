package edu.mum.ea.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String add(Model model) {
		model.addAttribute("user", "ABC");
		return "welcome";
	}
}
