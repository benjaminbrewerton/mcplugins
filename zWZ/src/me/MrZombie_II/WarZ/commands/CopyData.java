package me.MrZombie_II.WarZ.commands;

import java.io.IOException;

import me.MrZombie_II.WarZ.func.WorldHandler;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CopyData implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		try {
			WorldHandler.getWH().copyPlayerData();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
