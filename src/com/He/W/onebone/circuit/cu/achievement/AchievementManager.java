package com.He.W.onebone.circuit.cu.achievement;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeMap;

import android.content.Context;
import android.content.SharedPreferences;

import com.He.W.onebone.circuit.cu.activity.MainActivity;

public class AchievementManager {
	private static TreeMap<String, BaseAchievement> achievements;
	private static LinkedList<String> grantedAchievements;
	
	public static void clearSeq(){
		achievements = new TreeMap<String, BaseAchievement>();
		grantedAchievements = new LinkedList<String>();
	}
	
	public static int addAchievement(String achievementId, BaseAchievement achievement){
		if(achievements == null){
			achievements = new TreeMap<String, BaseAchievement>();
		}
		
		if(achievements.containsKey(achievementId)){
			return 0;
		}
		achievements.put(achievementId, achievement);
		return 1;
	}
	
	public static boolean grantAchievement(String achievementId){
		if(grantedAchievements == null){
			grantedAchievements = new LinkedList<String>();
		}
		if(achievements == null){
			achievements = new TreeMap<String, BaseAchievement>();
		}
		
		if(achievements.containsKey(achievementId)){
			if(grantedAchievements.contains(achievementId)){
				return false;
			}
			grantedAchievements.add(achievementId);
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean cancelAchievement(int achievementId){
		if(grantedAchievements == null){
			grantedAchievements = new LinkedList<String>();
		}
		if(achievements == null){
			achievements = new TreeMap<String, BaseAchievement>();
		}
		
		if(grantedAchievements.contains(achievementId)){
			grantedAchievements.removeFirstOccurrence(achievementId);
			return true;
		}else{
			return false;
		}
	}
	
	public static void loadAchievementListFromFile(){
		SharedPreferences preference = MainActivity.getInstance().getSharedPreferences("achievements", Context.MODE_PRIVATE);
		Set<String> set = preference.getStringSet("granted", (new HashSet<String>()));
		for(String achievement:set){
			grantedAchievements.add(achievement);
		}
	}
	
	public static void saveAchievementListToFile(){
		SharedPreferences preference = MainActivity.getInstance().getSharedPreferences("achievements", Context.MODE_PRIVATE);
		HashSet<String> set = new HashSet<String>();
		for(String id : grantedAchievements){
			set.add(id);
		}
		preference.edit().putStringSet("granted", set).apply();
	}
}
