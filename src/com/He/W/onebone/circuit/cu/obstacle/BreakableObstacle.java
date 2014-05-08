package com.He.W.onebone.circuit.cu.obstacle;

public class BreakableObstacle {
	private int gotElectricity;
	
	public BreakableObstacle(){
		gotElectricity = 0;
	}
	
	public boolean addGotElectricity(int amount){
		if(amount <= 0){
			return false;
		}
		gotElectricity += amount;
		return true;
	}
	
	public int getGotElectricity(){
		return gotElectricity;
	}
}