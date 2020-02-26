package me.MrZombie_II.commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import me.MrZombie_II.Listeners.PlayerListener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Vanish implements CommandExecutor {
	
	public static List<String> vanished = new ArrayList<String>();
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		Player player = (Player) sender;
		if (commandLabel.equalsIgnoreCase("v") || (commandLabel.equalsIgnoreCase("vanish"))) {
			
			if (player.hasPermission("weed.vanish")) {
				
				
			if (vanished.contains(player.getName())) {	
				
				me.MrZombie_II.Listeners.PlayerListener.PlayersOnline--;
				vanished.remove(player.getName());
				
				for (String s : me.MrZombie_II.Listeners.PlayerListener.onlineplayersraw) {
                    Player p = Bukkit.getServer().getPlayerExact(s);
                    p.showPlayer(player);
            }
				
				for(String s : me.MrZombie_II.Listeners.PlayerListener.onlineadmins) {
					Player p = Bukkit.getServer().getPlayerExact(s);
					p.sendMessage(ChatColor.DARK_AQUA + "[A] " + player.getName() + " unvanished!");
					
				}
				
				player.sendMessage(ChatColor.GREEN + "You are now visible to" + ChatColor.LIGHT_PURPLE + " ALL " + ChatColor.GREEN + "players!");
				
				if (player.isOp()) {
					PlayerListener.Owner.add(player.getDisplayName() + "§r");
					Collections.sort(PlayerListener.Owner);
				}
				else if (player.hasPermission("weed.ranger")) {
					PlayerListener.Ranger.add(player.getDisplayName() + "§r");
					Collections.sort(PlayerListener.Ranger);
				}
				else if (player.hasPermission("weed.veteran")) {
					PlayerListener.Veteran.add(player.getDisplayName() + "§r");
					Collections.sort(PlayerListener.Veteran);
				}
				else if (player.hasPermission("weed.immortal")) {
					PlayerListener.Immortal.add(player.getDisplayName() + "§r");
					Collections.sort(PlayerListener.Immortal);
				}
				else if (player.hasPermission("weed.mod")) {
					PlayerListener.TrialMod.add(player.getDisplayName() + "§r");
					Collections.sort(PlayerListener.TrialMod);
				}
				else if (player.hasPermission("weed.mod+")) {
					PlayerListener.Modplus.add(player.getDisplayName() + "§r");
					Collections.sort(PlayerListener.Modplus);
				}
				else if (player.hasPermission("weed.admin" )) {
					PlayerListener.Admin.add(player.getDisplayName() + "§r");
					Collections.sort(PlayerListener.Admin);
				} 
				else if (player.hasPermission("weed.default")) {
					PlayerListener.Default.add(player.getDisplayName() + "§r");
					Collections.sort(PlayerListener.Default);
				}
				else if (player.hasPermission("weed.owner")) {
					PlayerListener.Owner.add(player.getDisplayName() + "§r");
					Collections.sort(PlayerListener.Owner);
				}
			
			} else {
				
				
				
				for(String s : me.MrZombie_II.Listeners.PlayerListener.onlineadmins) {
					Player p = Bukkit.getServer().getPlayerExact(s);
					p.sendMessage(ChatColor.RED + "[A] " + player.getName() + " vanished!");
					
				}
				
				player.sendMessage(ChatColor.GREEN + "You are now invisible to" + ChatColor.LIGHT_PURPLE + " IMMORTAL " + ChatColor.GREEN + "and below!");
				vanished.add(player.getName());
				
				
				for (String s : me.MrZombie_II.Listeners.PlayerListener.onlineplayersraw) {
                    Player p = Bukkit.getServer().getPlayerExact(s);
                    p.hidePlayer(player);
            }
				
				me.MrZombie_II.Listeners.PlayerListener.PlayersOnline++;
				
				
				if (player.isOp()) {
					PlayerListener.Owner.remove(player.getDisplayName() + "§r");
					Collections.sort(PlayerListener.Owner);
				}
				else if (player.hasPermission("weed.ranger")) {
					PlayerListener.Ranger.remove(player.getDisplayName() + "§r");
					Collections.sort(PlayerListener.Ranger);
				}
				else if (player.hasPermission("weed.veteran")) {
					PlayerListener.Veteran.remove(player.getDisplayName() + "§r");
					Collections.sort(PlayerListener.Veteran);
				}
				else if (player.hasPermission("weed.immortal")) {
					PlayerListener.Immortal.remove(player.getDisplayName() + "§r");
					Collections.sort(PlayerListener.Immortal);
				}
				else if (player.hasPermission("weed.mod")) {
					PlayerListener.TrialMod.remove(player.getDisplayName() + "§r");
					Collections.sort(PlayerListener.TrialMod);
				}
				else if (player.hasPermission("weed.mod+")) {
					PlayerListener.Modplus.remove(player.getDisplayName() + "§r");
					Collections.sort(PlayerListener.Modplus);
				}
				else if (player.hasPermission("weed.admin" )) {
					PlayerListener.Admin.remove(player.getDisplayName() + "§r");
					Collections.sort(PlayerListener.Admin);
				} 
				else if (player.hasPermission("weed.default")) {
					PlayerListener.Default.remove(player.getDisplayName() + "§r");
					Collections.sort(PlayerListener.Default);
				}
				else if (player.hasPermission("weed.owner")) {
					PlayerListener.Owner.remove(player.getDisplayName() + "§r");
					Collections.sort(PlayerListener.Owner);
				}
			
				
			}
				
			} else {
				player.sendMessage(ChatColor.RED + "Error: No Permission");
			}
		
		}
		return false;
	}
	
}
