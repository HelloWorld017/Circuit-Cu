package com.He.W.onebone.circuit.cu.component;

import com.He.W.onebone.circuit.cu.*;

public class LightBulb extends ElectricityBlockable{

	public LightBulb(CircuitBoard board, float x, float y, int rotation, int blockElectricity) {
		super(board.getContext(), R.drawable.light_bulb, x, y, rotation, blockElectricity); // TODO Insert image 
	}

	@Override
	public void electricityReleased() {
		
	}
	
}
