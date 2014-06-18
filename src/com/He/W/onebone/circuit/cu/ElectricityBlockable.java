package com.He.W.onebone.circuit.cu;

import com.He.W.onebone.circuit.cu.component.*;

import android.content.Context;
import android.graphics.drawable.Drawable;

public interface ElectricityBlockable{
	public float getBlockingElectricty();
	public void addBlockElectricity(int value);
	public void setBlockElectricity(int value);
}
/*public abstract class ElectricityBlockable extends Component{

	private int blockElectricity;
	
	public ElectricityBlockable(Context ctx, Drawable drawable, float x, float y, float rotation, int blockElectricity, EnumComponentType type) {
		/*super(ctx, drawable, x, y, rotation, type);
		this.blockElectricity = blockElectricity;*
		this(ctx, drawable, x, y, rotation, blockElectricity, type, Integer.MAX_VALUE);
	}
	
	public ElectricityBlockable(Context ctx, int resId, float x, float y, float rotation, int blockElectricity, EnumComponentType type){
		/*super(ctx, resId, x, y, rotation, type);
		this.blockElectricity = blockElectricity;*
		this(ctx, ctx.getResources().getDrawable(resId), x, y, rotation, blockElectricity, type, Integer.MAX_VALUE);
	}
	
	public ElectricityBlockable(Context ctx, Drawable drawable, float x, float y, float rotation, int blockElectricity, EnumComponentType type, int maxElectricity){
		super(ctx, drawable, x, y, rotation, type, maxElectricity);
	}
	
	public float getBlockingElectricity(){
		return blockElectricity;
	}
	
	public ElectricityBlockable addBlockElectricity(int value){
		blockElectricity += value;
		return this;
	}
	
	public ElectricityBlockable setBlockElectricity(int value){
		blockElectricity = value;
		return this;
	}
}*/