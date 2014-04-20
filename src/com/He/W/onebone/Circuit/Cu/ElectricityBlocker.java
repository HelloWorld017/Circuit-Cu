package com.He.W.onebone.circuit.cu;

import android.widget.ImageView;

public class ElectricityBlocker extends Component{

	private int blockElectricity;
	
	public ElectricityBlocker(ImageView img, int x, int y, int locationId, int blockElectricity) {
		super(img, x, y, locationId);
		this.blockElectricity = blockElectricity;
	}
}