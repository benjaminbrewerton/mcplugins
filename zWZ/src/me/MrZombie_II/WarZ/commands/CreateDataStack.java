package me.MrZombie_II.WarZ.commands;

import me.MrZombie_II.WarZ.api.ChestUtils;
import net.minecraft.util.org.apache.commons.lang3.StringUtils;

import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CreateDataStack implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(!(sender instanceof Player)) {
			System.out.println("Yea, fuck off mate");
			return true;
		}
		
		Player player = (Player) sender;
		
		if(!(args.length == 2) || !StringUtils.isNumeric(args[1])) {
			player.sendMessage(ChatColor.RED + "Error: Incorrect Syntax; /cds <Material> <Byte>");
			player.sendMessage(ChatColor.GREEN + "Applicable Materials: Ink Sack, Golden Apple, Wool");
			return true;
		}
		
		String material = args[0].toUpperCase();
		
		byte databyte = Byte.parseByte(args[1]);
		
		Material am = null;
		
		/*
		switch(material) {
		case "INK_SACK":
			am = Material.INK_SACK;
		
		case "GOLDEN_APPLE":
			am = Material.GOLDEN_APPLE;
			
		case "WOOL":
			am = Material.WOOL;
			
		}
		*/
		
		if(material.equals("INK_SACK")) am = Material.INK_SACK;
		if(material.equals("GOLDEN_APPLE")) am = Material.GOLDEN_APPLE;
		if(material.equals("WOOL")) am = Material.WOOL;
		
		if(am == null) {
			player.sendMessage(ChatColor.RED + "Error: Unrecongnized Material input");
			return true;
		}
		
		ItemStack ii = new ItemStack(am, 1, databyte);
		
		player.getInventory().setItemInHand(ii);
		
		return false;
	}

}
