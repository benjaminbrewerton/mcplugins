package me.MrZombie_II.core;

import me.MrZombie_II.zEV.main.Main;
import me.confuser.barapi.BarAPI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class GeneralListener implements Listener {
	
	public Main plugin;
	
	public GeneralListener(Main main) {
		this.plugin = main;
	}
	

	@EventHandler
	public void WitherImplmentation (PlayerJoinEvent event) {
		final Player player = event.getPlayer();
		
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("zEV"), new Runnable() {

			@Override
			public void run() {
				BarAPI.setMessage(player, ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Welcome to CreditZ!");
				
			}
			
		}, 80L);
		
	}

}
