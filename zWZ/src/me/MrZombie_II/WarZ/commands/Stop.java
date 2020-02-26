package me.MrZombie_II.WarZ.commands;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;

import me.MrZombie_II.WarZ.func.WorldHandler;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Stop implements CommandExecutor {
	
	public static boolean GlobalLockdown = false;
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		sender.sendMessage(ChatColor.GREEN + "Stopping WarZ. \n Incoming Lag Spike.");
		Bukkit.broadcastMessage(ChatColor.RED + "Manually restarting server.");
		
		
		for(Player p : Bukkit.getOnlinePlayers()) {
			p.kickPlayer(ChatColor.RED + "Server restart issued by " + sender.getName());
			Bukkit.getWorld("world").save();
			p.saveData();
		}
		
		GlobalLockdown = true;
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getPluginManager().getPlugin("zWZ"), new Runnable() {

			@Override
			public void run() {
				WorldHandler.getWH().unloadWorld(Bukkit.getWorld("world"));
				WorldHandler.getWH().deleteWorld(Bukkit.getWorld("world").getWorldFolder());
				WorldHandler.getWH().copyWorld(Bukkit.getWorld("backup_world").getWorldFolder(), Bukkit.getWorld("world").getWorldFolder());
				
			}
			
		}, 80L);
		
		try {
			WorldHandler.getWH().copyPlayerData();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getPluginManager().getPlugin("zWZ"), new Runnable() {

			@Override
			public void run() {
				try {
					WorldHandler.getWH().RetrieveStoredPlayerData();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
			
		}, 120L);
		
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getPluginManager().getPlugin("zWZ"), new Runnable() {

			@Override
			public void run() {
				Bukkit.getServer().shutdown();
				
			}
			
		}, 60L);
		
		return false;
	}
}
