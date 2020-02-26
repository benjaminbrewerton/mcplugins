package me.MrZombie_II.commands;

import java.util.HashMap;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Kick implements CommandExecutor{
	
	public static HashMap<String, Long> KickTime = new HashMap<String, Long>();
	public static HashMap<String, Integer> KickDur = new HashMap<String, Integer>();
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		Player player = (Player) sender;
		
		
		
		if(player.hasPermission("weed.kick")) {
			if(commandLabel.equalsIgnoreCase("kick")) {
				if(!(args.length == 1 || args.length >= 2)) {
					player.sendMessage(ChatColor.RED + "Incorrect Usage: /kick <player> [Time (mins) ]");
					player.sendMessage(ChatColor.GRAY + "Example: /kick MrZombie_II 5 // /kick MrZombie_II This is a test");
					return true;
				}
				
				if (args.length == 1) {
					Player targetPlayer = Bukkit.getPlayer(args[0]);
					targetPlayer.kickPlayer(ChatColor.RED + "Kicked by " + ChatColor.ITALIC + player.getName());
					Bukkit.broadcastMessage(ChatColor.GREEN + "" + targetPlayer.getName() + "was kicked by " + player.getName());
				}
				
				if (args.length >= 2) {
					String KickArg = args[1];
					Player targetPlayer = Bukkit.getPlayer(args[0]);
					if (StringUtils.isNumeric(KickArg)) {
						
						
						
						int ki = (Integer.parseInt(args[1]));
						int kii = ki * 60;
						
						KickTime.put(targetPlayer.getName(), System.currentTimeMillis());
						KickDur.put(targetPlayer.getName(), kii);
						
						targetPlayer.kickPlayer(ChatColor.RED + "Kicked by " + ChatColor.ITALIC + player.getName() + " for " + ki + " minutes");
						Bukkit.broadcastMessage(ChatColor.GREEN + targetPlayer.getName() + " was kicked by " + player.getName() + " for "  + ki + " minutes!");
						
						
					} else if (!(StringUtils.isNumeric(KickArg))) {
						
						String reason = StringUtils.join(args, " ", 1, args.length);
						 targetPlayer.kickPlayer(ChatColor.RED + "Kicked for " + reason.toString() + ChatColor.ITALIC + " by " + player.getName());
						 
							Bukkit.broadcastMessage(ChatColor.GREEN + "" + targetPlayer.getName() + " was kicked by " + player.getName() + " for " + reason.toString() );
						
					}
				}
			}
		}
		
		
		return false;
		
	}
	
	
}
