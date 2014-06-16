package com.He.W.onebone.circuit.cu.map;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import com.He.W.onebone.circuit.cu.R;
import com.He.W.onebone.circuit.cu.StackTraceToString;
import com.He.W.onebone.circuit.cu.settings.FirstStartingHelper;

public class RankingHelper {
	public static HashMap<File , ArrayList<Object[]>> rankingsForAllMap = new HashMap<File , ArrayList<Object[]>>();
	private static Context ctxt;
	public static void readAllRanking(Context ctx){
		ctxt = ctx;
		ArrayList<Object[]> rankingsForThisMap = new ArrayList<Object[]>();

		
		/*
		 * Object[] index
		 * 0 = String Time : 1m50s ( 1 minute and 50 seconds)
		 * 1 = int minute
		 * 2 = int second
		 */
		
		/*
		 Ranking sheet is like this
		 /Tutorial.cc
		 1.25
		 1.50
		 /MappingTest.cc
		 4.28
		 3.62
		 */
		try {
			
			//Declaration part
			File f = new File(FirstStartingHelper.rankingPath);
			FileInputStream fis = new FileInputStream(f);
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			String s = "";
			int obje = 0;
			String mapTemp = "";
			
			for(int a = 0;(s = br.readLine()) != null;a++){
				if(s.startsWith("/")){
					if(obje == 0){
						mapTemp = s;
						obje++;
					}else{
						ArrayList<Object[]> rankingAlignedForThisMap = adjust(rankingsForThisMap);
						String mapPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/CircuitCu" + mapTemp;
						File mapf = new File(mapPath);
						rankingsForAllMap.put(mapf, rankingAlignedForThisMap);
						rankingsForThisMap = new ArrayList<Object[]>();
						mapTemp = s;
						obje++;
					}
					 
				}
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
				rankingsForThisMap.add(a, obj);
			}
			
		  
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public static Object[] getRanking(int index, File map){
		return rankingsForAllMap.get(map).get(index);
	}
	public static ArrayList<Object[]> getRankingList(File map){
		return rankingsForAllMap.get(map);
	}
	public static void writeRanking(String time, File map){
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
		ArrayList<Object[]> ll = rankingsForAllMap.get(map);
		ll.add(obj);
		rankingsForAllMap.remove(map);
		rankingsForAllMap.put(map, adjust(ll));
	}
	public static void destroyHelper(){
		
	}
	@SuppressWarnings("unchecked")
	public static ArrayList<Object[]> adjust(ArrayList<Object[]> raws){
		Iterator<Object[]> rankingItr;
		rankingItr = raws.iterator();
		while(rankingItr.hasNext()){
			raws.add(rankingItr.next());
		}
		RankingTimeComparator rtc = new RankingTimeComparator();
		Object[] aligned = raws.toArray();
		Arrays.sort(aligned, rtc );
		ArrayList<Object[]> KUBWS = new ArrayList<Object[]>();
		for(int a = 0;a < aligned.length;a++){
			KUBWS.add(0,(Object[])aligned[0]);
		}
		return KUBWS;
		
	}
	//TODO unchecked
	/*public static void adjust(HashMap<Integer, Object[]> hm){
		ArrayList<Object[]> raws = new ArrayList<Object[]>();
		Iterator<Object[]> rankingItr;
		rankingItr = hm.values().iterator();
		while(rankingItr.hasNext()){
			raws.add(rankingItr.next());
		}
		RankingTimeComparator rtc = new RankingTimeComparator();
		Object[] aligned = raws.toArray();
		Arrays.sort(aligned, rtc );
		for(int a = 0;a < aligned.length;a++){
			
		}
		//TODO write script
		
	}*/
	
	/*public static boolean compareRanking(Object[] first, Object[] second){
		
		// false = second°¡ ÂªÀ½
		//  true = first°¡ ÂªÀ½
		 
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
	}*/
	@SuppressWarnings("unchecked")
	public static void writeAllRankings(){
		//Declaration part
		String path = FirstStartingHelper.rankingPath;
		File f = new File(path);
		try{
			FileOutputStream fos = new FileOutputStream(f);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			Iterator i = rankingsForAllMap.values().iterator();
			ArrayList<ArrayList<Object[]>> rankingsFAM = new ArrayList<ArrayList<Object[]>>();
			while(i.hasNext()){
				rankingsFAM.add((ArrayList<Object[]>) i.next());
			}
			
			//Writing part
			
			for(int a = 0; a < rankingsForAllMap.size();a++){
				
			}
			
		}catch(IOException e){
			Log.d("error", StackTraceToString.convert(e));
		}
	}
}
