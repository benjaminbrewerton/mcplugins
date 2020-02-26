package me.MrZombie_II.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

public class CI implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		if(commandLabel.equalsIgnoreCase("ci") || (commandLabel.equalsIgnoreCase("clear"))) {
			Player player = (Player) sender;
			
			if(!(player.hasPermission("weed.ci"))) {
				player.sendMessage(ChatColor.RED + "Error: No Permission");
				return true;
			}
			
			if(args.length == 0) {
				
				player.getInventory().clear();
				player.sendMessage(ChatColor.GREEN + "Successfully cleared inventory!");
				PlayerInventory pi = player.getInventory();
				pi.setBoots(null);
				pi.setChestplate(null);
				pi.setHelmet(null);
				pi.setLeggings(null);
				
			}
			
			if(args.length == 1) {
				
				if(!(player.hasPermission("weed.ci.others"))) {
					player.sendMessage(ChatColor.RED + "Error: No Permission to clear other's inventory!");
					return true;
				}
				
				Player targetPlayer = Bukkit.getServer().getPlayer(args[0]);
				
				if(targetPlayer == null) {
					player.sendMessage(ChatColor.RED + "Error: Player not found!");
					return true;
				}
				
				targetPlayer.getInventory().clear();
				PlayerInventory pi = player.getInventory();
				player.sendMessage(ChatColor.GREEN + "Successfully cleared " + targetPlayer.getName() + "'s inventory!");
				pi.setBoots(null);
				pi.setChestplate(null);
				pi.setHelmet(null);
				pi.setLeggings(null);
				
			}
			
		}
		
		return false;
	}
	

}
