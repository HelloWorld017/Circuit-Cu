package com.He.W.onebone.circuit.cu.obstacle;

import com.He.W.onebone.circuit.cu.ElectricityBlockable;

public class BreakableObstacle{
	private int gotElectricity;
	private int max;
	private boolean broken;
	
	public BreakableObstacle(int max){
		this.max = max;
		this.broken = false;
		gotElectricity = 0;
	}
	
	public boolean addGotElectricity(int amount){
		if(amount <= 0 || this.broken){
			return false;
		}
		gotElectricity += amount;
		if(gotElectricity > max){
			this.broken = true;
		}
		return true;
	}
	
	public int getGotElectricity(){
		return gotElectricity;
	}
}