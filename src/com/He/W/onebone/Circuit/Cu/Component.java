package com.He.W.onebone.circuit.cu;

//import android.content.res.Resources;
import android.widget.ImageView;

public class Component extends Focusable{
	private ImageView img;
	private float x, y;
	//private Resources resource;
	
	public Component(ImageView img, int x, int y, int locationId){
		this.x = x;
		this.y = y;
		this.img = img;
		//this.resource = activity.getResources();
	}
	
	/*public Component(MainActivity activity, int imageResourceId, int x, int y, int locationId){
		this.activity = activity;
		this.x = x;
		this.y = y;
		this.resource = activity.getResources();
		this.img = resource.getDrawable(imageResourceId).;
	}*/
	
	public void setComponentImage(ImageView img){
		this.img = img;
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
