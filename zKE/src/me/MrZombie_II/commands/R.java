package me.MrZombie_II.commands;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class R implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if(commandLabel.equalsIgnoreCase("r") || (commandLabel.equalsIgnoreCase("reply"))) {
			
			Player player = (Player) sender;
			
			if(!(me.MrZombie_II.commands.Msg.msg.containsKey(player.getName()))) {
				player.sendMessage(ChatColor.RED + "Error: You have no one to reply to!");
				return true;
			}
			
			
			String r = me.MrZombie_II.commands.Msg.msg.get(player.getName());
			
			
			
			Player t = Bukkit.getServer().getPlayer(r);
			
			if(t == null) {
				player.sendMessage(ChatColor.RED + "Error: Player '" + r + "' not found!");
				
			}
			
			if(!(player.canSee(t))) {
				player.sendMessage(ChatColor.RED + "Error: Player " + args[0].toString() + " not found");
				return true;
			}
			
			me.MrZombie_II.commands.Msg.msg.remove(player.getName());
			me.MrZombie_II.commands.Msg.msg.put(player.getName(), t.getName());
			me.MrZombie_II.commands.Msg.msg.remove(t.getName());
			me.MrZombie_II.commands.Msg.msg.put(t.getName(), player.getName());
			
			List<String> l = new ArrayList<String>();
			for(Player p : Bukkit.getServer().getOnlinePlayers()) {
				if(p.hasPermission("weed.ss")) {
					l.add(p.getName());
				}
				
			}
			
			for(String s : l) {
				Player p = Bukkit.getServer().getPlayerExact(s);
				
				String reason = StringUtils.join(args, " ", 0, args.length);
				
				p.sendMessage(ChatColor.YELLOW + "[S] <" + player.getName() + " -> " + t.getName() + "> " + reason);
				
			}
			
			String reason = StringUtils.join(args, " ", 0, args.length);
			t.sendMessage(ChatColor.GRAY + "<" + player.getName() + " -> " + t.getName() + "> " + reason);
			player.sendMessage(ChatColor.GRAY + "<" + player.getName() + " -> " + t.getName() + "> " + reason);
			
		}
		
		
		
		return false;
	}

}
