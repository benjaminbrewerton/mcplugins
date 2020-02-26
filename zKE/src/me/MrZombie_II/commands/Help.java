package me.MrZombie_II.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Help implements CommandExecutor{
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		Player player = (Player)sender;
		if (commandLabel.equalsIgnoreCase("help") || (commandLabel.equalsIgnoreCase("?") || (commandLabel.equalsIgnoreCase("ver") || (commandLabel.equalsIgnoreCase("version"))))) {
		      player.sendMessage(ChatColor.GREEN + "WeedKits - Help!");
		      player.sendMessage(ChatColor.GRAY + "/kill - Suicides you to your death!");
		      player.sendMessage(ChatColor.GRAY + "/rules - Lists the rules for Players!");
		      player.sendMessage(ChatColor.GRAY + "/staff - Lists the Staff Members!");
		      player.sendMessage(ChatColor.GRAY + "/spawn - Teleports you to Spawn!");
		    }
		return false;
	}
}
