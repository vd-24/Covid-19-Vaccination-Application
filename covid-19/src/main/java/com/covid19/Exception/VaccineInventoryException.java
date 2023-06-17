package com.covid19.Exception;




public class VaccineInventoryException extends RuntimeException{

	public VaccineInventoryException() {
		super();
		
	}

	public VaccineInventoryException(String message) {
		super(message);
		
	}

}