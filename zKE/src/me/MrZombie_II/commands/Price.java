package me.MrZombie_II.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Price implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(commandLabel.equalsIgnoreCase("price")) {
			if(!(sender instanceof Player)) {
				return true;
			}
			
			Player player = (Player) sender;
			if(player.hasPermission("weed.price")) {
				if(!(args.length == 1)) {
					player.sendMessage(ChatColor.RED + "Error: Syntax Error; /price <Item>");
					player.sendMessage(ChatColor.GRAY + "/price <Item> - Item you want to view the price of");
					player.sendMessage(ChatColor.GRAY + "All items in the shop are one word. Ballistic Knife becomes bknife or ballisticknife.");
					player.sendMessage(ChatColor.GRAY + "Common nicknames for items can be used to purchase the knife. For example, you can buy a Barret using /shop barret");
					return true;
				}
					
				if(args[0].equalsIgnoreCase("m9")) {
					player.sendMessage(ChatColor.RED + "A M9 costs " + ChatColor.BLUE + "30" + ChatColor.RED + " credits!");
				}
				if(args[0].equalsIgnoreCase("m1074")) {
					player.sendMessage(ChatColor.RED + "A M1074 costs " + ChatColor.BLUE + "80" + ChatColor.RED + " credits!");
				}
				if(args[0].equalsIgnoreCase("msr")) {
					player.sendMessage(ChatColor.RED + "A MSR 250 costs " + ChatColor.BLUE + "250" + ChatColor.RED + " credits!");
				}
				if(args[0].equalsIgnoreCase("p90")) {
					player.sendMessage(ChatColor.RED + "A P90 costs " + ChatColor.BLUE + "300" + ChatColor.RED + " credits!");
				}
				if(args[0].equalsIgnoreCase("barret") || args[0].equalsIgnoreCase("barret50cal")) {
					player.sendMessage(ChatColor.RED + "A Barret 50. Cal costs " + ChatColor.BLUE + "600" + ChatColor.RED + " credits!");
				}
				if(args[0].equalsIgnoreCase("deserteagle") || args[0].equalsIgnoreCase("deagle")) {
					player.sendMessage(ChatColor.RED + "A Desert Eagle costs " + ChatColor.BLUE + "250" + ChatColor.RED + " credits!");
				}
				if(args[0].equalsIgnoreCase("spas12") || args[0].equalsIgnoreCase("spas")) {
					player.sendMessage(ChatColor.RED + "A Spas-12 costs " + ChatColor.BLUE + "300" + ChatColor.RED + " credits!");
				}
				if(args[0].equalsIgnoreCase("ak47") || args[0].equalsIgnoreCase("ak")) {
					player.sendMessage(ChatColor.RED + "A AK-47 costs " + ChatColor.BLUE + "450" + ChatColor.RED + " credits!");
				}
				if(args[0].equalsIgnoreCase("python")) {
					player.sendMessage(ChatColor.RED + "A Python costs " + ChatColor.BLUE + "1300" + ChatColor.RED + " credits!");
				}
				if(args[0].equalsIgnoreCase("gspas") || args[0].equalsIgnoreCase("goldenspas12") || args[0].equalsIgnoreCase("gspas12")) {
					player.sendMessage(ChatColor.RED + "A Golden Spas-12 costs " + ChatColor.BLUE + "4000" + ChatColor.RED + " credits!");
				}
				if(args[0].equalsIgnoreCase("disassembler")) {
					player.sendMessage(ChatColor.RED + "A Disassembler costs " + ChatColor.BLUE + "4500" + ChatColor.RED + " credits!");
				}
				if(args[0].equalsIgnoreCase("minigun")) {
					player.sendMessage(ChatColor.RED + "A Minigun costs " + ChatColor.BLUE + "9000" + ChatColor.RED + " credit!");
				}
				if(args[0].equalsIgnoreCase("executioner")) {
					player.sendMessage(ChatColor.RED + "A Executioner costs " + ChatColor.BLUE + "2000" + ChatColor.RED + " credits!");
				}
				if(args[0].equalsIgnoreCase("flamethrower")) {
					player.sendMessage(ChatColor.RED + "A Flamethrower costs " + ChatColor.BLUE + "1500" + ChatColor.RED + " credits!");
				}
				if(args[0].equalsIgnoreCase("l120") || args[0].equalsIgnoreCase("iso") || args[0].equalsIgnoreCase("l120isolator")) {
					player.sendMessage(ChatColor.RED + "A L120 Isolator costs " + ChatColor.BLUE + "5000" + ChatColor.RED + " credits!");
				}
				if(args[0].equalsIgnoreCase("famas") || args[0].equalsIgnoreCase("famas18")) {
					player.sendMessage(ChatColor.RED + "A Famas costs " + ChatColor.BLUE + "3000" + ChatColor.RED + " credits!");
				}
				if(args[0].equalsIgnoreCase("autoammo") || args[0].equalsIgnoreCase("automaticammo")) {
					player.sendMessage(ChatColor.RED + "Some Automatic Ammo costs " + ChatColor.BLUE + "150" + ChatColor.RED + " credits!");
				}
				if(args[0].equalsIgnoreCase("shottyammo") || args[0].equalsIgnoreCase("shotgunammo")) {
					player.sendMessage(ChatColor.RED + "Some Shotgun Ammo costs " + ChatColor.BLUE + "200" + ChatColor.RED + " credits!");
				}
				if(args[0].equalsIgnoreCase("sniperammo")) {
					player.sendMessage(ChatColor.RED + "Some Sniper Ammo costs " + ChatColor.BLUE + "350" + ChatColor.RED + " credits!");
				}
				if(args[0].equalsIgnoreCase("pistolammo") || args[0].equalsIgnoreCase("pammo")) {
					player.sendMessage(ChatColor.RED + "Some Pistol Ammo costs " + ChatColor.BLUE + "75" + ChatColor.RED + " credits!");
				}
				if(args[0].equalsIgnoreCase("bknife") || args[0].equalsIgnoreCase("ballisticknife")) {
					player.sendMessage(ChatColor.RED + "A Ballistic Knife costs " + ChatColor.BLUE + "6000" + ChatColor.RED + " credits!");
				}
				if(args[0].equalsIgnoreCase("bknifeammo") || args[0].equalsIgnoreCase("ballisticknifeammo")) {
					player.sendMessage(ChatColor.RED + "Some Ballistic Knife Ammo costs " + ChatColor.BLUE + "400" + ChatColor.RED + " credits!");
				}
				if(args[0].equalsIgnoreCase("dhelmet") || args[0].equalsIgnoreCase("diamondhelmet")) {
					player.sendMessage(ChatColor.RED + "A Diamond Helmet costs " + ChatColor.BLUE + "1000" + ChatColor.RED + " credits!");
				}
				if(args[0].equalsIgnoreCase("dchest") || args[0].equalsIgnoreCase("diamondchestplate")) {
					player.sendMessage(ChatColor.RED + "A Diamond Chestplate costs " + ChatColor.BLUE + "2000" + ChatColor.RED + " credits!");
				}
				if(args[0].equalsIgnoreCase("dlegs") || args[0].equalsIgnoreCase("diamondleggings")) {
					player.sendMessage(ChatColor.RED + "A pair of Diamond Leggings costs " + ChatColor.BLUE + "1500" + ChatColor.RED + " credits!");
				}
				if(args[0].equalsIgnoreCase("dboots") || args[0].equalsIgnoreCase("diamondboots")) {
					player.sendMessage(ChatColor.RED + "A pair of Diamond Boots costs " + ChatColor.BLUE + "1000" + ChatColor.RED + " credits!");
				}
				if(args[0].equalsIgnoreCase("beans") || args[0].equalsIgnoreCase("cannedbeans")) {			
					player.sendMessage(ChatColor.RED + "Some Canned Beans costs " + ChatColor.BLUE + "400" + ChatColor.RED + " credits!");
				}
				if(args[0].equalsIgnoreCase("pasta") || args[0].equalsIgnoreCase("cannedpasta")) {
					player.sendMessage(ChatColor.RED + "Some Canned Pasta costs " + ChatColor.BLUE + "500" + ChatColor.RED + " credits!");
				}
				if(args[0].equalsIgnoreCase("md") || args[0].equalsIgnoreCase("mountaindew")) {
					player.sendMessage(ChatColor.RED + "Some Mountain Dew costs " + ChatColor.BLUE + "300" + ChatColor.RED + " credits!");
				}
				if(args[0].equalsIgnoreCase("pepsi")) {
					player.sendMessage(ChatColor.RED + "Some Pepsi costs " + ChatColor.BLUE + "120" + ChatColor.RED + " credits!");
				}
				if(args[0].equalsIgnoreCase("enchantingbottles") || args[0].equalsIgnoreCase("eb") || args[0].equalsIgnoreCase("enchantbottles") || args[0].equalsIgnoreCase("enchantbottle")) {
					player.sendMessage(ChatColor.RED + "Some Bottles of Enchanting costs " + ChatColor.BLUE + "600" + ChatColor.RED + " credits!");
				}
				
			}
			
		}
		
		return false;
	}

}
