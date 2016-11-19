package edu.mum.ea.entity.enumtype;

public enum Role {
	ROLE_ADMIN("ROLE_ADMIN"), ROLE_USER("ROLE_USER");
	
	private String type;
	
	Role(String type) {
		this.type = type;
	}
	
	public String getValue() {
		return type;
	}
}
