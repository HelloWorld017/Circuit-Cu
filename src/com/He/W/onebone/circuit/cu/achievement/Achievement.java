package com.He.W.onebone.circuit.cu.achievement;

import com.He.W.onebone.circuit.cu.exception.AchievementCreateException;

abstract public class Achievement {
	private String message, title, achievementId;
	
	public Achievement(String achievementId, String title, String message) throws AchievementCreateException{
		int result = AchievementManager.addAchievement(this);
		if(result == 1){
			this.achievementId = achievementId;
			this.message = message;
			this.title = title;
			return;
		}
		throw new AchievementCreateException();
	}
	
	public final String getTitle(){
		return title;
	}
	
	public final String getMessage(){
		return message;
	}
	
	public final String getAchievementId(){
		return achievementId;
	}
}