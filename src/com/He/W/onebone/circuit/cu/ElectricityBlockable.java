package com.He.W.onebone.circuit.cu;

import com.He.W.onebone.circuit.cu.component.*;

import android.content.Context;
import android.graphics.drawable.Drawable;

public abstract class ElectricityBlockable extends Component{

	private int blockElectricity;
	
	public ElectricityBlockable(Context ctx, Drawable drawable, float x, float y, int rotation, int blockElectricity) {
		super(ctx, drawable, x, y, rotation);
		this.blockElectricity = blockElectricity;
	}
	
	public ElectricityBlockable(Context ctx, int resId, float x, float y, int rotation, int blockElectricity){
		super(ctx, resId, x, y, rotation);
		this.blockElectricity = blockElectricity;
	}
	
	public int getBlockingElectricity(){
		return blockElectricity;
	}
}