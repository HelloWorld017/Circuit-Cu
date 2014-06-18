package com.He.W.onebone.circuit.cu.gamebase;

import java.util.ArrayList;

import android.graphics.Canvas;
import android.widget.ImageView;

public class DrawGrid {
	public void drawGrid(int XgridCount, int YgridCount, ImageView iv){
		//grid count는 x번 짜르는 것을 의미. 0부터 재지않음. ex) xLineCount가 2이면, 2등분 하는것.
		float xLength = iv.getX();
		float yLength = iv.getY();
		ArrayList<ArrayList<Float>> raws = ScissorXY(xLength, yLength, XgridCount, YgridCount);
		ArrayList<Float> xT = raws.get(0);
		ArrayList<Float> yT = raws.get(1);
		Canvas canvas = new Canvas();
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
