package com.He.W.onebone.circuit.cu.achievement;

import java.util.LinkedList;
import java.util.TreeMap;

public class AchievementManager {
	private static TreeMap<Integer, BaseAchievement> achievements;
	private static LinkedList<Integer> grantedAchievements;
	
	public static void clearSeq(){
		achievements = new TreeMap<Integer, BaseAchievement>();
		grantedAchievements = new LinkedList<Integer>();
	}
	
	public static int addAchievement(int achievementId, BaseAchievement achievement){
		if(achievements == null){
			achievements = new TreeMap<Integer, BaseAchievement>();
		}
		
		if(achievements.containsKey(achievementId)){
			return 0;
		}
		achievements.put(achievementId, achievement);
		return 1;
	}
	
	public static boolean grantAchievement(int achievementId){
		if(grantedAchievements == null){
			grantedAchievements = new LinkedList<Integer>();
		}
		if(achievements == null){
			achievements = new TreeMap<Integer, BaseAchievement>();
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
			grantedAchievements = new LinkedList<Integer>();
		}
		if(achievements == null){
			achievements = new TreeMap<Integer, BaseAchievement>();
		}
		
		if(grantedAchievements.contains(achievementId)){
			grantedAchievements.removeFirstOccurrence(achievementId);
			return true;
		}else{
			return false;
		}
	}
}
