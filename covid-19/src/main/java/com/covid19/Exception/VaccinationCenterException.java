package com.covid19.Exception;

public class VaccinationCenterException extends RuntimeException {

	public VaccinationCenterException() {
		
	}
	
	public VaccinationCenterException(String msg) {
		
		super(msg);
	}
}