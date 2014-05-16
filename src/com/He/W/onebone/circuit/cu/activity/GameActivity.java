package com.He.W.onebone.circuit.cu.activity;

import com.He.W.onebone.circuit.cu.CircuitBoard;
import com.He.W.onebone.circuit.cu.R;
import com.He.W.onebone.circuit.cu.achievement.Achievement;
import com.He.W.onebone.circuit.cu.map.Level;

import de.keyboardsurfer.android.widget.crouton.*;

public class GameActivity extends SlidingActivity{
	
	private Level level;
	private CircuitBoard board;
	
	public GameActivity(Level level){
		this.level = level;
		CircuitBoard.destroyBoard();
		this.board = CircuitBoard.makeBoard(this);
		prepare();
	}
	
	public void resetGame(){
		board.removeAllComponents();
	}
	
	private void prepare(){ // TODO Preparing for level
		
	}
	
	public void showAchievementGranted(Achievement achievement){
		Crouton.makeText(this, getResources().getString(R.string.achievement_granted).replace("%1", achievement.getTitle()), Style.INFO).show();
	}
}