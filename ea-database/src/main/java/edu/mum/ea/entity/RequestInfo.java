package edu.mum.ea.entity;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;

import edu.mum.ea.entity.enumtype.RequestType;

@Entity
@DiscriminatorValue(value =  RequestType.Values.CHANGE_INFO)
public class RequestInfo extends Request{
	
	@ElementCollection
	private Map<String, String> infoChanges = new HashMap<String, String>();

	public Map<String, String> getInfoChanges() {
		return infoChanges;
	}

	public void setInfoChanges(Map<String, String> infoChanges) {
		this.infoChanges = infoChanges;
	}
	
}
