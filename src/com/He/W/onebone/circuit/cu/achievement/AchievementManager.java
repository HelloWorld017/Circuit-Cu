package com.He.W.onebone.circuit.cu.achievement;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeMap;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.He.W.onebone.circuit.cu.R;
import com.He.W.onebone.circuit.cu.activity.MainActivity;

import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

public class AchievementManager {
	private static TreeMap<String, Achievement> achievements;
	private static LinkedList<String> grantedAchievements;
	
	public static void clearSeq(){
		achievements = new TreeMap<String, Achievement>();
		grantedAchievements = new LinkedList<String>();
	}
	
	public static int addAchievement(Achievement achievement){
		if(achievements == null){
			achievements = new TreeMap<String, Achievement>();
		}
		
		if(achievements.containsKey(achievement.getAchievementId())){
			return 0;
		}
		achievements.put(achievement.getAchievementId(), achievement);
		return 1;
	}
	
	public static boolean grantAchievement(Achievement achievement){
		if(grantedAchievements == null){
			grantedAchievements = new LinkedList<String>();
		}
		if(achievements == null){
			achievements = new TreeMap<String, Achievement>();
		}
		
		if(achievements.containsKey(achievement.getAchievementId())){
			if(grantedAchievements.contains(achievement.getAchievementId())){
				return false;
			}
			grantedAchievements.add(achievement.getAchievementId());
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean grantAchievement(Achievement achievement, Activity ctx){
		if(grantedAchievements == null){
			grantedAchievements = new LinkedList<String>();
		}
		if(achievements == null){
			achievements = new TreeMap<String, Achievement>();
		}
		
		if(achievements.containsKey(achievement.getAchievementId())){
			if(grantedAchievements.contains(achievement.getAchievementId())){
				return false;
			}
			grantedAchievements.add(achievement.getAchievementId());
			Crouton.makeText(ctx, ctx.getResources().getString(R.string.achievement_granted).replace("%1", achievement.getTitle()), Style.INFO).show();
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
			achievements = new TreeMap<String, Achievement>();
		}
		
		if(grantedAchievements.contains(achievementId)){
			grantedAchievements.removeFirstOccurrence(achievementId);
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean cancelAchievement(Achievement achievement){
		if(grantedAchievements == null){
			grantedAchievements = new LinkedList<String>();
		}
		if(achievements == null){
			achievements = new TreeMap<String, Achievement>();
		}
		
		if(grantedAchievements.contains(achievement.getAchievementId())){
			grantedAchievements.removeFirstOccurrence(achievement.getAchievementId());
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