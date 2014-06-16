package com.He.W.onebone.circuit.cu.exception;

public class LevelParseException extends Exception{
	private static final long serialVersionUID = 2997898579090794698L;
	public static final int NO_FILE = -2;
	public static final int WRONG_FILE = -1;
	public static final int UNKNOWN = 0;
	
	private int type;
	private String str;
	
	public LevelParseException(int type){
		this.type = type;
	}
	
	public LevelParseException(int type, String str){
		this.type = type;
		this.str = str;
	}
	
	public LevelParseException(String str){
		this.str = str;
	}
	
	public int getType(){
		return type;
	}
	
	public String toString(){
		return str;
	}
}
