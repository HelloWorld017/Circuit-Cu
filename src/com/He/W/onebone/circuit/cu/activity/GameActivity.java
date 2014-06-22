package com.He.W.onebone.circuit.cu.activity;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.He.W.onebone.circuit.cu.CircuitBoard;
import com.He.W.onebone.circuit.cu.R;
import com.He.W.onebone.circuit.cu.achievement.Achievement;
import com.He.W.onebone.circuit.cu.android.ComponentAdapter;
import com.He.W.onebone.circuit.cu.component.Component;
import com.He.W.onebone.circuit.cu.component.EnumComponentType;
import com.He.W.onebone.circuit.cu.component.LightBulb;
import com.He.W.onebone.circuit.cu.component.Transistor;
import com.He.W.onebone.circuit.cu.gamebase.AudioHelper;
import com.He.W.onebone.circuit.cu.map.Level;
import com.He.W.onebone.circuit.cu.wire.Wire;

import de.keyboardsurfer.android.widget.crouton.*;

public class GameActivity extends Activity{ //SlidingActivity{
	
	private Level level;
	private CircuitBoard board;
	
	private ComponentAdapter adapter;
	private HashMap<EnumComponentType, Integer> map;
	
	private AlertDialog componentDialog = null;
	private boolean isPlacing = false;
	
	public GameActivity(Level level){
		this.level = level;
	}
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gaming);
		
		CircuitBoard.destroyBoard();
		this.board = CircuitBoard.makeBoard(this);
		map = new HashMap<EnumComponentType, Integer>();
		adapter = new ComponentAdapter(this, map);
		
		
		componentDialog.setOnDismissListener(new DialogInterface.OnDismissListener(){
			@Override
			public void onDismiss(DialogInterface dialog) {
				componentDialog = null;
			}
		});
		
		((Button)findViewById(R.id.btnDelete)).setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				Component focused = board.getFocusedComponent();
				board.getManager().removeComponent(focused);
				adapter.addItemToInventory(EnumComponentType.valueOf(focused.getTypeId()), 1);
			}
		});
		
		((Button)findViewById(R.id.btnBuild)).setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				
			}
		});
		
		((Button)findViewById(R.id.btnAdd)).setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				if(componentDialog == null){
					// TODO Add component insert dialog
					LinearLayout linear = (LinearLayout)View.inflate(GameActivity.this, R.layout.component_place, null);
					ListView itemList = (ListView) linear.findViewById(R.id.itemList);
					itemList.setAdapter(adapter);
					adapter.notifyDataSetChanged();
					
					componentDialog = new AlertDialog.Builder(GameActivity.this).create();
					componentDialog.setView(itemList);
					componentDialog.show();
					//.show();
				}
			}
		});
		
		((Button)findViewById(R.id.btnCancel)).setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				isPlacing = false;
			}
		});
		
		board.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				if(isPlacing){
					
				}
			}
		});
		prepare();
	}
	
	public void resetGame(){
		board.removeAllComponents();
	}
	
	private void prepare(){ // TODO Preparing for level, draw line for border, prepare for components, etc.
		TreeMap<String, Integer> list = level.getItemList();
		Set<String> keys = list.keySet();
		for(String component:keys){
			Class<?> c;
			
			if((c = Level.getComponentByName(component)) != null){
				
				String name = c.getClass().getName();
				if(name.equals("LightBulb")){
					adapter.addItemToInventory(EnumComponentType.COMPONENT_LIGHT_BULB, list.get(component));
				}else if(name.equals("Transistor")){
					adapter.addItemToInventory(EnumComponentType.COMPONENT_TRANSISTOR, list.get(component));
				}else if(name.equals("Resistor")){
					adapter.addItemToInventory(EnumComponentType.COMPONENT_RESISTOR, list.get(component));
				}
			}else if((c = Level.getWireByName(component)) != null){
				String name = c.getClass().getName();
				if(name.equals("CopperWire")){
					adapter.addItemToInventory(EnumComponentType.COMPONENT_COPPER_WIRE, list.get(component));
				}else if(name.equals("GoldWire")){
					adapter.addItemToInventory(EnumComponentType.COMPONENT_GOLD_WIRE, list.get(component));
				}
			}
		}
	}
	
	public void showAchievementGranted(Achievement achievement){
		Crouton.makeText(this, getResources().getString(R.string.achievement_granted).replace("%1", achievement.getTitle()), Style.INFO).show();
	}
}