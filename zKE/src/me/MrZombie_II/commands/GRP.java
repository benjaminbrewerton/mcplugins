package me.MrZombie_II.commands;

import me.MrZombie_II.api.API;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GRP implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(commandLabel.equalsIgnoreCase("grp")) {
			if(!sender.hasPermission("weed.grp")) {
				sender.sendMessage(ChatColor.RED + "No more abuse for you :P");
				return true;
			}
			
			API api = new API();
			Player p = api.GenerateRandomPlayer();
			
			Bukkit.broadcastMessage(ChatColor.DARK_AQUA + "Randomed Player: " + ChatColor.RED + p.getName());
			
		}
		
		return false;
	}

}
