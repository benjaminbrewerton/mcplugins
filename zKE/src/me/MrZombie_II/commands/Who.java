package me.MrZombie_II.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Who implements CommandExecutor {
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if (commandLabel.equalsIgnoreCase("who") || commandLabel.equalsIgnoreCase("list")) {
		if(sender instanceof Player){
			Player player = (Player) sender;
			player.getWorld().playSound(player.getLocation(), Sound.ORB_PICKUP, 1, 0);
	        player.sendMessage(" ");
	        sender.sendMessage(ChatColor.RED + "ADMIN " + ChatColor.RESET + ChatColor.RESET + 
	                ChatColor.DARK_PURPLE + ChatColor.ITALIC + "Mod+ " + ChatColor.RESET + 
	                ChatColor.DARK_PURPLE + "Mod " + ChatColor.WHITE + "| " + ChatColor.RESET + 
	                ChatColor.DARK_AQUA + "Immortal($30) " + ChatColor.GREEN + "Veteran($20) " + 
	                ChatColor.YELLOW + "Ranger($10) " + ChatColor.WHITE + "DEFAULT");
	        player.sendMessage(" ");
	        
	        int MaxPlayers = Bukkit.getServer().getMaxPlayers();
	        int op = Bukkit.getServer().getOnlinePlayers().length - me.MrZombie_II.commands.Vanish.vanished.size();
	        
	        player.sendMessage(ChatColor.GRAY + "Online Players :"  + ChatColor.RESET + "    (" + op + "/" + MaxPlayers + ")");
	        
	        List<String> who = new ArrayList<String>();
	        
	        for(String s : me.MrZombie_II.Listeners.PlayerListener.Owner) {
	        	who.add(s);
	        }
	        for(String s : me.MrZombie_II.Listeners.PlayerListener.Admin) {
	        	who.add(s);
	        }
	        for(String s : me.MrZombie_II.Listeners.PlayerListener.Modplus) {
	        	who.add(s);
	        }
	        for(String s : me.MrZombie_II.Listeners.PlayerListener.TrialMod) {
	        	who.add(s);
	        }
	        for(String s : me.MrZombie_II.Listeners.PlayerListener.Immortal) {
	        	who.add(s);
	        }
	        for(String s : me.MrZombie_II.Listeners.PlayerListener.Veteran) {
	        	who.add(s);
	        }
	        for(String s : me.MrZombie_II.Listeners.PlayerListener.Ranger) {
	        	who.add(s);
	        }
	        for(String s : me.MrZombie_II.Listeners.PlayerListener.Default) {
	        	who.add(s);
	        }
	        
	        String olp = who.toString();
	        String olpc = ChatColor.translateAlternateColorCodes('&', olp);
	        player.sendMessage(olpc);
	        
	        player.sendMessage(" ");
	        
	        who.clear();
	        
	        return true;
	    }else{
	        Player[] plist = sender.getServer().getOnlinePlayers();
	        System.out.println("Online Players :");
	        for(Player p : plist){
	            System.out.println(p.getDisplayName());
	        }
	        return true;
	    }
		}
	    return false;
	}
		

}
