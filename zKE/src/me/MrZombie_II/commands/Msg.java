package me.MrZombie_II.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Msg implements CommandExecutor { 
	
	public static Map<String, String> msg = new HashMap<String, String>();
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		
		
		if(!(sender instanceof Player)){
			System.out.println("Error: Command Cannot be used in the console");
			return true;
		}
		
		Player player = (Player) sender;
		
		if(commandLabel.equalsIgnoreCase("msg") || (commandLabel.equalsIgnoreCase("tell") || (commandLabel.equalsIgnoreCase("whisper")))) {
			if(player.hasPermission("weed.msg")) {
				if(args.length == 0 || args.length == 1) {
					player.sendMessage(ChatColor.RED + "Error: Incorrect Syntax; /msg <player> <message>");
					return true;
				}
				
				if(args.length >= 2) {
					Player targetPlayer = Bukkit.getServer().getPlayer(args[0]);
					
					if(targetPlayer == null) {
						player.sendMessage(ChatColor.RED + "Error: Player " + args[0].toString() + " not found");
						return true;
					}
					
					if(me.MrZombie_II.commands.MutePlayer.mute.containsKey(player.getName())) {
						player.sendMessage(ChatColor.RED + "You are still muted!");
						return true;
					}
					
					if(!(player.canSee(targetPlayer))) {
						player.sendMessage(ChatColor.RED + "Error: Player " + args[0].toString() + " not found");
						return true;
					}
					
					List<String> l = new ArrayList<String>();
					for(Player p : Bukkit.getServer().getOnlinePlayers()) {
						if(p.hasPermission("weed.ss")) {
							l.add(p.getName());
						}
						
					}
					
					for(String s : l) {
						Player p = Bukkit.getServer().getPlayerExact(s);
						
						String reason = StringUtils.join(args, " ", 1, args.length);
						
						p.sendMessage(ChatColor.YELLOW + "[S] <" + player.getName() + " -> " + targetPlayer.getName() + "> " + reason);
						
					}
					
					String reason = StringUtils.join(args, " ", 1, args.length);
					targetPlayer.sendMessage(ChatColor.GRAY + "<" + player.getName() + " -> " + targetPlayer.getName() + "> " + reason);
					player.sendMessage(ChatColor.GRAY + "<" + player.getName() + " -> " + targetPlayer.getName() + "> " + reason);
					
							msg.remove(player.getName());
							msg.put(player.getName(), targetPlayer.getName());
							msg.remove(targetPlayer.getName());
							msg.put(targetPlayer.getName(), player.getName());
					
				
			} else {
				player.sendMessage(ChatColor.RED + "Error: No Permission");
			}
			}
		}
		
		
		
		return false;
		
	}
}
