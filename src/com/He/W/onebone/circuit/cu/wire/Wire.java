package com.He.W.onebone.circuit.cu.wire;

import com.He.W.onebone.circuit.cu.*;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class Wire {
	private ImageView img;
	private double blockage;
	private BoardComponentManager manager;
	
	public Wire(Context context, Drawable drawable, float x, float y, int rotation, double blockage){
		this.img = new ImageView(context);
		this.img.setX(x);
		this.img.setY(y);
		this.img.setRotation(rotation);
		this.img.setImageDrawable(drawable);
		this.blockage = blockage;
		this.manager = CircuitBoard.getInstance().getManager();
	}
	
	public double getBlockage(){
		return blockage;
	}
	
	public void releaseElectricity(){ // TODO Releasing electricity
		
	}
}