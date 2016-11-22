package edu.mum.ea.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mum.ea.entity.Request;
import edu.mum.ea.service.RequestService;

@Controller
@RequestMapping("/request/rest")
public class RequestRestController {
	
	@Autowired
	private RequestService requestService;
	
	@RequestMapping("/{id}")
	public @ResponseBody List<Request> findRequestByUsername(@PathVariable Integer id) {
		List<Request> listRequestOfUser = requestService.listRequestOfUser(id);
		for (Request r : listRequestOfUser) {
			r.setCustomer(null);
		}
		return listRequestOfUser;
		
	}
	
}
