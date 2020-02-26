package me.MrZombie_II.commands;

import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlySpeed implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(commandLabel.equalsIgnoreCase("fs") || (commandLabel.equalsIgnoreCase("flyspeed"))) {
			Player player = (Player) sender;
			if (player.hasPermission("weed.fs")) {
				
				if (!(args.length == 1)) {
					player.sendMessage(ChatColor.RED + "Error: Incorrect Syntax");
					player.sendMessage(ChatColor.GRAY + "Example: /fs 1-10");
					return true;
				}
				
				if (!(StringUtils.isNumeric(args[0]))) {
					player.sendMessage(ChatColor.RED + "Error: Incorrect Syntax");
					player.sendMessage(ChatColor.GRAY + "Example: /fs 1-10");
					return true;
				}
				
				float i = Integer.parseInt(args[0]);
				
				
				
				player.setFlySpeed(i / 10);
				player.sendMessage(ChatColor.GREEN + "Successfully changed flight speed to: " + i / 10);
				
				
						
				
			} else {
				player.sendMessage(ChatColor.RED + "Error: No Permission");
			}
			
			
			
		}
		
		return false;
		
	}

}
