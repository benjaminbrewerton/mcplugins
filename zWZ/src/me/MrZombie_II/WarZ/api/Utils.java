package me.MrZombie_II.WarZ.api;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

import me.MrZombie_II.WarZ.enums.StatsVariable.SV;
import me.MrZombie_II.WarZ.func.ScoreboardUtil;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Utils {
	
	public static Utils u = new Utils();
	
	public static Utils getUtils() {
		return u;
	}
	
	
	 public void SendtoStaff(String s) {
		 for(Player p : Bukkit.getOnlinePlayers()) {
			 if(p.hasPermission("warz.staff"))
			 p.sendMessage(s);
		 }
	 }
	 
	 public FileConfiguration getPlayerFile(UUID u) {
			File f = new File(Bukkit.getServer().getPluginManager().getPlugin("zWZ").getDataFolder() + File.separator + "userdata" + File.separator + u + ".yml");
			FileConfiguration cfg = YamlConfiguration.loadConfiguration(f);
			
			return cfg;
	 }
	 
	 public File getRawPlayerFile(UUID u) {
		 File f = new File(Bukkit.getServer().getPluginManager().getPlugin("zWZ").getDataFolder() + File.separator + "userdata" + File.separator + u + ".yml");
		 return f;
	 }
	 
	 @SuppressWarnings("deprecation")
	public void LoadPlayerFile(final FileConfiguration cc, final File ff) {
			Bukkit.getServer().getScheduler().scheduleAsyncDelayedTask(Bukkit.getPluginManager().getPlugin("zWZ"), new Runnable() {

				@Override
				public void run() {
					try {
						cc.load(ff);
					} catch (IOException | InvalidConfigurationException e) {
						e.printStackTrace();
					}
					
				}
				
			}, 1L);
	 }
	 
	 @SuppressWarnings("deprecation")
	public void SavePlayerFile(final FileConfiguration cc, final File ff) {
			Bukkit.getServer().getScheduler().scheduleAsyncDelayedTask(Bukkit.getPluginManager().getPlugin("zWZ"), new Runnable() {

				@Override
				public void run() {
					try {
						cc.save(ff);
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				}
				
			}, 1L);
	 }
	 
	 @SuppressWarnings("deprecation")
	public void CreatePlayerFile(final UUID u) {
			Bukkit.getServer().getScheduler().scheduleAsyncDelayedTask(Bukkit.getPluginManager().getPlugin("zWZ"), new Runnable() {

				@Override
				public void run() {
					 File f = new File(Bukkit.getServer().getPluginManager().getPlugin("zWZ").getDataFolder() + File.separator + "userdata" + File.separator + u + ".yml");
						if (!f.exists()) {
						try { 
							f.createNewFile();
						}
						catch (Exception e) { 
							e.printStackTrace(); 
							}
						}
						FileConfiguration cfg = YamlConfiguration.loadConfiguration(f);
						try {
							cfg.load(f);
						} catch (IOException | InvalidConfigurationException e) {
							e.printStackTrace();
						}
						
						cfg.set(SV.KILLS.getVariableID(), 0);
						cfg.set(SV.DEATHS.getVariableID(), 0);
						
						try {
							cfg.save(f);
						} catch (IOException e) {
							e.printStackTrace();
						}
						
				}
				
			}, 20L);
	 }
		
		public void StoreFromUnknown(UUID u) {
			NameFetcher nn = new NameFetcher(Arrays.asList(u));

			String pname = null;
			try {
				pname = nn.call().get(u);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			uuidtoplayer.put(u, pname);
		}
		
		public Map<UUID, String> uuidtoplayer = new HashMap<UUID, String>();
		
		public String getCachedFromUnknown(UUID u) {
			return uuidtoplayer.get(u);
		}
		
		
		public void setKills(int i, UUID uuid) {
			File f = Utils.getUtils().getRawPlayerFile(uuid);
			FileConfiguration cfg = YamlConfiguration.loadConfiguration(f);
			Utils.getUtils().LoadPlayerFile(cfg, f);
			
			int oi = cfg.getInt(SV.KILLS.getVariableID());
			int ni = oi + i;
			
			cfg.set(SV.KILLS.getVariableID(), ni);
			Utils.getUtils().SavePlayerFile(cfg, f);
			ScoreboardUtil su = new ScoreboardUtil(uuid);
			su.setScoreboard();
		}
		
		public void setDeaths(int i, UUID uuid) {
			File f = Utils.getUtils().getRawPlayerFile(uuid);
			FileConfiguration cfg = YamlConfiguration.loadConfiguration(f);
			Utils.getUtils().LoadPlayerFile(cfg, f);
			
			int oi = cfg.getInt(SV.DEATHS.getVariableID());
			int ni = oi + i;
			Bukkit.broadcastMessage(ChatColor.GREEN + "" + i);
			
			cfg.set(SV.DEATHS.getVariableID(), ni);
			
			Utils.getUtils().SavePlayerFile(cfg, f);
			ScoreboardUtil su = new ScoreboardUtil(uuid);
			su.setScoreboard();
		}
}
