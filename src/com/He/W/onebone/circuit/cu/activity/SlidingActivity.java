package com.He.W.onebone.circuit.cu.activity;

import android.view.View;

public class SlidingActivity extends android.app.Activity{
	private View slideMenu = null;
	
	public void openSlideMenu(View view){
		// TODO Menu opening animation
		slideMenu = view;
		// It is okay to do with PopupMenu?
	}
	
	public void closeSlideMenu(){
		if(slideMenu != null){
			// TODO Menu closing animation
		}
	}
}