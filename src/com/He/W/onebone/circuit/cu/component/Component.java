package com.He.W.onebone.circuit.cu.component;

import java.util.LinkedList;

import com.He.W.onebone.circuit.cu.*;
import com.He.W.onebone.circuit.cu.exception.OverElectricityException;
import com.He.W.onebone.circuit.cu.gamebase.EnumRotation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.Toast;

abstract public class Component {

	private int x, y;
	private float electrified;
	private boolean isFocused;
	private Drawable drawable;
	private Context ctxt;
	private EnumRotation rot;
	private EnumComponentType type;
	private CircuitBoard board;
	private BoardComponentManager manager;
	private LinkedList<Integer> connected;
	private LinkedList<Integer> ableConnecting;
	private float requireElec;
	private boolean isElectricityFlowing = false;
	protected int maxElectricity;

	public boolean closed = false;

	public Component(Context context, int x, int y, EnumRotation rotation, EnumComponentType type, float requireElec) {
		this(context, x, y, rotation, type, Integer.MAX_VALUE, requireElec);
	}

	public Component(Context context, int x, int y, EnumRotation rotation, EnumComponentType type, int maxElectricity, float requireElec) {
		ctxt = context;
		this.x = x;
		this.y = y;
		this.setRotation(rotation);
		setImageDrawable(getDrawableByTypeAndRotAndFocused(type, rotation, false, false));
		this.type = type;
		this.ableConnecting = new LinkedList<Integer>();
		this.connected = new LinkedList<Integer>();
		this.board = CircuitBoard.getInstance();
		this.electrified = 0;
		this.manager = board.getManager();
		this.maxElectricity = maxElectricity;
		manager.addComponent(this);
	}

	public void setImageDrawable(Drawable d) {
		drawable = d;
	}

	public float getRequireElectricity() {
		return this.requireElec;
	}

	public void addAbleConnecting(int id) {
		ableConnecting.add(id);
	}

	public void removeAbleConnecting(int id) {
		ableConnecting.remove(id);
	}

	public LinkedList<Integer> getAbleConnecting() {
		return ableConnecting;
	}

	public void close() {
		this.setComponentVisibility(false);
		this.closed = true;
	}

	public void setFocused(boolean focus) { // TODO Showing focus status
	//	if(focus){
		//	board.notifyComponentFocused(manager.getComponentId(this));
	//	}else{
	//		board.notifyComponentUnfocused();
	//	} : notifyComponentFocused -> Component.setFocused -> notifyComponentFocused -> Component.setFocused ... : StackOverFlowException
		isFocused = focus;
	//	switch(this.type){ // TODO list all of it!!
	//	case COMPONENT_RESISTOR:
			// ((focus == true) ?
			// this.setImageResource(R.drawable.resistor_focused) :
			// this.setImageResource(R.drawable.resistor));
			//if(focus){
			//	this.setImageResource(R.drawable.resistor_focused);
		//	}else{
		//		this.setImageResource(R.drawable.resistor);
		//	}
		//	break;
		//case COMPONENT_TRANSISTOR:
	//		if(focus){
		//		this.setImageResource(R.drawable.transistor_focused);
		//	}else{
		//		this.setImageResource(R.drawable.transistor);
		//	}
		//	break;
		// case COMPONENT_LIGHT_BULB:
		/*
		 * if(this.electrified > 0){ // Check if it's light is on if(focus){
		 * this.setImageResource(R.drawable.glowing_light_bulb_focused); }else{
		 * this.setImageResource(R.drawable.glowing_light_bulb); } }else{
		 * if(focus){ this.setImageResource(R.drawable.light_bulb_focused);
		 * }else{ this.setImageResource(R.drawable.light_bulb); } } break;
		 */
		//default:
			//return;
		//}
		this.setComponentDrawable(getDrawableByTypeAndRotAndFocused(type, rot, focus, isElectricityFlowing));
		board.redraw();
	}

	protected void setImageResource(int resid) {
		// TODO Auto-generated method stub
		setImageDrawable(ctxt.getResources().getDrawable(resid));

	}

