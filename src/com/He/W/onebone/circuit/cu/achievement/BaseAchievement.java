package com.He.W.onebone.circuit.cu.achievement;

abstract public class BaseAchievement {
	private String message, title, achievementId;
	private boolean success;
	
	public BaseAchievement(String achievementId, String title, String message){
		int result = AchievementManager.addAchievement(achievementId, this);
		if(result == 1){
			this.achievementId = achievementId;
			this.message = message;
			this.title = title;
			success = true;
			return;
		}
		success = false;
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
	
	public final boolean isSuccessfullyCreated(){
		return success;
	}
}