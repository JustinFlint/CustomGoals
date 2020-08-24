package com.eavoron.sanchez;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;

public class CustomGoalObj {
	private String name;
	private int currentValue;
	private int goalValue;
	private boolean ascending;
	private List<String> goalCommands;
	
	public CustomGoalObj(String name, int startValue, int goalValue) {
		this.name = name;
		currentValue = startValue;
		this.goalValue = goalValue;
		if(startValue < goalValue) ascending = true;
		else ascending = false;
	}
	
	public void updateGoalValue(int updateValue) {
		currentValue += updateValue;
		if(ascending){
			if(currentValue > goalValue) completeGoal(); 
		}
		else {
			if(goalValue > currentValue) completeGoal();
		}
	}

	private void completeGoal() {
		ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
		for(int i=0; i<goalCommands.size(); i++) {
			Bukkit.dispatchCommand(console, goalCommands.get(i));
		}
	}
}
