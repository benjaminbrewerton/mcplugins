package me.MrZombie_II.Listeners;

import java.io.FileNotFoundException;
import java.io.IOException;

import me.MrZombie_II.commands.Kick;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;

public class BanListener implements Listener {
	public static me.MrZombie_II.main.Main plugin;
	public static me.MrZombie_II.main.BanConfig bcfg;

	public BanListener(me.MrZombie_II.main.Main main) {
		plugin = main;
	}
	
	public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(me.MrZombie_II.main.BanConfig.BanFile());
	
	@EventHandler
	public void BanRegister (PlayerJoinEvent event) {
		Player player = event.getPlayer();
		
		try {
			cfg.load(me.MrZombie_II.main.BanConfig.BanFile());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
		}
		
		if(!player.hasPlayedBefore() && !player.isBanned()) {
			
			cfg.set(player.getName() + ".banb", "nb");
			cfg.set(player.getName() + ".banr", "nb");
		}
		
		try {
			cfg.save(me.MrZombie_II.main.BanConfig.BanFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@EventHandler
	public void BanHandler (PlayerLoginEvent event) {
		Player player = event.getPlayer();
		
		try {
			cfg.load(me.MrZombie_II.main.BanConfig.BanFile());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
		}
		
		if ((player.isBanned()) && (!(cfg.getString(player.getName() + ".banr").equals("nb")))) {
			
			String bm = cfg.getString(player.getName() + ".banr");
			String bmp = cfg.getString(player.getName() + ".banb");
			event.setKickMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "BANNED!"
					+ ChatColor.RESET + ChatColor.RED + "\n You have been banned by " + bmp + " for " + bm +
					ChatColor.RESET + ChatColor.GREEN + ChatColor.BOLD + "\n Buy an unban at: " + ChatColor.RESET + ChatColor.BLUE + ChatColor.UNDERLINE + "buy.MinecraftWarZ.com");
			
		}
		
		try {
			cfg.save(me.MrZombie_II.main.BanConfig.BanFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@EventHandler
	public void KickHandler (PlayerJoinEvent event) {
		
		final Player player = event.getPlayer();
		
		if(Kick.KickDur.containsKey(player.getName()) && Kick.KickTime.containsKey(player.getName())) {
			int kicktime = Kick.KickDur.get(player.getName());
			
			final long secondsLeft = ((Kick.KickTime.get(player.getName())) /1000 + kicktime) - (System.currentTimeMillis() /1000);
			
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				
				@Override
				public void run() {
					player.kickPlayer(ChatColor.RED + "You have been kicked for " + secondsLeft / 60 + " another minutes!");
					
				}
				
			}, 1L);
		}
		
	}
}
