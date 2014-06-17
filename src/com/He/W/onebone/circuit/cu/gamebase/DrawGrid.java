package com.He.W.onebone.circuit.cu.gamebase;

import java.util.ArrayList;

import android.widget.ImageView;

public class DrawGrid {
	public void drawGrid(int XlineCount, int YlineCount, ImageView iv){
		//line count는 x번 짜르는 것을 의미. 0부터 재지않음. ex) xLineCount가 2이면, 2등분 하는것.
		float xLength = iv.getX();
		float yLength = iv.getY();
		ArrayList<ArrayList<Float>> raws = ScissorXY(xLength, yLength, XlineCount, YlineCount);
		
	}
	
	public ArrayList<ArrayList<Float>> ScissorXY(float xL, float yL, int xC, int yC){
		ArrayList<Float> xT = new ArrayList<Float>();
		ArrayList<Float> yT = new ArrayList<Float>();
		float xD = xL / xC;
		float yD = yL / yC;
		float xS = 0;
		float yS = 0;
		for(;xS <= xL;xS += xD){
			xT.add(xS);
		}
		for(;yS <= yL;yS += yD){
			yT.add(yS);
		}
		ArrayList<ArrayList<Float>> ttr = new ArrayList<ArrayList<Float>>();
		ttr.add(0, xT);
		ttr.add(0, yT);
		return ttr;
	}
}
