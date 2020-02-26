package me.MrZombie_II.core;

import me.MrZombie_II.api.Economy;
import me.MrZombie_II.ev.api.Utils;
import me.MrZombie_II.gungame.GunGameCore;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EventCmd implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2,
			String[] args) {
		
		Player player = (Player) sender;
		
		if(arg2.equalsIgnoreCase("ev") || arg2.equalsIgnoreCase("event")) {
			
			
			if(!(args.length == 2)) {
				player.sendMessage(ChatColor.RED + "Error: Syntax Error; /ev [host/spectate/join/leave] [event]");
				return true;
			}
			
				if(args[0].equalsIgnoreCase("host") && args[1].equalsIgnoreCase("gungame")) {
					if(!(me.MrZombie_II.Listeners.ACListener.onlinestaff.contains(player.getName()))) {
						player.sendMessage(ChatColor.RED + "Error: Hosting Error; No sufficient permissions to host events!");
						return true;
					}
					
					if(Utils.getInstance().GetEventInProgress()) {
						player.sendMessage(ChatColor.RED + "Error: Hosting Error; An event is already in progress, try again later!");
						return true;
					}
					if(Utils.getInstance().GetGunGameInProgress()) {
						player.sendMessage(ChatColor.RED + "Error: Hosting Error; An event is already in progress, try again later!");
						return true;
					}
					if(!Utils.getInstance().isAdmin(player)) {
						if(Economy.getEconomy().getBalance(player) < 2500) {
							player.sendMessage(ChatColor.RED + "Error: Hosting Failure; Insufficient Funds (2500)");
							return true;
						}
						Economy.getEconomy().takeBalance(player, 2500);
					}
					
					Utils.getInstance().beginGunGame(player);
					
				}
				
				if(args[0].equalsIgnoreCase("join") && args[1].equalsIgnoreCase("gungame")) {
					if(!Utils.getInstance().GetGunGameInProgress()) {
						player.sendMessage(ChatColor.RED + "Error: Join Error; Specified Event is not being hosted!");
						return true;
					}
					if(Utils.getInstance().GetGunGameInProgressA()) {
						player.sendMessage(ChatColor.RED + "Error: Join Error; Gun Game In Progress!");
						return true;
					}
					if(GunGameCore.getGunGame().ggplayers.size() >= 30) {
						player.sendMessage(ChatColor.RED + "Error: Join Error; Maximum players reached (20)");
						return true;
					}
					if(Utils.getInstance().GetPlayerHostingEvent().equals(player.getName())) {
						player.sendMessage(ChatColor.RED + "Error: Join Error; You cannot join your own event!");
						return true;
					}
					
					GunGameCore.getGunGame().ggplayers.add(player.getName());
					Bukkit.broadcastMessage(ChatColor.AQUA + player.getName() + ChatColor.RED + " has joined the Gun Game event! Use /ev join gungame to enter!");
				}
				if(args[0].equalsIgnoreCase("debug") && args[1].equalsIgnoreCase("status")) {
					player.sendMessage(Utils.getInstance().GetEventInProgress() + "");
					player.sendMessage(Utils.getInstance().GetGunGameInProgress() + "");
					player.sendMessage(Utils.getInstance().GetPlayerHostingEvent() + "");
					player.sendMessage(Utils.getInstance().GetInvincibilityState() + "");
					
				}
				if(args[0].equalsIgnoreCase("debug") && args[1].equalsIgnoreCase("tester")) {
					StringBuilder builder = new StringBuilder();
					for(Player p : Bukkit.getOnlinePlayers())
					builder.append(",").append(p.getName());
					
					player.sendMessage(ChatColor.RED + builder.toString().substring(1));
				}
			}
			
		return false;
	}
	

}
