package com.eavoron.sanchez;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
//Data structure for CustomGoals
public class CustomGoalObj {
	/*
	 * name = name of goal
	 * current value = numerical indicator of progress
	 * goal value = number the current value needs to meet in order to finish goal
	 * ascending = true if progression for the current value is in an ascending direction
	 * goalCommands = commands to execute once goal finishes.
	 */
	private String name;
	private int currentValue;
	private int goalValue;
	private boolean ascending;
	private List<String> goalCommands;
	
	//Constructor for a CustomGoal, expected to only be executed by server admins
	public CustomGoalObj(String name, int startValue, int goalValue) {
		this.name = name;
		currentValue = startValue;
		this.goalValue = goalValue;
		if(startValue < goalValue) ascending = true;
		else ascending = false;
	}
	//Returns name of string
	public String getName() {
		return name;
	}
	//Updates the current value of a goal, executes completeGoal if target value is met
	public void updateGoalValue(int updateValue) {
		currentValue += updateValue;
		if(ascending){
			if(currentValue > goalValue) completeGoal(); 
		}
		else {
			if(goalValue > currentValue) completeGoal();
		}
	}
	//Runs goalCommands once run
	private void completeGoal() {
		ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
		for(int i=0; i<goalCommands.size(); i++) {
			Bukkit.dispatchCommand(console, goalCommands.get(i));
		}
	}
}
