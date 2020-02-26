package me.MrZombie_II.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

public class Inv implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		
		if(!(sender instanceof Player)) {
			System.out.println("Error: Command Must be used Ingame!");
			return true;
		}
		
		
		Player player = (Player) sender;
		if (commandLabel.equalsIgnoreCase("inv")) {
			if (player.hasPermission("weed.inv")) {
				if (args.length == 0) {
					player.sendMessage(ChatColor.RED + "Error: Wrong Syntax: /inv <player>");
					}
				if (args.length == 1) {
					Player targetPlayer = Bukkit.getServer().getPlayer(args[0]);
					
					PlayerInventory ti = targetPlayer.getInventory();
					
					
					
					player.openInventory(ti);
					
					
					if(player.hasPermission("weed.inv.change") ) {
						
					}
					
					
				}
				
				if (args.length >= 2) {
					player.sendMessage(ChatColor.RED + "Error: Wrong Syntax: /inv <player>");
				}
				
				} else {
					player.sendMessage(ChatColor.RED + "Error: NO Permission");
				}
			}
		
		return false;
		
	}

}


