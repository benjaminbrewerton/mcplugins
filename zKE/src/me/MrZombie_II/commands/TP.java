package me.MrZombie_II.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TP implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		if(commandLabel.equalsIgnoreCase("tp") || (commandLabel.equalsIgnoreCase("teleport"))) {
			
			if(!(sender instanceof Player)) {
				System.out.println("Error: Command cannot be used from the console!");
				return true;
			}
			
			
			Player player = (Player) sender;
			
			
			if(!(player.hasPermission("weed.tp"))) {
				player.sendMessage(ChatColor.RED + "Error: No Permission");
				return true;
			}
			
			if(args.length == 0) {
				player.sendMessage(ChatColor.RED + "Error: Syntax Error; /tp <player> [player]");
				player.sendMessage(ChatColor.GRAY + "Example: /tp MrZombie_II _W33D_PvP || this will teleport MrZombie to _W33D_PvP");
				return true;
			}
			
			if(args.length == 1) {
				Player targetPlayer = Bukkit.getServer().getPlayer(args[0]);
				
				if(targetPlayer == null) {
					player.sendMessage(ChatColor.RED + "Error: Player '" + args[0].toString() + "' not found!");
					return true;
				}
				
				player.teleport(targetPlayer.getLocation());
				player.sendMessage(ChatColor.GREEN + "Teleported to " + targetPlayer.getName());
			}
			
			if(args.length == 2) {
				Player t1 = Bukkit.getServer().getPlayer(args[0]);
				Player t2 = Bukkit.getServer().getPlayer(args[1]);
				
				if(t1 == null || t2 == null) {
					player.sendMessage(ChatColor.RED + "Error: Player(s) not found!");
					return true;
				}
				
				t1.teleport(t2.getLocation());
				player.sendMessage(ChatColor.GREEN + "Teleported " + t1.getName() + " to " + t2.getName());
				
			}
			
			if(args.length >= 3) {
				player.sendMessage(ChatColor.RED + "Error: Syntax Error; /tp <player> [player]");
				player.sendMessage(ChatColor.GRAY + "Example: /tp MrZombie_II _W33D_PvP || this will teleport MrZombie to _W33D_PvP");
				return true;
				
			}
			
			
		}
		
		return false;
	}
	
}
