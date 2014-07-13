package com.He.W.onebone.circuit.cu.component;

import com.He.W.onebone.circuit.cu.*;
import com.He.W.onebone.circuit.cu.gamebase.EnumRotation;

public class LightBulb extends Component implements ElectricityBlockable{
	
	private float blockElectricity;

	public LightBulb(CircuitBoard board, int x, int y, EnumRotation rotation, int blockElectricity) {
		this(board, x, y, rotation, blockElectricity, 40, 50);
	}
	
	public LightBulb(CircuitBoard board, int x, int y, EnumRotation rotation, int blockElectricity, int requireElec, int maxElectricity) {
		super(board.getContext(), x, y, rotation, EnumComponentType.COMPONENT_LIGHT_BULB, requireElec, maxElectricity);
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
	
	public static EnumComponentType getTypeId(){
		return EnumComponentType.COMPONENT_LIGHT_BULB;
	}
	
}