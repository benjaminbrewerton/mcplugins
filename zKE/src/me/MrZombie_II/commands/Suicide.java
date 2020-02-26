package me.MrZombie_II.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Suicide implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		Player player = (Player) sender;
		
		if (commandLabel.equalsIgnoreCase("suicide") || (commandLabel.equalsIgnoreCase("kill"))) {
				if (args.length == 0) {
					if (player.hasPermission("weed.kill")) {
				player.setHealth(0.0);
				player.sendMessage(ChatColor.GRAY +  "You has suicided!");
					} else {
						player.sendMessage(ChatColor.RED + "Error: No Permission");
					}
				}
				if (args.length == 1) {
					if (player.hasPermission("weed.kill.others")) {
						Player targetPlayer = Bukkit.getServer().getPlayer(args[0]);
						
						player.sendMessage(ChatColor.GREEN + "You killed " + targetPlayer.getName());
						targetPlayer.setHealth(0.0);
						targetPlayer.sendMessage(ChatColor.RED + "You were killed by " + player.getName());
					} else {
						player.sendMessage(ChatColor.RED + "Error: No Permission");
					}
				}
		}
		return false;
	}

}
