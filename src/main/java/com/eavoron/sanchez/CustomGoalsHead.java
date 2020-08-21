package com.eavoron.sanchez;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomGoalsHead extends JavaPlugin{
    // Fired when plugin is first enabled
    @Override
    public void onEnable() {
        if(Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null){
            new CustomGoalsPAPIExpansion(this).register();
      }
    }
    // Fired when plugin is disabled
    @Override
    public void onDisable() {

    }
}
