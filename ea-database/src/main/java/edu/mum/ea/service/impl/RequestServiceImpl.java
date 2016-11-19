package edu.mum.ea.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.ea.entity.Request;
import edu.mum.ea.entity.enumtype.RequestStatus;
import edu.mum.ea.repo.RequestRepository;
import edu.mum.ea.service.RequestService;

@Service
@Transactional
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
		return waitingList;
	}

	@Override
	public List<Request> listRequestOfUser(Integer username) {
		List<Request> findByCustomerUsername = requestRepository.findByCustomerUsername(username);
		return findByCustomerUsername;
	}

	@Override
	public Request get(Integer id) {
		return requestRepository.findOne(id);
	}

}
