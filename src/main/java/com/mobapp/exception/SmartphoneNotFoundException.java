package com.mobapp.exception;

public class SmartphoneNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -2859292084648724403L;
	
	public SmartphoneNotFoundException(int smartphoneId) {
		super("Smartphone with id: "+smartphoneId+" not found.");
	}

}
