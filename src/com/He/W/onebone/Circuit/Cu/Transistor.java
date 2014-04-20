package com.He.W.onebone.circuit.cu;

import android.widget.ImageView;

public class Transistor extends Component{

	public Transistor(ImageView img, int x, int y, int locationId) {
		super(img, x, y, locationId);
		CircuitBoard.getInstance().getManager().addComponent(this);
	}
}