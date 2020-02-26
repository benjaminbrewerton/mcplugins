package me.MrZombie_II.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.PluginCommand;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginEnableEvent;


public class BroadcastListener implements Listener {
	
	public static me.MrZombie_II.main.Main plugin;
	public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(me.MrZombie_II.main.Config.File());

	public BroadcastListener(me.MrZombie_II.main.Main main) {
		plugin = main;
	}
	
	@EventHandler
	public void BroadcasterStart (PluginEnableEvent event) {
		
		
		if(event.getPlugin().getName().equals("zWE")) {
			Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
				public int Timer = 0;
				@Override
				public void run() {
	                            if (Timer == 0){
	                            	String m1 = cfg.getString("Message1");
	                            	
	                            	Bukkit.broadcastMessage(m1);
	                            }
	                            if (Timer == 1){
	                            	String m2 = cfg.getString("Message2");
	                            	
	                            	Bukkit.broadcastMessage(m2);
	                            }
	                            if (Timer == 2){
	                            	String m3 = cfg.getString("Message3");
	                            	
	                            	
	                            	Bukkit.broadcastMessage(m3);
	                            }
	                            if (Timer == 3) {
	                            	String m4 = cfg.getString("Message4");
	                            	
	                            	Bukkit.broadcastMessage(m4);
	                            	
	                            	Timer = -1;
	                            }
	                            Timer++;
	                    }
				
		
				
				
				
			}, 0L, 40 * 20);
			
			Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {

				@Override
				public void run() {
					me.MrZombie_II.Listeners.ACListener.fp.clear();
					
				}
			
		}, 40L, 40L);
			
			Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {

				@Override
				public void run() {
					me.MrZombie_II.Listeners.ACListener.lc.clear();
					
				}
			
		}, 40L, 40L);
			
	}
		
	}
}
