package com.mobapp.exception;

public class SmartphoneNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -2859292084648724403L;
	
	public SmartphoneNotFoundException(String smartphoneId) {
		super("Smartphone not found with id: "+smartphoneId);
	}

}
