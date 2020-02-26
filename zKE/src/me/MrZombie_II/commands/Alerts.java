package me.MrZombie_II.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Alerts implements CommandExecutor {
	
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(commandLabel.equalsIgnoreCase("alerts") || (commandLabel.equalsIgnoreCase("a"))) {
			
			Player player = (Player) sender;
			
			if(!(player.hasPermission("weed.alert"))) {
				player.sendMessage(ChatColor.RED + "Error: No Permission");
				return true;
			}
			
			
			if(me.MrZombie_II.Listeners.ACListener.onlinestaff.contains(player.getName())) {
				
				me.MrZombie_II.Listeners.ACListener.onlinestaff.remove(player.getName());
				player.sendMessage(ChatColor.RED + "Alerts are now silent!");
				
				return true;
			}
			
			me.MrZombie_II.Listeners.ACListener.onlinestaff.add(player.getName());
			player.sendMessage(ChatColor.RED + "Alerts are now visible!");
		}
		
		
		
		return false;
		
	}

}
