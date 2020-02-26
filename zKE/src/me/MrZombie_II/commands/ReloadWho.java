package me.MrZombie_II.commands;

import java.util.Collections;

import me.MrZombie_II.Listeners.PlayerListener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadWho implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		if(commandLabel.equalsIgnoreCase("rw")) {
		
		if(!(sender.hasPermission("weed.rw")) && (sender instanceof Player)) return true;
		
		PlayerListener.Admin.clear();
		PlayerListener.Owner.clear();
		PlayerListener.Modplus.clear();
		PlayerListener.TrialMod.clear();
		PlayerListener.Ranger.clear();
		PlayerListener.Veteran.clear();
		PlayerListener.Immortal.clear();
		PlayerListener.Default.clear();
		
		for (Player player : Bukkit.getServer().getOnlinePlayers()) {
			
			if(me.MrZombie_II.commands.Vanish.vanished.contains(player.getName())) {
				return true;
			}
			
			
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
		}
		
		if(sender instanceof Player) {
			sender.sendMessage(ChatColor.GREEN + "Who Reload Successful!");
			
		} else {
			
			sender.sendMessage(ChatColor.GREEN + "Who Reload Successful!");
		}
		
		}
		
		return false;

	}
	
}
