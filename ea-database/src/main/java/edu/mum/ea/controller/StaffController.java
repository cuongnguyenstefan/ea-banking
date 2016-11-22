package edu.mum.ea.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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

import edu.mum.ea.constant.BankingConstant;
import edu.mum.ea.entity.AccountChecking;
import edu.mum.ea.entity.AccountSaving;
import edu.mum.ea.entity.Customer;
import edu.mum.ea.entity.Request;
import edu.mum.ea.entity.RequestAccount;
import edu.mum.ea.entity.RequestInfo;
import edu.mum.ea.entity.Staff;
import edu.mum.ea.entity.StaffHistory;
import edu.mum.ea.entity.enumtype.AccountType;
import edu.mum.ea.entity.enumtype.RequestStatus;
import edu.mum.ea.entity.enumtype.RequestType;
import edu.mum.ea.service.AccountService;
import edu.mum.ea.service.CustomerService;
import edu.mum.ea.service.RequestService;
import edu.mum.ea.service.StaffHistoryService;
import edu.mum.ea.service.StaffService;

@Controller
@RequestMapping("/staff")
public class StaffController {

	@Autowired
	private StaffService staffService;

	@Autowired
	private RequestService requestService;

	@Autowired
	private AccountService accountService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private StaffHistoryService staffHistoryService;

	@RequestMapping(value = { "", "/" })
	public String staffHome(Model model, HttpServletRequest request) {
		Staff staff = getStaff();
		model.addAttribute("staff", staff);

		// list request
		List<Request> listActiveRequest = requestService.listActiveRequest();
		List<RequestAccount> ra = new ArrayList<RequestAccount>();
		List<RequestInfo> ri = new ArrayList<RequestInfo>();
		for (Request r : listActiveRequest) {
			if (r instanceof RequestAccount) {
				ra.add((RequestAccount) r);
			} else {
				ri.add((RequestInfo) r);
			}
		}
		model.addAttribute("accountRequests", ra);
		model.addAttribute("infoRequests", ri);

		return "Staff/staff";
	}

	@RequestMapping("/approval")
	public String approvalNewAccount(@Valid @RequestParam boolean a, @RequestParam String rId) {
		// request approving
		int parseInt = Integer.parseInt(rId);
		RequestAccount request = (RequestAccount) requestService.get(parseInt);

		// staff
		Staff staff = getStaff();
		StaffHistory history = new StaffHistory();

		Customer customer = request.getCustomer();
		if (a) {
			request.setRequestStatus(RequestStatus.APPROVED);
			AccountType accountType = request.getAccountType();
			switch (accountType) {
			case CHECKING:
				AccountChecking accountChecking = new AccountChecking();
				accountChecking.setAmount(0);
				accountChecking.setCustomer(customer);
				accountService.create(accountChecking);
				break;
			case SAVING:
				AccountSaving accountSaving = new AccountSaving();
				accountSaving.setAmount(0);
				accountSaving.setCustomer(customer);
				accountSaving.setInterest(BankingConstant.DEFAULT_INTEREST);
				accountService.create(accountSaving);
				break;
			}
			history.setAction("Created account on customer: " + customer.getUsername() + " - Request ID: "
					+ request.getRequestId());
		} else {
			request.setRequestStatus(RequestStatus.DISAPPROVED);
			history.setAction("Denied account request on customer: " + customer.getUsername() + " - Request ID: "
					+ request.getRequestId());
		}
		history.setApproved(a);
		history.setCreatedOn(new Date());
		history.setCustomer(customer);
		history.setStaff(staff);
		history.setRequestType(RequestType.REQUEST_ACCOUNT);
		staffHistoryService.save(history);

		return "redirect:/staff";
	}

	@RequestMapping(value = "/list")
	public String editCustomer(@Valid Model model) {
		List<Customer> findAll = customerService.findAll();
		model.addAttribute("customers", findAll);
		return "Staff/listOfCustomers";
	}

	@RequestMapping("/history")
	public String history(Model model) {
		Staff staff = getStaff();
		List<StaffHistory> findByStaffId = staffHistoryService.findByStaffId(staff.getUsername());
		model.addAttribute("histories", findByStaffId);
		model.addAttribute("staff", staff);
		return "Staff/history";
	}

	@RequestMapping("/updateUser")
	public String updatePage(@RequestParam String id, Model model) {
		try {
			Integer userName = Integer.parseInt(id);
			Customer customer = customerService.findById(userName);
			model.addAttribute("customer", customer);
			return "Staff/editcustomer";
		} catch (NumberFormatException e) {
			return "redirect:/staff";
		}
	}

	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public String updateUser(@ModelAttribute @Valid Customer customer, BindingResult result) {
		if (result.hasErrors()) {
			result.getAllErrors();
			return "Staff/editcustomer";
		}
		customerService.save(customer);
		return "redirect:/staff/list";
	}
	
	private Staff getStaff() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		String username = userDetail.getUsername();
		Integer id = Integer.parseInt(username);
		Staff staff = staffService.getStaff(id);
		return staff;
	}
}
