package me.MrZombie_II.Listeners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Egg;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.potion.Potion;

import me.MrZombie_II.api.Cuboid;
import me.MrZombie_II.main.Main;

public class SpawnProtListener implements Listener {
	
	public Main plugin;
	
	public SpawnProtListener(Main main) {
		this.plugin = main;
	}

	
	public static ArrayList<String> teleportmove = new ArrayList();
	  public static Map<String, Long> warping = new HashMap();
	  public static HashMap<String, String> nospawn = new HashMap();

	  @EventHandler
	  public void onPlayerLeave(PlayerQuitEvent event) {
	    Player player = event.getPlayer();
	    SpawnProtListener.nospawn.remove(player.getName());
	  }

	  @EventHandler
	  public void onPlayerJoin(PlayerJoinEvent event) {
	    Player player = event.getPlayer();
	    SpawnProtListener.nospawn.remove(player.getName());
	  }

	  @EventHandler
	  public void onDamage(EntityDamageEvent event) {
	    Entity entity = event.getEntity();

	    if ((entity instanceof Player)) {
	      Player player = (Player)entity;
	      if (SpawnProtListener.nospawn.containsKey(player.getName())) {
	        Location pLoc = player.getLocation();
	        Block bBlock = pLoc.getBlock().getRelative(BlockFace.DOWN);
	        if ((bBlock.getType() == bBlock.getType()) && 
	          (event.getCause() == EntityDamageEvent.DamageCause.FALL))
	          event.setCancelled(false);
	      }
	    }
	  }

	  @EventHandler(priority=EventPriority.HIGH, ignoreCancelled=true)
	  public void onPlayerTeleport(PlayerMoveEvent event)
	  {
	    if ((event.getFrom().getBlockX() == event.getTo().getBlockX()) && (event.getFrom().getBlockZ() == event.getTo().getBlockZ()) && (event.getFrom().getBlockY() == event.getTo().getBlockY())) {
	      return;
	    }
	    if (SpawnProtListener.teleportmove.contains(event.getPlayer().getName())) {
	      SpawnProtListener.teleportmove.remove(event.getPlayer().getName());
	      event.getPlayer().sendMessage(ChatColor.GRAY + "Teleporting cancelled");
	    }
	  }

	  @EventHandler
	  public void PlayerMove(PlayerMoveEvent event) {
	    Player player = event.getPlayer();
	    Location l1 = new Location(Bukkit.getWorld("world"), -737, 42, -201);
	    Location l2 = new Location(Bukkit.getWorld("world"), -723, 36, -215);
	    
	    Cuboid c = new Cuboid(l1,l2);

	    if ((!c.contains(player.getLocation())) && (!SpawnProtListener.nospawn.containsKey(player.getName()))) {
	      player.sendMessage(ChatColor.GRAY + "You no longer have spawn protection.");
	      SpawnProtListener.nospawn.put(player.getName(), null);
	      return;
	    }

	    if ((!c.contains(player.getLocation())) && (!SpawnProtListener.nospawn.containsKey(player.getName()))) {
	      player.sendMessage(ChatColor.GRAY + "You no longer have spawn protection.");
	      SpawnProtListener.nospawn.put(player.getName(), null);
	      return;
	    }
	  }

	  @EventHandler
	  public void OnPlayerRespawn(PlayerRespawnEvent event)
	  {
	    Player player = event.getPlayer();
	    player.sendMessage(ChatColor.RED + "You now have spawn protection");
	    SpawnProtListener.nospawn.remove(player.getName());
	  }

	  @EventHandler
	  public void PlayerDamageEvent(EntityDamageEvent event)
	  {
	    if ((event.getEntity() instanceof Player)) {
	      Player damagee = (Player)event.getEntity();
	      if (!SpawnProtListener.nospawn.containsKey(damagee.getName())) {
	        Bukkit.getLogger().info(damagee.getName());
	        event.setCancelled(true);
	      }
	    }
	  }

	  @EventHandler
	  public void PlayerDamagebyPlayer(EntityDamageByEntityEvent e) { if (((e.getDamager() instanceof Player)) || ((e.getDamager() instanceof Egg)) || ((e.getDamager() instanceof Fireball)) || ((e.getDamager() instanceof EnderPearl)) || ((e.getDamager() instanceof Potion)) || ((e.getDamager() instanceof Snowball)) || ((e.getDamager() instanceof Arrow))) {
		  
		  Entity ent = e.getDamager();
		  Player damager = null;
		  
		  if(ent instanceof Snowball) {
              Snowball snowball = (Snowball) ent;
              if(snowball.getShooter() instanceof Player) {
                  damager = (Player) snowball.getShooter();
              }
		  }
		  
		  if(ent instanceof Player) {
			  damager = (Player) e.getDamager();
		  }
		 
	      if ((e.getEntity() instanceof Player)) {
	        Player damagee = (Player)e.getEntity();

	        if ((!SpawnProtListener.nospawn.containsKey(damager.getName())) && (SpawnProtListener.nospawn.containsKey(damagee.getName()))) {
	          SpawnProtListener.nospawn.put(damager.getName(), null);
	          damager.sendMessage(ChatColor.GRAY + "You no longer have spawn protection.");
	        }
	      }
	    } }

