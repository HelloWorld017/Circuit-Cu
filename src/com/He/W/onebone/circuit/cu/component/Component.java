package com.He.W.onebone.circuit.cu.component;

import java.util.LinkedList;

import com.He.W.onebone.circuit.cu.*;
import com.He.W.onebone.circuit.cu.exception.OverElectricityException;
import com.He.W.onebone.circuit.cu.gamebase.EnumRotation;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

abstract public class Component{
	private int x, y;
	private float electrified;
	private boolean isFocused;
	private Drawable drawable;
	private Context ctxt;
	private EnumComponentType type;
	private CircuitBoard board;
	private BoardComponentManager manager;
	private LinkedList<Integer> connected;
	private LinkedList<Integer> ableConnecting;
	private float requireElec;
	
	protected int maxElectricity;
	
	public boolean closed = false;
	
	public static final String LIGHT_BULB = "COMPONENT_LIGHT_BULB";
	public static final String RESISTOR = "COMPONENT_RESISTOR";
	public static final String TRANSISTOR = "COMPONENT_TRANSISTOR";
	
	public Component(Context context, Drawable drawable, int x, int y, EnumRotation rotation, EnumComponentType type, float requireElec){
		this(context, drawable, x, y, rotation, type, Integer.MAX_VALUE, requireElec);
	}
	
	public Component(Context context, int resourceId, int x, int y, EnumRotation rotation, EnumComponentType type, float requireElec){
		this(context, context.getResources().getDrawable(resourceId), x, y, rotation, type, Integer.MAX_VALUE, requireElec);
	}
	
	public Component(Context context, Drawable drawable, int x, int y, EnumRotation rotation, EnumComponentType type, int maxElectricity, float requireElec){
		ctxt = context;
		this.x = x;
		this.y = y;
		this.setRotation(rotation);
		setImageDrawable(drawable);	
		this.type = type;
		this.ableConnecting = new LinkedList<Integer>();
		this.connected = new LinkedList<Integer>();
		this.board = CircuitBoard.getInstance();
		this.electrified = 0;
		this.manager = board.getManager();
		this.maxElectricity = maxElectricity;
		manager.addComponent(this);
	}
	public void setImageDrawable(Drawable d){
		drawable = d;
	}
	public float getRequireElectricity(){
		return this.requireElec;
	}
	
	public void addAbleConnecting(int id){
		ableConnecting.add(id);
	}
	
	public void removeAbleConnecting(int id){
		ableConnecting.remove(id);
	}
	
	public LinkedList<Integer> getAbleConnecting(){
		return ableConnecting;
	}
	
	public void close(){
		this.setComponentVisibility(View.GONE);
		this.closed = true;
	}
	
	public void setFocused(boolean focus){ // TODO Showing focus status
		if(focus){
			board.notifyComponentFocused(manager.getComponentId(this));
		}else{
			board.notifyComponentUnfocused();
		}
		isFocused = focus;
		switch(this.type){ // TODO list all of it!!
		case COMPONENT_RESISTOR:
			//((focus == true) ? this.setImageResource(R.drawable.resistor_focused) : this.setImageResource(R.drawable.resistor));
			if(focus){
				this.setImageResource(R.drawable.resistor_focused);
			}else{
				this.setImageResource(R.drawable.resistor);
			}
			break;
		case COMPONENT_TRANSISTOR:
			if(focus){
				this.setImageResource(R.drawable.transistor_focused);
			}else{
				this.setImageResource(R.drawable.transistor);
			}
			break;
		//case COMPONENT_LIGHT_BULB:
			/*if(this.electrified > 0){ // Check if it's light is on
				if(focus){
					this.setImageResource(R.drawable.glowing_light_bulb_focused);
				}else{
					this.setImageResource(R.drawable.glowing_light_bulb);
				}
			}else{
				if(focus){
					this.setImageResource(R.drawable.light_bulb_focused);
				}else{
					this.setImageResource(R.drawable.light_bulb);
				}
			}
			break;*/
			default:
				return;
		}
	}
	
	private void setImageResource(int resid) {
		// TODO Auto-generated method stub
		setImageDrawable(ctxt.getResources().getDrawable(resid));
		
	}

	public boolean isFocused(){
		return isFocused;
	}
	
	public void setComponentDrawable(Drawable drawable){
		setImageDrawable(drawable);
	}
	
	public void setComponentVisibility(int visibility){
		setComponentVisibility(visibility);
	}
	
	public Drawable getComponentImage(){
		return drawable;
	}
	
	public final float getX(){
		return x;
	}
	
	public final float getY(){
		return y;
	}
	
	public void setRotation(EnumRotation rotation){
		
	}
	
	
	public final void moveTo(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public final float getElectrified(){
		return electrified;
	}
	
	public final boolean setElectrified(float electrified) throws OverElectricityException{
		if(electrified < 0){
			return false;
		}
		float current = this.electrified;
		this.electrified = electrified;
		
		if(current > electrified){
			this.electricityUnreleased();
		}else{
			if(this.maxElectricity <= this.electrified){
				throw new OverElectricityException(this.electrified, this.maxElectricity);
			}
			this.electricityReleased();
		}
		return true;
	}
	
	public final boolean addElectrified(float amount) throws OverElectricityException{
		if(this.electrified - amount < 0 || amount == 0){
			return false;
		}
		this.electrified += amount;
		if(amount < 0){
			this.electricityUnreleased();
		}else{
			if(this.maxElectricity <= this.electrified){
				throw new OverElectricityException(this.electrified, this.maxElectricity);
			}
			this.electricityReleased();
		}
		return true;
	}
	
	public final boolean addConnectedComponent(int id){
		return this.connected.add(id);
	}
	
	public final boolean addConnectedComponent(Component component){
		return this.connected.add(CircuitBoard.getInstance().getManager().getComponentId(component));
	}
	
	public final int removeConnectedComponent(int id){
		return this.connected.remove(id);
	}
	
	public final int removeConnectedComponent(Component component){
		return this.connected.remove(CircuitBoard.getInstance().getManager().getComponentId(component));
	}
	
	public final LinkedList<Integer> getConnected(){
		return this.connected;
	}
	
	public static String getTypeId(){
		return null;
	}
	
	abstract public void electricityReleased();
	abstract public void electricityUnreleased();
}
