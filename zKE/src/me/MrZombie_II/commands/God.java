package me.MrZombie_II.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class God implements CommandExecutor {
	
	
	public static List<String> GP = new ArrayList<String>();
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		Player player = (Player) sender;
		if (commandLabel.equalsIgnoreCase("god")) {
			if(GP.contains(player.getName())) {
				GP.remove(player.getName());
				player.sendMessage(ChatColor.GREEN + "God Mode disabled!");
			} else {
				GP.add(player.getName());
				player.sendMessage(ChatColor.GREEN + "God Mode enabled!");
			}
			
			
		}
		
		return false;
		
	}

}
