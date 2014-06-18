package com.He.W.onebone.circuit.cu.component;

import com.He.W.onebone.circuit.cu.*;

public class LightBulb extends Component implements ElectricityBlockable{
	
	private float blockElectricity;

	public LightBulb(CircuitBoard board, float x, float y, int rotation, int blockElectricity) {
		this(board, x, y, rotation, blockElectricity, 20);
	}
	
	public LightBulb(CircuitBoard board, float x, float y, int rotation, int blockElectricity, int requireElec) {
		super(board.getContext(), R.drawable.light_bulb, x, y, rotation, EnumComponentType.COMPONENT_LIGHT_BULB, requireElec);
	}

	@Override
	public synchronized void electricityReleased() {
		this.setImageResource(R.drawable.glowing_light_bulb);
		this.addBlockElectricity(1);
	}

	@Override
	public synchronized void electricityUnreleased() {
		this.setImageResource(R.drawable.light_bulb);
	}

	@Override
	public float getBlockingElectricty() {
		return blockElectricity;
	}

	@Override
	public void addBlockElectricity(int value) {
		this.blockElectricity += value;
	}

	@Override
	public void setBlockElectricity(int value) {
		this.blockElectricity = value;
	}
	
}