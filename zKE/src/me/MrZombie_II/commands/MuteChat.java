package me.MrZombie_II.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MuteChat implements CommandExecutor {
	public static me.MrZombie_II.main.Main plugin;

	
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		Player player = (Player) sender;
		 if (commandLabel.equalsIgnoreCase("cc")) {
		    	if (player.hasPermission("weed.cc")) {
		    		for (int i = 0; i < 100; i++) {
		    			Bukkit.broadcastMessage(" ");
		    		}
		    		Bukkit.broadcastMessage(ChatColor.RED + player.getDisplayName() + " " + ChatColor.RESET + ChatColor.BLUE + "Has cleared the chat!");
		    	} else {
		    		player.sendMessage(ChatColor.RED + "You don't have permissions to do this!");
		    	}
		    }
		return false;
}
}
