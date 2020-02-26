package me.MrZombie_II.commands;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Ban implements CommandExecutor {
	public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(me.MrZombie_II.main.BanConfig.BanFile());

	public static me.MrZombie_II.main.CheckConfig check;
	

	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		
		if (!(sender instanceof Player)) {
			if (args.length <= 1) {
				System.out.println(ChatColor.RED + "Error: Wrong Syntax: /ban <player> <reason>");
				System.out.println(ChatColor.GRAY + "Eg. /ban MrZombie_II cheating ff/autosoup");
				System.out.println(ChatColor.GRAY + "OFFLINE BAN NAMES NEED TO BE EXACT");
			}
			
			
			if (args.length >= 2) {
				
				Player targetPlayer = (Player) Bukkit.getServer().getPlayer(args[0]);
				
				if (targetPlayer == null) {
					
					
					String altarg = args[0];
					
					 OfflinePlayer offplayer = Bukkit.getServer().getOfflinePlayer(args[0]);
					 
					 me.MrZombie_II.Listeners.ACListener.ab.remove(offplayer.getName());
					 
					 StringBuilder banmsg = new StringBuilder();
				        for (int i = 1; i < args.length; i++){
				            banmsg.append(args[i] + " ");
				        }
					 
					 //get the date
					 DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
					   Date date = new Date();
					   
					   dateFormat.format(date);
					 
					 offplayer.setBanned(true);
					 
					 
					 
						 Bukkit.broadcastMessage(ChatColor.GRAY + altarg + " has been banned");
					 
					 cfg.set(altarg + ".banr", banmsg.toString());
					 cfg.set(altarg + ".banb", "Console");
					 try {
						cfg.save(me.MrZombie_II.main.BanConfig.BanFile());
					} catch (IOException e) {
						e.printStackTrace();
					} 
					 
					 return true;
				}
				
				

				me.MrZombie_II.Listeners.ACListener.ab.remove(targetPlayer.getName());
				 
				 
				 if(targetPlayer.hasPermission("weed.ban")) {
					 System.out.println(ChatColor.RED + "Error: Player is also staff!");
					 return true;
				 }
				 
				 StringBuilder banmsg = new StringBuilder();
			        for (int i = 1; i < args.length; i++){
			            banmsg.append(args[i] + " ");
			        }
				 
				 
					 Bukkit.broadcastMessage(ChatColor.GRAY + targetPlayer.getName() + " has been banned");
				 
				 cfg.set(targetPlayer.getName() + ".banr", banmsg.toString());
				 cfg.set(targetPlayer.getName() + ".banb", "Console");
				 targetPlayer.setBanned(true);
				 targetPlayer.kickPlayer(ChatColor.RED + "" + ChatColor.BOLD + "You have been banned for " + banmsg.toString());
				 try {
					cfg.save(me.MrZombie_II.main.BanConfig.BanFile());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return true;
		}
		
		Player player = (Player) sender;
		if (commandLabel.equalsIgnoreCase("ban")) {
			if (player.hasPermission("weed.ban")) {
				
				
				if (args.length <= 1) {
					player.sendMessage(ChatColor.RED + "Error: Wrong Syntax: /ban <player> <reason>");
					player.sendMessage(ChatColor.GRAY + "Eg. /ban MrZombie_II cheating ff/autosoup");
					player.sendMessage(ChatColor.GRAY + "OFFLINE BAN NAMES NEED TO BE EXACT");
				}
				
				if (args.length >= 2) {
					
					Player targetPlayer = (Player) Bukkit.getServer().getPlayer(args[0]);
					
					if (targetPlayer == null) {
						
						String altarg = args[0];
						
						
						 OfflinePlayer offplayer = Bukkit.getServer().getOfflinePlayer(args[0]);
						 
						 me.MrZombie_II.Listeners.ACListener.ab.remove(offplayer.getName());
						 
						 StringBuilder banmsg = new StringBuilder();
					        for (int i = 1; i < args.length; i++){
					            banmsg.append(args[i] + " ");
					        }
						 
						 
						 
						 offplayer.setBanned(true);
						 
						 
						 if (me.MrZombie_II.commands.Vanish.vanished.contains(player.getName())) {
							 for (String s : me.MrZombie_II.Listeners.ACListener.onlinestaff) {
								 Player p = Bukkit.getServer().getPlayerExact(s);
								 p.sendMessage(ChatColor.GRAY + altarg + " has been banned");
							 } 
							 
						 } else {
							 Bukkit.broadcastMessage(ChatColor.GRAY + altarg + " has been banned");
						 }
						 
						 cfg.set(altarg + ".banr", banmsg.toString());
						 cfg.set(altarg + ".banb", player.getName());
						 try {
							cfg.save(me.MrZombie_II.main.BanConfig.BanFile());
						} catch (IOException e) {
							e.printStackTrace();
						}
						 
						 return true;
					}
					
					

					 
					 
					 
					 if(targetPlayer.hasPermission("weed.ban")) {
						 player.sendMessage(ChatColor.RED + "Error: Player is also staff!");
						 return true;
					 }
					 
					 me.MrZombie_II.Listeners.ACListener.ab.remove(player.getName());
					 
					 StringBuilder banmsg = new StringBuilder();
				        for (int i = 1; i < args.length; i++){
				            banmsg.append(args[i] + " ");
				        }
					 
					 
					 if (me.MrZombie_II.commands.Vanish.vanished.contains(player.getName())) {
						 for (String s : me.MrZombie_II.Listeners.ACListener.onlinestaff) {
							 Player p = Bukkit.getServer().getPlayerExact(s);
							 p.sendMessage(ChatColor.GRAY + targetPlayer.getName() + " has been banned");
						 }
					 } else {
						 Bukkit.broadcastMessage(ChatColor.GRAY + targetPlayer.getName() + " has been banned");
					 }
					 
					 cfg.set(targetPlayer.getName() + ".banr", banmsg.toString());
					 cfg.set(targetPlayer.getName() + ".banb", player.getName());
					 targetPlayer.setBanned(true);
					 targetPlayer.kickPlayer(ChatColor.RED + "" + ChatColor.BOLD + "You have been banned for " + banmsg.toString());
					 try {
						cfg.save(me.MrZombie_II.main.BanConfig.BanFile());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} else {
				player.sendMessage(ChatColor.RED + "Error: No Permission");
			}
		}
		
		return false;
	}


}
