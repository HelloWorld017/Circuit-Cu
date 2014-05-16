package com.He.W.onebone.circuit.cu;

import com.He.W.onebone.circuit.cu.component.*;

import java.util.LinkedList;
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
	private TreeMap<Integer, LinkedList<Integer>> connectedComponent;
	
	private CircuitBoard(Context context) {
		super(context);
		obj = this;
		manager = new BoardComponentManager(this);
		componentList = new TreeMap<Integer, Component>();
		connectedComponent = new TreeMap<Integer, LinkedList<Integer>>();
		setImageResource(R.drawable.circuit_board); // TODO Insert image!!
	}
	
	public static CircuitBoard makeBoard(Context context){
		if(obj instanceof CircuitBoard){
			return null;
		}
		return new CircuitBoard(context);
	}
	
	public static void destroyBoard(){
		obj = null;
	}
	
	public static CircuitBoard getInstance(){
		return obj;
	}
	
	public BoardComponentManager getManager(){
		return manager;
	}
	
	public void removeComponent(Component component){ // TODO Removing component from board
		
	}
	
	public int putComponentTo(Component component, int locationId){
		ImageView img = component.getComponentImage();
		img.setTag(id);
		img.setVisibility(View.VISIBLE);
		componentList.put(id, component);
		manager.addComponent(component);
		return id++;
	}
	
	public boolean addConnectedComponent(int id, int connectedLocationId){
		return connectedComponent.get(id).add(connectedLocationId);
	}
}