package com.He.W.onebone.circuit.cu.activity;

import java.util.HashMap;

import android.app.Activity;
import android.widget.ListView;

import com.He.W.onebone.circuit.cu.CircuitBoard;
import com.He.W.onebone.circuit.cu.R;
import com.He.W.onebone.circuit.cu.achievement.Achievement;
import com.He.W.onebone.circuit.cu.android.ComponentAdapter;
import com.He.W.onebone.circuit.cu.component.EnumComponentType;
import com.He.W.onebone.circuit.cu.map.Level;

import de.keyboardsurfer.android.widget.crouton.*;

public class GameActivity extends Activity{ //SlidingActivity{
	
	private Level level;
	private CircuitBoard board;
	
	private ComponentAdapter adapter;
	private HashMap<EnumComponentType, Integer> map;
	
	private ListView itemList;
	
	public GameActivity(Level level){
		this.level = level;
		CircuitBoard.destroyBoard();
		this.board = CircuitBoard.makeBoard(this);
		map = new HashMap<EnumComponentType, Integer>();
		adapter = new ComponentAdapter(this, map);
		
		// TODO Get ListView this#itemList from layout resource 
		prepare();
	}
	
	public void resetGame(){
		board.removeAllComponents();
	}
	
	private void prepare(){ // TODO Preparing for level, draw line for border, prepare for components, etc.
		
	}
	
	public void showAchievementGranted(Achievement achievement){
		Crouton.makeText(this, getResources().getString(R.string.achievement_granted).replace("%1", achievement.getTitle()), Style.INFO).show();
	}
}