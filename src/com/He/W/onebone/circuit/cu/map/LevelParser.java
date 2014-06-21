package com.He.W.onebone.circuit.cu.map;

import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.os.Environment;

import com.He.W.onebone.circuit.cu.exception.LevelParseException;

public class LevelParser {
	
	public static ArrayList<String>  readAllLevels(){
		final ArrayList<String> result = new ArrayList<String>();
		File ccpfolder = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/CircuitCu/");
		ccpfolder.list(new FilenameFilter(){

			@Override
			public boolean accept(File arg0, String arg1) {
				if(arg1.endsWith(".cc")){
					result.add(arg1);
				}
				return false;
			}
			
		});
		
		result.remove("Settings.cc");
		result.remove("Ranking.cc");
		
		return result;
	}
	
	public static Level parseLevel(File file) throws LevelParseException{
		if(!file.isFile()){
			throw new LevelParseException(LevelParseException.NO_FILE);
		}
		try{
			FileInputStream fis = new FileInputStream(file);
			byte[] buffer = new byte[fis.available()];
			while(fis.read(buffer) != -1){}
			String content = new String(buffer);
			fis.close();
			TreeMap<String, String> mapData = new TreeMap<String, String>();
			ArrayList<TreeMap<String, Object>> componentData = new ArrayList<TreeMap<String, Object>>();
			
			Pattern startPattern = Pattern.compile("(\\[)([a-zA-Z0-9]{1,}+)(\\])"); // [something]
			Matcher startMatcher = startPattern.matcher(content);
			
			Pattern endPattern = Pattern.compile("\\[/\\]"); // [/]
			Matcher endMatcher = endPattern.matcher(content);
			
			Pattern itemDataPattern = Pattern.compile("(.*{1,}+)=(.*{1,}+)"); // something=data
			while(startMatcher.find()){
				int curIndex = componentData.size() - 1;
				
				int start = startMatcher.start();
				int end = startMatcher.end();
				
				String tmp = content.substring(start, end);
				String tag = tmp.substring(1, tmp.length() -1);
				if(tag.equals("MAP")){
					endMatcher.find();
					int start2 = endMatcher.start();
					String item = content.substring(end, start2);
					Matcher matcher = itemDataPattern.matcher(item);
					while(matcher.find()){
						int dataStart = matcher.start();
						int dataEnd = matcher.end();
						String dataStr = item.substring(dataStart, dataEnd);
						String[] data = dataStr.split("=");
						
						mapData.put(data[0], data[1]);
					}
					continue;
				}
				
				endMatcher.find();
				int start2 = endMatcher.start();
				String item = content.substring(end, start2);
				Matcher matcher = itemDataPattern.matcher(item);
				while(matcher.find()){
					int dataStart = matcher.start();
					int dataEnd = matcher.end();
					String dataStr = item.substring(dataStart, dataEnd);
					String[] data = dataStr.split("=");
					
					componentData.get(curIndex).put(data[0], data[1]);
				}
			}
			return new Level(mapData, componentData);
		}catch(IllegalStateException e){
			throw new LevelParseException(LevelParseException.WRONG_FILE);
		}catch(StringIndexOutOfBoundsException e){
			throw new LevelParseException(LevelParseException.WRONG_FILE);
		}catch(ArrayIndexOutOfBoundsException e){
			throw new LevelParseException(LevelParseException.WRONG_FILE);
		}catch(Exception e){
			throw new LevelParseException(LevelParseException.UNKNOWN, e.toString());
		}
	}
	
	public static Level parseLevel(String file) throws LevelParseException{
		return parseLevel(new File(file));
	}
}
