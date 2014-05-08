package com.He.W.onebone.circuit.cu;

import com.He.W.onebone.circuit.cu.component.*;

import java.util.TreeMap;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

public class CircuitBoard extends ImageView{
	private static CircuitBoard obj;
	private BoardComponentManager manager;
	private int id = 0;
	private TreeMap<Integer, Component> componentList;
	
	private CircuitBoard(Context context) {
		super(context);
		obj = this;
		manager = new BoardComponentManager(this);
		setImageResource(R.drawable.circuit_board); // TODO Insert image!!
	}
	
	public CircuitBoard makeBoard(Context context){
		if(obj instanceof CircuitBoard){
			return null;
		}
		return new CircuitBoard(context);
	}
	
	public void destroyBoard(){
		obj = null;
	}
	
	public static CircuitBoard getInstance(){
		return obj;
	}
	
	public BoardComponentManager getManager(){
		return manager;
	}
	
	public void removeComponent(Component component){
		
	}
	
	public int putComponentTo(Component component, int locationId){ // TODO Insert component putting
		ImageView img = component.getComponentImage();
		img.setTag(id);
		img.setVisibility(View.VISIBLE);
		componentList.put(id, component);
		manager.addComponent(component);
		return id++;
	}
}