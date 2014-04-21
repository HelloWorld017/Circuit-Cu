package com.He.W.onebone.circuit.cu.component;

import com.He.W.onebone.circuit.cu.*;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class Component{
	private ImageView img;
	private float x, y;
	private int rotation;
	
	public Component(Context context, Drawable drawable, float x, float y, int rotation){
		this.x = x;
		this.y = y;
		this.rotation = rotation;
		this.img = new ImageView(context);
		this.img.setImageDrawable(drawable);
		this.img.setX(x);
		this.img.setY(y);
		CircuitBoard.getInstance().getManager().addComponent(this);
	}
	
	public Component(Context context, int resourceId, float x, float y, int rotation){
		this.x = x;
		this.y = y;
		this.rotation = rotation;
		this.img = new ImageView(context);
		this.img.setImageResource(resourceId);
		this.img.setX(x);
		this.img.setY(y);
		CircuitBoard.getInstance().getManager().addComponent(this);
	}
	
	public Component(ImageView img, float x, float y, int rotation){
		this.x = x;
		this.y = y;
		this.rotation = rotation;
		this.img = img;
		this.img.setX(x);
		this.img.setY(y);
		CircuitBoard.getInstance().getManager().addComponent(this);
	}
	
	public void setFocus(boolean focus){ // TODO Showing focus status
		
	}
	
	public void setComponentImage(ImageView img){
		this.img = img;
	}
	
	public void setComponentDrawable(Drawable drawable){
		this.img.setImageDrawable(drawable);
	}
	
	public final ImageView getComponentImage(){
		return this.img;
	}
	
	public void setComponentVisibility(int visibility){
		img.setVisibility(visibility);
	}
	
	public final float getX(){
		return x;
	}
	
	public final float getY(){
		return y;
	}
	
	public final int getRotation(){
		return rotation;
	}
	
	public final void moveTo(float x, float y){
		this.img.setX(x);
		this.img.setY(y);
		this.x = x;
		this.y = y;
	}
}
