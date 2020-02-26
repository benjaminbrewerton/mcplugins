package me.MrZombie_II.commands;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Stats implements CommandExecutor {


	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		if(commandLabel.equalsIgnoreCase("stats")) {
			Player player = (Player) sender;
			
			
			
			if(player.hasPermission("weed.stats")) {
				if (!((args.length == 0) || (args.length == 1))) {
					player.sendMessage(ChatColor.RED + "Error: Incorrect Syntax; /stats <player");
					return true;
				}
				
				if(args.length == 0) {
					
					File f = new File(Bukkit.getServer().getPluginManager().getPlugin("zWE").getDataFolder() + File.separator + "userdata" + File.separator + player.getName() + ".yml");
					final FileConfiguration cfg = YamlConfiguration.loadConfiguration(f);
					
					int kills = cfg.getInt("kills");
					int deaths = cfg.getInt("deaths");
					int credits = cfg.getInt("credits");
					
					if(kills == 0) {
					kills = 1;
					}
					if(deaths == 0) {
					deaths = 1;
					}
						
					
					
					float kd = kills / deaths;
					
					player.sendMessage(ChatColor.RED + player.getName() + "'s Stats:");
					player.sendMessage(ChatColor.GRAY + "Kills: " + kills);
					player.sendMessage(ChatColor.GRAY + "Deaths: " + deaths);
					player.sendMessage(ChatColor.GRAY + "Credits: " + credits);
					player.sendMessage(ChatColor.GRAY + "K/D: " + kd);
					
				}
				
				if(args.length == 1) {
					Player target = Bukkit.getServer().getPlayer(args[0]);
					
					if(target == null) {
						player.sendMessage(ChatColor.RED + "Error: Player '" + args[0].toString() + "' not found!");
						return true;
					}
					
					File f = new File(Bukkit.getServer().getPluginManager().getPlugin("zWE").getDataFolder() + File.separator + "userdata" + File.separator + target.getName() + ".yml");
					final FileConfiguration cfg = YamlConfiguration.loadConfiguration(f);
					
					int kills = cfg.getInt("kills");
					int deaths = cfg.getInt("deaths");
					int credits = cfg.getInt("credits");
					
					if(kills == 0) {
						kills = 1;
						}
						if(deaths == 0) {
						deaths = 1;
						}
							
					
						float kd = kills / deaths;
					
					player.sendMessage(ChatColor.RED + target.getName() + "'s Stats:");
					player.sendMessage(ChatColor.GRAY + "Kills: " + kills);
					player.sendMessage(ChatColor.GRAY + "Deaths: " + deaths);
					player.sendMessage(ChatColor.GRAY + "Credits: " + credits);
					player.sendMessage(ChatColor.GRAY + "K/D: " + kd);
					
				}
				
			}
			
			
		}
		
		
		return false;
	}
	
	

}
