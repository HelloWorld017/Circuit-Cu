package com.He.W.onebone.circuit.cu.map;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import android.content.Context;
import android.widget.Toast;

import com.He.W.onebone.circuit.cu.R;
import com.He.W.onebone.circuit.cu.settings.FirstStartingHelper;

public class RankingHelper {
	public static HashMap<Integer, Object[]> rankings;
	private static Context ctxt;
	public static void readAllRanking(Context ctx){
		ctxt = ctx;
		rankings = new HashMap<Integer, Object[]>();

		
		/*
		 * Object[] index
		 * 0 = String Time : 1m50s ( 1 minute and 50 seconds)
		 * 1 = int minute
		 * 2 = int second
		 */
		try {
			
			//Declaration part
			File f = new File(FirstStartingHelper.rankingPath);
			FileInputStream fis = new FileInputStream(f);
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			String s = "";
			
			for(int a = 0;(s = br.readLine()) != null;a++){
				String splited[] = s.split(".");
				int minute = Integer.valueOf(splited[0]);
				int second = Integer.valueOf(splited[1]);
				if(second > 60){
					Toast.makeText(ctxt, "Invalid Ranking", Toast.LENGTH_LONG).show();
				}
				String time = minute + ctxt.getString(R.string.layout_time_minute) + second +ctxt.getString(R.string.layout_time_second);
				Object[] obj  = new Object[3];
				obj[0] = time;
				obj[1] = minute;
				obj[2] = second;
				rankings.put(a, obj);
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public static Object[] getRanking(int index){
		return rankings.get(index);
	}
	public static void writeRanking(String time){
		String splited[] = time.split(".");
		int minute = Integer.valueOf(splited[0]);
		int second = Integer.valueOf(splited[1]);
		if(second > 60){
			Toast.makeText(ctxt, "Invalid Ranking", Toast.LENGTH_LONG).show();
		}
		String timea = minute + ctxt.getString(R.string.layout_time_minute) + second +ctxt.getString(R.string.layout_time_second);
		Object[] obj  = new Object[3];
		obj[0] = timea;
		obj[1] = minute;
		obj[2] = second;
	}
	public static void destroyHelper(){
		
	}
	public static boolean compareRanking(Object[] first, Object[] second){
		/*
		 * false = second°¡ ÂªÀ½
		 * true = first°¡ ÂªÀ½
		 */
		return false;
	}
	public static HashMap<Integer, Object[]> adjustRanking(HashMap<Integer, Object[]> hm){
		ArrayList<Object[]> raws = new ArrayList<Object[]>();
		Iterator<Object[]> rankingItr;
		rankingItr = hm.values().iterator();
		while(rankingItr.hasNext()){
			raws.add(rankingItr.next());
		}
		Object[] aligned = new Object[raws.size()];
		Object[] CompareTarget = raws.get(0);
		//TODO write script
		return null;
	}
	public static void writeAllRankings(){
		
	}
}
