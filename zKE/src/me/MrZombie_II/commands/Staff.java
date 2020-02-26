package me.MrZombie_II.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Staff implements CommandExecutor{
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		Player player = (Player)sender;
		if (commandLabel.equalsIgnoreCase("staff")) {
		      player.sendMessage(ChatColor.GREEN + "MinecrafWarZ - Staff!");
		      player.sendMessage(ChatColor.AQUA + "Mod: " + ChatColor.DARK_PURPLE + "");
		      player.sendMessage(ChatColor.AQUA + "Mod+: "+ ChatColor.DARK_PURPLE + ChatColor.ITALIC + "MxnkeyBoy, ThatsSoSquishy");
		      player.sendMessage(ChatColor.AQUA + "Admins: " + ChatColor.RED + ChatColor.ITALIC + " MrZombie_II");
		      player.sendMessage(ChatColor.AQUA + "Owner: " + ChatColor.DARK_RED + "_W33D_PvP");
		    }
		return false;
		
	}
}
