package com.He.W.onebone.circuit.cu.gamebase;

import java.util.ArrayList;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.widget.ImageView;

public class DrawGrid {
	public void drawGrid(int XgridCount, int YgridCount, ImageView iv){
		//grid count는 x번 짜르는 것을 의미. 0부터 재지않음. ex) XgridCount가 2이면, x축을 2등분 하는것.
		float xLength = iv.getX();
		float yLength = iv.getY();
		ArrayList<ArrayList<Float>> raws = ScissorXY(xLength, yLength, XgridCount, YgridCount);
		ArrayList<Float> xT = raws.get(0);
		ArrayList<Float> yT = raws.get(1);
		Paint blackPaint = new Paint();
        blackPaint.setColor(Color.BLACK);
        Bitmap bitmap = Bitmap.createBitmap((int)xLength,(int)yLength, Bitmap.Config.ARGB_8888);
		Canvas canvas = new Canvas(bitmap);
		for(int a = 0;a < xT.size();a++){
			float nX = xT.get(a);
			
			canvas.drawLine(nX, 0, nX, yLength, blackPaint);
		}
		for(int b = 0;b < yT.size();b++){
			float nY = yT.get(b);
			
			canvas.drawLine(0, nY, xLength, nY, blackPaint);
		}
		iv.setImageBitmap(bitmap);
	}
	
	public ArrayList<ArrayList<Float>> ScissorXY(float xL, float yL, int xC, int yC){
		ArrayList<Float> xT = new ArrayList<Float>();
		ArrayList<Float> yT = new ArrayList<Float>();
		float xD = xL / xC;
		float yD = yL / yC;
		float xS = 0;
		float yS = 0;
		xT.add(0F);
		for(;xS <= xL;xS += xD){
			xT.add(xS);
		}
		yT.add(0F);
		for(;yS <= yL;yS += yD){
			yT.add(yS);
		}
		ArrayList<ArrayList<Float>> ttr = new ArrayList<ArrayList<Float>>();
		ttr.add(0, xT);
		ttr.add(0, yT);
		return ttr;
	}
}