	public boolean isFocused() {
		return isFocused;
	}

	public Drawable getDrawableByTypeAndRotAndFocused(EnumComponentType type, EnumRotation rot, boolean isFocused, boolean isElectricity) {
		switch(type){
		case COMPONENT_GOLD_WIRE:return getRotatedWireDrawable(rot, true, isFocused, isElectricity);
		case COMPONENT_COPPER_WIRE:return getRotatedWireDrawable(rot, false, isFocused, isElectricity);
		case COMPONENT_RESISTOR:
		case COMPONENT_TRANSISTOR:return getRotatedDirectionDrawable(type, rot, isFocused, isElectricity);
		default:Log.d("ERROR", "Unsupported Component : " + type.toString());return null;
		}
	}

	public Drawable getDrawable(int resid) {
		return ctxt.getResources().getDrawable(resid);
	}

	public void setComponentDrawable(Drawable drawable) {
		setImageDrawable(drawable);
	}

	public void setComponentVisibility(boolean visibility) {
		if(visibility){
			this.setComponentDrawable(getDrawableByTypeAndRotAndFocused(type, rot, isFocused, isElectricityFlowing));
		}else{
			this.setComponentDrawable(getDrawable(R.drawable.alphares));
		}

		board.redraw();
	}

	public Drawable getComponentDrawable() {
		return drawable;
	}
	public Drawable getRotatedDirectionDrawable(EnumComponentType ect, EnumRotation r, boolean isFocused, boolean isElectricity){
		Matrix m = new Matrix();
		Bitmap bit = null;
		switch(ect){
			case COMPONENT_TRANSISTOR:if(isElectricity){bit = BitmapFactory.decodeResource(ctxt.getResources(), R.drawable.transistor_released);}else if(isFocused){bit = BitmapFactory.decodeResource(ctxt.getResources(), R.drawable.transistor_focused);}else{bit = BitmapFactory.decodeResource(ctxt.getResources(), R.drawable.transistor)	;}
			case COMPONENT_RESISTOR:if(isElectricity){bit = BitmapFactory.decodeResource(ctxt.getResources(), R.drawable.resistor_released);}else if(isFocused){bit = BitmapFactory.decodeResource(ctxt.getResources(), R.drawable.resistor_focused);}else{bit = BitmapFactory.decodeResource(ctxt.getResources(), R.drawable.resistor);}
			default:Log.d("Error", "Unsupported ComponentType! at Component.java 168");
		}
		try{
			switch(r){
				case ROTATE_TOP_BOTTOM:m.setRotate(90, (float) bit.getWidth(), (float) bit.getHeight());
				case SP_ROTATE_RIGHT_LEFT:m.setRotate(180, (float) bit.getWidth(), (float) bit.getHeight());
				case SP_ROTATE_BOTTOM_TOP:m.setRotate(270, (float) bit.getWidth(), (float) bit.getHeight());
				case ROTATE_LEFT_RIGHT:break;
				default:Log.d("Error","Unsupported Rotation! at Component.java 177");break;
			}
		}catch(OutOfMemoryError e){
			Toast.makeText(ctxt, "Too low memory to play this game! Sorry for inconvenience!", Toast.LENGTH_LONG).show();
			System.exit(1);
		}catch(NullPointerException e){
			Log.d("ERROR", StackTraceToString.convert(e));
		}
		return new BitmapDrawable(ctxt.getResources(), Bitmap.createBitmap(bit, 0, 0, bit.getWidth(), bit.getHeight(), m, false));
		
	}
	public Drawable getRotatedWireDrawable(EnumRotation r, boolean isGold, boolean isFocused, boolean isElectricity) {

		Matrix m = new Matrix();
		Bitmap bit = null;
		switch(r){
		case ROTATE_BOTTOM_LEFT:
		case ROTATE_BOTTOM_RIGHT:
		case ROTATE_TOP_LEFT:
		case ROTATE_TOP_RIGHT:bit = BitmapFactory.decodeResource(ctxt.getResources(), getWireResid(true, isGold, isFocused, isElectricity));break;
		case ROTATE_LEFT_RIGHT:
		case ROTATE_TOP_BOTTOM:bit = BitmapFactory.decodeResource(ctxt.getResources(), getWireResid(false, isGold, isFocused, isElectricity));break;
		default:Log.d("Error","Unsupported Rotation! at Component.java 184");break;
		}
		try{
			switch(r){
			case ROTATE_BOTTOM_LEFT:break;
			case ROTATE_BOTTOM_RIGHT:m.setRotate(270,(float) bit.getWidth() / 2, (float) bit.getHeight() / 2);break;
			case ROTATE_TOP_RIGHT:m.setRotate(180, (float) bit.getWidth() / 2, (float) bit.getHeight() / 2);break;
			case ROTATE_TOP_LEFT:
			case ROTATE_TOP_BOTTOM:m.setRotate(90, (float) bit.getWidth() / 2, (float) bit.getHeight() / 2);break;
			case ROTATE_LEFT_RIGHT:break;
			default:Log.d("Error","Unsupported Rotation! at Component.java 194");break;
			
			}

		}catch(OutOfMemoryError e){
			Toast.makeText(ctxt, "Too low memory to play this game! Sorry for incovenience!", Toast.LENGTH_LONG).show();
			System.exit(1);
		}catch(NullPointerException e){
			Log.d("ERROR", StackTraceToString.convert(e));
			System.exit(1);
		}
		return new BitmapDrawable(ctxt.getResources(),Bitmap.createBitmap(bit, 0, 0, bit.getWidth(), bit.getHeight(), m, false));

	}
	public int getWireResid(boolean isCurved, boolean isGold, boolean isFocused, boolean isElectricityFlowing){
		if(isCurved){
			if(isElectricityFlowing){
				return R.drawable.wire_curve_released;
			}else{
				if(isFocused){
					return R.drawable.wire_curve_focused;
				}else{
					if(isGold){
						return R.drawable.gold_wire_curve;
					}else{
						return R.drawable.wire_curve;
					}
				}
			}
		}else{
			if(isElectricityFlowing){
				return R.drawable.wire_released;
			}else{
				if(isFocused){
					return R.drawable.wire_focused;
				}else{
					if(isGold){
						return R.drawable.gold_wire;
					}else{
						return R.drawable.wire;
					}
				}
			}
		}
	}

