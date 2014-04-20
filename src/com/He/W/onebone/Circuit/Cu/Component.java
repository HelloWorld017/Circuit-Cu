package com.He.W.onebone.circuit.cu;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class Component extends Focusable{
	private ImageView img;
	private float x, y;
	
	public Component(ImageView img, int x, int y, int locationId){
		this.x = x;
		this.y = y;
		this.img = img;
	}
	
	public void setComponentImage(ImageView img){
		this.img = img;
	}
	
	public void setComponentDrawable(Drawable drawable){
		this.img.setImageDrawable(drawable);
	}
	
	public ImageView getComponentImage(){
		return this.img;
	}
	
	public void setComponentVisibility(int visibility){
		img.setVisibility(visibility);
	}
	
	public float getX(){
		return x;
	}
	
	public float getY(){
		return y;
	}
	
	public void moveTo(float x, float y){
		this.img.setX(x);
		this.img.setY(y);
		this.x = x;
		this.y = y;
	}
}
