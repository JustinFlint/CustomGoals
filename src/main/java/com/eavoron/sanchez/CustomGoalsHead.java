package com.eavoron.sanchez;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomGoalsHead extends JavaPlugin{
    // Fired when plugin is first enabled
    @Override
    public void onEnable() {
        if(Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null){
            new CustomGoalsPAPIExpansion(this).register();
      }
        //register the command to minecraft
        this.getCommand("customgoals").setExecutor(new CustomGoalsCommand());    
        
    }
    // Fired when plugin is disabled
    @Override
    public void onDisable() {

    }
    //Class to handle loading and unloading of customGoals
    public static class CustomGoalsIO{
    	//List of all current goals
    	public static List<CustomGoalObj> loadedGoals;
    	//Check list of loaded goals to see if one exists with the given goalname 
    	public static CustomGoalObj goalSearch(String goalName) {
    		for(int i = 0; i < loadedGoals.size(); i++) {
    			if(loadedGoals.get(i).getName() == goalName) return loadedGoals.get(i);
    		}
    		return null;
    	}
    	//Check list of loaded goals to see if one matches given name, if exists, remove from list
    	public static boolean goalRemove(String goalName) {
    		for(int i = 0; i < loadedGoals.size(); i++) {
    			if(loadedGoals.get(i).getName() == goalName) {
    				loadedGoals.remove(i);
    				return true;
    			}
    		}
    		return false;
    	}
    }
}
