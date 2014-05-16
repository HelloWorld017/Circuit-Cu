package com.He.W.onebone.circuit.cu.component;

import com.He.W.onebone.circuit.cu.*;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

abstract public class Component extends ImageView{
	private float x, y;
	private float electrified;
	private boolean isFocused;
	private CircuitBoard board;
	private BoardComponentManager manager;
	
	public Component(Context context, Drawable drawable, float x, float y, float rotation){
		super(context);
		this.x = x;
		this.y = y;
		this.setRotation(rotation);
		setImageDrawable(drawable);
		setX(x);
		setY(y);
		this.board = CircuitBoard.getInstance();
		this.manager = board.getManager();
		manager.addComponent(this);
		
		this.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				setFocused(true);
			}
		});
	}
	
	public Component(Context context, int resourceId, float x, float y, int rotation){
		super(context);
		this.x = x;
		this.y = y;
		this.setRotation(rotation);
		setImageResource(resourceId);
		setX(x);
		setY(y);
		this.board = CircuitBoard.getInstance();
		this.manager = board.getManager();
		manager.addComponent(this);
	}
	
	public void setFocused(boolean focus){ // TODO Showing focus status
		if(focus){
			board.notifyComponentFocused(manager.getComponentId(this));
		}else{
			board.notifyComponentUnfocused();
		}
		
		isFocused = focus;
	}
	
	public boolean isFocused(){
		return isFocused;
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
	
	public void setRotation(float rotation){
		setRotation(rotation);
	}
	
	public final int getRotationId(){
		return (int)Math.ceil((getRotation() / 90));
	}
	
	public final void moveTo(float x, float y){
		setX(x);
		setY(y);
		this.x = x;
		this.y = y;
	}
	
	public final float getElectrified(){
		return electrified;
	}
	
	public final void setElectrified(float electrified){
		this.electrified = electrified;
	}
	
	public final void addElectrified(float amount){
		this.electrified += amount;
	}
	
	abstract public void electricityReleased();
}
