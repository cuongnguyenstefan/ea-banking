package edu.mum.ea.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.ea.entity.Request;
import edu.mum.ea.entity.RequestAccount;
import edu.mum.ea.entity.RequestInfo;
import edu.mum.ea.entity.Staff;
import edu.mum.ea.entity.enumtype.Role;
import edu.mum.ea.service.RequestService;
import edu.mum.ea.service.StaffService;

@Controller
@RequestMapping("/staff")
public class StaffController {

	@Autowired
	private StaffService staffService;
	
	@Autowired
	private RequestService requestService;

	@RequestMapping(value = { "", "/" })
	public String staffHome(Model model, HttpServletRequest request) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		String username = userDetail.getUsername();
		Integer id = Integer.parseInt(username);
		Staff staff = staffService.getStaff(id);
		model.addAttribute("staff", staff);
		
		//list request
		List<Request> listActiveRequest = requestService.listActiveRequest();
		List<RequestAccount> ra = new ArrayList<RequestAccount>();
		List<RequestInfo> ri = new ArrayList<RequestInfo>();
		for (Request r : listActiveRequest) {
			if (r instanceof RequestAccount) {
				ra.add((RequestAccount)r);
			} else {
				ri.add((RequestInfo)r);
			}
		}
		model.addAttribute("accountRequests", ra);
		model.addAttribute("infoRequests", ri);
		
		return "Staff/staff";
	}

}
