package com.He.W.onebone.circuit.cu.achievement;

import com.He.W.onebone.circuit.cu.exception.AchievementCreateException;

public class GettingStartedAchievement extends Achievement{
	public GettingStartedAchievement() throws AchievementCreateException{
		super("getting_started", "Getting started", "The first of the game");
	}
}