	public final int getX() {
		return x;
	}

	public final int getY() {
		return y;
	}

	public void setRotation(EnumRotation rotation) {
		rot = rotation;
		this.setComponentDrawable(getDrawableByTypeAndRotAndFocused(type, rotation, isFocused, isElectricityFlowing));
	}

	public final void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
		board.redraw();
	}

	public final float getElectrified() {
		return electrified;
	}

	public final boolean setElectrified(float electrified) throws OverElectricityException {
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

	public final boolean addElectrified(float amount) throws OverElectricityException {
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

	public final boolean addConnectedComponent(int id) {
		return this.connected.add(id);
	}

	public final boolean addConnectedComponent(Component component) {
		return this.connected.add(CircuitBoard.getInstance().getManager().getComponentId(component));
	}

	public final int removeConnectedComponent(int id) {
		return this.connected.remove(id);
	}

	public final int removeConnectedComponent(Component component) {
		return this.connected.remove(CircuitBoard.getInstance().getManager().getComponentId(component));
	}

	public final LinkedList<Integer> getConnected() {
		return this.connected;
	}
	public EnumRotation getRotation(){
		return rot;
	}

	public static EnumComponentType getTypeId() {
		return null;
	}
	public void setElectricityFlowing(boolean isFlowing){
		isElectricityFlowing = isFlowing;
		this.setComponentDrawable(getDrawableByTypeAndRotAndFocused(type, rot, isFocused, isFlowing));
		board.redraw();
	}

	abstract public void electricityReleased();

	abstract public void electricityUnreleased();
}
