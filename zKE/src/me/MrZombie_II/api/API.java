package me.MrZombie_II.api;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.MrZombie_II.commands.Kick;
import me.MrZombie_II.commands.Lock;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class API {
	
	public Player GenerateRandomPlayer() {
		List<String> l = new ArrayList<String>();
		
		for(Player p : Bukkit.getServer().getOnlinePlayers()) {
			l.add(p.getName());
		}
		
		Random random = new Random();
		String pr = l.get(random.nextInt(l.size()));
		Player p = Bukkit.getServer().getPlayer(pr);
		
		return p;
		
	}
	
	public boolean canEnterLockedServer(Player player) {
		if(Lock.lock.equals("NONE")) {
			return true;
		}
		if(Lock.lock.equals("OWNER")) {
			if(RankManager.getPlayerRank(player).equals("OWNER")) {
				return true;
			}
			if(!RankManager.getPlayerRank(player).equals("OWNER")) {
				return false;
			}
		}
		if(Lock.lock.equals("ADMIN")) {
			if(!(RankManager.getPlayerRank(player).equals("OWNER") || RankManager.getPlayerRank(player).equals("ADMIN"))) {
				return false;
			} else {
				return true;
			}
		}
		if(Lock.lock.equals("MODPLUS")) {
			if(!(RankManager.getPlayerRank(player).equals("OWNER") || RankManager.getPlayerRank(player).equals("ADMIN") || RankManager.getPlayerRank(player).equals("MODPLUS"))) {
				return false;
			} else {
				return true;
			}
		}
		if(Lock.lock.equals("MOD")) {
			if(!(RankManager.getPlayerRank(player).equals("OWNER") || RankManager.getPlayerRank(player).equals("ADMIN") || RankManager.getPlayerRank(player).equals("MODPLUS") || RankManager.getPlayerRank(player).equals("MOD"))) {
				return false;
			} else {
				return true;
			}
		}
		if(Lock.lock.equals("IMMORTAL")) {
			if(!(RankManager.getPlayerRank(player).equals("OWNER") || RankManager.getPlayerRank(player).equals("ADMIN") || RankManager.getPlayerRank(player).equals("MODPLUS") || RankManager.getPlayerRank(player).equals("MOD") || RankManager.getPlayerRank(player).equals("IMMORTAL"))) {
				return false;
			} else {
				return true;
			}
		}
		if(Lock.lock.equals("VETERAN")) {
			if(!(RankManager.getPlayerRank(player).equals("OWNER") || RankManager.getPlayerRank(player).equals("ADMIN") || RankManager.getPlayerRank(player).equals("MODPLUS") || RankManager.getPlayerRank(player).equals("MOD") || RankManager.getPlayerRank(player).equals("IMMORTAL") || RankManager.getPlayerRank(player).equals("VETERAN"))) {
				return false;
			} else {
				return true;
			}
		}
		if(Lock.lock.equals("RANGER")) {
			if(!(RankManager.getPlayerRank(player).equals("OWNER") || RankManager.getPlayerRank(player).equals("ADMIN") || RankManager.getPlayerRank(player).equals("MODPLUS") || RankManager.getPlayerRank(player).equals("MOD") || RankManager.getPlayerRank(player).equals("IMMORTAL") || RankManager.getPlayerRank(player).equals("VETERAN") || RankManager.getPlayerRank(player).equals("RANGER"))) {
				return false;
			} else {
				return true;
			}
		}
		if(Lock.lock.equals("DEFAULT")) {
			if(!(RankManager.getPlayerRank(player).equals("OWNER") || RankManager.getPlayerRank(player).equals("ADMIN") || RankManager.getPlayerRank(player).equals("MODPLUS") || RankManager.getPlayerRank(player).equals("MOD") || RankManager.getPlayerRank(player).equals("IMMORTAL") || RankManager.getPlayerRank(player).equals("VETERAN") || RankManager.getPlayerRank(player).equals("RANGER") || RankManager.getPlayerRank(player).equals("DEFAULT"))) {
				return false;
			} else {
				return true;
			}
		}
		return false;
		
		
	}
	
	public static boolean isTempKicked(Player player) {
		if(!Kick.KickDur.containsKey(player.getName()) || !Kick.KickTime.containsKey(player.getName())) {
			return false;
		} else {
			return true;
		}
	}
	
	public void TransferData(Player player) {
		YamlConfiguration oecc = YamlConfiguration.loadConfiguration(me.MrZombie_II.main.ChestConfig.ChestFile());
		YamlConfiguration os = YamlConfiguration.loadConfiguration(me.MrZombie_II.main.Stats.StatFile());
		File f = new File(Bukkit.getServer().getPluginManager().getPlugin("zWE").getDataFolder() + File.separator + "userdata" + File.separator + player.getName() + ".yml");
		YamlConfiguration necc = YamlConfiguration.loadConfiguration(f);
		
		try {
			oecc.load(me.MrZombie_II.main.ChestConfig.ChestFile());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
		}
		
		try {
			os.load(me.MrZombie_II.main.Stats.StatFile());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
		}
		
		int ok = os.getInt(player.getName() + ".kills");
		int oc = os.getInt(player.getName() + ".credits");
		int od = os.getInt(player.getName() + ".deaths");
		
		List<?> oeci = oecc.getList(player.getName() + ".ec");
		
		if(oeci !=null) {
			necc.set("ec", oeci);
		} else {
			player.sendMessage(ChatColor.RED + "Error: Exception! Unable to transfer enderchest data or enderchest doesn't exist!");
		}
		
		
		
		necc.set("kills", ok);
		necc.set("credits", oc);
		necc.set("deaths", od);
		
		try {
			necc.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

}
