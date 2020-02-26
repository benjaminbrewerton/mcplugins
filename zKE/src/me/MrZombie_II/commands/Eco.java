package me.MrZombie_II.commands;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import me.MrZombie_II.Listeners.StatsListener;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Eco implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(commandLabel.equalsIgnoreCase("eco")) {
			
			if(!(sender instanceof Player)) {
				if(args[0].equalsIgnoreCase("give")) {
					
					
					final Player target = Bukkit.getServer().getPlayer(args[1]);
					
					File f = new File(Bukkit.getServer().getPluginManager().getPlugin("zWE").getDataFolder() + File.separator + "userdata" + File.separator + target.getName() + ".yml");
					final FileConfiguration cfg = YamlConfiguration.loadConfiguration(f);
					
					try {
						cfg.load(f);
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (InvalidConfigurationException e1) {
						e1.printStackTrace();
					}
					
					int oc = cfg.getInt("credits");
					int nc = Integer.parseInt(args[2]);
					int nb = oc + nc;
					
					
					cfg.set("credits", nb);
					
					try {
						cfg.save(f);
					} catch (IOException e) {
						e.printStackTrace();
					}
					
			        
					StatsListener.setPS(target, 10L);
					
					System.out.println("Successfully gave " + target.getName() + " " + nc + " credits!");
					target.sendMessage(ChatColor.GREEN + "Received " + nc + " from console");
					
				}
				
				if(args[0].equalsIgnoreCase("take")) {
					
					
					final Player target = Bukkit.getServer().getPlayer(args[1]);
					File f = new File(Bukkit.getServer().getPluginManager().getPlugin("zWE").getDataFolder() + File.separator + "userdata" + File.separator + target.getName() + ".yml");
					final FileConfiguration cfg = YamlConfiguration.loadConfiguration(f);
					
					try {
						cfg.load(f);
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (InvalidConfigurationException e1) {
						e1.printStackTrace();
					}
					
					int oc = cfg.getInt("credits");
					int nc = Integer.parseInt(args[2]);
					int nb = oc - nc;
					
					if(nc > oc) {
						System.out.println(ChatColor.RED + "Error: Insufficient funds!");
						System.out.println(ChatColor.GREEN + "Only " + oc + " credits in " + target.getName() + "'s account!");
						return true;
						
					}
					
					cfg.set("credits", nb);
					
					try {
						cfg.save(f);
					} catch (IOException e) {
						e.printStackTrace();
					}
					
			        
					StatsListener.setPS(target, 10L);
					
			        System.out.println(ChatColor.GREEN + "Successfully took " + nc + " credits from " + target.getName() + "!");
					target.sendMessage(ChatColor.GREEN + "" + nc + " credits removed by Console");
					
				}
				
				return true;
				
			}
			
			
			Player player = (Player) sender;
		
		if(!(args.length == 3)) {
			player.sendMessage(ChatColor.RED + "Error: Incorrect Syntax; /eco [give/pay/take] <player> <amount>");
			return true;
		}
		
		
		
		
		
		if(!(StringUtils.isNumeric(args[2].toString()))) {
			player.sendMessage(ChatColor.RED + "Error: Incorrect Syntax; /eco [give/pay/take] <player> <amount>");
			player.sendMessage(ChatColor.RED + "<amount> must be a value!");
			return true;
		}
		
		if(args[0].equalsIgnoreCase("give")) {
			
			
			if(!(player.hasPermission("weed.eco.give"))) {
				player.sendMessage(ChatColor.RED + "Error: No Permission to spawn money!");
				return true;
			}
			
			final Player target = Bukkit.getServer().getPlayer(args[1]);
			
			File f = new File(Bukkit.getServer().getPluginManager().getPlugin("zWE").getDataFolder() + File.separator + "userdata" + File.separator + player.getName() + ".yml");
			final FileConfiguration cfg = YamlConfiguration.loadConfiguration(f);
			
			File f1 = new File(Bukkit.getServer().getPluginManager().getPlugin("zWE").getDataFolder() + File.separator + "userdata" + File.separator + target.getName() + ".yml");
			final FileConfiguration cfg1 = YamlConfiguration.loadConfiguration(f1);
			
			try {
				cfg1.load(f1);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (InvalidConfigurationException e1) {
				e1.printStackTrace();
			}
			
			int oc = cfg1.getInt("credits");
			int nc = Integer.parseInt(args[2]);
			int nb = oc + nc;
			cfg1.set("credits", nb);
			
			try {
				cfg1.save(f1);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
	        
			StatsListener.setPS(target, 10L);
			
			player.sendMessage(ChatColor.GREEN + "Successfully gave " + target.getName() + " " + nc + " credits!");
			target.sendMessage(ChatColor.GREEN + "Received " + nc + " from " + player.getName());
			
		}
		
		if(args[0].equalsIgnoreCase("take")) {
			
			
			if(!(player.hasPermission("weed.eco.take"))) {
				player.sendMessage(ChatColor.RED + "Error: No Permission to take money!");
				return true;
			}
			
			final Player target = Bukkit.getServer().getPlayer(args[1]);
			
			File f = new File(Bukkit.getServer().getPluginManager().getPlugin("zWE").getDataFolder() + File.separator + "userdata" + File.separator + player.getName() + ".yml");
			final FileConfiguration cfg = YamlConfiguration.loadConfiguration(f);
			
			File f1 = new File(Bukkit.getServer().getPluginManager().getPlugin("zWE").getDataFolder() + File.separator + "userdata" + File.separator + target.getName() + ".yml");
			final FileConfiguration cfg1 = YamlConfiguration.loadConfiguration(f1);
			
			int oc = cfg1.getInt("credits");
			int nc = Integer.parseInt(args[2]);
			int nb = oc - nc;
			
			if(nc > oc) {
				player.sendMessage(ChatColor.RED + "Error: Insufficient funds!");
				player.sendMessage(ChatColor.GREEN + "Only " + oc + " credits in " + target.getName() + "'s account!");
				return true;
				
			}
			
			cfg1.set("credits", nb);
			
			try {
				cfg1.save(f1);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
	        
			StatsListener.setPS(target, 10L);
			
			player.sendMessage(ChatColor.GREEN + "Successfully took " + nc + " credits from " + target.getName() + "!");
			target.sendMessage(ChatColor.GREEN + "" + nc + " credits removed by " + player.getName());
			
		}
		
		if(args[0].equalsIgnoreCase("pay")) {
		
			
			if(!(player.hasPermission("weed.eco.pay"))) {
				player.sendMessage(ChatColor.RED + "Error: No Permission to spawn money!");
				return true;
			}
			
			Player target = Bukkit.getServer().getPlayer(args[1]);
			
			File f = new File(Bukkit.getServer().getPluginManager().getPlugin("zWE").getDataFolder() + File.separator + "userdata" + File.separator + player.getName() + ".yml");
			final FileConfiguration cfg = YamlConfiguration.loadConfiguration(f);
			
			File f1 = new File(Bukkit.getServer().getPluginManager().getPlugin("zWE").getDataFolder() + File.separator + "userdata" + File.separator + target.getName() + ".yml");
			final FileConfiguration cfg1 = YamlConfiguration.loadConfiguration(f1);
			
			if(target.getName() == player.getName()) {
				player.sendMessage(ChatColor.RED + "Error: Cannot give money to yourself!");
				return true;
			}
			
			
			int oc = cfg1.getInt("credits");
			int tc = cfg.getInt("credits");
			int nc = Integer.parseInt(args[2]);
			
			if(nc > tc) {
				player.sendMessage(ChatColor.RED + "Error: Insufficient funds!");
				player.sendMessage(ChatColor.GREEN + "Only " + oc + " credits in your account!");
				return true;
			}
			
			
			int occ = tc - nc;
			int tcc = oc + nc;
			
			cfg1.set("credits", tcc);
			cfg.set("credits", occ);
			
			try {
				cfg.save(f);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				cfg1.save(f1);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
	        
			StatsListener.setPS(target, 10L);
	        
			StatsListener.setPS(player, 10L);
			
			player.sendMessage(ChatColor.GREEN + "Successfully payed " + nc + " credits to " + target.getName() + "! ");
			target.sendMessage(ChatColor.GREEN + "Received " + nc + " credits from " + player.getName());
			
			
		}
		
		
		}
		
		return false;
	}

}
