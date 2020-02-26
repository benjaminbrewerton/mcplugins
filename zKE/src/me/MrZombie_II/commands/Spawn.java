package me.MrZombie_II.commands;

import java.util.Iterator;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Spawn implements CommandExecutor, Listener {
	
	 public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
	    if (cmd.getName().equalsIgnoreCase("spawn")) {
	      final Player player = (Player)sender;
	      if ((sender instanceof Player)) {
	        int num = 0;
	        for (Object localObject = player.getNearbyEntities(25.0D, 25.0D, 25.0D).iterator(); ((Iterator) localObject).hasNext(); ) { Entity ent = (Entity)((Iterator)localObject).next();
	          if ((ent instanceof Player)) {
	            num++;
	          }
	        }
	        if (num > 0) {
	          me.MrZombie_II.Listeners.SpawnProtListener.warping.put(player.getName(), null);
	          me.MrZombie_II.Listeners.SpawnProtListener.teleportmove.add(player.getName());
	          player.sendMessage(ChatColor.GRAY + "Someone is nearby. You will warp in 10 seconds!");
	          Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("zWE"), new Runnable() {
	            public void run() {
	              if (me.MrZombie_II.Listeners.SpawnProtListener.warping.containsKey(player.getName())) {
	                if (me.MrZombie_II.Listeners.SpawnProtListener.teleportmove.contains(player.getName())) {
	                	me.MrZombie_II.Listeners.SpawnProtListener.teleportmove.remove(player.getName());
	                  player.teleport(Bukkit.getServer().getWorld("world").getSpawnLocation());
	                  me.MrZombie_II.Listeners.SpawnProtListener.warping.remove(player.getName());
	                  if (me.MrZombie_II.Listeners.SpawnProtListener.nospawn.containsKey(player.getName()))
	                    player.sendMessage(ChatColor.RED + "You now have spawn protection");
	                  me.MrZombie_II.Listeners.SpawnProtListener.nospawn.remove(player.getName());
	                }
	              }
	              else player.teleport(player);
	            }
	          }
	          , 200L);
	        } else {
	          player.teleport(Bukkit.getServer().getWorld("world").getSpawnLocation());
	          if (me.MrZombie_II.Listeners.SpawnProtListener.nospawn.containsKey(player.getName())) {
	        	  me.MrZombie_II.Listeners.SpawnProtListener.nospawn.remove(player.getName());
	        	  me.MrZombie_II.Listeners.SpawnProtListener.warping.remove(player.getName());
	            player.sendMessage(ChatColor.RED + "You now have spawn protection");
	          }
	        }

	      }

	    }

	    return false;
	  }

}
