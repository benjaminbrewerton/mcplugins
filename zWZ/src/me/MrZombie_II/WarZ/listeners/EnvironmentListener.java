package me.MrZombie_II.WarZ.listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.Entity;

import me.MrZombie_II.WarZ.main.Main;
import me.MrZombie_II.WarZ.api.MathUtil;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class EnvironmentListener implements Listener {
	
	public Main plugin;
	
	public EnvironmentListener(Main main) {
		main = plugin;
	}
	
	
	//Fall/Bone Thingy ma fuck it
	public List<String> bones = new ArrayList<String>();
	
	public boolean AreBonesBroken(Player player) {
		if(bones.contains(player.getName())) return true;
		else return false;
	}
	
	public void BreakBones(Player player) {
		bones.add(player.getName());
		player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, 10));
		player.sendMessage(ChatColor.RED + "Your brones are broken! Heal yourself by right clicking on a bone!");
	}
	
	
	public void HealBones(Player player) {
		bones.remove(player.getName());
		player.removePotionEffect(PotionEffectType.SLOW);
		player.sendMessage(ChatColor.GREEN + "Healed your bones!");
	}
	
	@EventHandler
	public void BoneListener(EntityDamageEvent event) {
		if(!(event.getEntity() instanceof Player)) return;
		if(!(event.getCause().equals(DamageCause.FALL))) return;
		
		Player player = (Player) event.getEntity();
		
		BreakBones(player);
		
	}
	
	@EventHandler
	public void BoneInteraction(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		
		if(player.getInventory().getItemInHand() == null || player.getInventory().getItemInHand().getType() == Material.AIR ||
				!AreBonesBroken(player)) return;
		
	    ItemStack i = new ItemStack(player.getInventory().getItemInHand());
	    
	    if (((event.getAction().equals(Action.RIGHT_CLICK_AIR)) || (event.getAction().equals(Action.RIGHT_CLICK_BLOCK))) && 
	      (!player.getGameMode().equals(GameMode.CREATIVE)) && 
	      (i.getType() == Material.BONE))
	    {
	    	int oa = i.getAmount();
	    	int na = oa - 1;
	    	
	    	if(na == 0) {
	    		player.setItemInHand(new ItemStack(Material.AIR));
	    	} else {
	    		ItemStack ni = new ItemStack(i.getType(), na);
	    		player.setItemInHand(ni);
	    	}
	    	
	    	HealBones(player);
	    }
	}
	
	//Bleeding Chance
	
	public static List<String> bleeding = new ArrayList<String>();
	
	public boolean isBleeding(Player player) {
		if(bleeding.contains(player.getName())) return true;
		else return false;
	}
	
	public void CauseBleeding(Player player) {
		bleeding.add(player.getName());
		player.sendMessage(ChatColor.RED + "You are bleeding, use a bandage to heal");
	}
	
	public void StopBleeding(Player player) {
		bleeding.remove(player.getName());
		player.sendMessage(ChatColor.GREEN + "You are no longer bleeding");
	}
	
	public boolean BleedQ() {
		int i = MathUtil.getUtil().getMinMaxRand(1, 9);
		if(i >= 1 && i <= 3) return true;
		else return false;
	}
	
	@EventHandler
	public void BleedEvent(EntityDamageEvent event) {
		if(!(event.getEntity() instanceof Player)) return;
		
		Player player = (Player) event.getEntity();
		
		double i = MathUtil.getUtil().getMinMaxDouble(1.0D, 10.0D);
		
		if(bleeding.contains(player.getName())) return;
		if(i >= 1 && i <= 2.5) CauseBleeding(player); //15% chance to cause bleeding
		
		
	}
	
	@EventHandler
	public void BandageInteraction(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		
		if(player.getInventory().getItemInHand() == null || player.getInventory().getItemInHand().getType() == Material.AIR ||
				!isBleeding(player)) return;
		
	    ItemStack i = new ItemStack(player.getInventory().getItemInHand());
	    
	    if (((event.getAction().equals(Action.RIGHT_CLICK_AIR)) || (event.getAction().equals(Action.RIGHT_CLICK_BLOCK))) && 
	      (!player.getGameMode().equals(GameMode.CREATIVE)) && 
	      (i.getType() == Material.PAPER))
	    {
	    	int oa = i.getAmount();
	    	int na = oa - 1;
	    	
	    	if(na == 0) {
	    		player.setItemInHand(new ItemStack(Material.AIR));
	    	} else {
	    		ItemStack ni = new ItemStack(i.getType(), na);
	    		player.setItemInHand(ni);
	    	}
	    	
	    	StopBleeding(player);
	    }
	}
	
	@EventHandler
	public void BoneBleedFix(PlayerDeathEvent event) {
		Player player = event.getEntity().getPlayer();
		
		if(isBleeding(player))
		bleeding.remove(player.getName());
		
		if(AreBonesBroken(player))
		bones.remove(player.getName());
		
		if(isInfected(player))
		infected.remove(player.getName());
	}
	
	//Respawn Randomiser
	@EventHandler
	public void RespawnRandomizer(PlayerRespawnEvent event) {
		Player player = event.getPlayer();
		World w = player.getWorld();
		
		Location[] l = new Location[] {
				new Location(w, -640, 65, 1310),
				new Location(w, -840, 65, 1280),
				new Location(w, -1050, 65, 1040),
				new Location(w, -382, 65, 1150),
				new Location(w, 430, 65, 935)
		};
		
		Location ll = l[new Random().nextInt(l.length)];
		
		player.teleport(ll);
		
	}
	
	private int zinterval = 0;
	
	//Zombie Spawner
	@EventHandler
	public void MobCoordinator(CreatureSpawnEvent event) {
		if(!event.getEntityType().equals(EntityType.ZOMBIE)) {
			zinterval++;
			
			if(zinterval == 3) {
			World w = event.getEntity().getWorld();
			Zombie z = (Zombie) w.spawnEntity(event.getLocation(), EntityType.ZOMBIE);
			z.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
			z.setCanPickupItems(false);
			zinterval = 0;
			} else 
				event.setCancelled(true);
			
		}
	}
	
	//Generic Death Listener
	@EventHandler
	public void MobDeathCoordinator(EntityDeathEvent event) {
		event.setDroppedExp(0);
		event.getDrops().clear();
	}
	
	//Infection Listener & Infection related stuff
	
	public List<String> infected = new ArrayList<String>();
	
	public void Infect(Player player) {
		if(!infected.contains(player.getName())) infected.add(player.getName());
		player.sendMessage(ChatColor.RED + "You have become infected with the virus! Find an infection cure to cure yourself!");
	}
	
	public void Cure(Player player) {
		if(infected.contains(player.getName())) infected.remove(player.getName());
		player.removePotionEffect(PotionEffectType.HUNGER);
		player.sendMessage(ChatColor.GREEN + "You are no longer infected.");
	}
	
	public boolean isInfected(Player player) {
		if(infected.contains(player.getName())) return true;
		return false;
	}
	
	public boolean InfectQ() {
		int i = MathUtil.getUtil().getMinMaxRand(1, 10);
		if(i == 1) return true;
		else return false;
	}
	
	@EventHandler
	public void InfectionListener(EntityDamageByEntityEvent event) {
		int i = MathUtil.getUtil().getMinMaxRand(1, 10);
		
		if(event.getEntity().getType().equals(EntityType.PLAYER) && 
				event.getDamager().getType().equals(EntityType.ZOMBIE) && (i == 1) && !isInfected((Player) event.getEntity())) 
		{
			
			Player player = (Player) event.getEntity();		
			player.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 120, 1));
		}
	}
	
	@EventHandler
	public void CureInteraction(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		
		if(player.getInventory().getItemInHand() == null || player.getInventory().getItemInHand().getType() == Material.AIR ||
				!isInfected(player)) return;
		
	    ItemStack i = new ItemStack(player.getInventory().getItemInHand());
	    
	    if (((event.getAction().equals(Action.RIGHT_CLICK_AIR)) || (event.getAction().equals(Action.RIGHT_CLICK_BLOCK))) && 
	      (!player.getGameMode().equals(GameMode.CREATIVE)) && 
	      (i.getType() == Material.INK_SACK && ((byte)i.getData().getData() == 5)))
	    {
	    	int oa = i.getAmount();
	    	int na = oa - 1;
	    	
	    	if(na == 0) {
	    		player.setItemInHand(new ItemStack(Material.AIR));
	    	} else {
	    		ItemStack ni = new ItemStack(i.getType(), na, (byte) 2);
	    		player.setItemInHand(ni);
	    	}
	    	
	    	Cure(player);
	    }
	}
	
	@EventHandler
	public void SugarInteraction(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		
		if(player.getInventory().getItemInHand() == null || player.getInventory().getItemInHand().getType() == Material.AIR) return;
		
	    ItemStack i = new ItemStack(player.getInventory().getItemInHand());
	    
	    if (((event.getAction().equals(Action.RIGHT_CLICK_AIR)) || (event.getAction().equals(Action.RIGHT_CLICK_BLOCK))) && 
	      (!player.getGameMode().equals(GameMode.CREATIVE)) && 
	      (i.getType() == Material.SUGAR))
	    {
	    	int oa = i.getAmount();
	    	int na = oa - 1;
	    	
	    	if(na == 0) {
	    		player.setItemInHand(new ItemStack(Material.AIR));
	    	} else {
	    		ItemStack ni = new ItemStack(i.getType(), na, (byte) 5);
	    		player.setItemInHand(ni);
	    	}
	    	
	    	player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 7 * 20, 3));
	    }
	}

}
