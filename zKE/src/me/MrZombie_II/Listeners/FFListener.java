package me.MrZombie_II.Listeners;

import java.util.HashMap;
import java.util.Map;

import me.MrZombie_II.main.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class FFListener implements Listener {

	public Main plugin;

	public FFListener(Main main) {
		this.plugin = main;
	}
	
	public Map<String, Integer> ffangle = new HashMap<String, Integer>();
	
	private float getCompressedAngle(float value) {
        return (value * 256.0F / 360.0F);
	}
	
    @EventHandler
    public void FFCheck (EntityDamageByEntityEvent event) {
    	if(!(event.getDamager() instanceof Player)) {
    		return;
    		
    	}
    	
    	final Player player = (Player) event.getDamager();
    	
    	if(player.getGameMode().equals(GameMode.CREATIVE)) {
    		
    		return;
    	}
    	
    	
    	double rotation = (player.getLocation().getYaw() - 90) % 360;
    	if (rotation < 0) {
            rotation += 360.0;
        }
    	
    	
    	
    	
    	if(player.getGameMode().equals(GameMode.CREATIVE)) {
    		
    		return;
    	}
    	
    	
    	
    	int anglev = 0;
 
    	 if (0 <= rotation && rotation < 22.5) {
    		 anglev = 1;
    	    } else if (22.5 <= rotation && rotation < 67.5) {
    	    	anglev = 2;
    	    } else if (67.5 <= rotation && rotation < 112.5) {
    	    	anglev = 3;
    	    } else if (112.5 <= rotation && rotation < 157.5) {
    	    	anglev = 4;
    	    } else if (157.5 <= rotation && rotation < 202.5) {
    	    	anglev = 5;
    	    } else if (202.5 <= rotation && rotation < 247.5) {
    	    	anglev = 6;
    	    } else if (247.5 <= rotation && rotation < 292.5) {
    	    	anglev = 7;
    	    } else if (292.5 <= rotation && rotation < 337.5) {
    	    	anglev = 8;
    	    } else if (337.5 <= rotation && rotation < 360.0) {
    	    	anglev = 9;
    	    }
    	
    	 int anglevv = 0;
    	 
    	 if(anglev == 1) {
    		 anglevv = 5;
    	 }
    	 if(anglev == 2) {
    		 anglevv = 6;
    	 }
    	 if(anglev == 3) {
    		 anglevv = 7;
    	 }
    	 if(anglev == 4) {
    		 anglevv = 8;
    	 }
    	 if(anglev == 5) {
    		 anglevv = 9;
    	 }
    	 if(anglev == 6) {
    		 anglevv = 1;
    	 }
    	 if(anglev == 7) {
    		 anglevv = 2;
    	 }
    	 if(anglev == 8) {
    		 anglevv = 3;
    	 }
    	 if(anglev == 9) {
    		 anglevv = 4;
    	 }
    	 
    	
    	if(!(ffangle.containsKey(player.getName()))) {
    		ffangle.put(player.getName(), anglevv);
    		
    		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

				@Override
				public void run() {
						ffangle.remove(player.getName());
					
				}
    			
    		}, 10L);
    		
    		return;
    	}
    	
    	
    	
    	
    	double i = ffangle.get(player.getName());
    	
    	if(anglev == anglevv) {
    		for (String s : me.MrZombie_II.Listeners.ACListener.onlinestaff) {
				Player p = Bukkit.getServer().getPlayerExact(s);
				p.sendMessage(ChatColor.DARK_RED + player.getName() + " is using aimbot or forcefield! (1)");
			}
    		return;
    	}
    	if(i == anglev) {
    		for (String s : me.MrZombie_II.Listeners.ACListener.onlinestaff) {
				Player p = Bukkit.getServer().getPlayerExact(s);
				p.sendMessage(ChatColor.DARK_RED + player.getName() + " is using aimbot or forcefield! (1)");
			}
    		return;
    	}
    	if(i == anglev) {
    		for (String s : me.MrZombie_II.Listeners.ACListener.onlinestaff) {
				Player p = Bukkit.getServer().getPlayerExact(s);
				p.sendMessage(ChatColor.DARK_RED + player.getName() + " is using aimbot or forcefield! (1)");
			}
    		return;
    	}
    	if(i == anglev) {
    		for (String s : me.MrZombie_II.Listeners.ACListener.onlinestaff) {
				Player p = Bukkit.getServer().getPlayerExact(s);
				p.sendMessage(ChatColor.DARK_RED + player.getName() + " is using aimbot or forcefield! (1)");
			}
    		return;
    	}
    	if(i == anglev) {
    		for (String s : me.MrZombie_II.Listeners.ACListener.onlinestaff) {
				Player p = Bukkit.getServer().getPlayerExact(s);
				p.sendMessage(ChatColor.DARK_RED + player.getName() + " is using aimbot or forcefield! (1)");
			}
    		return;
    	}
    	if(i == anglev) {
    		for (String s : me.MrZombie_II.Listeners.ACListener.onlinestaff) {
				Player p = Bukkit.getServer().getPlayerExact(s);
				p.sendMessage(ChatColor.DARK_RED + player.getName() + " is using aimbot or forcefield! (1)");
			}
    		return;
    	}
    	if(i == anglev) {
    		for (String s : me.MrZombie_II.Listeners.ACListener.onlinestaff) {
				Player p = Bukkit.getServer().getPlayerExact(s);
				p.sendMessage(ChatColor.DARK_RED + player.getName() + " is using aimbot or forcefield! (1)");
			}
    		return;
    	}
    	if(i == anglev) {
    		for (String s : me.MrZombie_II.Listeners.ACListener.onlinestaff) {
				Player p = Bukkit.getServer().getPlayerExact(s);
				p.sendMessage(ChatColor.DARK_RED + player.getName() + " is using aimbot or forcefield! (1)");
			}
    		return;
    	}
    	
    	
    	
    	
    	ffangle.remove(player.getName());
    }
    

}
