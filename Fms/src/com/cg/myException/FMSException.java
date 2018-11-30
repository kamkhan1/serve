package com.cg.myException;

public class FMSException extends Exception{
	String message;

	public FMSException(String message) {
		super(message);
		this.message = message;
	}
	
	

}
