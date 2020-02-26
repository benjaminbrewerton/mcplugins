package me.MrZombie_II.commands;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Pardon implements CommandExecutor {
	public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(me.MrZombie_II.main.BanConfig.BanFile());

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		if (commandLabel.equalsIgnoreCase("unban")) {
			
			if (!(sender instanceof Player)) {
				if (args.length == 0) {
					System.out.println(ChatColor.RED + "Error: Wrong Syntax: /unban <player>");
					System.out.println(ChatColor.DARK_RED + "" + ChatColor.BOLD + "OFFLINE UNBANS ARE CASE SENSITIVE");
				}
				
				if (args.length == 1) {
					Player targetPlayer = Bukkit.getServer().getPlayer(args[0]);
					
					if (targetPlayer == null) {
						
						String altarg = args[0];
						OfflinePlayer offplayer = Bukkit.getServer().getOfflinePlayer(args[0]);
						
						if (offplayer.isBanned()) {
						cfg.set(altarg + "banr", "nb");
						cfg.set(altarg + "banp", "nb");
						
						try {
							cfg.save(me.MrZombie_II.main.BanConfig.BanFile());
						} catch (IOException e) {
							e.printStackTrace();
						}
						
						offplayer.setBanned(false);
						
						System.out.println(ChatColor.RED + "" + ChatColor.BOLD + "You have unbanned " + altarg);
						} else {
							System.out.println("Error: Player is not banned!");
						}
						if (args.length >= 2) {
							System.out.println(ChatColor.RED + "Error: Wrong Syntax: /unban <player>");
							System.out.println(ChatColor.DARK_RED + "" + ChatColor.BOLD + "OFFLINE UNBANS ARE CASE SENSITIVE");
						}
						
						
						return true;
						
					}
					
					if (targetPlayer.isBanned()) {
					cfg.set(targetPlayer.getName() + "banr", "nb");
					cfg.set(targetPlayer.getName() + "banp", "nb");
					
					try {
						cfg.save(me.MrZombie_II.main.BanConfig.BanFile());
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					targetPlayer.setBanned(false);
					System.out.println(ChatColor.RED + "" + ChatColor.BOLD + "You have unbanned " + targetPlayer.getName());
					}
					else {
						System.out.println("Error: Player is not banned!");
					}
					
				}
				
				
				return true;
			}
			
			
			
			Player player = (Player) sender;
			if (player.hasPermission("weed.unban")) {
				if (args.length == 0) {
					player.sendMessage(ChatColor.RED + "Error: Wrong Syntax: /unban <player>");
					player.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "OFFLINE UNBANS ARE CASE SENSITIVE");
				}
				
				if (args.length == 1) {
					Player targetPlayer = Bukkit.getServer().getPlayer(args[0]);
					
					if (targetPlayer == null) {
						
						String altarg = args[0];
						OfflinePlayer offplayer = Bukkit.getServer().getOfflinePlayer(args[0]);
						
						if (offplayer.isBanned()) {
						
						cfg.set(altarg + ".banb", "nb");
						cfg.set(altarg + ".banr", "nb");
						
						try {
							cfg.save(me.MrZombie_II.main.BanConfig.BanFile());
						} catch (IOException e) {
							e.printStackTrace();
						}
						
						
						offplayer.setBanned(false);
						
						player.sendMessage(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "You have unbanned " + altarg);
						} else {
							player.sendMessage(ChatColor.RED + "Error: Player is not banned!");
						}
						return true;
					}
					
					if (targetPlayer.isBanned()) {
					
						cfg.set(targetPlayer.getName() + ".banb", "nb");
						cfg.set(targetPlayer.getName() + ".banr", "nb");
					
					try {
						cfg.save(me.MrZombie_II.main.BanConfig.BanFile());
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					targetPlayer.setBanned(false);
					player.sendMessage(ChatColor.DARK_AQUA + ""  + "You have unbanned" + targetPlayer.getName());
					}
					
					else {
						player.sendMessage(ChatColor.RED + "Error: Player is not banned!");
					}
					
				}
				if (args.length >= 2) {
					player.sendMessage(ChatColor.RED + "Error: Wrong Syntax: /unban <player>");
					player.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "OFFLINE UNBANS ARE CASE SENSITIVE");
				}
				
				
			} else {
				player.sendMessage(ChatColor.RED + "Error: No Permission");
			}
		}
		
		return false;
		
	}

	
	
}
