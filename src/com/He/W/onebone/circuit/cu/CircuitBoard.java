package com.He.W.onebone.circuit.cu;

import com.He.W.onebone.circuit.cu.activity.MainActivity;
import com.He.W.onebone.circuit.cu.component.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeMap;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class CircuitBoard extends ImageView{
	private static CircuitBoard obj;
	private BoardComponentManager manager;
	//private TreeMap<Integer, LinkedList<Integer>> connectedComponent;
	private int focused = -1;
	
	private CircuitBoard(Context context) {
		super(context);
		obj = this;
		manager = new BoardComponentManager(this);
		//connectedComponent = new TreeMap<Integer, LinkedList<Integer>>();
		this.setOnTouchListener(new View.OnTouchListener(){
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				/*if(focused == -1) return false;
				Component focusedCmt = manager.getComponentById(focused);
				float x = event.getX();
				float overBoard = MainActivity.getInstance().getResources().getDisplayMetrics().density / 4;
				if(x < overBoard){
					removeComponent(focused);
					return false;
				}
				focusedCmt.moveTo(x, event.getY());
				focusedCmt.setFocused(false);
				return false;*/
				int maxY = CircuitBoard.this.getHeight();
				
				return false;
			}
		});
		setImageResource(R.drawable.circuit_board); // TODO Insert image!!
	}
	
	public static CircuitBoard makeBoard(Context context){
		if(obj instanceof CircuitBoard){
			return obj;
		}
		return new CircuitBoard(context);
	}
	
	public static void destroyBoard(){
		if(obj != null){
			obj.setVisibility(View.INVISIBLE);
		}
		obj = null;
	}
	
	public static CircuitBoard getInstance(){
		return obj;
	}
	
	public BoardComponentManager getManager(){
		return manager;
	}
	
	public void notifyComponentFocused(int id){
		Component focusedCmt = manager.getComponentById(id);
		focusedCmt.setFocused(false);
		focused = id;
	}
	
	public void notifyComponentUnfocused(){
		focused = -1;
	}
	
	public Component getFocusedComponent(){
		return manager.getComponentById(focused);
	}
	
	public int getFocused(){
		return focused;
	}
	
	public void removeComponent(int id){
		Component component = manager.getComponentById(id);
		component.setVisibility(View.INVISIBLE);
		manager.removeComponent(id);
	}
	
	public void removeComponent(Component component){
		component.setVisibility(View.INVISIBLE);
		manager.removeComponent(component);
		Iterator<Integer> keys = manager.getAll().keySet().iterator();
		while(keys.hasNext()){
			int next = keys.next();
			if(manager.getComponentById(next).equals(component)){
				manager.removeComponent(next);
				return;
			}
		}
	}
	
	public void removeAllComponents(){
		Iterator<Integer> key = manager.getAll().navigableKeySet().iterator();
		while(key.hasNext()){
			this.removeComponent(manager.getComponentById(key.next()));
		}
	}
	
	public int putComponentTo(Component component, int locationId){
		ImageView img = component.getComponentImage();
		img.setVisibility(View.VISIBLE);
		return manager.addComponent(component);
	}
	
	public boolean addConnectedComponent(int id, int targetId){
	//	return connectedComponent.get(id).add(connectedLocationId);
		return manager.getComponentById(id).addConnectedComponent(targetId);
	}
	
	public void electricityPassedOn(int id){ // TODO electricity passed
		Component component = manager.getComponentById(id);
		LinkedList<Integer> list = component.getConnected();
		for(int cmtId:list){
			if(manager.getComponentById(cmtId).getElectrified() > 0){
				continue;
			}
			electricityPassedOn(cmtId);
		}
	}
	
	public void electricityUnreleasedTo(int id){
		//LinkedList<Integer> list = connectedComponent.get(id);
		Component component = manager.getComponentById(id);
		LinkedList<Integer> list = component.getConnected();
		for(int cmtId:list){
			Component cmt = manager.getComponentById(cmtId);
			if(cmt.getElectrified() > 0){ // If the component has electricit
				try{
					cmt.setElectrified(0); // Block its electricity
				}catch(Exception e){}
				electricityUnreleasedTo(cmtId);
			}
		}
	}
}