	  @EventHandler
	  public void PlayerDamagebyEgg(EntityDamageByEntityEvent e)
	  {
	    if ((e.getDamager() instanceof Egg)) {
	      Egg egg = (Egg)e.getDamager();

	      if ((e.getEntity() instanceof Player)) {
	        Player damagee = (Player)e.getEntity();
	        Player egg1 = (Player)egg.getShooter();

	        if ((!SpawnProtListener.nospawn.containsKey(egg1.getName())) && (SpawnProtListener.nospawn.containsKey(damagee.getName()))) {
	          SpawnProtListener.nospawn.put(egg1.getName(), null);
	          egg1.sendMessage(ChatColor.GRAY + "You no longer have spawn protection.");
	        }
	      }
	    }
	  }

	  @EventHandler
	  public void PlayerDamagebyArrow(EntityDamageByEntityEvent e) {
	    if ((e.getDamager() instanceof Arrow)) {
	      Arrow arrow = (Arrow)e.getDamager();

	      if ((e.getEntity() instanceof Player)) {
	        Player damagee = (Player)e.getEntity();
	        Player arrow1 = (Player)arrow.getShooter();

	        if ((!SpawnProtListener.nospawn.containsKey(arrow1.getName())) && (SpawnProtListener.nospawn.containsKey(damagee.getName()))) {
	          SpawnProtListener.nospawn.put(arrow1.getName(), null);
	          arrow1.sendMessage(ChatColor.GRAY + "You no longer have spawn protection.");
	        }
	      }
	    }
	  }

	  @EventHandler
	  public void PlayerDamagebyPearl(EntityDamageByEntityEvent e) {
	    if ((e.getDamager() instanceof EnderPearl)) {
	      EnderPearl pearl = (EnderPearl)e.getDamager();

	      if ((e.getEntity() instanceof Player)) {
	        Player damagee = (Player)e.getEntity();
	        Player pearl1 = (Player)pearl.getShooter();

	        if ((!SpawnProtListener.nospawn.containsKey(pearl1.getName())) && (SpawnProtListener.nospawn.containsKey(damagee.getName()))) {
	          SpawnProtListener.nospawn.put(pearl1.getName(), null);
	          pearl1.sendMessage(ChatColor.GRAY + "You no longer have spawn protection.");
	        }
	      }
	    }
	  }

	  @EventHandler
	  public void PlayerDamagebySnow(EntityDamageByEntityEvent e) {
	    if ((e.getDamager() instanceof Snowball)) {
	      Snowball snow = (Snowball)e.getDamager();

	      if ((e.getEntity() instanceof Player)) {
	        Player damagee = (Player)e.getEntity();
	        Player snow1 = (Player)snow.getShooter();

	        if ((!SpawnProtListener.nospawn.containsKey(snow1.getName())) && (SpawnProtListener.nospawn.containsKey(damagee.getName()))) {
	          SpawnProtListener.nospawn.put(snow1.getName(), null);
	          snow1.sendMessage(ChatColor.GRAY + "You no longer have spawn protection.");
	        }
	      }
	    }
	  }

	  @EventHandler
	  public void PlayerDamagebyFire(EntityDamageByEntityEvent e) {
	    if ((e.getDamager() instanceof Fireball)) {
	      Fireball fire = (Fireball)e.getDamager();

	      if ((e.getEntity() instanceof Player)) {
	        Player damagee = (Player)e.getEntity();
	        Player fire1 = (Player)fire.getShooter();
	        if ((!SpawnProtListener.nospawn.containsKey(fire1.getName())) && (SpawnProtListener.nospawn.containsKey(damagee.getName()))) {
	          SpawnProtListener.nospawn.put(fire1.getName(), null);
	          fire1.sendMessage(ChatColor.GRAY + "You no longer have spawn protection.");
	        }
	      }
	    }
	  }

	  @EventHandler
	  public void PlayerDamagebyPotion(EntityDamageByEntityEvent e) {
	    if ((e.getDamager() instanceof Potion)) {
	      Potion potion = (Potion)e.getDamager();

	      if ((e.getEntity() instanceof Player)) {
	        Player damagee = (Player)e.getEntity();
	        Player potion1 = (Player)((Projectile)potion).getShooter();
	        if ((!SpawnProtListener.nospawn.containsKey(potion1.getName())) && (SpawnProtListener.nospawn.containsKey(damagee.getName()))) {
	          SpawnProtListener.nospawn.put(potion1.getName(), null);
	          potion1.sendMessage(ChatColor.GRAY + "You no longer have spawn protection.");
	        }
	      }
	    }
	  }
	
}
