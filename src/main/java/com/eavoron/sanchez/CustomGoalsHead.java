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
        this.getCommand("customgoals").setExecutor(new CustomGoalsCommand());    
        
    }
    // Fired when plugin is disabled
    @Override
    public void onDisable() {

    }
    
    public static class CustomGoalsIO{
    	public static List<CustomGoalObj> loadedGoals;
    }
}
