package com.He.W.onebone.circuit.cu;

import com.He.W.onebone.circuit.cu.component.*;

import android.content.Context;
import android.graphics.drawable.Drawable;

public abstract class ElectricityBlockable extends Component{

	private float blockElectricity;
	
	public ElectricityBlockable(Context ctx, Drawable drawable, float x, float y, int rotation, float blockElectricity) {
		super(ctx, drawable, x, y, rotation);
		this.blockElectricity = blockElectricity;
	}
	
	public ElectricityBlockable(Context ctx, int resId, float x, float y, int rotation, int blockElectricity){
		super(ctx, resId, x, y, rotation);
		this.blockElectricity = blockElectricity;
	}
	
	public float getBlockingElectricity(){
		return blockElectricity;
	}
	
	public ElectricityBlockable addBlockElectricity(float value){
		blockElectricity += value;
		return this;
	}
	
	public ElectricityBlockable setBlockElectricity(float value){
		blockElectricity = value;
		return this;
	}
}