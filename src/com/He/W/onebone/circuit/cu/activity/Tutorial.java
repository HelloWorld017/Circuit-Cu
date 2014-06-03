package com.He.W.onebone.circuit.cu.activity;

import com.He.W.onebone.circuit.cu.R;
import com.He.W.onebone.circuit.cu.R.layout;
import com.He.W.onebone.circuit.cu.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Tutorial extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tutorial);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_tutorial, menu);
		return true;
	}

}
