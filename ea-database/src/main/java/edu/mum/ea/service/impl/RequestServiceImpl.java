package edu.mum.ea.service.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.ea.entity.Request;
import edu.mum.ea.entity.enumtype.RequestStatus;
import edu.mum.ea.repo.RequestRepository;
import edu.mum.ea.service.RequestService;

@Service
//@Transactional(dontRollbackOn=Exception.class)
public class RequestServiceImpl implements RequestService {
	
	@Autowired
	private RequestRepository requestRepository;

	@Override
	public boolean saveOrUpdate(Request request) {
		try {
			requestRepository.save(request);
			return true;
		} catch (Exception e) {
			System.out.println("Can not save request " + e);
		}
		return false;
	}

	@Override
	public List<Request> listActiveRequest() {
		List<Request> waitingList = requestRepository.findByRequestStatusOrderByCreatedOnDesc(RequestStatus.WAITING);
		List<Request> processingList = requestRepository.findByRequestStatusOrderByCreatedOnDesc(RequestStatus.PROCESSING);
		waitingList.addAll(processingList);
		for (Request r : waitingList) {
			Hibernate.initialize(r.getCustomer());
		}
		return waitingList;
	}

	@Override
	public List<Request> listRequestOfUser(Integer username) {
		List<Request> findByCustomerUsername = requestRepository.findByCustomerUsername(username);
		return findByCustomerUsername;
	}

	@Override
	public Request get(Integer id) {
		Request findOne = requestRepository.findOne(id);
		Hibernate.initialize(findOne.getCustomer());
		return findOne;
	}

}
