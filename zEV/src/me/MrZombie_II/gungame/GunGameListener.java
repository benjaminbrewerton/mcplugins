package me.MrZombie_II.gungame;

import me.MrZombie_II.ev.api.Cuboid;
import me.MrZombie_II.ev.api.Utils;
import me.MrZombie_II.zEV.main.Main;
import net.minecraft.server.v1_7_R1.EnumClientCommand;
import net.minecraft.server.v1_7_R1.PacketPlayInClientCommand;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_7_R1.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

public class GunGameListener implements Listener {
	
	public Main plugin;
	
	public GunGameListener(Main main) {
		this.plugin = main;
	}
	
	
	@EventHandler(priority = EventPriority.MONITOR)
	public void GunGameDeathRegistration(PlayerDeathEvent event) {
		if(!Utils.getInstance().GetGunGameInProgress()) return;
		
		
		Player player = event.getEntity().getPlayer();
		final Player killer = event.getEntity().getKiller();
		
		if(!GunGameCore.getGunGame().ggplayers.contains(player.getName()) || !GunGameCore.getGunGame().ggplayers.contains(killer.getName())) return;
		
		Utils.getInstance().addTierScore(killer);
		
		
		PacketPlayInClientCommand packet = new PacketPlayInClientCommand(EnumClientCommand.PERFORM_RESPAWN);
		((CraftPlayer)player).getHandle().playerConnection.a(packet);
		
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

			@Override
			public void run() {
				killer.getInventory().setContents(Utils.getInstance().upgradeGunGameTier(killer));
				
			}
			
			
		}, 5L);

			for(String s : GunGameCore.getGunGame().ggplayers) {
				Player p1 = Bukkit.getServer().getPlayerExact(s);
				p1.sendMessage(ChatColor.AQUA + killer.getName() + ChatColor.GRAY + " has killed " + ChatColor.RED + 
						player.getName());
			}
			
			Utils.getInstance().updateGunGameSB();
			
		
		
	}

	@EventHandler
	public void GunGameAbuseFix(PlayerCommandPreprocessEvent event) {
		if(!Utils.getInstance().GetGunGameInProgress()) return;
		
		if(GunGameCore.getGunGame().ggplayers.contains(event.getPlayer().getName())) {
			event.getPlayer().sendMessage(ChatColor.RED + "You cannot use commands while in a Gun Game!");
			event.setCancelled(true);
		}
	}
	
	@EventHandler
	public void GunGameInvincibility(EntityDamageByEntityEvent event) {
		Entity e = event.getEntity();
		
		Player player = null;
		Player hurt = (Player) event.getEntity();
		if(e instanceof Snowball) {
			Snowball s = (Snowball) event.getEntity();
			if(s.getShooter() instanceof Player) {
				player = (Player) s.getShooter();
			}
		}
		
		if(e instanceof Player) {
			player = (Player) event.getEntity();
		}
		
		if(Utils.getInstance().GetGunGameInProgress() && GunGameCore.getGunGame().ggplayers.contains(player.getName()) && Utils.getInstance().GetInvincibilityState()) {
			hurt.sendMessage(ChatColor.RED + "Invincibility is enabled!");
			event.setCancelled(true);
		}
	}
	
	@EventHandler
	public void GunGameLeave(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		
		if(GunGameCore.getGunGame().ggplayers.contains(player.getName()) && Utils.getInstance().GetGunGameInProgress()) {
			GunGameCore.getGunGame().ggplayers.remove(player.getName());
			for(String s : GunGameCore.getGunGame().ggplayers) {
				Player p1 = Bukkit.getServer().getPlayerExact(s);
				p1.sendMessage(ChatColor.RED + player.getName() + ChatColor.DARK_AQUA + " has abandoned gun game!");
			}
			player.teleport(new Location(Bukkit.getWorld("world"), 0 , 100 ,0));
		}
		
		if(GunGameCore.getGunGame().ggplayers.size() == 1) {
			for(String s : GunGameCore.getGunGame().ggplayers) {
			Utils.getInstance().endGunGame(Bukkit.getPlayerExact(s));
			}
		}
		
	}
	
	@EventHandler
	public void GunGameLeave(PlayerKickEvent event) {
		Player player = event.getPlayer();
		
		if(GunGameCore.getGunGame().ggplayers.contains(player.getName()) && Utils.getInstance().GetGunGameInProgress()) {
			GunGameCore.getGunGame().ggplayers.remove(player.getName());
			for(String s : GunGameCore.getGunGame().ggplayers) {
				Player p1 = Bukkit.getServer().getPlayerExact(s);
				p1.sendMessage(ChatColor.RED + player.getName() + ChatColor.DARK_AQUA + " has abandoned gun game!");
			}
			
			player.teleport(new Location(Bukkit.getWorld("world"), 0 , 100 ,0));
		}
		
		if(GunGameCore.getGunGame().ggplayers.size() == 1) {
			for(String s : GunGameCore.getGunGame().ggplayers) {
			Utils.getInstance().endGunGame(Bukkit.getPlayerExact(s));
			}
		}
		
	}
	
	@EventHandler
	public void DropFix(PlayerDropItemEvent event) {
		Player player = event.getPlayer();
		if(GunGameCore.getGunGame().ggplayers.contains(player.getName())) {
			event.setCancelled(true);
		}
		
	}
	
	@EventHandler
	public void RespawnFix(PlayerRespawnEvent event) {
		final Player player = event.getPlayer();
		
		
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("zEV"), new Runnable() {

			@Override
			public void run() {
				if(GunGameCore.getGunGame().ggplayers.contains(player.getName())) {
					
					final int r1 = Utils.getInstance().randInt(-96, 96);
					final int r2 = Utils.getInstance().randInt(-1177, -992);
					
					Location l1 = new Location(Bukkit.getWorld("world"), r1, 180, r2);
					if(!(l1.getBlock().getType() == Material.AIR)) {
						l1 = new Location(Bukkit.getWorld("world"), r1, 180, r2);
					}
					
					GunGameCore.getGunGame().godmode.add(player.getName());
					
					
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

						@Override
						public void run() {
							player.getInventory().setContents(Utils.getInstance().upgradeGunGameTier(player));
							
						}
						
					}, 20L);
					
					player.getInventory().setArmorContents(new ItemStack[] {new ItemStack(Material.IRON_HELMET, 1), new ItemStack(Material.IRON_CHESTPLATE, 1), new ItemStack(Material.IRON_LEGGINGS, 1), new ItemStack(Material.IRON_BOOTS, 1)});
					player.teleport(l1);
					
				}
				
			}
			
		
		}, 20L);
	}
	
	@EventHandler
	public void  DropItemFix(ItemSpawnEvent event) {
		Cuboid c = new Cuboid(new Location(Bukkit.getWorld("world"), 102, 123, -987), new Location(Bukkit.getWorld("world"), -101, 71, -1182));
		
		if(c.contains(event.getEntity().getLocation())) event.setCancelled(true);
	}
	
	@EventHandler
	public void GodHax(EntityDamageEvent event) {
		if(!(event.getEntity() instanceof Player)) return;
		
		final Player player = (Player) event.getEntity();
		
		if(event.getCause().equals(DamageCause.FALL) && GunGameCore.getGunGame().godmode.contains(player.getName())) {
			event.setCancelled(true);
			GunGameCore.getGunGame().godmode.remove(player.getName());
		}
		
		
	}
}
