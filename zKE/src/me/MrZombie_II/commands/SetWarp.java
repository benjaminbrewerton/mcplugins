package me.MrZombie_II.commands;

import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class SetWarp implements CommandExecutor {
	
	private FileConfiguration cfg = YamlConfiguration.loadConfiguration(me.MrZombie_II.main.WarpConfig.WarpFile());
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if(commandLabel.equalsIgnoreCase("setwarp")) {
			Player player = (Player) sender;
			if(player.hasPermission("weed.setwarp")) {
				
				int x = player.getLocation().getBlockX();
				int y = player.getLocation().getBlockY();
				int z = player.getLocation().getBlockZ();
				String warp = args[0].toString();
				
				
				cfg.set(warp + ".x", x);
				cfg.set(warp + ".y", y);
				cfg.set(warp + ".z", z);
				
				try {
					cfg.save(me.MrZombie_II.main.Stats.StatFile());
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				player.sendMessage(ChatColor.GREEN + "Warp '" + warp + "' set to coordinates: " + x + "X , " + y + "Y , " + z + "Z !");
			} else {
				
				player.sendMessage(ChatColor.RED + "Error: No Permission");
			}
			
			
		}
 		
		
		return false;
	}

}
