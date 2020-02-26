package me.MrZombie_II.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Afk implements CommandExecutor {
	
	public static List<String> afkplayers = new ArrayList<String>();
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		Player player = (Player) sender;
		if (commandLabel.equalsIgnoreCase("afk")) {
			if (player.hasPermission("weed.afk")) {
				if (afkplayers.contains(player.getName())) {
					afkplayers.remove(player.getName());
					Bukkit.broadcastMessage(ChatColor.GREEN + "* " + player.getDisplayName() +  ChatColor.GRAY + " is no longer AFK" + ChatColor.GREEN+ " *");
					return true;
				} else {
				afkplayers.add(player.getName());
				Bukkit.broadcastMessage(ChatColor.GREEN + "* " + player.getDisplayName() +  ChatColor.GRAY + " is now AFK" + ChatColor.GREEN+ " *");
				}
			} else {
				player.sendMessage(ChatColor.RED + "Error: No Permission");
			}
		}
		return false;
	}


}
