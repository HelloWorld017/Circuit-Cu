package com.He.W.onebone.circuit.cu.map;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.He.W.onebone.circuit.cu.component.Component;

public class LevelParser {
	public static final int NO_FILE = -2;
	public static final int WRONG_FILE = -1;
	public static final int UNKNOWN = 0;
	public static final int SUCCESS = 1;
	//enum으로 변환시키는 것은 에러를 줄여줍니다.
	
	public static int parseLevel(File file){
		if(!file.isFile()){
			return NO_FILE;
		}
		try{
			FileInputStream fis = new FileInputStream(file);
			byte[] buffer = new byte[fis.available()];
			while(fis.read(buffer) != -1){}
			String content = new String(buffer);
			fis.close();
			TreeMap<String, String> mapData = new TreeMap<String, String>();
			TreeMap<String, String> componentData = new TreeMap<String, String>();
			
			Pattern startPattern = Pattern.compile("(\\[)([a-zA-Z0-9]{1,}+)(\\])"); // [something]
			Matcher startMatcher = startPattern.matcher(content);
			
			Pattern endPattern = Pattern.compile("(\\[/)([a-zA-Z0-9]{1,}+)(\\])"); // [/something]
			Matcher endMatcher = endPattern.matcher(content);
			
			Pattern itemDataPattern = Pattern.compile("(\n)([a-zA-Z0-9]{1,}+)=([a-zA-Z0-9]{1,}+)"); // something=data
			while(startMatcher.find()){
				int start = startMatcher.start();
				int end = startMatcher.end();
				int thisStart = endMatcher.start();
				int thisEnd = endMatcher.end();
				String item = content.substring(end, thisStart);
				Matcher matcher = itemDataPattern.matcher(item);
				while(matcher.find()){
					int dataStart = matcher.start();
					int dataEnd = matcher.end();
					String dataStr = item.substring(dataStart, dataEnd);
					String[] data = dataStr.split("=");
					componentData.put(data[0], data[1]);
				}
			}
		}catch(IllegalStateException e){
			return WRONG_FILE;
		}catch(StringIndexOutOfBoundsException e){
			return WRONG_FILE;
		}catch(ArrayIndexOutOfBoundsException e){
			return WRONG_FILE;
		}catch(Exception e){
			return UNKNOWN;
		}
		return SUCCESS;
	}
	
	public static int parseLevel(String file){
		return parseLevel(new File(file));
	}
}
