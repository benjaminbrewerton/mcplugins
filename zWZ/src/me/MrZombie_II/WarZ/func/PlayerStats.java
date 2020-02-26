package me.MrZombie_II.WarZ.func;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import me.MrZombie_II.WarZ.api.Utils;
import me.MrZombie_II.WarZ.enums.StatsVariable.SV;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class PlayerStats {
	private int kills;
	private int deaths;
	private UUID uuid;
	
	public PlayerStats(UUID u) {
		this.uuid = u;
		File f = Utils.getUtils().getRawPlayerFile(u);
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(f);
		Utils.getUtils().LoadPlayerFile(cfg, f);
		this.kills = cfg.getInt(SV.KILLS.getVariableID());
		this.deaths = cfg.getInt(SV.DEATHS.getVariableID());
	}
	
	public Integer getKills() {
		return kills;
	}
	
	public Integer getDeaths() {
		return deaths;
	}
	
	public UUID getUUID() {
		return uuid;
	}
	
	public void setKills(int i) {
		File f = Utils.getUtils().getRawPlayerFile(uuid);
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(f);
		Utils.getUtils().LoadPlayerFile(cfg, f);
		
		int oi = getKills();
		int ni = oi + i;
		kills = ni;
		
		cfg.set(SV.KILLS.getVariableID(), ni);
		Utils.getUtils().SavePlayerFile(cfg, f);
		ScoreboardUtil su = new ScoreboardUtil(uuid);
		su.setScoreboard();
	}
	
	public void setDeaths(int i) {
		File f = Utils.getUtils().getRawPlayerFile(uuid);
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(f);
		Utils.getUtils().LoadPlayerFile(cfg, f);
		
		int oi = getDeaths();
		int ni = oi + i;
		deaths = ni;
		
		cfg.set(SV.DEATHS.getVariableID(), ni);

		Utils.getUtils().SavePlayerFile(cfg, f);
		
	}
	
}
