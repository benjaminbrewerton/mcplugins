package me.MrZombie_II.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearChat implements CommandExecutor {
	
	public static me.MrZombie_II.main.Main plugin;
	
	public static List<String> chattoggler = new ArrayList<String>();
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		Player player = (Player) sender;
	if (commandLabel.equalsIgnoreCase("tc")) {
    	if (player.hasPermission("weed.tc")) {
    		if(chattoggler.contains("chatoff")) {
				 chattoggler.remove("chatoff");
				 Bukkit.broadcastMessage(ChatColor.RED + "Chat has been unmuted by" + " " + player.getDisplayName());
				 return true;
		 }
			 chattoggler.add("chatoff");
			 Bukkit.broadcastMessage(ChatColor.RED + "Chat has been muted by" + " " + player.getDisplayName());
    	}
    } else {
    	player.sendMessage(ChatColor.RED + "You don't have permission to do this");
    }
	return false;
}
}
