package me.MrZombie_II.commands;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class Soup implements CommandExecutor {
	public static me.MrZombie_II.main.Main plugin;

	public HashMap<String, Long> cooldowns = new HashMap<String, Long>();
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
	        Player player = (Player) sender;
	        int cooldownTime = 60;
	        		 if(cooldowns.containsKey(player.getName())) {
	                     long secondsLeft = ((cooldowns.get(player.getName())) /1000 +cooldownTime) - (System.currentTimeMillis() /1000 );
	                     if(secondsLeft > 0) {
	                         player.sendMessage(ChatColor.BLUE+"You will be able to refill in "+ ChatColor.RED + secondsLeft + ChatColor.BLUE + " more seconds");
	                         return true;
	                     } 
	                 }    
	        		 
	 	        	if (commandLabel.equalsIgnoreCase("soup")){
	 	        		cooldowns.put(sender.getName(), System.currentTimeMillis());
	 	        		 PlayerInventory pi = player.getInventory();
	 	        		 player.sendMessage(ChatColor.BLUE + "Refilled! 60 second cooldown inbound.");
	 	        		 ItemStack soup = new ItemStack(Material.MUSHROOM_SOUP);
	 	        		 pi.addItem(soup);
	 	        		 pi.addItem(soup);
	 	        		 pi.addItem(soup);
		   				 pi.addItem(soup);
		   				 pi.addItem(soup);
		   				 pi.addItem(soup);
		   				 pi.addItem(soup);
		   				 pi.addItem(soup);
		   				 pi.addItem(soup);
		   				 pi.addItem(soup);
	 	        	}
	 	   
	 	    return true;
	 
}
}
