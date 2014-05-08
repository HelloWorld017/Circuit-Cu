package com.He.W.onebone.circuit.cu.component;

import com.He.W.onebone.circuit.cu.*;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

abstract public class Component extends ImageView{
	private float x, y;
	private float rotation;
	
	public Component(Context context, Drawable drawable, float x, float y, float rotation){
		super(context);
		this.x = x;
		this.y = y;
		this.rotation = rotation;
		setImageDrawable(drawable);
		setX(x);
		setY(y);
		CircuitBoard.getInstance().getManager().addComponent(this);
	}
	
	public Component(Context context, int resourceId, float x, float y, int rotation){
		super(context);
		this.x = x;
		this.y = y;
		this.rotation = rotation;
		setImageResource(resourceId);
		setX(x);
		setY(y);
		CircuitBoard.getInstance().getManager().addComponent(this);
	}
	
	public void setFocus(boolean focus){ // TODO Showing focus status
		
	}
	
	public void setComponentDrawable(Drawable drawable){
		setImageDrawable(drawable);
	}
	
	public void setComponentVisibility(int visibility){
		setVisibility(visibility);
	}
	
	public ImageView getComponentImage(){
		return this;
	}
	
	public final float getX(){
		return x;
	}
	
	public final float getY(){
		return y;
	}
	
	public final float getRotation(){
		return rotation;
	}
	
	public void setRotation(float rotation){
		setRotation(rotation);
		this.rotation = rotation;
	}
	
	public final void moveTo(float x, float y){
		setX(x);
		setY(y);
		this.x = x;
		this.y = y;
	}
	
	abstract public void electricityReleased();
}
