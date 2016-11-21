package edu.mum.ea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mum.ea.entity.Request;
import edu.mum.ea.service.RequestService;

@Controller
@RequestMapping("/request")
public class RequestController {
	
	@Autowired
	private RequestService requestService;
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public @ResponseBody HttpStatus create(Request request) {
		requestService.saveOrUpdate(request);
		return HttpStatus.ACCEPTED;
	}
	
}
