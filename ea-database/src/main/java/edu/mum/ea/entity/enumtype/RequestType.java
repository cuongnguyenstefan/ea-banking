package edu.mum.ea.entity.enumtype;

public enum RequestType {
	
	CHANGE_INFO(Values.CHANGE_INFO), REQUEST_ACCOUNT(Values.CHANGE_INFO);
	
	private String type;
	
	RequestType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	public static class Values {
		public static final String CHANGE_INFO = "CHANGE_INFO";
		public static final String REQUEST_ACCOUNT = "REQUEST_ACCOUNT";
	}
}
