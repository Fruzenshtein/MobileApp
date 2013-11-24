package com.mobapp.exception;

public class SmartphoneNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -2859292084648724403L;
	private final int smartphoneId;
	
	public SmartphoneNotFoundException(int id) {
		smartphoneId = id;
	}
	
	public int getSmartphoneId() {
		return smartphoneId;
	}

}
