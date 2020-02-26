package me.MrZombie_II.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Broadcast implements CommandExecutor{
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if (commandLabel.equalsIgnoreCase("bc") || (commandLabel.equalsIgnoreCase("bcast"))) {
			Player player = (Player) sender;
			
			
			if (player.hasPermission("weed.bc")) {
				
				if(args.length < 1) {
					player.sendMessage(ChatColor.RED + "Error: Incorrect Syntax; /bc <String>");
					return true;
				}
				
				 StringBuilder msg = new StringBuilder();
				 for (int i = 0; i < args.length; i++) {
			            msg.append(args[i]);
			            if (i < args.length - 1) {
			              msg.append(" ");
			            }
			          }
				 
				 String bcmsg = ChatColor.GRAY + "[" + ChatColor.GREEN + "MinecraftWarZ" + ChatColor.GRAY + "] " + ChatColor.AQUA + msg;
				 
				String bcmsgcolour = ChatColor.translateAlternateColorCodes('&', bcmsg);
				
				Bukkit.broadcastMessage(bcmsgcolour);
				
			} else {
				player.sendMessage(ChatColor.RED + "Error: No Permissions");
			}
		}
		
		
		
		
		return false;
		
	}

}
