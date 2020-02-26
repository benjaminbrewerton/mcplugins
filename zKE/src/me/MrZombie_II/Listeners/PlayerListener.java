package me.MrZombie_II.Listeners;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.MrZombie_II.api.API;
import me.MrZombie_II.api.RankManager;
import me.MrZombie_II.commands.Lock;
import me.MrZombie_II.func.SpamManager;
import me.MrZombie_II.main.Main;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class PlayerListener implements Listener{
	public Main plugin;

	public PlayerListener(Main main) {
		this.plugin = main;
	}
	
	 @EventHandler
	  public void onPlayerInteract(PlayerInteractEvent event) {
	    Player player = event.getPlayer();
	    if (((event.getAction().equals(Action.RIGHT_CLICK_AIR)) || (event.getAction().equals(Action.RIGHT_CLICK_BLOCK))) && 
	      (!player.getGameMode().equals(GameMode.CREATIVE)) && 
	      (player.getItemInHand().getType().equals(Material.MUSHROOM_SOUP)))
	      if ((player.getHealth() < 20.0)) {
	        if (player.getHealth() < 20.0 - 7.0){
	          player.setHealth(player.getHealth() + 7.0);
	          player.getItemInHand().setType(Material.BOWL);
	        } else {
	          player.setHealth(player.getMaxHealth());
	          player.getItemInHand().setType(Material.BOWL);
	        }
	  
	      }
	    
	   
	 }
	 
	 
	 @EventHandler
	 public void RefillChestClick(PlayerInteractEvent event) {
		 ItemStack soup = new ItemStack(Material.MUSHROOM_SOUP, 1);
		 Player player = event.getPlayer();
		 if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			 if (event.getClickedBlock().getType() == Material.PISTON_BASE) {
				 Inventory soupcrate = Bukkit.createInventory(null, 54, ChatColor.RED + "" + ChatColor.BOLD + "--Soup Crate--");
				 for(int i=0; i<54; i++){
					 soupcrate.addItem(soup);
				 }
				 player.getWorld().playSound(player.getLocation(), Sound.CLICK, 1, 0);
				 player.openInventory(soupcrate);
			 }
		 }
		 
	 }
	 
	 
	 
	 
	 @EventHandler
	 public void BlockProtection(BlockBreakEvent event) {
		 Player player = event.getPlayer();
		 
		 
			 if (player.hasPermission("weed.admin") || (player.hasPermission("weed.coder") || player.isOp()) || player.hasPermission("weed.owner")) {
				 
			 } else {
				 event.setCancelled(true);
			 }
	 }
	 
	 @EventHandler
	 public void BlockProtection(BlockPlaceEvent event) {
		 Player player = event.getPlayer();
		 
		 
			 if (player.hasPermission("weed.admin") || (player.hasPermission("weed.coder") || player.isOp()) || player.hasPermission("weed.owner")) {
				 
			 } else {
				 event.setCancelled(true);
			 }
	 }
	 

	@EventHandler(priority=EventPriority.MONITOR)
	  public void onKill(PlayerDeathEvent event)
	  {
		
	    if ((event.getEntity().getKiller() instanceof Player)) {
	      event.setDeathMessage(null);
	    } else {
	    	event.setDeathMessage(null);
	    }
}

	
	
	
	@EventHandler
	public void onASyncPlayerChatEvent(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
		if (me.MrZombie_II.commands.ClearChat.chattoggler.contains("chatoff")) {
			event.setCancelled(true);
			if (player.hasPermission("weed.tc.bypass")) {
				event.setCancelled(false);
			} else {
				player.sendMessage(ChatColor.AQUA + "An operator has disabled chatting!");
			}
		}
		
		 int muteTime = 600;
		 if(me.MrZombie_II.commands.MutePlayer.mute.containsKey(player.getName())) {
			 
			 if (player.hasPermission("weed.mute.bypass")) {
            	 return;
             }
			 
             long muteLeft = ((me.MrZombie_II.commands.MutePlayer.mute.get(player.getName())) /1000 + muteTime) - (System.currentTimeMillis() /1000 );
             if(muteLeft > 0) {
            	 event.setCancelled(true);
            	 player.sendMessage(ChatColor.RED + "You are still muted!");
                 return;
             } 
             if (muteLeft <= 0) {
            	 me.MrZombie_II.commands.MutePlayer.mute.remove(player.getName());
             }
             
		 }
		
		if (player.hasPermission("weed.chat.color")) {
		event.setMessage(ChatColor.translateAlternateColorCodes('&',event.getMessage()));
		}
		
	}
		
		
		//Chat Fixes for groups
	public static List<String> onlineplayers = new ArrayList<String>();
	public static List<String> onlineplayersraw = new ArrayList<String>();
	public static List<String> onlinestaff = new ArrayList<String>();
	public static List<String> onlineadmins = new ArrayList<String>();
	public static List<String> randomplayer = new ArrayList<String>();
	
	public static List<String> Owner = new ArrayList<String>();
	public static List<String> Admin = new ArrayList<String>();
	public static List<String> Modplus = new ArrayList<String>();
	public static List<String> TrialMod = new ArrayList<String>();
	public static List<String> Immortal = new ArrayList<String>();
	public static List<String> Veteran = new ArrayList<String>();
	public static List<String> Ranger = new ArrayList<String>();
	public static List<String> Default = new ArrayList<String>();
	
	
	

	
	public static int PlayersOnline = 0;
	
	
	API api = new API();
	
	@EventHandler
	public void onPlayerJoinEvent(PlayerJoinEvent event) {
		final Player player = event.getPlayer();
		randomplayer.add(player.getName());
		event.setJoinMessage(null);
		
		if(!(api.canEnterLockedServer(player))) {
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

				@Override
				public void run() {
					player.kickPlayer(ChatColor.RED + "THE SERVER IS CURRENTLY LOCKED DOWN TO " + Lock.lock + " AND ABOVE! \n TRY AGAIN LATER");
					
				}
			}, 1L);
		}
		
		/*
		File f = new File(plugin.getDataFolder() + File.separator + "userdata" + File.separator + player.getName() + ".yml");
		if (!f.exists()) {
		try { 
			f.createNewFile();
		}
		catch (Exception e) { e.printStackTrace(); }
		
		
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

			@Override
			public void run() {
				File f = new File(plugin.getDataFolder() + File.separator + "userdata" + File.separator + player.getName() + ".yml");
				YamlConfiguration cfg = YamlConfiguration.loadConfiguration(f);
				cfg.set("hastransferreddata", false);
				cfg.set("credits", 1000);
				cfg.set("kills", 0);
				cfg.set("deaths", 0);
				try {
					cfg.save(f);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
			
			
		}, 10L);
		
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			@Override
			public void run() {
				API api = new API();
				api.TransferData(player);
			}
		}, 40L);
		
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			@Override
			public void run() {
				player.kickPlayer(ChatColor.RED + "Please Relog for your data to be successfully transferred!");
			}
		}, 80L);
		
		}
		*/
		
		player.sendMessage(ChatColor.RED + "Successfully logged on as a " + RankManager.getPlayerRank(player));
		
		if(!(player.hasPermission("weed.admin") || (player.hasPermission("weed.owner") || (player.hasPermission("weed.mod+"))))) {
			player.setGameMode(GameMode.ADVENTURE);
		} else {
			player.setGameMode(GameMode.CREATIVE);
		}
		
		if(player.hasPermission("weed.owner") || (player.hasPermission("weed.admin"))) {
			
			onlineadmins.add(player.getName());
		}
		
		if (player.hasPermission("weed.mod") || player.hasPermission("weed.mod+") || player.hasPermission("weed.headmod") ||
				player.hasPermission("weed.coder") || player.hasPermission("weed.admin") || player.isOp() || player.hasPermission("weed.owner")) {
			
			onlinestaff.add(player.getName());
			
		} else {

		onlineplayersraw.add(player.getName());
		}
		
		
		if(player.hasPermission("weed.mod+")) {
		String name = player.getName();
		if(name.length() > 12) {
			name = name.substring(0, 12);
			
		}
		
	
		
			if (player.isOp()) {
				onlineplayers.add("&4" + player.getName() + "&r");
				player.setDisplayName(ChatColor.DARK_RED + player.getName());
				player.setPlayerListName(ChatColor.DARK_RED + name);
			}
			else if (player.hasPermission("weed.ranger")) {
				onlineplayers.add("&e" + player.getName() + "&r");
				player.setDisplayName(ChatColor.YELLOW + player.getName());
				player.setPlayerListName(ChatColor.YELLOW + name);
			}
			else if (player.hasPermission("weed.veteran")) {
				onlineplayers.add("&a" + player.getName() + "&r");
				player.setDisplayName(ChatColor.GREEN + player.getName());
				player.setPlayerListName(ChatColor.GREEN + name);
			}
			else if (player.hasPermission("weed.immortal")) {
				onlineplayers.add("&3" + player.getName() + "&r");
				player.setDisplayName(ChatColor.DARK_AQUA + player.getName());
				player.setPlayerListName(ChatColor.DARK_AQUA + name);
			}
			else if (player.hasPermission("weed.mod")) {
				onlineplayers.add("&5" + player.getName() + "&r");
				player.setDisplayName(ChatColor.DARK_PURPLE + player.getName());
				player.setPlayerListName(ChatColor.DARK_PURPLE + name);
			}
			else if (player.hasPermission("weed.mod+")) {
				onlineplayers.add("&5 &o" + player.getName() + "&r");
				player.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.ITALIC + player.getName());
				player.setPlayerListName(ChatColor.DARK_PURPLE + "" + ChatColor.ITALIC + name);
			}
			else if (player.hasPermission("weed.admin" )) {
				onlineplayers.add("&c" + player.getName() + "&r");
				player.setDisplayName(ChatColor.RED + player.getName());
				player.setPlayerListName(ChatColor.RED + name);
			} 
			else if (player.hasPermission("weed.default")) {
				onlineplayers.add("&f" + player.getName() + "&r");
				player.setDisplayName(ChatColor.WHITE + player.getName());
				player.setPlayerListName(ChatColor.WHITE + name);
			}
			else if (player.hasPermission("weed.owner")) {
				onlineplayers.add("&4" + player.getName() + "&r");
				player.setDisplayName(ChatColor.DARK_RED + player.getName());
				player.setPlayerListName(ChatColor.DARK_RED + name);
			}
			else { 
				onlineplayers.add(player.getName());
			}
			
		} else {
			String name = player.getName();
			if(name.length() > 14) {
				name = name.substring(0, 14);
				
			}
			
		
			
				if (player.isOp()) {
					onlineplayers.add("&4" + player.getName() + "&r");
					player.setDisplayName(ChatColor.DARK_RED + player.getName());
					player.setPlayerListName(ChatColor.DARK_RED + name);
				}
				else if (player.hasPermission("weed.ranger")) {
					onlineplayers.add("&e" + player.getName() + "&r");
					player.setDisplayName(ChatColor.YELLOW + player.getName());
					player.setPlayerListName(ChatColor.YELLOW + name);
				}
				else if (player.hasPermission("weed.veteran")) {
					onlineplayers.add("&a" + player.getName() + "&r");
					player.setDisplayName(ChatColor.GREEN + player.getName());
					player.setPlayerListName(ChatColor.GREEN + name);
				}
				else if (player.hasPermission("weed.immortal")) {
					onlineplayers.add("&3" + player.getName() + "&r");
					player.setDisplayName(ChatColor.DARK_AQUA + player.getName());
					player.setPlayerListName(ChatColor.DARK_AQUA + name);
				}
				else if (player.hasPermission("weed.mod")) {
					onlineplayers.add("&5" + player.getName() + "&r");
					player.setDisplayName(ChatColor.DARK_PURPLE + player.getName());
					player.setPlayerListName(ChatColor.DARK_PURPLE + name);
				}
				else if (player.hasPermission("weed.mod+")) {
					onlineplayers.add("&5 &o" + player.getName() + "&r");
					player.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.ITALIC + player.getName());
					player.setPlayerListName(ChatColor.DARK_PURPLE + "" + ChatColor.ITALIC + name);
				}
				else if (player.hasPermission("weed.admin" )) {
					onlineplayers.add("&c" + player.getName() + "&r");
					player.setDisplayName(ChatColor.RED + player.getName());
					player.setPlayerListName(ChatColor.RED + name);
				} 
				else if (player.hasPermission("weed.default")) {
					onlineplayers.add("&f" + player.getName() + "&r");
					player.setDisplayName(ChatColor.WHITE + player.getName());
					player.setPlayerListName(ChatColor.WHITE + name);
				}
				else if (player.hasPermission("weed.owner")) {
					onlineplayers.add("&4" + player.getName() + "&r");
					player.setDisplayName(ChatColor.DARK_RED + player.getName());
					player.setPlayerListName(ChatColor.DARK_RED + name);
				}
				else { 
					onlineplayers.add(player.getName());
				}
				
			
		}
		//Vanish Stuff VVV
		
		if (player.isOp()) {
			Owner.add(player.getDisplayName() + "§r");
			Collections.sort(Owner);
		}
		else if (player.hasPermission("weed.ranger")) {
			Ranger.add(player.getDisplayName() + "§r");
			Collections.sort(Ranger);
		}
		else if (player.hasPermission("weed.veteran")) {
			Veteran.add(player.getDisplayName() + "§r");
			Collections.sort(Veteran);
		}
		else if (player.hasPermission("weed.immortal")) {
			Immortal.add(player.getDisplayName() + "§r");
			Collections.sort(Immortal);
		}
		else if (player.hasPermission("weed.mod")) {
			TrialMod.add(player.getDisplayName() + "§r");
			Collections.sort(TrialMod);
		}
		else if (player.hasPermission("weed.mod+")) {
			Modplus.add(player.getDisplayName() + "§r");
			Collections.sort(Modplus);
		}
		else if (player.hasPermission("weed.admin" )) {
			Admin.add(player.getDisplayName() + "§r");
			Collections.sort(Admin);
		} 
		else if (player.hasPermission("weed.default")) {
			Default.add(player.getDisplayName() + "§r");
			Collections.sort(Default);
		}
		else if (player.hasPermission("weed.owner")) {
			Owner.add(player.getDisplayName() + "§r");
			Collections.sort(Owner);
		}
		
			
		
		for (String s : me.MrZombie_II.commands.Vanish.vanished) {
			Player p = Bukkit.getServer().getPlayerExact(s);
			for (String s1 : onlineplayersraw) {
					
				Player p1 = Bukkit.getServer().getPlayerExact(s1);
				
				if(p1 == null) {
					return;
					
				}
				
				p1.hidePlayer(p);
				
				
			}
		}
	
	}
	
	@EventHandler
	public void onPlayerMiscLeave(PlayerKickEvent event) {
		Player player = event.getPlayer();
		if(onlineadmins.contains(player.getName())) {
			
			onlineadmins.remove(player.getName());
		}
		
		if (me.MrZombie_II.commands.Vanish.vanished.contains(player.getName())) {	
			
			me.MrZombie_II.Listeners.PlayerListener.PlayersOnline--;
			me.MrZombie_II.commands.Vanish.vanished.remove(player.getName());
			
			for (String s : me.MrZombie_II.Listeners.PlayerListener.onlineplayersraw) {
                Player p = Bukkit.getServer().getPlayerExact(s);
                p.showPlayer(player);
        }
		}
		
		randomplayer.remove(player.getName());
		event.setLeaveMessage(null);
		onlineplayersraw.remove(player.getName());
		
		
		if (player.isOp()) {
			Owner.remove(player.getDisplayName() + "§r");
			Collections.sort(Owner);
		}
		else if (player.hasPermission("weed.ranger")) {
			Ranger.remove(player.getDisplayName() + "§r");
			Collections.sort(Ranger);
		}
		else if (player.hasPermission("weed.veteran")) {
			Veteran.remove(player.getDisplayName() + "§r");
			Collections.sort(Veteran);
		}
		else if (player.hasPermission("weed.immortal")) {
			Immortal.remove(player.getDisplayName() + "§r");
			Collections.sort(Immortal);
		}
		else if (player.hasPermission("weed.mod")) {
			TrialMod.remove(player.getDisplayName() + "§r");
			Collections.sort(TrialMod);
		}
		else if (player.hasPermission("weed.mod+")) {
			Modplus.remove(player.getDisplayName() + "§r");
			Collections.sort(Modplus);
		}
		else if (player.hasPermission("weed.admin" )) {
			Admin.remove(player.getDisplayName() + "§r");
			Collections.sort(Admin);
		} 
		else if (player.hasPermission("weed.default")) {
			Default.remove(player.getDisplayName() + "§r");
			Collections.sort(Default);
		}
		else if (player.hasPermission("weed.owner")) {
			Owner.remove(player.getDisplayName() + "§r");
			Collections.sort(Owner);
		}
	
	
	}
	
	@EventHandler
	public void onPlayerLeaveEvent(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		if(onlineadmins.contains(player.getName())) {
			
			onlineadmins.remove(player.getName());
		}
		
		if (me.MrZombie_II.commands.Vanish.vanished.contains(player.getName())) {	
			
			me.MrZombie_II.Listeners.PlayerListener.PlayersOnline--;
			me.MrZombie_II.commands.Vanish.vanished.remove(player.getName());
			
			for (String s : me.MrZombie_II.Listeners.PlayerListener.onlineplayersraw) {
                Player p = Bukkit.getServer().getPlayerExact(s);
                p.showPlayer(player);
        }
		}
		
		randomplayer.remove(player.getName());
		event.setQuitMessage(null);
		onlineplayersraw.remove(player.getName());
		
		
		if (player.isOp()) {
			Owner.remove(player.getDisplayName() + "§r");
			Collections.sort(Owner);
		}
		else if (player.hasPermission("weed.ranger")) {
			Ranger.remove(player.getDisplayName() + "§r");
			Collections.sort(Ranger);
		}
		else if (player.hasPermission("weed.veteran")) {
			Veteran.remove(player.getDisplayName() + "§r");
			Collections.sort(Veteran);
		}
		else if (player.hasPermission("weed.immortal")) {
			Immortal.remove(player.getDisplayName() + "§r");
			Collections.sort(Immortal);
		}
		else if (player.hasPermission("weed.mod")) {
			TrialMod.remove(player.getDisplayName() + "§r");
			Collections.sort(TrialMod);
		}
		else if (player.hasPermission("weed.mod+")) {
			Modplus.remove(player.getDisplayName() + "§r");
			Collections.sort(Modplus);
		}
		else if (player.hasPermission("weed.admin" )) {
			Admin.remove(player.getDisplayName() + "§r");
			Collections.sort(Admin);
		} 
		else if (player.hasPermission("weed.default")) {
			Default.remove(player.getDisplayName() + "§r");
			Collections.sort(Default);
		}
		else if (player.hasPermission("weed.owner")) {
			Owner.remove(player.getDisplayName() + "§r");
			Collections.sort(Owner);
		}
	
	
	}
	
	@EventHandler
	public void HungerFix (FoodLevelChangeEvent event) {
		event.setCancelled(true);
		
	}
	
	
	@EventHandler
    public void onItemSpawn(final ItemSpawnEvent e) {
		Material i = e.getEntity().getItemStack().getType();
		if(i == Material.REDSTONE_TORCH_ON || i == Material.SAND || 
			i == Material.STONE_BUTTON || i == Material.BONE ||
			i == Material.FEATHER || i == Material.FIREWORK ||
			i == Material.STICK || i == Material.WOOD_HOE ||
			i == Material.BLAZE_ROD || i == Material.EGG ||
			i == Material.IRON_DOOR || i == Material.SNOW_BALL ||
			i == Material.LEATHER_BOOTS || i == Material.BEACON ||
			i == Material.WATCH || i == Material.GOLD_AXE ||
			i == Material.IRON_AXE || i == Material.PAPER) {
			
			e.setCancelled(true);
			return;
		}
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            public void run() {
            	
            	e.getEntity().getLocation().getWorld().playEffect(e.getEntity().getLocation(), Effect.SMOKE, 0);
            	e.getEntity().getLocation().getWorld().playSound(e.getEntity().getLocation(), Sound.ITEM_PICKUP, 1, 0);
                e.getEntity().remove();
            }
        }, 10 * 20);
       
    }
	
	
	
	@EventHandler
	public void ChatFix (AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
		
		String msg = event.getMessage();
		
		if (player.isOp()) {
			event.setFormat("<" + player.getDisplayName() + ChatColor.RESET +">" + ChatColor.AQUA + " %2$s");
		}
		else if (player.hasPermission("weed.ranger")) {
			event.setFormat("<" + player.getDisplayName() + ChatColor.RESET +">" + " %2$s");
		}
		else if (player.hasPermission("weed.veteran")) {
			event.setFormat("<" + player.getDisplayName() + ChatColor.RESET +">"  + " %2$s");
		}
		else if (player.hasPermission("weed.immortal")) {
			event.setFormat("<" + player.getDisplayName() + ChatColor.RESET +">"  + " %2$s");
		}
		else if (player.hasPermission("weed.mod")) {
			event.setFormat("<" + player.getDisplayName() + ChatColor.RESET +">"  + " %2$s");
		}
		else if (player.hasPermission("weed.mod+")) {
			event.setFormat("<" + player.getDisplayName() + ChatColor.RESET + ">"   + " %2$s");
		}
		else if (player.hasPermission("weed.admin" )) {
			event.setFormat("<" + player.getDisplayName() + ChatColor.RESET +">"  + " %2$s");
		} 
		else if (player.hasPermission("weed.default")) {
			event.setFormat("<" + player.getDisplayName() + ChatColor.RESET +">"  + " %2$s");
		}
		else if (player.hasPermission("weed.owner")) {
			event.setFormat("<" + player.getDisplayName() + ChatColor.RESET +">"  + ChatColor.AQUA  + " %2$s");
		}
		
	}
	
	@EventHandler
	public void WeatherFix (WeatherChangeEvent event) {
		event.setCancelled(true);
		
	}
	
	/* 
	 * Fixes for WarZ steak, Drinks and other things below
	 * Do not touch
	 */
	
	private List<String> steak = new ArrayList<String>();
	
	@EventHandler
	public void SteakFix (PlayerInteractEvent event) {
		
		    final Player player = event.getPlayer();

		    ItemStack i = new ItemStack(player.getInventory().getItemInHand());
		    
		    if (((event.getAction().equals(Action.RIGHT_CLICK_AIR)) || (event.getAction().equals(Action.RIGHT_CLICK_BLOCK))) && 
		      (!player.getGameMode().equals(GameMode.CREATIVE)) && 
		      (i.getType().equals(Material.COOKED_BEEF)))
		    {
		    	
		    if(steak.contains(player.getName())) return;

		    if ((player.getHealth() < 20.0)) {
		        if (player.getHealth() < 20.0 - 10.0){
		          player.setHealth(player.getHealth() + 10.0);
		        } else {
		          player.setHealth(player.getMaxHealth());
		        }
		    } else {
		    	
		    	return;
		    }
		          PlayerInventory pi = player.getInventory();

		          int samnt = pi.getItemInHand().getAmount() - 1;
		          
		          steak.add(player.getName());
			    	
			      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

					@Override
					public void run() {
						steak.remove(player.getName());
						
					}
			    	  
			      }, 20L);
		          
			      if(samnt == 0 ) {
			    	  pi.setItemInHand(new ItemStack(Material.AIR));
		        	  return;
		          }
		          
			      ItemStack steake = new ItemStack(Material.COOKED_BEEF, samnt);
		          ItemMeta mdmeta = steake.getItemMeta();
		  	    mdmeta.setDisplayName(ChatColor.AQUA + "Steak");
		          pi.setItemInHand(steake);
			      
		  }
	}
	
	
	private List<String> md = new ArrayList<String>();
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void MDFix (PlayerInteractEvent event) {
		
		    final Player player = event.getPlayer();

		    
		    ItemStack i = new ItemStack(player.getInventory().getItemInHand());

		    if (((event.getAction().equals(Action.RIGHT_CLICK_AIR)) || (event.getAction().equals(Action.RIGHT_CLICK_BLOCK))) && 
		      (!player.getGameMode().equals(GameMode.CREATIVE)) && 
		      (i.getType() == Material.INK_SACK && ((byte)i.getData().getData() == 15)))
		    {
		    	
		    if(md.contains(player.getName())) return;
		    if(player.getHealth() == player.getMaxHealth()) return;
		    
		          player.setHealth(player.getMaxHealth());

		          PlayerInventory pi = player.getInventory();

		          int samnt = pi.getItemInHand().getAmount() - 1;
		          
		          md.add(player.getName());
			    	
			      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

					@Override
					public void run() {
						md.remove(player.getName());
						
					}
			    	  
			      }, 10L);
		          
		          if(samnt == 0 ) {
		        	  
		        	  pi.setItemInHand(new ItemStack(Material.AIR));
		        	  return;
		          }
		          


		          ItemStack steake = new ItemStack(Material.INK_SACK, samnt, (byte) 15);
		          ItemMeta mdmeta = steake.getItemMeta();
		  	    mdmeta.setDisplayName(ChatColor.AQUA + "Mountain Dew");
		  	    steake.setItemMeta(mdmeta);
		          pi.setItemInHand(steake);

		  }
	}
	
	private List<String> pepsi = new ArrayList<String>();
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void PepsiFix (PlayerInteractEvent event) {
		
		    final Player player = event.getPlayer();
		    
		    
		    ItemStack i = new ItemStack(player.getInventory().getItemInHand());
		    
		    
		    if (((event.getAction().equals(Action.RIGHT_CLICK_AIR)) || (event.getAction().equals(Action.RIGHT_CLICK_BLOCK))) && 
		      (!player.getGameMode().equals(GameMode.CREATIVE)) && 
		      (i.getType() == Material.INK_SACK && ((byte)i.getData().getData() == 14)))
		    {
		    	
		    if(pepsi.contains(player.getName())) return;
		    
		    if(player.getHealth() >= 19D) {
		    	return;
		    }
		    
		    
		    PlayerInventory pi = player.getInventory();

	          int samnt = pi.getItemInHand().getAmount() - 1;
	          
	          pepsi.add(player.getName());
			    
			     Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

					@Override
					public void run() {
						pepsi.remove(player.getName());
						
					}
			    	  
			      }, 2L);
	          
	          if(samnt == 0 ) {
	        	  
	        	  pi.setItemInHand(new ItemStack(Material.AIR));
	        	  return;
	          }
	          


	          ItemStack steake = new ItemStack(Material.INK_SACK, samnt, (byte) 14);
	          ItemMeta pepsimeta = steake.getItemMeta();
	  	    pepsimeta.setDisplayName(ChatColor.AQUA + "Pepsi");
	  	    steake.setItemMeta(pepsimeta);
	          pi.setItemInHand(steake);
		    
		    
		    player.setHealth(player.getHealth() + 1.0D);
		    

	  }
		    
}
	
	
	
	@EventHandler
	public void VanishDrops (PlayerPickupItemEvent event) {
		Player player = event.getPlayer();
		
		if(me.MrZombie_II.commands.Vanish.vanished.contains(player.getName())) {
			
			event.setCancelled(true);
		}
		
	}
	
	private List<String> bean = new ArrayList<String>();
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void BeansFix (PlayerInteractEvent event) {
		
		    final Player player = event.getPlayer();

		    
		    ItemStack i = new ItemStack(player.getInventory().getItemInHand());
		    
		    
  	    	
		    
		    if (((event.getAction().equals(Action.RIGHT_CLICK_AIR)) || (event.getAction().equals(Action.RIGHT_CLICK_BLOCK))) && 
		      (!player.getGameMode().equals(GameMode.CREATIVE)) && 
		      (i.getType() == Material.INK_SACK && ((byte)i.getData().getData() == 4)))
		    {
		    	
		    if(bean.contains(player.getName())) return;
		    
		    
		    if ((player.getHealth() < 20.0)) {
		        if (player.getHealth() < 20.0 - 7.0){
		          player.setHealth(player.getHealth() + 7.0);
		        } else {
		          player.setHealth(player.getMaxHealth());
		        }
		    } else {
		    	
		    	return;
		    }

		          PlayerInventory pi = player.getInventory();

		          int samnt = pi.getItemInHand().getAmount() - 1;
		          
		          bean.add(player.getName());
			    	
			      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

					@Override
					public void run() {
						bean.remove(player.getName());
						
					}
			    	  
			      }, 15L);
		          
		          if(samnt == 0 ) {
		        	  
		        	  pi.setItemInHand(new ItemStack(Material.AIR));
		        	  return;
		          }
		          


		          ItemStack steake = new ItemStack(Material.INK_SACK, samnt, (byte) 4);
		          ItemMeta mdmeta = steake.getItemMeta();
		  	    mdmeta.setDisplayName(ChatColor.AQUA + "Canned Beans");
		  	    steake.setItemMeta(mdmeta);
		          pi.setItemInHand(steake);

		  }
	}
	
	private List<String> pasta = new ArrayList<String>();
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void PasteFix (PlayerInteractEvent event) {
		
		    final Player player = event.getPlayer();

		    
		    ItemStack i = new ItemStack(player.getInventory().getItemInHand());
		    
		    
  	    	
		    
		    if (((event.getAction().equals(Action.RIGHT_CLICK_AIR)) || (event.getAction().equals(Action.RIGHT_CLICK_BLOCK))) && 
		      (!player.getGameMode().equals(GameMode.CREATIVE)) && 
		      (i.getType() == Material.INK_SACK && ((byte)i.getData().getData() == 11)))
		    {
		    	
		    if(pasta.contains(player.getName())) return;
		    
		    
		    if ((player.getHealth() < 20.0)) {
		        if (player.getHealth() < 20.0 - 8.0){
		          player.setHealth(player.getHealth() + 8.0);
		          player.getItemInHand().setType(Material.BOWL);
		        } else {
		          player.setHealth(player.getMaxHealth());
		          player.getItemInHand().setType(Material.BOWL);
		        }
		    } else {
		    	
		    	return;
		    }

		          PlayerInventory pi = player.getInventory();

		          int samnt = pi.getItemInHand().getAmount() - 1;

		          
		          pasta.add(player.getName());
			    	
			      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

					@Override
					public void run() {
						pasta.remove(player.getName());
						
					}
			    	  
			      }, 20L);
		          
		          if(samnt == 0 ) {
		        	  
		        	  pi.setItemInHand(new ItemStack(Material.AIR));
		        	  return;
		          }
		          
		          
		          ItemStack steake = new ItemStack(Material.INK_SACK, samnt, (byte) 11);
		          ItemMeta mdmeta = steake.getItemMeta();
		  	    mdmeta.setDisplayName(ChatColor.AQUA + "Canned Pasta");
		  	    steake.setItemMeta(mdmeta);
		          pi.setItemInHand(steake);
		          

		  }
	}
	
	private float getCompressedAngle(float value) {
        return (value * 256.0F / 360.0F);
	}
	
	@EventHandler
	  public void onHealthPotInteract(PlayerInteractEvent event) {
	    Player player = event.getPlayer();
	    if (((event.getAction().equals(Action.RIGHT_CLICK_AIR)) || (event.getAction().equals(Action.RIGHT_CLICK_BLOCK))) && 
	      (!player.getGameMode().equals(GameMode.CREATIVE)) && 
	      (player.getItemInHand().getType().equals(Material.POTION) && (byte) player.getItemInHand().getData().getData() == 8229))
	    {	
	    	
	    	event.setCancelled(true);
	      if ((player.getHealth() < 20.0)) {
	        if (player.getHealth() < 20.0 - 7.0){
	          player.setHealth(player.getHealth() + 7.0);
	          player.getItemInHand().setType(Material.GLASS_BOTTLE);
	        } else {
	          player.setHealth(player.getMaxHealth());
	          player.getItemInHand().setType(Material.GLASS_BOTTLE);
	        }
	  
	      }
	    }
	   
	 }
	
	
	
	@EventHandler
	public void PLFIX (PlayerCommandPreprocessEvent event) {
		Player player = event.getPlayer();
		
		String[] st = event.getMessage().split("\\s+");
		String command = st[0].substring(1);
		
		
	    if (player.hasPermission("weed.pl")) return;
	      
	    if(command.equalsIgnoreCase("pl") || command.equalsIgnoreCase("plugins")) {
	    player.sendMessage(ChatColor.WHITE + "Plugins (3): " + ChatColor.GREEN + "zWE" + ChatColor.WHITE + ", " + ChatColor.GREEN + "zWAC" + ChatColor.WHITE + ", " + ChatColor.GREEN + "zGUNS");
	    event.setCancelled(true);
	    }
	    
	    
	    }
	
	
	/*
	@EventHandler
	public void enderchest (InventoryCloseEvent event) {
		Inventory i = event.getInventory();
		Player player = (Player) event.getPlayer();
		File f = new File(Bukkit.getServer().getPluginManager().getPlugin("zWE").getDataFolder() + File.separator + "userdata" + File.separator + player.getName() + ".yml");
		final FileConfiguration cfg = YamlConfiguration.loadConfiguration(f);
		
		if(player.isOp()) {
			
			try {
				cfg.load(f);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InvalidConfigurationException e) {
				e.printStackTrace();
			}
			
			if(i.getName().equals(ChatColor.DARK_AQUA + "Personal Chest")) {
				
				cfg.set("ec", i.getContents());
				
				try {
					cfg.save(f);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
			} else
		if(player.hasPermission("weed.default")) {
			try {
				cfg.load(f);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InvalidConfigurationException e) {
				e.printStackTrace();
			}
			
			if(i.getName().equals(ChatColor.GRAY + "Personal Chest")) {
				
				cfg.set("ec", i.getContents());
				
				try {
					cfg.save(f);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		} else
		if(player.hasPermission("weed.ranger")) {
			try {
				cfg.load(f);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InvalidConfigurationException e) {
				e.printStackTrace();
			}
			
			if(i.getName().equals(ChatColor.YELLOW + "Personal Chest")) {
				
				cfg.set("ec", i.getContents());
				
				try {
					cfg.save(f);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
			} else
		if(player.hasPermission("weed.veteran")) {
			try {
				cfg.load(f);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InvalidConfigurationException e) {
				e.printStackTrace();
			}
			
			if(i.getName().equals(ChatColor.GREEN + "Personal Chest")) {
				
				cfg.set("ec", i.getContents());
				
				try {
					cfg.save(f);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
			} else
		if(player.hasPermission("weed.immortal")) {
			try {
				cfg.load(f);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InvalidConfigurationException e) {
				e.printStackTrace();
			}
			
			if(i.getName().equals(ChatColor.DARK_AQUA + "Personal Chest")) {
				
				cfg.set("ec", i.getContents());
				
				try {
					cfg.save(f);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
			}
		if(player.hasPermission("weed.mod")) {
			try {
				cfg.load(f);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InvalidConfigurationException e) {
				e.printStackTrace();
			}
			
			if(i.getName().equals(ChatColor.DARK_AQUA + "Personal Chest")) {
				
				cfg.set("ec", i.getContents());
				
				try {
					cfg.save(f);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
			} else
		if(player.hasPermission("weed.mod+")) {
			try {
				cfg.load(f);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InvalidConfigurationException e) {
				e.printStackTrace();
			}
			
			if(i.getName().equals(ChatColor.DARK_AQUA + "Personal Chest")) {
				
				cfg.set("ec", i.getContents());
				
				try {
					cfg.save(f);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
			} else
		if(player.hasPermission("weed.admin")) {
			try {
				cfg.load(f);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InvalidConfigurationException e) {
				e.printStackTrace();
			}
			
			if(i.getName().equals(ChatColor.DARK_AQUA + "Personal Chest")) {
				
				cfg.set("ec", i.getContents());
				
				try {
					cfg.save(f);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
			}
	}
	*/
	
	@EventHandler
	  public void onPlayerChat(PlayerChatEvent event) {
	    SpamManager.OnPlayerChat(event);
	  }
	
	public Integer getPlayerIntHealth(Player player) {
		if(player.isDead()) return 0;
		if(player.getHealth() == 1D) return 1;
		if(player.getHealth() == 2D) return 2;
		if(player.getHealth() == 3D) return 3;
		if(player.getHealth() == 4D) return 4;
		if(player.getHealth() == 5D) return 5;
		if(player.getHealth() == 6D) return 6;
		if(player.getHealth() == 7D) return 7;
		if(player.getHealth() == 8D) return 8;
		if(player.getHealth() == 9D) return 9;
		if(player.getHealth() == 10D) return 10;
		if(player.getHealth() == 11D) return 11;
		if(player.getHealth() == 12D) return 12;
		if(player.getHealth() == 13D) return 13;
		if(player.getHealth() == 14D) return 14;
		if(player.getHealth() == 15D) return 15;
		if(player.getHealth() == 16D) return 16;
		if(player.getHealth() == 17D) return 17;
		if(player.getHealth() == 18D) return 18;
		if(player.getHealth() == 19D) return 19;
		if(player.getHealth() == 20D) return 20;
		
		return null;
	}

	@EventHandler(priority=EventPriority.MONITOR)
    public void explodeHeight(EntityExplodeEvent e) {
        if(e.getEntityType() == EntityType.PRIMED_TNT) {
            e.blockList().clear();
        }
        if(e.getEntityType() == EntityType.FIREBALL) {
            e.blockList().clear();
        }
    }
	
}
	
