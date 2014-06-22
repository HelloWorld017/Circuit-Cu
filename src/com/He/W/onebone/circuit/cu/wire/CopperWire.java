package com.He.W.onebone.circuit.cu.wire;

import android.content.Context;
import android.graphics.drawable.Drawable;

public class CopperWire extends Wire{

	public CopperWire(Context context, Drawable drawable, float x, float y,
			int rotation) {
		super(context, drawable, x, y, rotation, 2);
	}

	@Override
	public void electricityReleased() {
		
	}
	
	public static String getTypeId(){
		return Wire.COPPER_WIRE;
	}
	
}