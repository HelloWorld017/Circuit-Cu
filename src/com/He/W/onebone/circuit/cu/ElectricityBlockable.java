package com.He.W.onebone.circuit.cu;

import com.He.W.onebone.circuit.cu.component.*;

import android.widget.ImageView;

public abstract class ElectricityBlockable extends Component{

	private int blockElectricity;
	
	public ElectricityBlockable(ImageView img, float x, float y, int rotation, int blockElectricity) {
		super(img, x, y, rotation);
		this.blockElectricity = blockElectricity;
	}
	
	public int getBlockingElectricity(){
		return blockElectricity;
	}
}