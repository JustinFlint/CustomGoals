package com.eavoron.sanchez;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.eavoron.sanchez.CustomGoalsHead.CustomGoalsIO;
/*
 * Handles the event triggered when /customgoals is run
 * 
 * Has different behavior based on the first parameter ran with command
 * 
 * New: Creates a new custom goal with the parameters GoalName, StartValue, and GoalValue
 * 
 * Update: Expects parameters GoalName and UpdateValue, 
 * changes the goals current value based on the update value provided
 *
 * Remove: Deletes all data for the provided GoalName
 */
public class CustomGoalsCommand implements CommandExecutor{
	
	//Expected command format: /customgoals (command type) (goal name) (num1) (num2)
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			 String[] args) {
		switch(args[0]) {
		case "new":
			if(args.length < 3) break;
			if(!(tryParseInt(args[2]) && tryParseInt(args[3]))) break;
			
			CustomGoalsIO.loadedGoals.add(new CustomGoalObj(args[1],
			Integer.parseInt(args[2]),Integer.parseInt(args[3])));
			
			return true;

		case "update":
			if(args.length < 2) break;
			if(!tryParseInt(args[2])) break;
			
			CustomGoalObj goalHolderUpdate = CustomGoalsIO.goalSearch(args[1]);
			if(goalHolderUpdate == null) break;
			
			goalHolderUpdate.updateGoalValue(Integer.parseInt(args[2]));
			return true;
		
		case "remove":
			CustomGoalsIO.goalRemove(args[1]);
			return true;
		}
		return false;
	}
	//Checks if a string can be parsed into an integer
	private boolean tryParseInt(String tester) {
		try {
			Integer.parseInt(tester);
			return true;
		}
		catch(NumberFormatException e){
			return false;
		}
	}
	
}
