package me.MrZombie_II.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Info implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		Player player = (Player)sender;
		if (commandLabel.equalsIgnoreCase("ip") || (commandLabel.equalsIgnoreCase("server"))) {
			player.sendMessage(ChatColor.GRAY + "Server IP " + ChatColor.GREEN + "us.MinecraftWarZ.com");
		} 
		
		
		
		return false;
		
	}
}
