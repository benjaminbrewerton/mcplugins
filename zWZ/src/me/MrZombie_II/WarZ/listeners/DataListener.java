package me.MrZombie_II.WarZ.listeners;

import java.io.File;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.event.server.PluginEnableEvent;

import me.MrZombie_II.WarZ.api.ChestUtils;
import me.MrZombie_II.WarZ.api.Utils;
import me.MrZombie_II.WarZ.commands.Stop;
import me.MrZombie_II.WarZ.func.Cuboid;
import me.MrZombie_II.WarZ.func.ScoreboardUtil;
import me.MrZombie_II.WarZ.main.Main;

public class DataListener implements Listener {
	public Main plugin;
	
	public DataListener(Main main) {
		plugin = main;
	}

	//Create player file on first login
	@EventHandler
	public void DataHandler(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		
		File f = Utils.getUtils().getRawPlayerFile(player.getUniqueId());
		if(f.exists()) return;
		Utils.getUtils().CreatePlayerFile(player.getUniqueId());
		
	}
	
	//Cache player's name for optimization
	@SuppressWarnings("deprecation")
	@EventHandler
	public void UUIDConverter(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		
		final UUID u = player.getUniqueId();
		
		Bukkit.getServer().getScheduler().scheduleAsyncDelayedTask(Bukkit.getPluginManager().getPlugin("zWZ"), new Runnable() {

			@Override
			public void run() {
				Utils.getUtils().StoreFromUnknown(u);
				
			}
			
		}, 0L);
	}
	
	//Set a player's scoreboard when they join
	@EventHandler
	public void ScoreboardHandler(PlayerJoinEvent event) {
		final Player player = event.getPlayer();
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

			@Override
			public void run() {
				ScoreboardUtil uu = new ScoreboardUtil(player.getUniqueId());
				uu.setScoreboard();
			}
			
		}, 20L);
	}
	
	@EventHandler
	public void ChestHandler(PluginEnableEvent event) {
		if(event.getPlugin().getName().equals("zWZ")) {
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

				@Override
				public void run() {
					ChestUtils.getCU().CreateRandomChest(Bukkit.getWorld("world"));
					
				}
				
			}, 40L);
			
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

				@Override
				public void run() {
					ChestUtils.getCU().getChestsInWorld(Bukkit.getWorld("world"));
					
				}
				
			}, 10L);
		}
	}
	
	
	//Shutdown event
	@EventHandler(priority = EventPriority.NORMAL)
	public void ShutDownListener(PlayerLoginEvent event) {
		
		if(Stop.GlobalLockdown) {
			event.disallow(Result.KICK_OTHER, ChatColor.RED + "Server is restarting, try again in a bit.");
		}
	}
	
}
