package me.MrZombie_II.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Lock implements CommandExecutor {

	public static String lock = "NONE";
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(commandLabel.equalsIgnoreCase("lock")) {
			
			if(sender instanceof Player) {
			if(sender.hasPermission("weed.lock")) {
				if(args.length == 0) {
					sender.sendMessage(ChatColor.RED + "Error: Incorrect Syntax; /lock <Rank>");
					
				}
				
				if(args.length == 1) {
					if(args[0].equalsIgnoreCase("owner")) {
						
						lock = "OWNER";
						Bukkit.broadcastMessage(ChatColor.RED + "THE SERVER IS NOW LOCKED DOWN TO " + lock + " AND ABOVE. ALL LOWER RANKS, GTFO!");
					}
					if(args[0].equalsIgnoreCase("admin")) {
						
						lock = "ADMIN";
						Bukkit.broadcastMessage(ChatColor.RED + "THE SERVER IS NOW LOCKED DOWN TO " + lock + " AND ABOVE. ALL LOWER RANKS, GTFO!");
					}
					if(args[0].equalsIgnoreCase("modplus")) {
	
						lock = "MODPLUS";
						Bukkit.broadcastMessage(ChatColor.RED + "THE SERVER IS NOW LOCKED DOWN TO " + lock + " AND ABOVE. ALL LOWER RANKS, GTFO!");
					}
					if(args[0].equalsIgnoreCase("mod")) {
	
						lock = "MOD";
						Bukkit.broadcastMessage(ChatColor.RED + "THE SERVER IS NOW LOCKED DOWN TO " + lock + " AND ABOVE. ALL LOWER RANKS, GTFO!");
					}
					if(args[0].equalsIgnoreCase("immortal")) {
						lock = "IMMORTAL";
						Bukkit.broadcastMessage(ChatColor.RED + "THE SERVER IS NOW LOCKED DOWN TO " + lock + " AND ABOVE. ALL LOWER RANKS, GTFO!");
	
					}
					if(args[0].equalsIgnoreCase("veteran")) {
						lock = "VETERAN";
						Bukkit.broadcastMessage(ChatColor.RED + "THE SERVER IS NOW LOCKED DOWN TO " + lock + " AND ABOVE. ALL LOWER RANKS, GTFO!");
	
					}
					if(args[0].equalsIgnoreCase("ranger")) {
						lock = "RANGER";
						Bukkit.broadcastMessage(ChatColor.RED + "THE SERVER IS NOW LOCKED DOWN TO " + lock + " AND ABOVE. ALL LOWER RANKS, GTFO!");
	
					}
					if(args[0].equalsIgnoreCase("default")) {
						lock = "DEFAULT";
						Bukkit.broadcastMessage(ChatColor.RED + "THE SERVER IS NOW LOCKED DOWN TO " + lock + " AND ABOVE. ALL LOWER RANKS, GTFO!");
	
					}
					if(args[0].equalsIgnoreCase("none")) {
						lock = "NONE";
						Bukkit.broadcastMessage(ChatColor.RED + "THE SERVER IS NOW UNLOCKED!");
	
					}

					
				}
				
			}
			} else {
				if(args.length == 0) {
					sender.sendMessage(ChatColor.RED + "Error: Incorrect Syntax; /lock <Rank>");
					
				}
				
				if(args.length == 1) {
					if(args[0].equalsIgnoreCase("owner")) {
						
						lock = "OWNER";
						Bukkit.broadcastMessage(ChatColor.RED + "THE SERVER IS NOW LOCKED DOWN TO " + lock + " AND ABOVE. ALL LOWER RANKS, GTFO!");
					}
					if(args[0].equalsIgnoreCase("admin")) {
						
						lock = "ADMIN";
						Bukkit.broadcastMessage(ChatColor.RED + "THE SERVER IS NOW LOCKED DOWN TO " + lock + " AND ABOVE. ALL LOWER RANKS, GTFO!");
					}
					if(args[0].equalsIgnoreCase("modplus")) {
	
						lock = "MODPLUS";
						Bukkit.broadcastMessage(ChatColor.RED + "THE SERVER IS NOW LOCKED DOWN TO " + lock + " AND ABOVE. ALL LOWER RANKS, GTFO!");
					}
					if(args[0].equalsIgnoreCase("mod")) {
	
						lock = "MOD";
						Bukkit.broadcastMessage(ChatColor.RED + "THE SERVER IS NOW LOCKED DOWN TO " + lock + " AND ABOVE. ALL LOWER RANKS, GTFO!");
					}
					if(args[0].equalsIgnoreCase("immortal")) {
						lock = "IMMORTAL";
						Bukkit.broadcastMessage(ChatColor.RED + "THE SERVER IS NOW LOCKED DOWN TO " + lock + " AND ABOVE. ALL LOWER RANKS, GTFO!");
	
					}
					if(args[0].equalsIgnoreCase("veteran")) {
						lock = "VETERAN";
						Bukkit.broadcastMessage(ChatColor.RED + "THE SERVER IS NOW LOCKED DOWN TO " + lock + " AND ABOVE. ALL LOWER RANKS, GTFO!");
	
					}
					if(args[0].equalsIgnoreCase("ranger")) {
						lock = "RANGER";
						Bukkit.broadcastMessage(ChatColor.RED + "THE SERVER IS NOW LOCKED DOWN TO " + lock + " AND ABOVE. ALL LOWER RANKS, GTFO!");
	
					}
					if(args[0].equalsIgnoreCase("default")) {
						lock = "DEFAULT";
						Bukkit.broadcastMessage(ChatColor.RED + "THE SERVER IS NOW LOCKED DOWN TO " + lock + " AND ABOVE. ALL LOWER RANKS, GTFO!");
	
					}
					if(args[0].equalsIgnoreCase("none")) {
						lock = "NONE";
						Bukkit.broadcastMessage(ChatColor.RED + "THE SERVER IS NOW UNLOCKED!");
	
					}

					
				}
				
			}
			
		}
		
		return false;
	}
	
}
