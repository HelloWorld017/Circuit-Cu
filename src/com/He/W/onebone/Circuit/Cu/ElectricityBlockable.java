package com.He.W.onebone.circuit.cu;

import com.He.W.onebone.circuit.cu.component.*;

import android.widget.ImageView;

public class ElectricityBlockable extends Component{

	private int blockElectricity, errorRange;
	
	public ElectricityBlockable(ImageView img, float x, float y, int rotation, int blockElectricity, int errorRange) {
		super(img, x, y, rotation);
		this.blockElectricity = blockElectricity;
		this.errorRange = errorRange;
	}
	
	public int getBlockingElectricity(){
		return blockElectricity;
	}
	
	public int getErrorRange(){
		return errorRange;
	}
}