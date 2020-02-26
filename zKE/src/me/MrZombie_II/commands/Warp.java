package me.MrZombie_II.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Warp implements CommandExecutor {
	
	private FileConfiguration cfg = YamlConfiguration.loadConfiguration(me.MrZombie_II.main.WarpConfig.WarpFile());
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(commandLabel.equalsIgnoreCase("warp")) {
			Player player = (Player) sender;
			if(player.hasPermission("weed.warp")) {
				
				
			}
		}
		return false;
	}

}
