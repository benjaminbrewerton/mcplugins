package me.MrZombie_II.WarZ.listeners;

import me.MrZombie_II.WarZ.func.PlayerStats;
import me.MrZombie_II.WarZ.func.ScoreboardUtil;
import me.MrZombie_II.WarZ.main.Main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class StatsListener implements Listener {
	public Main plugin;
	
	public StatsListener(Main main) {
		plugin = main;
	}
	
	@EventHandler
	public void KDRegistration(PlayerDeathEvent event) {
		Player killer = null;
		Player dead = event.getEntity();
		if(event.getEntity().getKiller() instanceof Player) {
			killer = event.getEntity().getKiller();
		}
		
		if(killer != null) {
		PlayerStats killerstats = new PlayerStats(killer.getUniqueId());
		killerstats.setKills(1);
		}
		
		PlayerStats deadstats = new PlayerStats(dead.getUniqueId());
		deadstats.setDeaths(1);
	}
	
	@EventHandler
	public void ScoreboardHandler(PlayerRespawnEvent event) {
		final Player player = event.getPlayer();
		
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

			@Override
			public void run() {
				ScoreboardUtil su = new ScoreboardUtil(player.getUniqueId());
				su.setScoreboard();
				
			}
			
		}, 20L);
	}

}
