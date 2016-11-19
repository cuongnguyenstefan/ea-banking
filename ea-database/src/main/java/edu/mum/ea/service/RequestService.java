package edu.mum.ea.service;

import java.util.List;

import edu.mum.ea.entity.Request;

public interface RequestService {
	
	public boolean saveOrUpdate(Request request);
	
	public List<Request> listActiveRequest();
	
	public List<Request> listRequestOfUser(Integer username);
	
	public Request get(Integer id);
	
}
