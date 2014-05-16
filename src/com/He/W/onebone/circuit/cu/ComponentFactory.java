package com.He.W.onebone.circuit.cu;

import com.He.W.onebone.circuit.cu.component.*;

public class ComponentFactory {
	
	public static Component makeComponent(EnumComponentType type, Object... extArgs){
		switch(type){
		case COMPONENT_RESISTOR:
			return new Resistor((CircuitBoard)extArgs[0], Float.parseFloat(extArgs[1].toString()), Float.parseFloat(extArgs[2].toString()), Integer.parseInt(extArgs[3].toString()), Integer.parseInt(extArgs[4].toString()));
		case COMPONENT_TRANSISTOR:
			return new Transistor((CircuitBoard)extArgs[0], Integer.parseInt(extArgs[1].toString()), Integer.parseInt(extArgs[2].toString()), Integer.parseInt(extArgs[3].toString()));
			default:
				return null;
		}
	}
}