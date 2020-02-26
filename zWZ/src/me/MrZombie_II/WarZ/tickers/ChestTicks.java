package me.MrZombie_II.WarZ.tickers;

import java.lang.reflect.InvocationTargetException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import me.MrZombie_II.WarZ.api.ChestUtils;
import me.MrZombie_II.WarZ.api.MobBarAPI;
import me.MrZombie_II.WarZ.api.Utils;
import me.MrZombie_II.WarZ.api.ZoneUtils;


public class ChestTicks implements Runnable {
	
	public static long chestticker = 301;
	public static double chestpercent = 100;
	
	public void CalculatePercentage() {
		double pern = 0.333333;
		double l = chestpercent;
		double nl = (l - pern);
		chestpercent = nl;
	}
	
	public void run() {
		
		CalculatePercentage();
		chestticker--;
		
		int perc = (int) chestpercent;
		int dur = (int) chestticker;
		
		if(chestticker <= 0) {
			ChestUtils.getCU().CreateRandomChest(Bukkit.getWorld("world"));
			chestticker = 300;
			chestpercent = 100;
			return;
		}
		
		
		for(Player player : Bukkit.getOnlinePlayers()) {
			String i = ZoneUtils.getZU().getPlayerZone(player).getZoneString();
			
			try {
				MobBarAPI.getInstance().setStatus(player, ChatColor.RED + "" + dur + ChatColor.WHITE + " - " + ChatColor.GOLD + "Zone: " + i, perc, false);
				
			} catch (IllegalArgumentException | SecurityException
					| InstantiationException | IllegalAccessException
					| InvocationTargetException | NoSuchMethodException
					| NoSuchFieldException e) {
				Utils.getUtils().SendtoStaff(ChatColor.RED + "ERROR: SEVERE EXCEPTION; Boss Bar Exception");
				e.printStackTrace();
			}

		}
	}
}
