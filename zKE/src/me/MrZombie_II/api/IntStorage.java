package me.MrZombie_II.api;

import me.MrZombie_II.main.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class IntStorage {

	
	public int speed = 0;
	public Main plugin;
	
	public IntStorage(Main main) {
		this.plugin = main;
	}
	
	BukkitTask task = new BukkitRunnable() {
		 
		@Override
		public void run() {
			int countdown = 20; 
			for(Player p : Bukkit.getOnlinePlayers()){
			p.setLevel(countdown);
			p.sendMessage(ChatColor.GREEN + "Game starting in " + countdown +"...");
			}
			countdown--;
			if(countdown == 0)
			{
				task.cancel();
			}
		}
	}.runTaskTimer(plugin, 0L, 20L);
	
	
	
}
