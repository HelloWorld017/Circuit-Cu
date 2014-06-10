package com.He.W.onebone.circuit.cu.component;

import com.He.W.onebone.circuit.cu.*;

public class LightBulb extends ElectricityBlockable{

	public LightBulb(CircuitBoard board, float x, float y, int rotation, int blockElectricity) {
		super(board.getContext(), R.drawable.light_bulb, x, y, rotation, blockElectricity, EnumComponentType.COMPONENT_LIGHT_BULB);
	}

	@Override
	public void electricityReleased() {
		this.setImageResource(R.drawable.glowing_light_bulb);
		this.addBlockElectricity(1);
	}

	@Override
	public void electricityUnreleased() {
		this.setImageResource(R.drawable.light_bulb);
	}
	
}