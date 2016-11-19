package edu.mum.ea.repo.base;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import edu.mum.ea.entity.Request;
import edu.mum.ea.entity.enumtype.RequestStatus;

@NoRepositoryBean
public interface RequestBaseRepository<T extends Request> extends CrudRepository<T, Integer> {
	
	public List<Request> findByRequestStatusOrderByCreatedOnDesc(RequestStatus requestStatus);
	
	public List<Request> findByCustomerUsername(Integer userId);

}
