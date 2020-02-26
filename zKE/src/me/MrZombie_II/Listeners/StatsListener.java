package me.MrZombie_II.Listeners;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import me.MrZombie_II.api.API;
import me.MrZombie_II.api.RankManager;
import me.MrZombie_II.main.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class StatsListener implements Listener {
	
	public static Main plugin;

	@SuppressWarnings("static-access")
	public StatsListener(Main main) {
		this.plugin = main;
	}
	
	
	public static void setPS(final Player player, Long delay) {
		File f = new File(plugin.getDataFolder() + File.separator + "userdata" + File.separator + player.getName() + ".yml");
		final FileConfiguration cfg = YamlConfiguration.loadConfiguration(f);
		
		if(API.isTempKicked(player)) {
			return;
		}
		
		try {
			 cfg.load(f);
		 } catch (IOException e) {
			 e.printStackTrace();
		 } catch (InvalidConfigurationException e) {
			e.printStackTrace();
		}
		
		int b = Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getPluginManager().getPlugin("zWE"), new Runnable() {

			@Override
			public void run() {
				ScoreboardManager sbm = Bukkit.getScoreboardManager();
		        Scoreboard sb = sbm.getNewScoreboard();
		        Objective ob = sb.registerNewObjective("stats", "dummy");
		        ob.setDisplayName(ChatColor.AQUA + player.getName() + "'s Stats: ");
		        ob.setDisplaySlot(DisplaySlot.SIDEBAR);
		 
		        
		        
		        int KDKills = cfg.getInt("kills");
		        int KDDeaths = cfg.getInt("deaths");
		        int KDCreds = cfg.getInt("credits");
		 
		        Score kills = ob.getScore(Bukkit.getOfflinePlayer(ChatColor.WHITE + "Kills: "));
		        kills.setScore(KDKills);
		 
		        Score deaths = ob.getScore(Bukkit.getOfflinePlayer(ChatColor.WHITE + "Deaths: "));
		        deaths.setScore(KDDeaths);
		 
		        Score credits = ob.getScore(Bukkit.getOfflinePlayer(ChatColor.WHITE + "Credits: "));
		        credits.setScore(KDCreds);
		 

		        player.setScoreboard(sb);
		       
				
			}
			 
			 
		 }, delay);
		
	}
	
	@EventHandler
	public void ScoreFix (PlayerJoinEvent event) {
		API api = new API();
		
		
		final Player player = event.getPlayer();
		
		if(API.isTempKicked(player)) {
			return;
		}
		
		if(api.canEnterLockedServer(player)) {
		setPS(player, 80L);
		}
	
	}
	
	@EventHandler (priority = EventPriority.MONITOR)
	public void KillRegistration (PlayerDeathEvent event) {
	
		
		if(!(event.getEntity().getKiller() instanceof Player)) {
			return;
		}
		
		final Player player = event.getEntity().getKiller();
		Player target = event.getEntity().getPlayer();
		
		File f = new File(plugin.getDataFolder() + File.separator + "userdata" + File.separator + player.getName() + ".yml");
		final FileConfiguration cfg = YamlConfiguration.loadConfiguration(f);
		
		File f1 = new File(plugin.getDataFolder() + File.separator + "userdata" + File.separator + target.getName() + ".yml");
		final FileConfiguration cfg1 = YamlConfiguration.loadConfiguration(f1);
		
		try {
			 cfg.load(f);
		 } catch (IOException e) {
			 e.printStackTrace();
		 } catch (InvalidConfigurationException e) {
			e.printStackTrace();
		}
		
		try {
			 cfg1.load(f1);
		 } catch (IOException e) {
			 e.printStackTrace();
		 } catch (InvalidConfigurationException e) {
			e.printStackTrace();
		}
		
		setPS(player, 10L);
		
		int i = cfg.getInt("kills");
		
		int ii = i + 1;
		cfg.set("kills", ii);
		
		int iii = cfg1.getInt("deaths");
		int iiii = iii + 1;
		cfg1.set("deaths", iiii);
		
		if(RankManager.getPlayerRank(player).equals("OWNER")) {
			double c1 = cfg.getInt("credits") + 175;
			player.sendMessage(ChatColor.GRAY + "You killed " + ChatColor.BLUE + target.getName() +  ChatColor.YELLOW  + "+175 credits");
			cfg.set("credits", c1);
		}
		if(RankManager.getPlayerRank(player).equals("DEFAULT")) {
		double c1 = cfg.getInt("credits") + 70;
		player.sendMessage(ChatColor.GRAY + "You killed " + ChatColor.BLUE + target.getName() +  ChatColor.YELLOW  + "+70 credits");
		cfg.set("credits", c1);
		}
		if(RankManager.getPlayerRank(player).equals("RANGER")) {
			double c1 = cfg.getInt("credits") + 105;
			player.sendMessage(ChatColor.GRAY + "You killed " + ChatColor.BLUE + target.getName() +  ChatColor.YELLOW  + "+105 credits");
			cfg.set("credits", c1);
		}
		if(RankManager.getPlayerRank(player).equals("VETERAN")) {
			double c1 = cfg.getInt("credits") + 140;
			player.sendMessage(ChatColor.GRAY + "You killed " + ChatColor.BLUE + target.getName() +  ChatColor.YELLOW  + "+140 credits");
			cfg.set("credits", c1);
		}
		if(RankManager.getPlayerRank(player).equals("IMMORTAL") || RankManager.getPlayerRank(player).equals("MOD") || RankManager.getPlayerRank(player).equals("MODPLUS") || RankManager.getPlayerRank(player).equals("ADMIN")) {
			double c1 = cfg.getInt("credits") + 175;
			player.sendMessage(ChatColor.GRAY + "You killed " + ChatColor.BLUE + target.getName() +  ChatColor.YELLOW  + "+175 credits");
			cfg.set("credits", c1);
		}
		
		try {
			cfg.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			cfg.save(f1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	      target.sendMessage(ChatColor.GRAY + "You have been killed by " + ChatColor.RED + player.getName());
		
		
		
	}
	
	
	@EventHandler
	public void SBPLAYERFIX (PlayerRespawnEvent event) {
		Player player = event.getPlayer();
		 setPS(player, 20L);
		
	}
	
	
}
