package com.He.W.onebone.circuit.cu.exception;

public class OverElectricityException extends Exception{
	private static final long serialVersionUID = 1L;	
	
	private float curElec, maxElec;
	
	public OverElectricityException(float curElec, float maxElec){
		this.curElec = curElec;
		this.maxElec = maxElec;
	}
	
	public float getCurrentElectricity(){
		return curElec;
	}
	
	public float getMaxElectricity(){
		return maxElec;
	}
}