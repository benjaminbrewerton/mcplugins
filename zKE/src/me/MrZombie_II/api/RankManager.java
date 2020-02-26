package me.MrZombie_II.api;

import org.bukkit.entity.Player;

public class RankManager {

	public static String getPlayerRank(Player player) {
		
		if(player.isOp()) {
			String owner = "OWNER";
			
			return owner;
		}
		if(player.hasPermission("weed.owner")) {
			String owner = "OWNER";
			
			return owner;
		} else
		if(player.hasPermission("weed.admin")) {
			String owner = "ADMIN";
			
			return owner;
		} else
		if(player.hasPermission("weed.mod+")) {
			String owner = "MODPLUS";
			
			return owner;
		} else
		if(player.hasPermission("weed.mod")) {
			String owner = "MOD";
			
			return owner;
		} else
		if(player.hasPermission("weed.immortal")) {
			String owner = "IMMORTAL";
			
			return owner;
		} else
		if(player.hasPermission("weed.veteran")) {
			String owner = "VETERAN";
			
			return owner;
		} else
		if(player.hasPermission("weed.ranger")) {
			String owner = "RANGER";
			
			return owner;
		} else
		if(player.hasPermission("weed.default")) {
			String owner = "DEFAULT";
			
			return owner;
		} else {
			
			return null;
		}
	}
	
	
	
}
