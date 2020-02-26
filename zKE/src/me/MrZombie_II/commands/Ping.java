package me.MrZombie_II.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Ping implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		Player player = (Player) sender;
		if (commandLabel.equalsIgnoreCase("ping")) {
			if (player.hasPermission("weed.ping")) {
				
				if (args.length == 0) {
					
				int ping = ((CraftPlayer) player).getHandle().ping;
				player.sendMessage(ChatColor.GREEN + "Your Ping is: " + ping);
				}
				
				if (args.length == 1) {
					Player targetPlayer = Bukkit.getServer().getPlayer(args[0]);
					
					if(!(player.canSee(targetPlayer))) {
						player.sendMessage(ChatColor.RED + "Error: Player " + args[0].toString() + " not found");
						return true;
					}
					
					int ping = ((CraftPlayer) targetPlayer).getHandle().ping;
					player.sendMessage(ChatColor.GREEN + targetPlayer.getName() + "'s Ping is: " + ping);
					
				}
				
				
			} else {
				player.sendMessage(ChatColor.RED + "Error: No Permission");
			}
		}
		
		
		
		
		return false;
		
	}

}
