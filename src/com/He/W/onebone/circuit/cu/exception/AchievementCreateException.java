package com.He.W.onebone.circuit.cu.exception;

public class AchievementCreateException extends Exception{

	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public AchievementCreateException(String message){
		this.message = message;
	}
	
	public AchievementCreateException(){
		this.message = "Failed to create achievement";
	}
	
	public String getMessage(){
		return message;
	}
	
	public String toString(){
		return message;
	}
}
