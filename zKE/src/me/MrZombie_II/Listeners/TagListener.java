package me.MrZombie_II.Listeners;

import me.MrZombie_II.api.API;
import me.MrZombie_II.main.Main;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.kitteh.tag.PlayerReceiveNameTagEvent;

public class TagListener implements Listener {
	public Main plugin;

	public TagListener(Main main) {
		this.plugin = main;
	}
	
	@EventHandler
	public void onNameTag(PlayerReceiveNameTagEvent event) {
	Player player = event.getNamedPlayer();
	API api = new API();
	
	if(!api.canEnterLockedServer(player)) {
		return;
	}
	
	if (player.isOp()) {
		event.setTag(ChatColor.DARK_RED + player.getName());
	}
	else if (player.hasPermission("weed.ranger")) {
		event.setTag(ChatColor.YELLOW + player.getName());
	}
	else if (player.hasPermission("weed.veteran")) {
		event.setTag(ChatColor.GREEN + player.getName());
	}
	else if (player.hasPermission("weed.immortal")) {
		event.setTag(ChatColor.DARK_AQUA + player.getName());	
	}
	else if (player.hasPermission("weed.mod")) {
		event.setTag(ChatColor.DARK_PURPLE+ player.getName());
	}
	else if (player.hasPermission("weed.mod+")) {
		event.setTag(ChatColor.DARK_PURPLE + "" + ChatColor.ITALIC + player.getName());
	}
	else if (player.hasPermission("weed.admin" )) {
		event.setTag(ChatColor.RED + player.getName());
	} 
	else if (player.hasPermission("weed.default")) {
		event.setTag(ChatColor.GRAY + player.getName());
	}
	else if (player.hasPermission("weed.owner")) {
		event.setTag(ChatColor.DARK_RED + player.getName());
	}
	}

}
