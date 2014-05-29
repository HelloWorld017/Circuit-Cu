package com.He.W.onebone.circuit.cu.component;

import com.He.W.onebone.circuit.cu.*;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.widget.ImageView;

public class Resistor extends ElectricityBlockable{
	
	public Resistor(CircuitBoard board, float x, float y, int rotation, int blockElectricity){
		super(board.getContext(), R.drawable.resistor, x, y, rotation, blockElectricity); // TODO Insert image
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
	
	/*public static class number{
		public static final int BLACK = 0;
		public static final int BROWN = 1;
		public static final int RED = 2;
		public static final int ORANGE = 3;
		public static final int YELLOW = 4;
		public static final int GREEN = 5;
		public static final int BLUE = 6;
		public static final int PURPLE = 7;
		public static final int GRAY = 8;
		public static final int WHITE = 9;
	}*/
	
	public static enum number{
		BLACK, BROWN, RED, ORANGE, YELLOW, GREEN, BLUE, PURPLE, GRAY, WHITE
	}
	
	public void drawLine(int color, int lineId){ // TODO Inserting line which identifies the information of resister
		Canvas canvas = new Canvas();
		Paint paint = new Paint();
		
	}
	
	public int getErrorRange(){
		return errorRange;
	}

	@Override
	public void electricityReleased() {
		this.addBlockElectricity(1);
	}

	@Override
	public void electricityUnreleased() {
		this.addBlockElectricity(-1);
	}
	
	/*public Resister(MainActivity activity){
		resource = activity.getResources();
		img = resource.getDrawable(R.drawable.resister); // TODO Insert image!!
	}
	
	*/
}