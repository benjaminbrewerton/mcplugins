package me.MrZombie_II.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class CheckBan implements CommandExecutor {

	private FileConfiguration cfg = YamlConfiguration.loadConfiguration(me.MrZombie_II.main.BanConfig.BanFile());
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(commandLabel.equalsIgnoreCase("checkban")) {
			if(sender.hasPermission("weed.bcheck")) {

				if(args.length == 0) {
					sender.sendMessage(ChatColor.RED + "/checkban <Player>");
				}
				if(args.length == 1) {
					OfflinePlayer target = Bukkit.getServer().getOfflinePlayer(args[0]);
					
					if(!target.isBanned()) {
						sender.sendMessage(ChatColor.RED + "Error: Player is not banned!");
						return true;
					}
					
					
					sender.sendMessage(ChatColor.DARK_AQUA + "============" + ChatColor.GREEN + " Ban Check " + ChatColor.DARK_AQUA + "============");
					sender.sendMessage(ChatColor.GREEN + "Banned by: " + cfg.getString(target.getName() + ".banb"));
					sender.sendMessage(ChatColor.GREEN + "Ban Reason: " + cfg.getString(target.getName() + ".banr"));
					sender.sendMessage(ChatColor.DARK_AQUA + "==================================");
					
				}
			}
			
		}
		return false;
	}
}
