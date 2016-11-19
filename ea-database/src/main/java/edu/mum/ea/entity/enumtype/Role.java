package edu.mum.ea.entity.enumtype;

public enum Role {
	STAFF("STAFF"), CUSTOMER("CUSTOMER");
	
	private String type;
	
	Role(String type) {
		this.type = type;
	}
	
	public String getValue() {
		return type;
	}
}
