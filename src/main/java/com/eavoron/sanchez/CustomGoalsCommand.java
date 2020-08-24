package com.eavoron.sanchez;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CustomGoalsCommand implements CommandExecutor{
	private int goalValueArg, otherValueHolder;
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			 String[] args) {
		switch(args[0]) {
		case "new":
			if(args.length < 3) break;
			
			if((args[1] instanceof String))
			return true;

		case "update":
			
			return true;
		
		case "remove":
			
			return true;
		}
		return false;
	}
	
}
