package me.MrZombie_II.WarZ.commands;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import me.MrZombie_II.WarZ.api.ChestUtils;
import me.MrZombie_II.WarZ.api.ZoneUtils;
import me.MrZombie_II.WarZ.func.Cuboid;
import me.MrZombie_II.WarZ.main.Chests;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Chest implements CommandExecutor {

	
    public static String locToString(Location l) {
        return l.getWorld().getName() + ":" + l.getBlockX() + ":"
                + l.getBlockY() + ":" + l.getBlockZ();
    }
 
    public static Location stringToLoc(String s) {
        String[] st = s.split(":");
        return new Location(Bukkit.getServer().getWorld(st[0]),
                Integer.parseInt(st[1]), Integer.parseInt(st[2]),
                Integer.parseInt(st[3]));
    }
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(!(sender instanceof Player)) return true;
		if(!(sender.hasPermission("warz.chestsync"))) return true;
		
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(Chests.StatFile());
		
		if(args[0].equals("1")) {
			try {
				cfg.load(Chests.StatFile());
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InvalidConfigurationException e) {
				e.printStackTrace();
			}
			
			List<String> oldlist = (List<String>) cfg.getStringList("chests");
			
			for(Cuboid cc : ZoneUtils.getZU().getZoneOneList()) {
				for(Block b : cc.getBlocks()) {
				if(b.getType() == Material.CHEST) {
					oldlist.add(locToString(b.getLocation()));
				}
				}
			}
			
			
			
			cfg.set("chests", oldlist);
			
			try {
				cfg.save(Chests.StatFile());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			sender.sendMessage(ChatColor.GREEN + "Chests synced. Zone 1");
			return false;
		}
		
		if(args[0].equals("2")) {
			try {
				cfg.load(Chests.StatFile());
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InvalidConfigurationException e) {
				e.printStackTrace();
			}
			
			List<String> oldlist = (List<String>) cfg.getStringList("chests");
			
			for(Cuboid cc : ZoneUtils.getZU().getZoneTwoList()) {
				for(Block b : cc.getBlocks()) {
				if(b.getType() == Material.CHEST) {
					oldlist.add(locToString(b.getLocation()));
				}
				}
			}
			
			
			
			cfg.set("chests", oldlist);
			
			try {
				cfg.save(Chests.StatFile());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			sender.sendMessage(ChatColor.GREEN + "Chests synced. Zone 2");
			return false;
		}
		
		if(args[0].equals("3")) {
			try {
				cfg.load(Chests.StatFile());
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InvalidConfigurationException e) {
				e.printStackTrace();
			}
			
			List<String> oldlist = (List<String>) cfg.getStringList("chests");
			
			for(Cuboid cc : ZoneUtils.getZU().getZoneThreeList()) {
				for(Block b : cc.getBlocks()) {
				if(b.getType() == Material.CHEST) {
					oldlist.add(locToString(b.getLocation()));
				}
				}
			}
			
			
			
			cfg.set("chests", oldlist);
			
			try {
				cfg.save(Chests.StatFile());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			sender.sendMessage(ChatColor.GREEN + "Chests synced. Zone 3");
			return false;
		}
		
		if(args[0].equals("4")) {
			try {
				cfg.load(Chests.StatFile());
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InvalidConfigurationException e) {
				e.printStackTrace();
			}
			
			List<String> oldlist = (List<String>) cfg.getStringList("chests");
			
			for(Cuboid cc : ZoneUtils.getZU().getZoneFourList()) {
				for(Block b : cc.getBlocks()) {
				if(b.getType() == Material.CHEST) {
					oldlist.add(locToString(b.getLocation()));
				}
				}
			}
			
			
			
			cfg.set("chests", oldlist);
			
			try {
				cfg.save(Chests.StatFile());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			sender.sendMessage(ChatColor.GREEN + "Chests synced. Zone 4");
			return false;
		}
		return false;
	}

}
