package me.MrZombie_II.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gamemode implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		Player player = (Player) sender;
			if(commandLabel.equalsIgnoreCase("gm") || commandLabel.equalsIgnoreCase("gamemode")) {
				if(player.hasPermission("weed.gm")) {
				if(args.length == 0){
					player.sendMessage(ChatColor.RED + "Invalid Command Usage: /gm <0,1,2> [Player]");
				}
				
				if (args.length == 1) {
					if(args[0].equalsIgnoreCase("0")) {
						player.setGameMode(GameMode.SURVIVAL);
						player.sendMessage(ChatColor.RED + "Changed Gamemode to Survival!");
					}
					else if (args[0].equalsIgnoreCase("1")) {
						player.setGameMode(GameMode.CREATIVE);
						player.sendMessage(ChatColor.RED + "Changed Gamemode to Creative!");
					}
					else if (args[0].equalsIgnoreCase("2")) {
						player.setGameMode(GameMode.ADVENTURE);
						player.sendMessage(ChatColor.RED + "Changed Gamemode to Adventure!");
				}
				}
					
				if (args.length == 2) {
					if (player.hasPermission("weed.gm.others")) {
					Player targetPlayer = Bukkit.getServer().getPlayer(args[1]);
					if (targetPlayer == null) {
						player.sendMessage(ChatColor.RED + "Player cannot be found!");
						return true;
					}
					
					if(args[0].equalsIgnoreCase("0")) {
						targetPlayer.setGameMode(GameMode.SURVIVAL);
						player.sendMessage(ChatColor.RED + "Changed " + targetPlayer.getName() + ChatColor.RED + "'s Gamemode to Survival!");
					}
					else if (args[0].equalsIgnoreCase("1")) {
						targetPlayer.setGameMode(GameMode.CREATIVE);
						player.sendMessage(ChatColor.RED + "Changed " + targetPlayer.getName() +  ChatColor.RED + "'s Gamemode to Creative!");
					}
					else if (args[0].equalsIgnoreCase("2")) {
						targetPlayer.setGameMode(GameMode.ADVENTURE);
						player.sendMessage(ChatColor.RED + "Changed " + targetPlayer.getName() + ChatColor.RED + "'s Gamemode to Adventure!");
					}
					} else {
						player.sendMessage(ChatColor.RED + "Error: No Permission to change other's gamemodes");
					}
				}
		} 
		} else {
			player.sendMessage(ChatColor.RED + "Error: No Permission");
}
		return false;
		
	}
}