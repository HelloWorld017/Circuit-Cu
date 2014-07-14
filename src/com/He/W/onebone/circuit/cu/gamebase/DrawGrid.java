package com.He.W.onebone.circuit.cu.gamebase;

import java.util.ArrayList;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class DrawGrid {
	public Canvas drawGrid(int XgridCount, int YgridCount, float xLength, float yLength){
		//grid count�� x�� ¥���� ���� �ǹ�. 0���� ��������. ex) XgridCount�� 2�̸�, x���� 2��� �ϴ°�.
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
		return canvas;
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
	public Float[] getSizeOfClass(float xL, float yL, int xC, int yC){
		Float[] floatTachi = new Float[2];
		floatTachi[0] = xL / xC;
		floatTachi[1] = yL / yC;
		return floatTachi;
		
	}
}
