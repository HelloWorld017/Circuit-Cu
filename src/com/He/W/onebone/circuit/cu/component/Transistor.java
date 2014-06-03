package com.He.W.onebone.circuit.cu.component;

import java.util.LinkedList;
import java.util.TreeMap;

import com.He.W.onebone.circuit.cu.BoardComponentManager;
import com.He.W.onebone.circuit.cu.CircuitBoard;

import android.widget.ImageView;

public class Transistor extends Component{
	
	private CircuitBoard board;

	public Transistor(CircuitBoard board, float x, float y, int rotation) {
		super(board.getContext(), com.He.W.onebone.circuit.cu.R.drawable.transistor, x, y, rotation); // TODO Insert image
		this.board = board;
	}

	@Override
	public void electricityReleased() {
	//	TreeMap<Integer, LinkedList<Integer>> list = CircuitBoard.getInstance().getConnectedList();
		LinkedList<Integer> list = this.getConnected();
		int myId = CircuitBoard.getInstance().getManager().getComponentId(this);
	}

	@Override
	public void electricityUnreleased() {
		//TreeMap<Integer, LinkedList<Integer>> list = CircuitBoard.getInstance().getConnectedList();
		LinkedList<Integer> list = this.getConnected();
		int myId = CircuitBoard.getInstance().getManager().getComponentId(this);
		BoardComponentManager mgr = board.getManager();
		for(int cid : this.getConnected()){
			mgr.getComponentById(cid).setElectrified(0);
		}
	}
}