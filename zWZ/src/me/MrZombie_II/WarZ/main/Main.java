package me.MrZombie_II.WarZ.main;

import java.util.logging.Level;
import java.util.logging.Logger;

import me.MrZombie_II.WarZ.api.ChestUtils;
import me.MrZombie_II.WarZ.api.Lag;
import me.MrZombie_II.WarZ.api.MobBarAPI;
import me.MrZombie_II.WarZ.commands.Chest;
import me.MrZombie_II.WarZ.commands.CopyData;
import me.MrZombie_II.WarZ.commands.CreateDataStack;
import me.MrZombie_II.WarZ.commands.Stop;
import me.MrZombie_II.WarZ.commands.Tp;
import me.MrZombie_II.WarZ.func.WorldHandler;
import me.MrZombie_II.WarZ.listeners.DataListener;
import me.MrZombie_II.WarZ.listeners.EnvironmentListener;
import me.MrZombie_II.WarZ.listeners.StatsListener;
import me.MrZombie_II.WarZ.tickers.BleedTicks;
import me.MrZombie_II.WarZ.tickers.ChestTicks;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {
	public final Logger logger = Logger.getLogger("Minecraft");
	public static Main plugin;

	
	@EventHandler
	public void onDisable() {
		getServer().getLogger().log(Level.WARNING, "Disabling WarZ, Now copying map files for next restart!");
	}
	
	@EventHandler
	public void onEnable() {
		getServer().getLogger().log(Level.INFO, "WarZ is now locked and loaded. You may now blow your load while playing the server.");
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new EnvironmentListener(this), this);
		pm.registerEvents(new DataListener(this), this);
		pm.registerEvents(new StatsListener(this), this);

		getCommand("syncchests").setExecutor(new Chest());
		//getCommand("stop").setExecutor(new Stop());
		getCommand("copydatasync").setExecutor(new CopyData());
		getCommand("cds").setExecutor(new CreateDataStack());
		getCommand("tp").setExecutor(new Tp());
		
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new BleedTicks(), 60L, 20 * 2);
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Lag(), 100L, 1L);
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new ChestTicks(), 100L, 20L);

		if(!Chests.StatFile().exists()) {
			new Chests();
		}
		
		
		
	}


}
