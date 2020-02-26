package me.MrZombie_II.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UnKick implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(commandLabel.equalsIgnoreCase("uk") || (commandLabel.equalsIgnoreCase("unkick"))) {
			Player player = (Player) sender;
			if (player.hasPermission("weed.uk")) {
				
				if(!(args.length == 1)) {
					player.sendMessage(ChatColor.RED + "Error: Incorrect Syntax; /uk <player");
					
				}
				
				if (args.length == 1) {	
					
				OfflinePlayer targetPlayer = Bukkit.getServer().getOfflinePlayer(args[0]);
					
					
				if(targetPlayer == null) {
					player.sendMessage(ChatColor.RED + "Error: Player is not registered on server!");
					return true;
				}
				
				if(!me.MrZombie_II.commands.Kick.KickDur.containsKey(targetPlayer.getName()) || !me.MrZombie_II.commands.Kick.KickTime.containsKey(targetPlayer.getName())) {
					player.sendMessage(ChatColor.RED + "Error: Player is not temp-kicked!");
					return true;
				}
				
				me.MrZombie_II.commands.Kick.KickDur.remove(targetPlayer.getName());
				me.MrZombie_II.commands.Kick.KickTime.remove(targetPlayer.getName());
				player.sendMessage(ChatColor.GREEN + "Removed kick period for " + targetPlayer.getName());
				
				}
				
			} else {
				player.sendMessage(ChatColor.RED + "Error: No Permission");
			}
			
		}
		
		return false;
	}

}
