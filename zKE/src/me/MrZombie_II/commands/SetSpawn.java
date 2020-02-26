package me.MrZombie_II.commands;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawn implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if(commandLabel.equalsIgnoreCase("setspawn")) {
			Player player = (Player) sender;
			if(player.hasPermission("weed.setspawn")) {
				
				World world = player.getWorld();
				
				world.setSpawnLocation(player.getLocation().getBlockX(), player.getLocation().getBlockY(), player.getLocation().getBlockZ());
				player.sendMessage(ChatColor.GREEN + "Spawn changed to: " + player.getLocation());
			} else {
				player.sendMessage(ChatColor.RED + "Error: No Permission");
			}
				
				
		}
		
		return false;
	}

}
