package me.MrZombie_II.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Kits implements CommandExecutor{
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		Player player = (Player)sender;
		if (commandLabel.equalsIgnoreCase("kits")) {
			player.sendMessage(ChatColor.GRAY + "***" + ChatColor.GREEN + "WeedKits" + ChatColor.GRAY + "***");
		      player.sendMessage(ChatColor.AQUA + "Choose your kit now: " + ChatColor.GRAY + "/<kitname>");
		      player.sendMessage(ChatColor.WHITE + "Free: " + ChatColor.DARK_PURPLE + "PvP, Archer, SoupMaster, Knight, Elite");
		      player.sendMessage(ChatColor.YELLOW + "Ranger: " + ChatColor.DARK_PURPLE + "Fisherman, Sloth, Jumper, Snail, Enforcer");
		      player.sendMessage(ChatColor.GREEN + "Veteran: " + ChatColor.DARK_PURPLE + "Virus, Cheetah, Chemist, Pyro, Ghost");
		      player.sendMessage(ChatColor.DARK_AQUA + "Immortal: " + ChatColor.DARK_PURPLE + "Viper, Kangaroo, Ninja, Shield, Rabbit");
		      player.sendMessage(ChatColor.RED + "Coming Soon: " + ChatColor.GRAY + "Snake, Monk, Eagle, Robber, Sparta, Switcher, Flash, Dwarf, Freezer, Endermage, Grappler");
		    }
		return false;
	}
}
