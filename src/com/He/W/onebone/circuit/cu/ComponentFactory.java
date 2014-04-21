package com.He.W.onebone.circuit.cu;

import android.widget.ImageView;

import com.He.W.onebone.circuit.cu.component.*;

public class ComponentFactory {
	
	/*public static final int COMPONENT_RESISTER = 0x00;
	public static final int COMPONENT_TRANSISTOR = 0x01; */
	
	public static Component makeComponent(EnumComponentType type, Object... extArgs){
		switch(type){
		case COMPONENT_RESISTER:
			return new Resister((ImageView)extArgs[0], Float.parseFloat(extArgs[1].toString()), Float.parseFloat(extArgs[2].toString()), Integer.parseInt(extArgs[3].toString()), Integer.parseInt(extArgs[4].toString()), Integer.parseInt(extArgs[5].toString()));
		case COMPONENT_TRANSISTOR:
			return new Transistor((ImageView)extArgs[0], Integer.parseInt(extArgs[1].toString()), Integer.parseInt(extArgs[2].toString()), Integer.parseInt(extArgs[3].toString()));
		}
		return null;
	}
}