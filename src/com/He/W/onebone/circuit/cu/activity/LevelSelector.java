package com.He.W.onebone.circuit.cu.activity;

import java.util.ArrayList;

import android.widget.ListView;

import com.He.W.onebone.circuit.cu.R;
import com.He.W.onebone.circuit.cu.android.ComponentAdapter;
import com.He.W.onebone.circuit.cu.component.EnumComponentType;

public class LevelSelector extends android.app.Activity{
	private ListView levelList;
	private ComponentAdapter adapter;
	@Override
	public void onCreate(android.os.Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.level_selector);
		ListView levelList = (ListView)findViewById(R.id.levelList);
		//ComponentAdapter adapter = new ComponentAdapter(this, new ArrayList<EnumComponentType>(), ); 
		levelList.setAdapter(adapter);
	}
}
