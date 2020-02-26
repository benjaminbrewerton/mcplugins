package me.MrZombie_II.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Rules implements CommandExecutor{
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		Player player = (Player)sender;
		if (commandLabel.equalsIgnoreCase("rules")) {
		      player.sendMessage(ChatColor.GREEN + "WeedKits - Rules!");
		      player.sendMessage(ChatColor.RED + "NO HACKING! THIS INCLUDES FLYING, FORCEFIELD, AIMBOT, ETC.");
		    }
		return false;
	}
}
