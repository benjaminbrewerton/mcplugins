package me.MrZombie_II.WarZ.func;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import me.MrZombie_II.WarZ.api.NameFetcher;
import me.MrZombie_II.WarZ.api.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class ScoreboardUtil {
	
	private UUID u;
	private int kills;
	private int deaths;
	
	public ScoreboardUtil(UUID u) {
		this.u = u;
		PlayerStats ps = new PlayerStats(u);
		this.kills = ps.getKills();
		this.deaths = ps.getDeaths();
	}
	
	@SuppressWarnings("deprecation")
	public void setScoreboard() {
		ScoreboardManager sbm = Bukkit.getScoreboardManager();
		final Scoreboard sb = sbm.getNewScoreboard();
		Objective o = sb.registerNewObjective("default", "dummy");
		o.setDisplayName(ChatColor.GREEN + "WarZ Stats");
		o.setDisplaySlot(DisplaySlot.SIDEBAR);
		
		Score kills = o.getScore(Bukkit.getOfflinePlayer(ChatColor.WHITE + "Kills: "));
		kills.setScore(this.kills);
		
		Score deaths = o.getScore(Bukkit.getOfflinePlayer(ChatColor.WHITE + "Deaths: "));
		deaths.setScore(this.deaths);
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		
		Score date = o.getScore(Bukkit.getOfflinePlayer("" + dateFormat.format(cal.getTime())));
		date.setScore(0);
		
		final UUID u = this.u;
				
				final String pname = Utils.getUtils().getCachedFromUnknown(u);
				Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("zWZ"), new Runnable() {

					@Override
					public void run() {
						if(pname == null) {
							Utils.getUtils().SendtoStaff(ChatColor.RED + "Failed to Initalize Utility for converting UUIDs to names. Are the MC servers down? \n Scoreboards will NOT operate correctly");
							return;
						}
						
						Player player = Bukkit.getPlayer(pname);
						player.setScoreboard(sb);
						
					}
					
				}, 20L);
				
	}
}
