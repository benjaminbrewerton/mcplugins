package me.MrZombie_II.commands;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class EC implements CommandExecutor {
	
	public void loadinv (Player player, Integer slot, ChatColor color) {
		File f = new File(Bukkit.getServer().getPluginManager().getPlugin("zWE").getDataFolder() + File.separator + "userdata" + File.separator + player.getName() + ".yml");
		final FileConfiguration cfg = YamlConfiguration.loadConfiguration(f);
		
		
		try {
			cfg.load(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
		}
		
		List<?> oinv = cfg.getList("ec");

		Inventory i = Bukkit.createInventory(null, slot, color + "Personal Chest");
		
		if(oinv !=null) {
				
			for (int ii = 0; ii < Math.min(oinv.size(), i.getSize()); ii++) {
				i.setItem(ii, (ItemStack)oinv.get(ii));
				}
		} else {
			List<ItemStack[]> l = new ArrayList<ItemStack[]>();
			for(int ii = 0; ii<54; ii++) {
				l.add(null);
			}
			
			cfg.set("ec", l);
			
		}
		
		
		
		player.openInventory(i);
		
		try {
			cfg.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		Player player = (Player) sender;
		if(commandLabel.equalsIgnoreCase("chest") || commandLabel.equalsIgnoreCase("pc")) {
			
			if(player.isOp()) {
				loadinv(player, 54, ChatColor.DARK_AQUA);
				
			} else
			if(player.hasPermission("weed.default")) {
				loadinv(player, 9, ChatColor.GRAY);
				
			} else
			if(player.hasPermission("weed.ranger")) {
				loadinv(player, 27, ChatColor.YELLOW);
				
			} else
			if(player.hasPermission("weed.veteran")) {
				loadinv(player, 36, ChatColor.GREEN);
				
			} else
			if(player.hasPermission("weed.immortal")) {
				loadinv(player, 54, ChatColor.DARK_AQUA);
				
			}else
				if(player.hasPermission("weed.mod")) {
					loadinv(player, 54, ChatColor.DARK_AQUA);
					
				}else
					if(player.hasPermission("weed.mod+")) {
						loadinv(player, 54, ChatColor.DARK_AQUA);
						
					}else
						if(player.hasPermission("weed.admin")) {
							loadinv(player, 54, ChatColor.DARK_AQUA);
							
						}
			
			
		}
		
		return false;
		
	}

}
