package me.MrZombie_II.Listeners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.MrZombie_II.main.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Egg;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerAnimationEvent;
import org.bukkit.event.player.PlayerAnimationType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class ACListener implements Listener {
	
	public Main plugin;
	
	public ACListener(Main main) {
		this.plugin = main;
	}
	
public static List<String> onlinestaff = new ArrayList<String>();
	
	@EventHandler
	public void StaffRegister (PlayerJoinEvent event) {
		Player player = event.getPlayer();
		if(player.hasPermission("weed.ac")) {
			onlinestaff.add(player.getName());
		}
	}
	
	@EventHandler
	public void StaffUnRegister (PlayerQuitEvent event) {
		Player player = event.getPlayer();
		
		if (onlinestaff.contains(player.getName())) {
			onlinestaff.remove(player.getName());
		}
	}
	
	@EventHandler
	public void StaffUnRegisterAbnormal (PlayerKickEvent event) {
		Player player = event.getPlayer();
		
		if (onlinestaff.contains(player.getName())) {
			onlinestaff.remove(player.getName());
		}
	}
	
	
	
	private Map<String, Long> speeding = new HashMap<String, Long>();
	private List<String> jumping = new ArrayList<String>();
	
	
	@EventHandler
	public void onMove(PlayerMoveEvent event) {
	    Location from = event.getFrom();
	    from.setY(0);
	    Location to = event.getTo();
	    to.setY(0);
	    Player player = event.getPlayer();
	 
	    
	    
	    if(player.getGameMode().equals(GameMode.CREATIVE)) {
       	 return;
        }
	    
	    if(sp.contains(player.getName())) {
	    	
	    	
	    	return;
	    }
	    
	    double dis1 = from.distance(to);
	    
	    
	    if (from.distance(to) > 0.8) {
	    	
	    	if(dis1 >= 2) {
	    		int speedalert = 2;
	    		int speeddelay = 2;
		    	if(speeding.containsKey(player.getName())) {
	                long secondsLeft = ((speeding.get(player.getName())) /1000 + speeddelay) - (System.currentTimeMillis() /1000 );
	                if(secondsLeft > 0) {
	                    return;
	                } 
	            }    
		    	
		    	
		    	
		    	
		    	long dis = Math.round(from.distance(to) * 1) / 1;
		    	speeding.put(player.getName(), System.currentTimeMillis());
		    	
		    	for (String s : onlinestaff) {
					Player p = Bukkit.getServer().getPlayerExact(s);

					p.sendMessage(ChatColor.DARK_RED + player.getName() + " is speeding! Moving " + dis + " blocks too fast! (" + speedalert + ")");
				}
	    		
	    	} else
	    	if(from.distance(to) > 3) {
	    		int speedalert = 3;
	    		int speeddelay = 2;
		    	if(speeding.containsKey(player.getName())) {
	                long secondsLeft = ((speeding.get(player.getName())) /1000 + speeddelay) - (System.currentTimeMillis() /1000 );
	                if(secondsLeft > 0) {
	                    return;
	                } 
	            }    
		    	
		    	
		    	long dis = Math.round(from.distance(to) * 1) / 1;
		    	speeding.put(player.getName(), System.currentTimeMillis());
		    	
		    	for (String s : onlinestaff) {
					Player p = Bukkit.getServer().getPlayerExact(s);

					
					p.sendMessage(ChatColor.DARK_RED + player.getName() + " is speeding! Moving " + dis + " blocks too fast! (" + speedalert + ")");
				}
	    		
	    	}else
	    	if(from.distance(to) > 4) {
	    		int speedalert = 4;
	    		int speeddelay = 2;
		    	if(speeding.containsKey(player.getName())) {
	                long secondsLeft = ((speeding.get(player.getName())) /1000 + speeddelay) - (System.currentTimeMillis() /1000 );
	                if(secondsLeft > 0) {
	                    return;
	                } 
	            }    
		    	
		    	
		    	long dis = Math.round(from.distance(to) * 1) / 1;
		    	speeding.put(player.getName(), System.currentTimeMillis());
		    	
		    	for (String s : onlinestaff) {
					Player p = Bukkit.getServer().getPlayerExact(s);

					
					p.sendMessage(ChatColor.DARK_RED + player.getName() + " is speeding! Moving " + dis + " blocks too fast! (" + speedalert + ")");
				}
	    		
	    	}else
	    	if(from.distance(to) > 5) {
	    		int speedalert = 5;
	    		int speeddelay = 2;
		    	if(speeding.containsKey(player.getName())) {
	                long secondsLeft = ((speeding.get(player.getName())) /1000 + speeddelay) - (System.currentTimeMillis() /1000 );
	                if(secondsLeft > 0) {
	                    return;
	                } 
	            }    
		    	
		    	
		    	long dis = Math.round(from.distance(to) * 1) / 1;
		    	speeding.put(player.getName(), System.currentTimeMillis());
		    	
		    	for (String s : onlinestaff) {
					Player p = Bukkit.getServer().getPlayerExact(s);

					
					p.sendMessage(ChatColor.DARK_RED + player.getName() + " is speeding! Moving " + dis + " blocks too fast! (" + speedalert + ")");
				}
	    		
	    	}else
	    	if(from.distance(to) > 6) {
	    		int speedalert = 6;
	    		int speeddelay = 2;
		    	if(speeding.containsKey(player.getName())) {
	                long secondsLeft = ((speeding.get(player.getName())) /1000 + speeddelay) - (System.currentTimeMillis() /1000 );
	                if(secondsLeft > 0) {
	                    return;
	                } 
	            }    
		    	
		    	
		    	long dis = Math.round(from.distance(to) * 1) / 1;
		    	speeding.put(player.getName(), System.currentTimeMillis());
		    	
		    	for (String s : onlinestaff) {
					Player p = Bukkit.getServer().getPlayerExact(s);

					
					p.sendMessage(ChatColor.DARK_RED + player.getName() + " is speeding! Moving " + dis + " blocks too fast! (" + speedalert + ")");
				}
	    		
	    	}
	    	
	    	int speeddelay = 2;
	    	if(speeding.containsKey(player.getName())) {
                long secondsLeft = ((speeding.get(player.getName())) /1000 + speeddelay) - (System.currentTimeMillis() /1000 );
                if(secondsLeft > 0) {
                    return;
                } 
            }    
	    	
	    	
	    	long dis = Math.round(from.distance(to) * 1) / 1;
	    	speeding.put(player.getName(), System.currentTimeMillis());
	    	
	    	for (String s : onlinestaff) {
				Player p = Bukkit.getServer().getPlayerExact(s);
				
				p.sendMessage(ChatColor.DARK_RED + player.getName() + " is speeding! Moving " + dis + " blocks too fast! (" + "1" + ")");
			}
	    }
	}
	
	private List<String> sp = new ArrayList<String>();
	
	
	@EventHandler
	public void GunFix (ProjectileLaunchEvent event) {
		
		
		if(!(event.getEntity().getShooter() instanceof Player)) {
			return;
		}
		
		if(!(event.getEntityType().equals(EntityType.EGG))) return;
		
		
		EntityType p = event.getEntity().getType();
		
		event.getEntityType();
		if(!(p.equals(EntityType.SNOWBALL))) {
			return;
		}
		
		
		final Player player = (Player) event.getEntity().getShooter();
		
		sp.add(player.getName());
		
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

			@Override
			public void run() {
			
				sp.remove(player.getName());
				
			}
			
		}, 40L);
		
		
	}
	
	@EventHandler
	public void SpeedFix1 (EntityDamageEvent event) {
		
		if(!(event.getEntity() instanceof Player)) return;
		
		final Player player = (Player) event.getEntity();
		
		if(event.getCause().equals(DamageCause.PROJECTILE)) {
			sp.add(player.getName());
			
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

				@Override
				public void run() {
				
					sp.remove(player.getName());
					
				}
				
			}, 80L);
			
			
		}
		
	}
	
	@EventHandler
	public void SpeedFix (EntityDamageByEntityEvent event ) {
		
		if(!(event.getDamager() instanceof Player)) {
			
			return;
		}
		
		if(!(event.getEntity() instanceof Player)) {
			
			return;
		}
		final Player player = (Player) event.getEntity();
		
		sp.add(player.getName());
		
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

			@Override
			public void run() {
			
				sp.remove(player.getName());
				
			}
			
		}, 80L);
		
		
		
		
	}
	
	@EventHandler
	public void SneakDetection (PlayerMoveEvent event) {
		 Location from = event.getFrom();
		    from.setY(0);
		    Location to = event.getTo();
		    to.setY(0);
		    Player player = event.getPlayer();
		    
		    
		    
		    
		    if(player.getGameMode().equals(GameMode.CREATIVE)) {
	       	 return;
	        }
		    
		    if(sp.contains(player.getName())) {
		    	
		    	
		    	return;
		    }
		    
		    if(!player.isSneaking()) {
		    	
		    	return;
		    }
		    
		    
		    
		    
		    double dis1 = from.distance(to);
		    
		    		    	
		    	if(dis1 >= 0.5) {
		    		int speedalert = 2;
		    		int speeddelay = 2;
			    	if(speeding.containsKey(player.getName())) {
		                long secondsLeft = ((speeding.get(player.getName())) /1000 + speeddelay) - (System.currentTimeMillis() /1000 );
		                if(secondsLeft > 0) {
		                    return;
		                } 
		            }    
			    	
			    	
			    	speeding.put(player.getName(), System.currentTimeMillis());
			    	
			    	for (String s : onlinestaff) {
						Player p = Bukkit.getServer().getPlayerExact(s);

						p.sendMessage(ChatColor.DARK_RED + player.getName() + " is speeding while sneaking! (" + speedalert + ")");
					}
		    		
		    	} else
		    	if(from.distance(to) > 0.5) {
		    		int speedalert = 3;
		    		int speeddelay = 2;
			    	if(speeding.containsKey(player.getName())) {
		                long secondsLeft = ((speeding.get(player.getName())) /1000 + speeddelay) - (System.currentTimeMillis() /1000 );
		                if(secondsLeft > 0) {
		                    return;
		                } 
		            }    
			    	
			    	
			    	speeding.put(player.getName(), System.currentTimeMillis());
			    	
			    	for (String s : onlinestaff) {
						Player p = Bukkit.getServer().getPlayerExact(s);

						
						p.sendMessage(ChatColor.DARK_RED + player.getName() + " is speeding while sneaking! (" + speedalert + ")");
					}
		    		
		    	} else
		    	if(from.distance(to) > 1) {
		    		int speedalert = 4;
		    		int speeddelay = 2;
			    	if(speeding.containsKey(player.getName())) {
		                long secondsLeft = ((speeding.get(player.getName())) /1000 + speeddelay) - (System.currentTimeMillis() /1000 );
		                if(secondsLeft > 0) {
		                    return;
		                } 
		            }    
			    	
			    	
			    	speeding.put(player.getName(), System.currentTimeMillis());
			    	
			    	for (String s : onlinestaff) {
						Player p = Bukkit.getServer().getPlayerExact(s);

						
						p.sendMessage(ChatColor.DARK_RED + player.getName() + " is speeding while sneaking! (" + speedalert + ")");
					}
		    		
		    	} else
		    	if(from.distance(to) > 1.5) {
		    		int speedalert = 5;
		    		int speeddelay = 2;
			    	if(speeding.containsKey(player.getName())) {
		                long secondsLeft = ((speeding.get(player.getName())) /1000 + speeddelay) - (System.currentTimeMillis() /1000 );
		                if(secondsLeft > 0) {
		                    return;
		                } 
		            }    
			    	
			    	
			    	speeding.put(player.getName(), System.currentTimeMillis());
			    	
			    	for (String s : onlinestaff) {
						Player p = Bukkit.getServer().getPlayerExact(s);

						
						p.sendMessage(ChatColor.DARK_RED + player.getName() + " is speeding while sneaking! (" + speedalert + ")");
					}
		    		
		    	} else
		    	if(from.distance(to) > 2) {
		    		int speedalert = 6;
		    		int speeddelay = 2;
			    	if(speeding.containsKey(player.getName())) {
		                long secondsLeft = ((speeding.get(player.getName())) /1000 + speeddelay) - (System.currentTimeMillis() /1000 );
		                if(secondsLeft > 0) {
		                    return;
		                } 
		            }    
			    	
			    	
			    	speeding.put(player.getName(), System.currentTimeMillis());
			    	
			    	for (String s : onlinestaff) {
						Player p = Bukkit.getServer().getPlayerExact(s);

						
						p.sendMessage(ChatColor.DARK_RED + player.getName() + " is speeding while sneaking! (" + speedalert + ")");
					}
		    		
		    	}
		    	
		    
	}
	
	private Map<String, Location> loc = new HashMap<String, Location>();
	private Map<String, Location> loc2 = new HashMap<String, Location>();
	private Map<String, Integer> flyvl = new HashMap<String, Integer>();
	public static Map<String, Long> ab = new HashMap<String, Long>();
	private List<String> fly = new ArrayList<String>();
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void Jumping (PlayerMoveEvent event) {
		final Player player = event.getPlayer();
		
		if(player.getGameMode().equals(GameMode.CREATIVE)) {
			return;
			
		}
		
		
		
		if((new Location(player.getWorld(), player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ()).getBlock().getTypeId() == 65) && !player.isOnGround()) {
			
			return;
			
		}
		
		if(player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.LADDER) {
			
			return;
		}
		
		if(fly.contains(player.getName())) {
			
			return;
		}
		
		
		int b = player.getWorld().getHighestBlockYAt(player.getLocation());
			
		double bb = player.getLocation().getY() - b + 2;
		long dis = Math.round(bb * 1) / 1;
		
		if(player.getLocation().getY() > b + 4) {
			
			
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

				@Override
				public void run() {
					loc.put(player.getName(), player.getLocation());
					
				}
				
				
			}, 10L);
			
			
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

				@Override
				public void run() {
					loc2.put(player.getName(), player.getLocation());
					
				}
				
			}, 15L);
			
			if(!(loc.containsKey(player.getName()) && (loc2.containsKey(player.getName())))) {
				return;
			}
			
			
			fly.add(player.getName());
			
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

				@Override
				public void run() {
					fly.remove(player.getName());
					
				}
				
			}, 40L);
			
			
			Location l1 = loc.get(player.getName());
			double i = l1.getY();
			
			Location l2 = loc2.get(player.getName());
			double ii = l2.getY();
			
			if(i + 1.5 > ii) {
				loc.remove(player.getName());
				loc2.remove(player.getName());
				return;
			}
			
			if(jumping.contains(player.getName())) {
				
				return;
			}
			
			
			jumping.add(player.getName());
			
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

				@Override
				public void run() {
					jumping.remove(player.getName());
					
				}
				
			}, 40L);
			
			loc.remove(player.getName());
			loc2.remove(player.getName());
			
			if(!(flyvl.containsKey(player.getName()))) {
				
				flyvl.put(player.getName(), 0);
				
			}
			
			if(dis >= 20 || flyvl.get(player.getName()) == 3) {
				if(ab.containsKey(player.getName())) {
					return;
				}
				
				player.kickPlayer(ChatColor.RED + "Please remove any illegal client mods! \n Fly, Aimbot, Fastplace, Macros, Etc");
				for (String s1 : onlinestaff) {
					Player p = Bukkit.getServer().getPlayerExact(s1);
					p.sendMessage(ChatColor.RED + player.getName() + " has been kicked for flying a consecutive amount of times or flying too high!");
				}
			}
			
			int vll = flyvl.get(player.getName());
			int vlll = vll + 1;
			flyvl.remove(player.getName());
			flyvl.put(player.getName(), vlll);
			
			for (String s1 : onlinestaff) {
				Player p = Bukkit.getServer().getPlayerExact(s1);
				p.sendMessage(ChatColor.DARK_RED + player.getName() + " is flying! (" + dis + ")");
			}
		}
	}
	
	
	@EventHandler
	public void ResP (PlayerRespawnEvent event) {
		final Player player = event.getPlayer();
		
		sp.add(player.getName());
		
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

			@Override
			public void run() {
			
				sp.remove(player.getName());
				
			}
			
		}, 80L);
		
		
		
		me.MrZombie_II.commands.WarZ.kit.remove(player.getName());
	}
	
	public static Map<String, Integer> fp = new HashMap<String, Integer>();
	private List<String> fpa = new ArrayList<String>();
	
	@EventHandler
	public void FastPlace (PlayerInteractEvent event) {
		
		final Player player = event.getPlayer();
		
		if (((event.getAction().equals(Action.RIGHT_CLICK_AIR)) || (event.getAction().equals(Action.RIGHT_CLICK_BLOCK))) && 
			      (!player.getGameMode().equals(GameMode.CREATIVE)))
			    {
				
			
			
				if(!(fp.containsKey(player.getName()))) {
					fp.put(player.getName(), 1);
					return;
				}
			
				
				int i = fp.get(player.getName());
				int ii = i + 1;
				
				fp.remove(player.getName());
				fp.put(player.getName(), ii);
				
				if(ii >= 40) {
					if(fpa.contains(player.getName())) {
						
						return;
					}
					
					fpa.add(player.getName());
					
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

						@Override
						public void run() {
							fpa.remove(player.getName());
							
						} 
					
					
					}, 5L);
					
					int iii = ii - 39;
					
					for (String s1 : onlinestaff) {
						Player p = Bukkit.getServer().getPlayerExact(s1);
						p.sendMessage(ChatColor.DARK_RED + player.getName() + " is using fast-place or macros! (" + iii + ")");
					}
					
				}
				
			    }
		
	}
	
	public static Map<String, Integer> lc = new HashMap<String, Integer>();
	private List<String> lcm = new ArrayList<String>();
	
	@EventHandler
	public void LeftClickMacros (PlayerInteractEvent event) {
		
		final Player player = event.getPlayer();
		
		if (((event.getAction().equals(Action.LEFT_CLICK_AIR)) || (event.getAction().equals(Action.LEFT_CLICK_BLOCK))) && 
			      (!player.getGameMode().equals(GameMode.CREATIVE)))
			    {
				
			
			
				if(!(lc.containsKey(player.getName()))) {
					lc.put(player.getName(), 1);
					return;
				}
			
				
				int i = lc.get(player.getName());
				int ii = i + 1;
				
				lc.remove(player.getName());
				lc.put(player.getName(), ii);
				
				if(ii >= 40) {
					if(lcm.contains(player.getName())) {
						
						return;
					}
					
					lcm.add(player.getName());
					
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

						@Override
						public void run() {
							lcm.remove(player.getName());
							
						} 
					
					
					}, 5L);
					
					int iii = ii - 39;
					
					for (String s1 : onlinestaff) {
						Player p = Bukkit.getServer().getPlayerExact(s1);
						p.sendMessage(ChatColor.DARK_RED + player.getName() + " is interacting too fast! (" + iii + ")");
					}
					
				}
				
			    }
		
	}
	
}
	
	
