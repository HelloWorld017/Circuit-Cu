package com.He.W.onebone.circuit.cu.component;

import android.widget.ImageView;

import com.He.W.onebone.circuit.cu.*;

public class LightBulb extends ElectricityBlockable{

	public LightBulb(ImageView img, float x, float y, int rotation,
			int blockElectricity) {
		super(img, x, y, rotation, blockElectricity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void electricityReleased() {
		
	}
	
}
