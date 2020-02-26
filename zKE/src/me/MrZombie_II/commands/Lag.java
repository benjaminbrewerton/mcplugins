package me.MrZombie_II.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Lag implements CommandExecutor {
	

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) { 
		
		Player player = (Player) sender;
		if(commandLabel.equalsIgnoreCase("lag") || commandLabel.equalsIgnoreCase("me")) {
			if(player.hasPermission("weed.lag")) {
				
				double tps = me.MrZombie_II.api.Lag.getTPS();
			      double lag = Math.round((1.0D - tps / 20.0D) * 100.0D);

			      sender.sendMessage(ChatColor.GREEN + "Server running at " + tps + " tps");
			      sender.sendMessage(ChatColor.GREEN + "Lag is approx " + lag + "%");
				
				
			} else {
				player.sendMessage(ChatColor.RED + "Error: No Permission");
			}
			
		}
		
		return false;
	}
	
}
