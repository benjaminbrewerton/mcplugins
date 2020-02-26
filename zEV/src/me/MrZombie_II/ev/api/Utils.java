package me.MrZombie_II.ev.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import me.MrZombie_II.Listeners.StatsListener;
import me.MrZombie_II.api.Economy;
import me.MrZombie_II.gungame.GunGameCore;
import me.confuser.barapi.BarAPI;

public class Utils {
	
	public static Utils u = new Utils();
	
	public static Utils getInstance() {
		return u;
	}
	
	public Plugin zWE = Bukkit.getServer().getPluginManager().getPlugin("zEV");
	public List<Boolean> EventInProgress = new ArrayList<Boolean>();
	
	public boolean isAdmin(Player player) {
		if(player.isOp() || player.hasPermission("weed.admin")) return true;
		
		return false;
	}
	
	public int randInt(int min, int max) {

	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}

	//GUN GAME BELOW
	
	public List<Boolean> GunGameInProgress = new ArrayList<Boolean>();
	public List<Boolean> GunGameInProgressA = new ArrayList<Boolean>();
	public List<Boolean> InvincibilityGunGame = new ArrayList<Boolean>();
	public List<String> hoster = new ArrayList<String>();
	Player winner = null;
	
	public boolean GetGunGameInProgress() {
		if(GunGameInProgress.contains(true)) return true;
		if(GunGameInProgress.contains(false)) return false;
		return true;
	}
	public boolean GetInvincibilityState() {
		if(InvincibilityGunGame.contains(true)) return true;
		if(InvincibilityGunGame.contains(false)) return false;
		return true;
	}
	public boolean GetEventInProgress() {
		if(EventInProgress.contains(true)) return true;
		if(EventInProgress.contains(false)) return false;
		
		return true;
	}
	public boolean GetGunGameInProgressA() {
		if(GunGameInProgressA.contains(true)) return true;
		if(GunGameInProgressA.contains(false)) return false;
		
		return true;
	}
	public String GetPlayerHostingEvent() {
		return hoster.toString();
	}
	public void SetPlayerHostingEvent(String s) {
		hoster.clear();
		hoster.add(s);
	}
	public void SetGunGameInProgress(boolean b) {
		GunGameInProgress.clear();
		GunGameInProgress.add(b);
	}
	public void SetGunGameInProgressA(boolean b) {
		GunGameInProgressA.clear();
		GunGameInProgressA.add(b);
	}
	public void SetInvincibilityGunGameState(boolean b) {
		InvincibilityGunGame.clear();
		InvincibilityGunGame.add(b);
	}
	public void SetEventInProgress(boolean b) {
		EventInProgress.clear();
		EventInProgress.add(b);
	}
	public boolean isInGameGame(Player player) {
		if(GunGameCore.getGunGame().ggplayers.contains(player.getName())) return true;
		
		return false;
	}
	
	
	public void beginGunGame(final Player player) {
		SetEventInProgress(true);
		SetGunGameInProgress(true);
		
		Bukkit.broadcastMessage(ChatColor.AQUA + "A " + ChatColor.RED + "Gun Game" + ChatColor.AQUA + " is being hosted by " + player.getName());
		for(final Player p : Bukkit.getOnlinePlayers()) {
		
		Location l = p.getLocation();
		
		p.getWorld().playSound(l, Sound.IRONGOLEM_HIT, 1, 2);
		
		SetPlayerHostingEvent(player.getName());
		BarAPI.setMessage(p, ChatColor.AQUA + "A " + ChatColor.RED + "Gun Game" + ChatColor.AQUA + " is being hosted by " + player.getName());
		
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(zWE, new Runnable() {
			@Override
			public void run() {
				HeadsUpDisplay.displayLoadingBar(ChatColor.RED + "Type" + ChatColor.GRAY + " /event join GunGame " + ChatColor.RED + " to join!", ChatColor.RED + "An Gun Game event has started! with " + GunGameCore.getGunGame().ggplayers.size() + " players!", p, 30, true);
				BarAPI.setMessage(p, ChatColor.RED + "Type" + ChatColor.GRAY + " /event join GunGame " + ChatColor.RED + " to join!", 30);
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(zWE, new Runnable() {

					@Override
					public void run() {
						BarAPI.setMessage(p,  ChatColor.RED + "An Gun Game event has started! with " + GunGameCore.getGunGame().ggplayers.size() + " players!");
						
					}
					
				}, 600L);
			}
		}, 100L);
		
		
		}
	
		
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(zWE, new Runnable() {

			@Override
			public void run() {
				
				if(GunGameCore.getGunGame().ggplayers.size() < 2) {
					for(final Player pl : Bukkit.getOnlinePlayers()) {
							Location l = pl.getLocation();
							pl.getWorld().playSound(l, Sound.BLAZE_DEATH, 1, 2);
							
					
					
					BarAPI.setMessage(pl, ChatColor.RED + "Gun Game" + ChatColor.GRAY + " FAILED " + ChatColor.RED + " to host due to not enough players participating!", 5);
					Utils.getInstance().SetEventInProgress(false);
					Utils.getInstance().SetGunGameInProgress(false);
					Utils.getInstance().SetInvincibilityGunGameState(false);
					Utils.getInstance().SetPlayerHostingEvent("asd");
					GunGameCore.getGunGame().ggplayers.clear();
					
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(zWE, new Runnable() {

						@Override
						public void run() {
							BarAPI.setMessage(pl, ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Welcome to CreditZ!");
							
						}
						
					}, 100L);
					}
					return;
				}
				
				for(Player p : Bukkit.getOnlinePlayers()) {
				Location l = p.getLocation();
				p.getWorld().playSound(l, Sound.SHEEP_SHEAR, 1, 2);
				}
				
				for(String s : GunGameCore.getGunGame().ggplayers) {
					Player p1 = Bukkit.getServer().getPlayerExact(s);
					PlayerInventory pi = p1.getInventory();
					
					GunGameCore.getGunGame().playerinv.put(p1.getName(), pi.getContents());
					GunGameCore.getGunGame().playerarmour.put(p1.getName(), pi.getArmorContents());
					pi.clear();
					
					p1.setGameMode(GameMode.ADVENTURE);
					p1.teleport(new Location(Bukkit.getWorld("world"), -5, 81, -1051));
					
					GunGameCore.getGunGame().playertier.put(p1.getName(), 0);
					
					pi.addItem(new ItemStack(Material.STONE_SWORD, 1));
					pi.addItem(new ItemStack(Material.WOOD_SPADE, 1));
					pi.addItem(new ItemStack(Material.GOLD_NUGGET, 64));
					pi.addItem(new ItemStack(Material.GOLD_NUGGET, 64));
					pi.addItem(new ItemStack(Material.GOLD_NUGGET, 64));
					pi.addItem(new ItemStack(Material.GOLD_NUGGET, 64));
					
					
					pi.setHelmet(new ItemStack(Material.IRON_HELMET, 1));
					pi.setChestplate(new ItemStack(Material.IRON_CHESTPLATE, 1));
					pi.setLeggings(new ItemStack(Material.IRON_LEGGINGS, 1));
					pi.setBoots(new ItemStack(Material.IRON_BOOTS, 1));
					
					p1.sendMessage(ChatColor.DARK_AQUA + "Welcome to " + ChatColor.GOLD + "Gun Game" + ChatColor.AQUA + "!");
					p1.sendMessage(ChatColor.RED + "The Objective: To reach the highest tier gun and get the final kill with it to win 2.5k credits!");
					p1.sendMessage(ChatColor.GREEN + "You have 20 seconds of invincibility from now!");
					SetInvincibilityGunGameState(true);
				}
				SetGunGameInProgressA(true);
				updateGunGameSB();
				
				StringBuilder builder = new StringBuilder();
				for(String s : GunGameCore.getGunGame().ggplayers)
				builder.append(",").append(s);
				
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(zWE, new Runnable() {

					@Override
					public void run() {
						for(String s : GunGameCore.getGunGame().ggplayers) {
							Player p1 = Bukkit.getServer().getPlayerExact(s);
							p1.sendMessage(ChatColor.RED + "You have 10 seconds of invincibility left!");
						}
						
					}
					
				}, 20*10);
				
				
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(zWE, new Runnable() {

					@Override
					public void run() {
						SetInvincibilityGunGameState(false);
						for(String s : GunGameCore.getGunGame().ggplayers) {
							Player p1 = Bukkit.getServer().getPlayerExact(s);
							p1.sendMessage(ChatColor.RED + "Invincibility has worn off, good luck!");
						}
						
					}
					
				}, 20*20);
				
			}
			
			
		}, 20*36);
		
		
	}
	
	public boolean scoreboardset = false;
	
	public void updateGunGameSB () {
	
		ScoreboardManager sbm = Bukkit.getScoreboardManager();
		
		
        final Scoreboard sb = sbm.getNewScoreboard();
        Objective ob = sb.registerNewObjective("ggprogress", "dummy");
        ob.setDisplayName(ChatColor.BLUE + "GUN GAME");
        ob.setDisplaySlot(DisplaySlot.SIDEBAR);
        Team team = sb.registerNewTeam("gungamers");
        
        for(String s : GunGameCore.getGunGame().ggplayers) {
        	final Player p1 = Bukkit.getServer().getPlayerExact(s);
        	p1.setScoreboard(sbm.getNewScoreboard());
        	
        	team.addPlayer(p1);
        	
        	Score score = ob.getScore(p1);
        	score.setScore(GunGameCore.getGunGame().playertier.get(p1.getName()));
        	
        	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(zWE, new Runnable() {

				@Override
				public void run() {
					p1.setScoreboard(sb);
					
				}
        		
        	}, 10L);
        }
 
	}
	
	public ItemStack[] upgradeGunGameTier(Player player) {
		
		player.getInventory().clear();
		if(GunGameCore.getGunGame().ggplayers.contains(player.getName())) {
			if(GunGameCore.getGunGame().playertier.get(player.getName()) == 0) {
				return new ItemStack[] {
						new ItemStack(Material.STONE_SWORD, 1),
						new ItemStack(Material.WOOD_SPADE, 1),
						new ItemStack(Material.INK_SACK, 8, (byte) 4),
						new ItemStack(Material.GOLD_NUGGET, 64)
				};
			}
			if(GunGameCore.getGunGame().playertier.get(player.getName()) == 1) {
				return new ItemStack[] {
						new ItemStack(Material.STONE_SWORD, 1),
						new ItemStack(Material.WOOD_PICKAXE, 1),
						new ItemStack(Material.INK_SACK, 8, (byte) 4),
						new ItemStack(Material.SEEDS, 64)
				};
			}
			if(GunGameCore.getGunGame().playertier.get(player.getName()) == 2) {
				return new ItemStack[] {
						new ItemStack(Material.STONE_SWORD, 1),
						new ItemStack(Material.WOOD_HOE, 1),
						new ItemStack(Material.INK_SACK, 8, (byte) 4),
						new ItemStack(Material.FLINT, 64)
				};
			}
			if(GunGameCore.getGunGame().playertier.get(player.getName()) == 3) {
				return new ItemStack[] {
						new ItemStack(Material.STONE_SWORD, 1),
						new ItemStack(Material.WOOD_AXE, 1),
						new ItemStack(Material.INK_SACK, 8, (byte) 4),
						new ItemStack(Material.CLAY_BALL, 64),
				};
			}
			if(GunGameCore.getGunGame().playertier.get(player.getName()) == 4) {
				return new ItemStack[] {
						new ItemStack(Material.STONE_SWORD, 1),
						new ItemStack(Material.STONE_SPADE, 1),
						new ItemStack(Material.INK_SACK, 8, (byte) 4),
						new ItemStack(Material.GOLD_NUGGET, 64)
				};
			}
			if(GunGameCore.getGunGame().playertier.get(player.getName()) == 5) {
				return new ItemStack[] {
						new ItemStack(Material.STONE_SWORD, 1),
						new ItemStack(Material.STONE_PICKAXE, 1),
						new ItemStack(Material.INK_SACK, 8, (byte) 4),
						new ItemStack(Material.SEEDS, 64)
				};
			}
			if(GunGameCore.getGunGame().playertier.get(player.getName()) == 6) {
				return new ItemStack[] {
						new ItemStack(Material.STONE_SWORD, 1),
						new ItemStack(Material.STONE_HOE, 1),
						new ItemStack(Material.INK_SACK, 8, (byte) 4),
						new ItemStack(Material.FLINT, 64)
				};
			}
			if(GunGameCore.getGunGame().playertier.get(player.getName()) == 7) {
				return new ItemStack[] {
						new ItemStack(Material.STONE_SWORD, 1),
						new ItemStack(Material.STONE_AXE, 1),
						new ItemStack(Material.INK_SACK, 8, (byte) 4),
						new ItemStack(Material.CLAY_BALL, 64)
				};
			}
			if(GunGameCore.getGunGame().playertier.get(player.getName()) == 8) {
				return new ItemStack[] {
						new ItemStack(Material.STONE_SWORD, 1),
						new ItemStack(Material.IRON_SPADE, 1),
						new ItemStack(Material.INK_SACK, 8, (byte) 4),
						new ItemStack(Material.GOLD_NUGGET, 64)
				};
			}
			if(GunGameCore.getGunGame().playertier.get(player.getName()) == 9) {
				return new ItemStack[] {
						new ItemStack(Material.STONE_SWORD, 1),
						new ItemStack(Material.IRON_PICKAXE, 1),
						new ItemStack(Material.INK_SACK, 8, (byte) 4),
						new ItemStack(Material.SEEDS, 64)
				};
			}
			if(GunGameCore.getGunGame().playertier.get(player.getName()) == 10) {
				return new ItemStack[] {
						new ItemStack(Material.STONE_SWORD, 1),
						new ItemStack(Material.IRON_HOE, 1),
						new ItemStack(Material.INK_SACK, 8, (byte) 4),
						new ItemStack(Material.FLINT, 64)
				};
			}
			if(GunGameCore.getGunGame().playertier.get(player.getName()) == 11) {
				return new ItemStack[] {
						new ItemStack(Material.STONE_SWORD, 1),
						new ItemStack(Material.IRON_AXE, 1),
						new ItemStack(Material.INK_SACK, 8, (byte) 4),
						new ItemStack(Material.CLAY_BALL, 64)
				};
			}
			if(GunGameCore.getGunGame().playertier.get(player.getName()) == 12) {
				return new ItemStack[] {
						new ItemStack(Material.STONE_SWORD, 1),
						new ItemStack(Material.DIAMOND_SPADE, 1),
						new ItemStack(Material.INK_SACK, 8, (byte) 4),
						new ItemStack(Material.GOLD_NUGGET, 64)
				};
			}
			if(GunGameCore.getGunGame().playertier.get(player.getName()) == 13) {
				return new ItemStack[] {
						new ItemStack(Material.STONE_SWORD, 1),
						new ItemStack(Material.DIAMOND_PICKAXE, 1),
						new ItemStack(Material.INK_SACK, 8, (byte) 4),
						new ItemStack(Material.SEEDS, 64)
				};
			}
			if(GunGameCore.getGunGame().playertier.get(player.getName()) == 14) {
				return new ItemStack[] {
						new ItemStack(Material.STONE_SWORD, 1),
						new ItemStack(Material.DIAMOND_HOE, 1),
						new ItemStack(Material.INK_SACK, 8, (byte) 4),
						new ItemStack(Material.FLINT, 64),
						new ItemStack(Material.FLINT, 64),
						new ItemStack(Material.FLINT, 64),
						new ItemStack(Material.FLINT, 64)
				};
			}
			if(GunGameCore.getGunGame().playertier.get(player.getName()) == 15) {
				return new ItemStack[] {
						new ItemStack(Material.STONE_SWORD, 1),
						new ItemStack(Material.DIAMOND_AXE, 1),
						new ItemStack(Material.INK_SACK, 8, (byte) 4),
						new ItemStack(Material.CLAY_BALL, 64)
				};
			}
			if(GunGameCore.getGunGame().playertier.get(player.getName()) == 16) {
				return new ItemStack[] {
						new ItemStack(Material.STONE_SWORD, 1),
						new ItemStack(Material.GOLD_SPADE, 1),
						new ItemStack(Material.INK_SACK, 8, (byte) 4),
						new ItemStack(Material.SEEDS, 64)
				};
			}
			if(GunGameCore.getGunGame().playertier.get(player.getName()) == 17) {
				return new ItemStack[] {
						new ItemStack(Material.STONE_SWORD, 1),
						new ItemStack(Material.GOLD_PICKAXE, 1),
						new ItemStack(Material.INK_SACK, 8, (byte) 4),
						new ItemStack(Material.FLINT, 64)
				};
			}
			if(GunGameCore.getGunGame().playertier.get(player.getName()) == 18) {
				return new ItemStack[] {
						new ItemStack(Material.STONE_SWORD, 1),
						new ItemStack(Material.GOLD_HOE, 1),
						new ItemStack(Material.INK_SACK, 8, (byte) 4),
						new ItemStack(Material.FLINT, 64)
				};
			}
			if(GunGameCore.getGunGame().playertier.get(player.getName()) == 19) {
				return new ItemStack[] {
						new ItemStack(Material.STONE_SWORD, 1),
						new ItemStack(Material.GOLD_AXE, 1),
						new ItemStack(Material.INK_SACK, 8, (byte) 4),
						new ItemStack(Material.CLAY_BALL, 64)
				};
			}
			if(GunGameCore.getGunGame().playertier.get(player.getName()) == 20) {
				return new ItemStack[] {
						new ItemStack(Material.STONE_SWORD, 1),
						new ItemStack(Material.GOLD_SWORD, 1),
						new ItemStack(Material.INK_SACK, 8, (byte) 4),
						new ItemStack(Material.ARROW, 64)
				};
			}
			
			if(GunGameCore.getGunGame().playertier.get(player.getName()) == 21) {
				endGunGame(player);
			}
			
		}
		
		return null;
	}
	
	public void addTierScore(final Player player) {
	
		int i = GunGameCore.getGunGame().playertier.get(player.getName());
		final int ii = i + 1;
		GunGameCore.getGunGame().playertier.remove(player.getName());
				GunGameCore.getGunGame().playertier.put(player.getName(), ii);
		
	}
	
	//Player in this method is the winner
	public void endGunGame(final Player player) {
		SetInvincibilityGunGameState(true);
		for(Player p : Bukkit.getOnlinePlayers()) {
			Location l = p.getLocation();
			p.getWorld().playSound(l, Sound.FIREWORK_LARGE_BLAST, 2, 1);
			BarAPI.setMessage(p, ChatColor.RED + player.getName() + ChatColor.AQUA + " has won the Gun Game event!");
		}
		
		Bukkit.broadcastMessage(ChatColor.RED + player.getName() + ChatColor.AQUA + " has won the Gun Game event!");
		
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(zWE, new Runnable() {

			@Override
			public void run() {
				for(Player p : Bukkit.getOnlinePlayers()) {
				BarAPI.setMessage(p, ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Welcome to CreditZ!");
				}
				
				for(String s : GunGameCore.getGunGame().ggplayers) {
					Player p1 = Bukkit.getServer().getPlayerExact(s);
					p1.teleport(new Location(Bukkit.getWorld("world"), 0 , 100, 0));
					if(!p1.isDead()) {
						StatsListener.setPS(p1, 10L);
					}
				}
				player.teleport(new Location(Bukkit.getWorld("world"), 0 , 100, 0));
				
				SetEventInProgress(false);
				SetInvincibilityGunGameState(false);
				SetGunGameInProgress(false);
				SetGunGameInProgressA(true);
				SetPlayerHostingEvent(null);
				
				player.sendMessage(ChatColor.GREEN + "Congratulations, you have won" + ChatColor.RED + " Gun Game " + ChatColor.GREEN + "and won 2500 credits!");
				Economy.getEconomy().addBalance(player, 2500);
				
			}
			
			
		}, 100L);
		
		GunGameCore.getGunGame().diedby.clear();
		GunGameCore.getGunGame().playertier.clear();
		
		for(String s : GunGameCore.getGunGame().ggplayers) {
			Player p1 = Bukkit.getServer().getPlayerExact(s);
			
			p1.getInventory().setArmorContents(GunGameCore.getGunGame().playerarmour.get(p1.getName()));
			p1.getInventory().setContents(GunGameCore.getGunGame().playerinv.get(p1.getName()));
		}
		
		GunGameCore.getGunGame().ggplayers.clear();
		GunGameCore.getGunGame().playerinv.clear();
		GunGameCore.getGunGame().playerarmour.clear();
		
	}
	
	//TO DO EVENTS BELOW
}
