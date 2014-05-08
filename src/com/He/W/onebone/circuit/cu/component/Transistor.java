package com.He.W.onebone.circuit.cu.component;

import com.He.W.onebone.circuit.cu.CircuitBoard;

import android.widget.ImageView;

public class Transistor extends Component{

	public Transistor(CircuitBoard board, float x, float y, int rotation) {
		super(board.getContext(), com.He.W.onebone.circuit.cu.R.drawable.transistor, x, y, rotation); // TODO Insert image
	}

	@Override
	public void electricityReleased() {
		
	}
}