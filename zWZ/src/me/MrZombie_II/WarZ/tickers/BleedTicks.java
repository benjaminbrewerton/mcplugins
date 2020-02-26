package me.MrZombie_II.WarZ.tickers;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.MrZombie_II.WarZ.listeners.EnvironmentListener;

public class BleedTicks implements Runnable {
	//Players bleeding take periodic damage
	public void run() {
		for(String s : EnvironmentListener.bleeding) {
			Player p = Bukkit.getServer().getPlayerExact(s);
			p.damage(1.0D);
		}
	}
}
