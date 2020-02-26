package me.MrZombie_II.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class SwornGuns implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(commandLabel.equalsIgnoreCase("swornguns")) {
			if(!sender.isOp()) {
				sender.sendMessage(ChatColor.WHITE + "Unknown command. Type '/help' for help.");
			} else {
				sender.sendMessage(ChatColor.RED + "Use the config for editing guns you lazy cunt");
			}
			
		}
		
		return false;
	}

}
