package com.He.W.onebone.circuit.cu.component;

import com.He.W.onebone.circuit.cu.*;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.widget.ImageView;

public class Resistor extends Component implements ElectricityBlockable{
	
	private float blockElectricity;
	
	public Resistor(CircuitBoard board, float x, float y, int rotation, int blockElectricity){
		this(board, x, y, rotation, blockElectricity, 20);
		//this.blockElectricity = blockElectricity;
	}
	
	public Resistor(CircuitBoard board, float x, float y, int rotation, int blockElectricity, int require){
		super(board.getContext(), R.drawable.resistor, x, y, rotation, EnumComponentType.COMPONENT_RESISTOR, require);
		this.blockElectricity = blockElectricity;
	}
	
	private int errorRange;
	
	public static final String UNIT = "\u8486";
	
	public static class error{
		public static final float BLACK = 0;
		public static final float ORANGE = 0;
		public static final float YELLOW = 0;
		public static final float WHITE = 0;
		public static final float BROWN = 1;
		public static final float RED = 2;
		public static final float GREEN = 0.5F;
		public static final float BLUE = 0.25F;
		public static final float PURPLE = 0.1F;
		public static final float GRAY = 0.05F;
		public static final float GOLD = 5;
		public static final float SILVER = 10;
		public static final float NONE = 20;
	}
	
	public static enum number{
		BLACK, BROWN, RED, ORANGE, YELLOW, GREEN, BLUE, PURPLE, GRAY, WHITE
	}
	
	/*public void drawLine(int color, int lineId){ // TODO Inserting line which identifies the information of resister
		Canvas canvas = new Canvas();
		Paint paint = new Paint();
		
	}*/
	
	public int getErrorRange(){
		return errorRange;
	}

	@Override
	public synchronized void electricityReleased() {
		this.setImageResource(R.drawable.resistor_released);
		this.addBlockElectricity(1);
	}

	@Override
	public synchronized void electricityUnreleased() {
		if(this.getElectrified() <= 0){
			this.setImageResource(R.drawable.resistor);
		}
		this.addBlockElectricity(-1);
	}

	@Override
	public float getBlockingElectricty() {
		return blockElectricity;
	}

	@Override
	public void addBlockElectricity(int value) {
		blockElectricity += value;
	}

	@Override
	public void setBlockElectricity(int value) {
		blockElectricity = value;
	}
}