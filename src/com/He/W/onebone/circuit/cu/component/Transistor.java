package com.He.W.onebone.circuit.cu.component;

import java.util.LinkedList;

import com.He.W.onebone.circuit.cu.BoardComponentManager;
import com.He.W.onebone.circuit.cu.CircuitBoard;
import com.He.W.onebone.circuit.cu.R;

public class Transistor extends Component{
	
	private CircuitBoard board;

	public Transistor(CircuitBoard board, float x, float y, int rotation, float requireElec) {
		super(board.getContext(), com.He.W.onebone.circuit.cu.R.drawable.transistor, x, y, rotation, EnumComponentType.COMPONENT_TRANSISTOR, requireElec);
		this.board = board;
	}

	@Override
	public synchronized void electricityReleased() {
	//	TreeMap<Integer, LinkedList<Integer>> list = CircuitBoard.getInstance().getConnectedList();
		LinkedList<Integer> list = this.getAbleConnecting();
		this.setImageResource(R.drawable.transistor_released);
		//int myId = CircuitBoard.getInstance().getManager().getComponentId(this);
		BoardComponentManager mgr = CircuitBoard.getInstance().getManager();
		for(int id : list){
			try{
				mgr.getComponentById(id).setElectrified(5);
			}catch(Exception e){}
		}
	}
	
	@Override
	public synchronized void electricityUnreleased() {
		//TreeMap<Integer, LinkedList<Integer>> list = CircuitBoard.getInstance().getConnectedList();
		LinkedList<Integer> list = this.getConnected();
		if(this.getElectrified() <= 0){
			this.setImageResource(R.drawable.transistor);
		}
		//int myId = CircuitBoard.getInstance().getManager().getComponentId(this);
		BoardComponentManager mgr = board.getManager();
		for(int cid : list){
			try{
				mgr.getComponentById(cid).setElectrified(0);
			}catch(Exception e){}
		}
	}
}