package me.MrZombie_II.commands;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import me.MrZombie_II.Listeners.StatsListener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Shop implements CommandExecutor {
	
public void buy (Player player, Integer a, ItemStack bi, String item) {
		
		File f = new File(Bukkit.getServer().getPluginManager().getPlugin("zWE").getDataFolder() + File.separator + "userdata" + File.separator + player.getName() + ".yml");
		final FileConfiguration cfg = YamlConfiguration.loadConfiguration(f);
			try {
				cfg.load(f);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InvalidConfigurationException e) {
				e.printStackTrace();
			}
			
			int i = cfg.getInt("credits");
			
			if(a > i) {
				player.sendMessage(ChatColor.RED + "Insufficient Credits to purchase a " + ChatColor.BLUE +  item + "!");
				return;
			}
			
			int ii = i - a;
			
			cfg.set("credits", ii);
			
			try {
				cfg.save(f);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
	        
			StatsListener.setPS(player, 5L);
			
	        player.getInventory().addItem(bi);
			
			player.sendMessage(ChatColor.GREEN + "Purchased a " + ChatColor.BLUE + item + ChatColor.GREEN + " for " + a + " credits!");
			player.sendMessage(ChatColor.BLUE + "You have " + ChatColor.RED + ii + " credits remaining!");
			
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(commandLabel.equalsIgnoreCase("shop")) {
			if(!(sender instanceof Player)) return true;
			
			Player player = (Player) sender;
			
			if(sender.hasPermission("weed.shop")) {
				
			if(!(args.length == 1)) {
				player.sendMessage(ChatColor.RED + "Error: Syntax Error; /shop <Item>");
				player.sendMessage(ChatColor.GRAY + "/shop <Item> - Item being the item you want to purchase from the shop");
				player.sendMessage(ChatColor.GRAY + "All items in the shop are one word. Ballistic Knife becomes bknife or ballisticknife.");
				player.sendMessage(ChatColor.GRAY + "Common nicknames for items can be used to purchase the knife. For example, you can buy a Barret using /shop barret");
				return true;
			}
				
			if(args[0].equalsIgnoreCase("m9")) {
				buy(player, 30, new ItemStack(Material.STONE_SPADE), "M9");
			}
			if(args[0].equalsIgnoreCase("m1074")) {
				buy(player, 80, new ItemStack(Material.STONE_PICKAXE, 1), "M1074");
			}
			if(args[0].equalsIgnoreCase("msr")) {
				buy(player, 250, new ItemStack(Material.STONE_AXE), "MSR");
			}
			if(args[0].equalsIgnoreCase("p90")) {
				buy(player, 300, new ItemStack(Material.STONE_HOE), "P90");
			}
			if(args[0].equalsIgnoreCase("barret") || args[0].equalsIgnoreCase("barret50cal")) {
				buy(player, 600, new ItemStack(Material.IRON_AXE), "Barret 50.cal");
			}
			if(args[0].equalsIgnoreCase("deserteagle") || args[0].equalsIgnoreCase("deagle")) {
				buy(player, 250, new ItemStack(Material.IRON_SPADE, 1), "Desert Eagle");
			}
			if(args[0].equalsIgnoreCase("spas12") || args[0].equalsIgnoreCase("spas")) {
				buy(player, 300, new ItemStack(Material.IRON_PICKAXE, 1), "Spas-12");
			}
			if(args[0].equalsIgnoreCase("ak47") || args[0].equalsIgnoreCase("ak")) {
				buy(player, 450, new ItemStack(Material.IRON_HOE), "AK-47");
			}
			if(args[0].equalsIgnoreCase("python")) {
				buy(player, 1300, new ItemStack(Material.DIAMOND_SPADE, 1), "Python");
			}
			if(args[0].equalsIgnoreCase("gspas") || args[0].equalsIgnoreCase("goldenspas12") || args[0].equalsIgnoreCase("gspas12")) {
				buy(player, 4000, new ItemStack(Material.DIAMOND_PICKAXE, 1), "Golden Spas-12");
			}
			if(args[0].equalsIgnoreCase("disassembler")) {
				buy(player, 4500, new ItemStack(Material.DIAMOND_AXE), "Disassembler");
			}
			if(args[0].equalsIgnoreCase("minigun")) {
				buy(player, 9000, new ItemStack(Material.DIAMOND_HOE), "Minigun");
			}
			if(args[0].equalsIgnoreCase("executioner")) {
				buy(player, 2000, new ItemStack(Material.GOLD_SPADE, 1), "Executioner");
			}
			if(args[0].equalsIgnoreCase("flamethrower")) {
				buy(player, 1500, new ItemStack(Material.GOLD_PICKAXE, 1), "Flamethrower");
			}
			if(args[0].equalsIgnoreCase("l120") || args[0].equalsIgnoreCase("iso") || args[0].equalsIgnoreCase("l120isolator")) {
				buy(player, 5000, new ItemStack(Material.GOLD_AXE), "L120_Isolator");
			}
			if(args[0].equalsIgnoreCase("famas") || args[0].equalsIgnoreCase("famas18")) {
				buy(player, 3000, new ItemStack(Material.GOLD_HOE), "Famas-18");
			}
			if(args[0].equalsIgnoreCase("autoammo") || args[0].equalsIgnoreCase("automaticammo")) {
				ItemStack autoa = new ItemStack(Material.FLINT, 64);
				ItemMeta autoab = autoa.getItemMeta();
				autoab.setDisplayName(ChatColor.GRAY + "Automatic Ammo");
				autoa.setItemMeta(autoab);
				
				buy(player, 150, autoa, "Automatic Ammo");
			}
			if(args[0].equalsIgnoreCase("shottyammo") || args[0].equalsIgnoreCase("shotgunammo")) {
				ItemStack shoty = new ItemStack(Material.SEEDS, 64);
				ItemMeta shotyb = shoty.getItemMeta();
				shotyb.setDisplayName(ChatColor.GRAY + "Shotgun Ammo");
				shoty.setItemMeta(shotyb);
				
				buy(player, 200, shoty, "Shotgun Ammo");
			}
			if(args[0].equalsIgnoreCase("sniperammo")) {
				ItemStack sniper = new ItemStack(Material.CLAY_BALL, 64);
				ItemMeta sniperb = sniper.getItemMeta();
				sniperb.setDisplayName(ChatColor.GRAY + "Sniper Ammo");
				sniper.setItemMeta(sniperb);

				buy(player, 350, sniper, "Sniper Ammo");
			}
			if(args[0].equalsIgnoreCase("pistolammo") || args[0].equalsIgnoreCase("pammo")) {
				ItemStack pistola = new ItemStack(Material.GOLD_NUGGET, 64);
				ItemMeta pistolab = pistola.getItemMeta();
				pistolab.setDisplayName(ChatColor.GRAY + "Pistol Ammo");
				pistola.setItemMeta(pistolab);
				
				buy(player, 75, pistola, "Pistol Ammo");
			}
			if(args[0].equalsIgnoreCase("bknife") || args[0].equalsIgnoreCase("ballisticknife")) {
				buy(player, 6000, new ItemStack(Material.GOLD_SWORD, 1), "Ballistic Knife");
			}
			if(args[0].equalsIgnoreCase("bknifeammo") || args[0].equalsIgnoreCase("ballisticknifeammo")) {
				ItemStack arrow = new ItemStack(Material.ARROW, 64);
				ItemMeta arrowb = arrow.getItemMeta();
				arrowb.setDisplayName(ChatColor.RED + "Ballistic Knife Ammo");
				arrow.setItemMeta(arrowb);
				
				buy(player, 400, arrow, "Ballistic Knife Ammo");
			}
			if(args[0].equalsIgnoreCase("dhelmet") || args[0].equalsIgnoreCase("diamondhelmet")) {
				buy(player, 1000, new ItemStack(Material.DIAMOND_HELMET, 1), "Diamond Helmet");
			}
			if(args[0].equalsIgnoreCase("dchest") || args[0].equalsIgnoreCase("diamondchestplate")) {
				buy(player, 2000, new ItemStack(Material.DIAMOND_CHESTPLATE, 1), "Diamond Chestplate");
			}
			if(args[0].equalsIgnoreCase("dlegs") || args[0].equalsIgnoreCase("diamondleggings")) {
				buy(player, 1500, new ItemStack(Material.DIAMOND_LEGGINGS, 1), "Diamond Leggings");
			}
			if(args[0].equalsIgnoreCase("dboots") || args[0].equalsIgnoreCase("diamondboots")) {
				buy(player, 1000, new ItemStack(Material.DIAMOND_BOOTS, 1), "Diamond Boots");
			}
			if(args[0].equalsIgnoreCase("beans") || args[0].equalsIgnoreCase("cannedbeans")) {			
				ItemStack beans = new ItemStack(Material.INK_SACK, 64, (byte) 4);
				ItemMeta beansb = beans.getItemMeta();
				beansb.setDisplayName(ChatColor.AQUA + "Canned Beans");
				beans.setItemMeta(beansb);
				
				buy(player, 400, beans, "Canned Beans");
			}
			if(args[0].equalsIgnoreCase("pasta") || args[0].equalsIgnoreCase("cannedpasta")) {
				ItemStack pasta = new ItemStack(Material.INK_SACK, 64, (byte) 11);
				ItemMeta pastab = pasta.getItemMeta();
				pastab.setDisplayName(ChatColor.AQUA + "Canned Pasta");
				pasta.setItemMeta(pastab);
				
				buy(player, 500, pasta, "Canned Pasta");
			}
			if(args[0].equalsIgnoreCase("md") || args[0].equalsIgnoreCase("mountaindew")) {
				ItemStack steak = new ItemStack(Material.INK_SACK, 1, (byte) 15);
				ItemMeta steakb = steak.getItemMeta();
				steakb.setDisplayName(ChatColor.AQUA + "Mountain Dew");
				steak.setItemMeta(steakb);
				
				buy(player, 300, steak, "Mountain Dew");
			}
			if(args[0].equalsIgnoreCase("pepsi")) {
				ItemStack pepsi = new ItemStack(Material.INK_SACK, 64, (byte) 14);
				ItemMeta pepsib = pepsi.getItemMeta();
				pepsib.setDisplayName(ChatColor.AQUA + "Pepsi");
				pepsi.setItemMeta(pepsib);
				
				buy(player, 120, pepsi, "Pepsi");
			}
			if(args[0].equalsIgnoreCase("enchantingbottles") || args[0].equalsIgnoreCase("eb") || args[0].equalsIgnoreCase("enchantbottles") || args[0].equalsIgnoreCase("enchantbottle")) {
				ItemStack xp = new ItemStack(Material.EXP_BOTTLE, 64);
				ItemMeta xpb = xp.getItemMeta();
				xpb.setDisplayName(ChatColor.AQUA + "XP Bottles");
				xp.setItemMeta(xpb);
				
				buy(player, 600, xp, "XP Bottle");
			}
		}
		} else {
			sender.sendMessage(ChatColor.RED + "Error: No Permissions");
		}
		
		
		return false;
		
		
	}
	
	/* GUI SHOP
	 * 
	 * Inventory gshop = Bukkit.createInventory(null, 9, ChatColor.RED + "Global Shop");
			
			ItemStack gs1 = new ItemStack(Material.ARROW, 1);
			ItemMeta gm1 = gs1.getItemMeta();
			gm1.setDisplayName(ChatColor.RED + "Item Shop");
			gm1.setLore(Arrays.asList(ChatColor.BLUE + "Use this shop to buy buffs and food!"));
			gs1.setItemMeta(gm1);
			
			ItemStack gs2 = new ItemStack(Material.DIAMOND_AXE, 1);
			ItemMeta gm2 = gs2.getItemMeta();
			gm2.setDisplayName(ChatColor.RED + "Gun Shop");
			gm2.setLore(Arrays.asList(ChatColor.BLUE + "Use this shop to buy high tier weapons and other goodies!"));
			gs2.setItemMeta(gm2);
			
			ItemStack b1 = new ItemStack(Material.THIN_GLASS, 1);
			ItemMeta bm1 = b1.getItemMeta();
			bm1.setDisplayName(ChatColor.AQUA + "<-- Pick a shop -->");
			b1.setItemMeta(bm1);
			
			gshop.setItem(0, gs1);
			gshop.setItem(1, b1);
			gshop.setItem(2, b1);
			gshop.setItem(3, b1);
			gshop.setItem(4, b1);
			gshop.setItem(5, b1);
			gshop.setItem(6, b1);
			gshop.setItem(7, b1);
			gshop.setItem(8, gs2);
			
			player.openInventory(gshop);
	 * 
	 */

}
