package me.MrZombie_II.commands;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MutePlayer implements CommandExecutor {
	public static me.MrZombie_II.main.Main plugin;
	
	public static HashMap<String, Long> mute = new HashMap<String, Long>();
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
        Player player = (Player) sender;
        
        
        
        		 
        		 
        		 
 	        	if (commandLabel.equalsIgnoreCase("mute")){
 	        		
 	        		if(player.hasPermission("weed.mute")) {
 	        			
 	        		if(!(args.length == 1)) {
 	        			player.sendMessage(ChatColor.RED + "Error: Incorrect Syntax; /mute <player>");
 	        			
 	        			return true;
 	        		}
 	        		
 	        		 if (args.length == 1) {
 	        			Player targetPlayer = Bukkit.getServer().getPlayer(args[0]);
 	        			
 	        			if(targetPlayer == null ) {
 	        				player.sendMessage(ChatColor.RED + "Error: '" + args[0].toString() + "' not found!");
 	        				return true;
 	        			}
 	        			
 	        			if(mute.containsKey(targetPlayer.getName())) {
 	        				mute.remove(targetPlayer.getName());
 	        				player.sendMessage(ChatColor.AQUA + "You unmuted: " + targetPlayer.getName());
 	        				return true;
 	        			}
 	        			
 	        			
 	        			player.sendMessage(ChatColor.GREEN + "You have muted: " + targetPlayer.getName());
 	        			targetPlayer.sendMessage(ChatColor.AQUA + "You have been muted by " + player.getName() + " for 10 minutes!");
 	        			mute.put(targetPlayer.getName(), System.currentTimeMillis());
 	        			

 	        	}
 	        		} else {
 	        			player.sendMessage(ChatColor.RED + "Error: No Permission");
 	        		}
 
} 
 	        	return true;
	
}
}
