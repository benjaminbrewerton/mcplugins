package me.MrZombie_II.Listeners;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import me.MrZombie_II.main.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class GUIListener implements Listener {
	
public Main plugin;
	
	public GUIListener(Main main) {
		this.plugin = main;
	}
	
	/*
	 * Inventory GUI for Shop
	 * ~1000 Lines
	 * DO not touch or modify
	 * Shop will break!
	 */
	
	
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
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void Shop (InventoryClickEvent event) {
		
		Player player = (Player) event.getWhoClicked();
		
		if(event.getInventory().getName().equals(ChatColor.RED + "Global Shop")) {
			
			if(event.getCurrentItem() == null || event.getSlotType().equals(SlotType.OUTSIDE)) return;
			if(event.getInventory() == null) return;
			
			event.setCancelled(true);
			
			if(event.getCurrentItem().getType() == Material.ARROW) {
				
				Inventory ishop = Bukkit.createInventory(null, 54, ChatColor.BLUE + "" + ChatColor.BOLD + "Item Shop");
				
				ItemStack foodbreak = new ItemStack(Material.THIN_GLASS, 1);
				ItemMeta foodbreakm = foodbreak.getItemMeta();
				foodbreakm.setDisplayName(ChatColor.AQUA + "Food Items");
				foodbreakm.setLore(Arrays.asList(ChatColor.GREEN + "Items that give you health or effects!"));
				foodbreak.setItemMeta(foodbreakm);
				
				ItemStack steak = new ItemStack(Material.INK_SACK, 1, (byte) 15);
				ItemMeta steakb = steak.getItemMeta();
				steakb.setDisplayName(ChatColor.AQUA + "Mountain Dew");
				steakb.setLore(Arrays.asList(new String[] {ChatColor.YELLOW + "Single", ChatColor.YELLOW + "1.5 Sec Cooldown", ChatColor.YELLOW + "Heals All Hearts", ChatColor.GREEN + "300 Credits"}));
				steak.setItemMeta(steakb);
				
				ItemStack beans = new ItemStack(Material.INK_SACK, 1, (byte) 4);
				ItemMeta beansb = beans.getItemMeta();
				beansb.setDisplayName(ChatColor.AQUA + "Canned Beans");
				beansb.setLore(Arrays.asList(new String[] {ChatColor.YELLOW + "Whole Stack", ChatColor.YELLOW + "0.75 Sec Cooldown", ChatColor.YELLOW + "Heals 3.5 Hearts", ChatColor.GREEN + "400 Credits"}));
				beans.setItemMeta(beansb);
				
				ItemStack pasta = new ItemStack(Material.INK_SACK, 1, (byte) 11);
				ItemMeta pastab = pasta.getItemMeta();
				pastab.setDisplayName(ChatColor.AQUA + "Canned Pasta");
				pastab.setLore(Arrays.asList(new String[] {ChatColor.YELLOW + "Whole Stack", ChatColor.YELLOW + "1 Sec Cooldown", ChatColor.YELLOW + "Heals 4 Hearts", ChatColor.GREEN + "500 Credits"}));
				pasta.setItemMeta(pastab);
				
				ItemStack pepsi = new ItemStack(Material.INK_SACK, 1, (byte) 14);
				ItemMeta pepsib = pepsi.getItemMeta();
				pepsib.setDisplayName(ChatColor.AQUA + "Pepsi");
				pepsib.setLore(Arrays.asList(new String[] {ChatColor.YELLOW + "Whole Stack", ChatColor.YELLOW+ "2 Tick Cooldown", ChatColor.YELLOW + "Heals 0.5 Hearts", ChatColor.GREEN + "120 Credits"}));
				pepsi.setItemMeta(pepsib);
				
				ItemStack fb = new ItemStack(Material.THIN_GLASS, 1);
				ItemMeta fbb = fb.getItemMeta();
				fbb.setDisplayName(ChatColor.YELLOW + "<-- Food Items -->");
				fb.setItemMeta(fbb);
				
				ItemStack back = new ItemStack(Material.ACTIVATOR_RAIL, 1);
				ItemMeta backb = back.getItemMeta();
				backb.setDisplayName(ChatColor.RED + "<- Previous Inventory");
				backb.setLore(Arrays.asList(ChatColor.YELLOW + "Return to the previous inventory"));
				back.setItemMeta(backb);
				
				ItemStack next = new ItemStack(Material.ACTIVATOR_RAIL, 1);
				ItemMeta nextb = next.getItemMeta();
				nextb.setDisplayName(ChatColor.RED + "Next Inventory ->");
				nextb.setLore(Arrays.asList(ChatColor.YELLOW + "Go to the next page/inventory"));
				next.setItemMeta(nextb);
				
				ItemStack dh = new ItemStack(Material.DIAMOND_HELMET, 1);
				ItemMeta dhb = dh.getItemMeta();
				dhb.setDisplayName(ChatColor.YELLOW + "Diamond Helmet");
				dhb.setLore(Arrays.asList(ChatColor.GREEN + "1000 Credits"));
				dh.setItemMeta(dhb);
				
				ItemStack dc = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
				ItemMeta dcb = dh.getItemMeta();
				dcb.setDisplayName(ChatColor.YELLOW + "Diamond Chestplate");
				dcb.setLore(Arrays.asList(ChatColor.GREEN + "2000 Credits"));
				dc.setItemMeta(dcb);
				
				ItemStack dl = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
				ItemMeta dlb = dh.getItemMeta();
				dlb.setDisplayName(ChatColor.YELLOW + "Diamond Leggings");
				dlb.setLore(Arrays.asList(ChatColor.GREEN + "1500 Credits"));
				dl.setItemMeta(dlb);
				
				ItemStack db = new ItemStack(Material.DIAMOND_BOOTS, 1);
				ItemMeta dbb = dh.getItemMeta();
				dbb.setDisplayName(ChatColor.YELLOW + "Diamond Boots");
				dbb.setLore(Arrays.asList(ChatColor.GREEN + "1000 Credits"));
				db.setItemMeta(dbb);
				
				ItemStack fbbb = new ItemStack(Material.THIN_GLASS, 1);
				ItemMeta fbbbb = fb.getItemMeta();
				fbbbb.setDisplayName(ChatColor.YELLOW + "<-- Armour -->");
				fbbb.setItemMeta(fbbbb);
				
				ItemStack xp = new ItemStack(Material.EXP_BOTTLE, 1);
				ItemMeta xpb = xp.getItemMeta();
				xpb.setDisplayName(ChatColor.YELLOW + "XP Bottles");
				xpb.setLore(Arrays.asList(ChatColor.GREEN + "600 Credits"));
				xp.setItemMeta(xpb);
				
				
				ishop.setItem(0, new ItemStack(Material.THIN_GLASS, 1));
				ishop.setItem(1, new ItemStack(Material.THIN_GLASS, 1));
				ishop.setItem(2, new ItemStack(Material.THIN_GLASS, 1));
				ishop.setItem(3, new ItemStack(Material.THIN_GLASS, 1));
				ishop.setItem(4, xp);
				ishop.setItem(5, new ItemStack(Material.THIN_GLASS, 1));
				ishop.setItem(6, new ItemStack(Material.THIN_GLASS, 1));
				ishop.setItem(7, new ItemStack(Material.THIN_GLASS, 1));
				ishop.setItem(8, new ItemStack(Material.THIN_GLASS, 1));
				ishop.setItem(9, new ItemStack(Material.THIN_GLASS, 1));
				ishop.setItem(10, new ItemStack(Material.THIN_GLASS, 1));
				ishop.setItem(11, steak);
				ishop.setItem(12, beans);
				ishop.setItem(13, fb);
				ishop.setItem(14, pasta);
				ishop.setItem(15, pepsi);
				ishop.setItem(16, new ItemStack(Material.THIN_GLASS, 1));
				ishop.setItem(17, new ItemStack(Material.THIN_GLASS, 1));
				ishop.setItem(18, new ItemStack(Material.THIN_GLASS, 1));
				ishop.setItem(19, new ItemStack(Material.THIN_GLASS, 1));
				ishop.setItem(20, dh);
				ishop.setItem(21, dc);
				ishop.setItem(22, fbbb);
				ishop.setItem(23, dl);
				ishop.setItem(24, db);
				ishop.setItem(25, new ItemStack(Material.THIN_GLASS, 1));
				ishop.setItem(26, new ItemStack(Material.THIN_GLASS, 1));
				
				
				
				for(int i=27; i<54; i++) {
					ishop.setItem(i, new ItemStack(Material.THIN_GLASS, 1));
				}
				
				ishop.setItem(45, back);
				ishop.setItem(53, next);
				
				player.openInventory(ishop);
				
			}
			
			if(event.getCurrentItem().getType() == Material.DIAMOND_AXE) {
				event.setCancelled(true);
				
				Inventory gshop = Bukkit.createInventory(null, 54, ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Gun Shop");
				
				ItemStack m9 = new ItemStack(Material.STONE_SPADE, 1);
				ItemMeta m9b = m9.getItemMeta();
				m9b.setDisplayName(ChatColor.YELLOW + "M9");
				m9b.setLore(Arrays.asList(new String[] {ChatColor.AQUA + "Fast Firing", ChatColor.AQUA + "Pistol", ChatColor.AQUA + "Short Range", ChatColor.GREEN + "30 Credits"}));
				m9.setItemMeta(m9b);
				
				ItemStack m1074 = new ItemStack(Material.STONE_PICKAXE, 1);
				ItemMeta m1074b = m1074.getItemMeta();
				m1074b.setDisplayName(ChatColor.YELLOW + "M1074");
				m1074b.setLore(Arrays.asList(new String[] {ChatColor.AQUA + "8 Round", ChatColor.AQUA + "Shotgun", ChatColor.AQUA + "Short Range", ChatColor.GREEN + "80 Credits"}));
				m1074.setItemMeta(m1074b);
				
				ItemStack p90 = new ItemStack(Material.STONE_HOE, 1);
				ItemMeta p90b = p90.getItemMeta();
				p90b.setDisplayName(ChatColor.YELLOW + "P90");
				p90b.setLore(Arrays.asList(new String[] {ChatColor.AQUA + "Fast Firing", ChatColor.AQUA + "SMG", ChatColor.AQUA + "Short Range", ChatColor.GREEN + "250 Credits"}));
				p90.setItemMeta(p90b);
				
				ItemStack msr = new ItemStack(Material.STONE_AXE, 1);
				ItemMeta msrb = msr.getItemMeta();
				msrb.setDisplayName(ChatColor.YELLOW + "MSR");
				msrb.setLore(Arrays.asList(new String[] {ChatColor.AQUA + "Semi-Automatic", ChatColor.AQUA + "Sniper Rifle", ChatColor.AQUA + "Long Range", ChatColor.GREEN + "250 Credits"}));
				msr.setItemMeta(msrb);
				
				
				ItemStack dg = new ItemStack(Material.IRON_SPADE, 1);
				ItemMeta dgb = dg.getItemMeta();
				dgb.setDisplayName(ChatColor.YELLOW + "Desert Eagle");
				dgb.setLore(Arrays.asList(new String[] {ChatColor.AQUA + "Super Strong", ChatColor.AQUA + "Pistol", ChatColor.AQUA + "Short-Med Range", ChatColor.GREEN + "250 Credits"}));
				dg.setItemMeta(dgb);
				
				ItemStack spas = new ItemStack(Material.IRON_PICKAXE, 1);
				ItemMeta spasb = spas.getItemMeta();
				spasb.setDisplayName(ChatColor.YELLOW + "Spas-12");
				spasb.setLore(Arrays.asList(new String[] {ChatColor.AQUA + "6 Round", ChatColor.AQUA + "Shotgun", ChatColor.AQUA + "Short Range", ChatColor.GREEN + "300 Credits"}));
				spas.setItemMeta(spasb);
				
				ItemStack ak = new ItemStack(Material.IRON_HOE, 1);
				ItemMeta akb = ak.getItemMeta();
				akb.setDisplayName(ChatColor.YELLOW + "AK-47");
				akb.setLore(Arrays.asList(new String[] {ChatColor.AQUA + "30 Round", ChatColor.AQUA + "Assault Rifle", ChatColor.AQUA + "Medium Range", ChatColor.GREEN + "450 Credits"}));
				ak.setItemMeta(akb);
				
				ItemStack barret = new ItemStack(Material.IRON_AXE, 1);
				ItemMeta barretb = barret.getItemMeta();
				barretb.setDisplayName(ChatColor.YELLOW + "Barret 50.cal");
				barretb.setLore(Arrays.asList(new String[] {ChatColor.AQUA + "10 Round", ChatColor.AQUA + "Sniper Rifle", ChatColor.AQUA + "Long Range", ChatColor.GREEN + "600 Credits"}));
				barret.setItemMeta(barretb);
				
				ItemStack t3 = new ItemStack(Material.THIN_GLASS, 1);
				ItemMeta t3b = t3.getItemMeta();
				t3b.setDisplayName(ChatColor.YELLOW + "<-- Tier 3 -- >");
				t3.setItemMeta(t3b);
				
				ItemStack t4 = new ItemStack(Material.THIN_GLASS, 1);
				ItemMeta t4b = t4.getItemMeta();
				t4b.setDisplayName(ChatColor.YELLOW + "<-- Tier 4 -- >");
				t4.setItemMeta(t4b);
				
				ItemStack t5 = new ItemStack(Material.THIN_GLASS, 1);
				ItemMeta t5b = t5.getItemMeta();
				t5b.setDisplayName(ChatColor.YELLOW + "<-- Tier 5 -- >");
				t5.setItemMeta(t5b);
				
				ItemStack t6 = new ItemStack(Material.THIN_GLASS, 1);
				ItemMeta t6b = t6.getItemMeta();
				t6b.setDisplayName(ChatColor.YELLOW + "<-- Tier 6 -- >");
				t6.setItemMeta(t6b);
				
				ItemStack t3d = new ItemStack(Material.IRON_INGOT, 1);
				ItemMeta t3db = t3d.getItemMeta();
				t3db.setDisplayName(ChatColor.YELLOW + "Tier 3 Weapons");
				t3d.setItemMeta(t3db);

				ItemStack t4d = new ItemStack(Material.DIAMOND, 1);
				ItemMeta t4db = t4d.getItemMeta();
				t4db.setDisplayName(ChatColor.YELLOW + "Tier 4 Weapons");
				t4d.setItemMeta(t4db);
				
				ItemStack t5d = new ItemStack(Material.WOOD, 1);
				ItemMeta t5db = t5d.getItemMeta();
				t5db.setDisplayName(ChatColor.YELLOW + "Tier 5 Weapons");
				t5d.setItemMeta(t5db);
				
				ItemStack t6d = new ItemStack(Material.GOLD_INGOT, 1);
				ItemMeta t6db = t6d.getItemMeta();
				t6db.setDisplayName(ChatColor.YELLOW + "Tier 6 Weapons");
				t6d.setItemMeta(t6db);
				
				ItemStack keyb = new ItemStack(Material.THIN_GLASS, 1);
				ItemMeta keybb = keyb.getItemMeta();
				keybb.setDisplayName(ChatColor.AQUA + "<-- Shop Key -->");
				keyb.setItemMeta(keybb);
				
				ItemStack sniper = new ItemStack(Material.CLAY_BALL, 1);
			    ItemMeta snipermeta = sniper.getItemMeta();
			    snipermeta.setDisplayName(ChatColor.GRAY + "Sniper Ammo");
			    snipermeta.setLore(Arrays.asList(new String[] { ChatColor.RED + "Ammo for Snipers!", ChatColor.GREEN + "350 Credits" }));
			    sniper.setItemMeta(snipermeta);
			    
			    ItemStack auto = new ItemStack(Material.FLINT, 1);
			    ItemMeta autometa = auto.getItemMeta();
			    autometa.setDisplayName(ChatColor.GRAY + "Auto Ammo");
			    autometa.setLore(Arrays.asList(new String[] { ChatColor.RED + "Ammo for Automatics!", ChatColor.GREEN + "150 Credits"  }));
			    auto.setItemMeta(autometa);

			    ItemStack shot = new ItemStack(Material.SEEDS, 1);
			    ItemMeta shotmeta = shot.getItemMeta();
			    shotmeta.setDisplayName(ChatColor.GRAY + "Shotgun Ammo");
			    shotmeta.setLore(Arrays.asList(new String[] { ChatColor.RED + "Ammo for Shotguns!", ChatColor.GREEN + "100 Credits"  }));
			    shot.setItemMeta(shotmeta);

			    ItemStack pistol = new ItemStack(Material.GOLD_NUGGET, 1);
			    ItemMeta pistolmeta = pistol.getItemMeta();
			    pistolmeta.setDisplayName(ChatColor.GRAY + "Pistol Ammo");
			    pistolmeta.setLore(Arrays.asList(new String[] { ChatColor.RED + "Ammo for Pistols!", ChatColor.GREEN + "75 Credits"  }));
			    pistol.setItemMeta(pistolmeta);
				
				ItemStack python = new ItemStack(Material.DIAMOND_SPADE, 1);
				ItemMeta pythonb = python.getItemMeta();
				pythonb.setDisplayName(ChatColor.YELLOW + "Python");
				pythonb.setLore(Arrays.asList(new String[] {ChatColor.AQUA + "9 Round", ChatColor.AQUA + "Pistol", ChatColor.AQUA + "Short Range", ChatColor.GREEN + "1300 Credits"}));
				python.setItemMeta(pythonb);
				
				ItemStack gspas = new ItemStack(Material.DIAMOND_PICKAXE, 1);
				ItemMeta gspasb = gspas.getItemMeta();
				gspasb.setDisplayName(ChatColor.YELLOW + "Golden Spas-12");
				gspasb.setLore(Arrays.asList(new String[] {ChatColor.AQUA + "8 Round", ChatColor.AQUA + "Shotgun", ChatColor.AQUA + "Medium Range", ChatColor.GREEN + "4000 Credits"}));
				gspas.setItemMeta(gspasb);
				
				ItemStack min = new ItemStack(Material.DIAMOND_HOE, 1);
				ItemMeta minb = min.getItemMeta();
				minb.setDisplayName(ChatColor.YELLOW + "Minigun");
				minb.setLore(Arrays.asList(new String[] {ChatColor.AQUA + "300 Round", ChatColor.AQUA + "Machine Gun", ChatColor.AQUA + "Short-Med Range", ChatColor.GREEN + "9000 Credits"}));
				min.setItemMeta(minb);
				
				ItemStack dis = new ItemStack(Material.DIAMOND_AXE, 1);
				ItemMeta disb = dis.getItemMeta();
				disb.setDisplayName(ChatColor.YELLOW + "Disassembler");
				disb.setLore(Arrays.asList(new String[] {ChatColor.AQUA + "30 Round", ChatColor.AQUA + "Sniper Rifle", ChatColor.AQUA + "Med-Long Range", ChatColor.GREEN + "4500 Credits"}));
				dis.setItemMeta(disb);
				
				ItemStack exe = new ItemStack(Material.GOLD_SPADE, 1);
				ItemMeta exeb = exe.getItemMeta();
				exeb.setDisplayName(ChatColor.YELLOW + "Executioner");
				exeb.setLore(Arrays.asList(new String[] {ChatColor.AQUA + "5 Round", ChatColor.AQUA + "Pump", ChatColor.AQUA + "Med Range", ChatColor.GREEN + "2000 Credits"}));
				exe.setItemMeta(exeb);
				
				ItemStack flame = new ItemStack(Material.GOLD_PICKAXE, 1);
				ItemMeta flamb = flame.getItemMeta();
				flamb.setDisplayName(ChatColor.YELLOW + "Flamethrower");
				flamb.setLore(Arrays.asList(new String[] {ChatColor.AQUA + "25 Round", ChatColor.AQUA + "Semi-Automatic", ChatColor.AQUA + "Short Range", ChatColor.GREEN + "1500 Credits"}));
				flame.setItemMeta(flamb);
				
				ItemStack famas = new ItemStack(Material.GOLD_HOE, 1);
				ItemMeta famasb = famas.getItemMeta();
				famasb.setDisplayName(ChatColor.YELLOW + "Famas-18");
				famasb.setLore(Arrays.asList(new String[] {ChatColor.AQUA + "30 Round", ChatColor.AQUA + "Semi-Automatic (3 Round Burst)", ChatColor.AQUA + "Medium Range", ChatColor.GREEN + "3000 Credits"}));
				famas.setItemMeta(famasb);
				
				ItemStack iso = new ItemStack(Material.GOLD_AXE, 1);
				ItemMeta isob = iso.getItemMeta();
				isob.setDisplayName(ChatColor.YELLOW + "L120_Isolator");
				isob.setLore(Arrays.asList(new String[] {ChatColor.AQUA + "4 Round", ChatColor.AQUA + "High Power Sniper Rifle", ChatColor.AQUA + "Extreme Range", ChatColor.GREEN + "5000 Credits"}));
				iso.setItemMeta(isob);
				
				ItemStack back = new ItemStack(Material.ACTIVATOR_RAIL, 1);
				ItemMeta backb = back.getItemMeta();
				backb.setDisplayName(ChatColor.RED + "<- Previous Inventory");
				backb.setLore(Arrays.asList(ChatColor.YELLOW + "Return to the previous inventory"));
				back.setItemMeta(backb);
				
				ItemStack next = new ItemStack(Material.ACTIVATOR_RAIL, 1);
				ItemMeta nextb = next.getItemMeta();
				nextb.setDisplayName(ChatColor.RED + "Next Inventory ->");
				nextb.setLore(Arrays.asList(ChatColor.YELLOW + "Go to the next page/inventory"));
				next.setItemMeta(nextb);
				
				ItemStack arrow = new ItemStack(Material.ARROW, 1);
				ItemMeta arrowb = arrow.getItemMeta();
				arrowb.setDisplayName(ChatColor.GRAY + "Ballistic Knife Ammo");
				arrowb.setLore(Arrays.asList(new String[] { ChatColor.RED + "Ammo for Ballistic Knife!", ChatColor.GREEN + "400 Credits" }));
				arrow.setItemMeta(arrowb);
				
				ItemStack bknife = new ItemStack(Material.GOLD_SWORD, 1);
				ItemMeta bknifeb = bknife.getItemMeta();
				bknifeb.setDisplayName(ChatColor.YELLOW + "Ballistic Knife");
				bknifeb.setLore(Arrays.asList(new String[] {ChatColor.AQUA + "1 Round", ChatColor.AQUA + "High Damage", ChatColor.AQUA + "Med-Long Range", ChatColor.GREEN + "6000 Credits"}));
				bknife.setItemMeta(bknifeb);
				
				gshop.setItem(0, new ItemStack(Material.THIN_GLASS, 1));
				gshop.setItem(1, new ItemStack(Material.THIN_GLASS, 1));
				gshop.setItem(2, new ItemStack(Material.THIN_GLASS, 1));
				gshop.setItem(3, new ItemStack(Material.THIN_GLASS, 1));
				gshop.setItem(4, new ItemStack(Material.THIN_GLASS, 1));
				gshop.setItem(5, new ItemStack(Material.THIN_GLASS, 1));
				gshop.setItem(6, new ItemStack(Material.THIN_GLASS, 1));
				gshop.setItem(7, new ItemStack(Material.THIN_GLASS, 1));
				gshop.setItem(8, new ItemStack(Material.THIN_GLASS, 1));
				gshop.setItem(9, new ItemStack(Material.THIN_GLASS, 1));
				gshop.setItem(10, new ItemStack(Material.THIN_GLASS, 1));
				gshop.setItem(11, m9);
				gshop.setItem(12, m1074);
				gshop.setItem(13, t3);
				gshop.setItem(14, p90);
				gshop.setItem(15, msr);
				gshop.setItem(16, new ItemStack(Material.THIN_GLASS, 1));
				gshop.setItem(17, new ItemStack(Material.THIN_GLASS, 1));
				gshop.setItem(18, new ItemStack(Material.THIN_GLASS, 1));
				gshop.setItem(19, new ItemStack(Material.THIN_GLASS, 1));
				gshop.setItem(20, dg);
				gshop.setItem(21, spas);
				gshop.setItem(22, t4);
				gshop.setItem(23, ak);
				gshop.setItem(24, barret);
				gshop.setItem(25, new ItemStack(Material.THIN_GLASS, 1));
				gshop.setItem(26, new ItemStack(Material.THIN_GLASS, 1));
				gshop.setItem(27, new ItemStack(Material.THIN_GLASS, 1));
				gshop.setItem(28, new ItemStack(Material.THIN_GLASS, 1));
				gshop.setItem(29, python);
				gshop.setItem(30, gspas);
				gshop.setItem(31, t5);
				gshop.setItem(32, min);
				gshop.setItem(33, dis);
				gshop.setItem(34, new ItemStack(Material.THIN_GLASS, 1));
				gshop.setItem(35, new ItemStack(Material.THIN_GLASS, 1));
				gshop.setItem(36, new ItemStack(Material.THIN_GLASS, 1));
				gshop.setItem(37, new ItemStack(Material.THIN_GLASS, 1));
				gshop.setItem(38, exe);
				gshop.setItem(39, flame);
				gshop.setItem(40, bknife);
				gshop.setItem(41, famas);
				gshop.setItem(42, iso);
				gshop.setItem(43, new ItemStack(Material.THIN_GLASS, 1));
				gshop.setItem(44, new ItemStack(Material.THIN_GLASS, 1));
				gshop.setItem(45, back);
				gshop.setItem(46, new ItemStack(Material.THIN_GLASS, 1));
				gshop.setItem(47, pistol);
				gshop.setItem(48, shot);
				gshop.setItem(49, arrow);
				gshop.setItem(50, auto);
				gshop.setItem(51, sniper);
				gshop.setItem(52, new ItemStack(Material.THIN_GLASS, 1));
				gshop.setItem(53, next);
				
				
				player.openInventory(gshop);
				
			}

		}
		
		if(event.getInventory().getName().equals(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Gun Shop")) {
			if(event.getCurrentItem() == null || event.getSlotType().equals(SlotType.OUTSIDE)) return;
			if(event.getInventory() == null) return;
			
			event.setCancelled(true);
			
			if(!(event.getCurrentItem().hasItemMeta())) return;
			if(!(event.getCurrentItem().getItemMeta().hasLore())) return;
				
			
			if(event.getCurrentItem().getType() == Material.STONE_SPADE && event.getCursor().getItemMeta().getLore().equals(Arrays.asList(new String[] {ChatColor.AQUA + "Fast Firing", ChatColor.AQUA + "Pistol", ChatColor.AQUA + "Short Range", ChatColor.GREEN + "30 Credits"}))) {
				buy(player, 30, new ItemStack(Material.STONE_SPADE), "M9");
				event.setCancelled(true);
			}
			if(event.getCurrentItem().getType() == Material.STONE_PICKAXE  && event.getCurrentItem().getItemMeta().getLore().equals(Arrays.asList(new String[] {ChatColor.AQUA + "8 Round", ChatColor.AQUA + "Shotgun", ChatColor.AQUA + "Short Range", ChatColor.GREEN + "80 Credits"}))) {
				buy(player, 80, new ItemStack(Material.STONE_PICKAXE, 1), "M1074");
				event.setCancelled(true);
			}
			if(event.getCurrentItem().getType() == Material.STONE_HOE && event.getCurrentItem().getItemMeta().getLore().equals(Arrays.asList(new String[] {ChatColor.AQUA + "Fast Firing", ChatColor.AQUA + "SMG", ChatColor.AQUA + "Short Range", ChatColor.GREEN + "250 Credits"}))) {
				buy(player, 300, new ItemStack(Material.STONE_HOE), "P90");
				event.setCancelled(true);
			}
			if(event.getCurrentItem().getType() == Material.STONE_AXE && event.getCurrentItem().getItemMeta().getLore().equals(Arrays.asList(new String[] {ChatColor.AQUA + "Semi-Automatic", ChatColor.AQUA + "Sniper Rifle", ChatColor.AQUA + "Long Range", ChatColor.GREEN + "250 Credits"}))) {
				buy(player, 250, new ItemStack(Material.STONE_AXE), "MSR");
				event.setCancelled(true);
			}
			if(event.getCurrentItem().getType() == Material.IRON_SPADE && event.getCurrentItem().getItemMeta().getLore().equals(Arrays.asList(new String[] {ChatColor.AQUA + "Super Strong", ChatColor.AQUA + "Pistol", ChatColor.AQUA + "Short-Med Range", ChatColor.GREEN + "250 Credits"}))) {
				buy(player, 250, new ItemStack(Material.IRON_SPADE, 1), "Desert Eagle");
				event.setCancelled(true);
			}
			if(event.getCurrentItem().getType() == Material.IRON_PICKAXE && event.getCurrentItem().getItemMeta().getLore().equals(Arrays.asList(new String[] {ChatColor.AQUA + "6 Round", ChatColor.AQUA + "Shotgun", ChatColor.AQUA + "Short Range", ChatColor.GREEN + "300 Credits"}))) {
				buy(player, 300, new ItemStack(Material.IRON_PICKAXE, 1), "Spas-12");
				event.setCancelled(true);
			}
			if(event.getCurrentItem().getType() == Material.IRON_HOE && event.getCurrentItem().getItemMeta().getLore().equals(Arrays.asList(new String[] {ChatColor.AQUA + "30 Round", ChatColor.AQUA + "Assault Rifle", ChatColor.AQUA + "Medium Range", ChatColor.GREEN + "450 Credits"}))) {
				buy(player, 450, new ItemStack(Material.IRON_HOE), "AK-47");
				event.setCancelled(true);
			}
			if(event.getCurrentItem().getType() == Material.IRON_AXE && event.getCurrentItem().getItemMeta().getLore().equals(Arrays.asList(new String[] {ChatColor.AQUA + "10 Round", ChatColor.AQUA + "Sniper Rifle", ChatColor.AQUA + "Long Range", ChatColor.GREEN + "600 Credits"}))) {
				buy(player, 600, new ItemStack(Material.IRON_AXE), "Barret 50.cal");
				event.setCancelled(true);
			}
			if(event.getCurrentItem().getType() == Material.DIAMOND_SPADE && event.getCurrentItem().getItemMeta().getLore().equals(Arrays.asList(new String[] {ChatColor.AQUA + "9 Round", ChatColor.AQUA + "Pistol", ChatColor.AQUA + "Short Range", ChatColor.GREEN + "1300 Credits"}))) {
				buy(player, 1300, new ItemStack(Material.DIAMOND_SPADE, 1), "Python");
				event.setCancelled(true);
			}
			if(event.getCurrentItem().getType() == Material.DIAMOND_PICKAXE && event.getCurrentItem().getItemMeta().getLore().equals(Arrays.asList(new String[] {ChatColor.AQUA + "8 Round", ChatColor.AQUA + "Shotgun", ChatColor.AQUA + "Medium Range", ChatColor.GREEN + "4000 Credits"}))) {
				buy(player, 4000, new ItemStack(Material.DIAMOND_PICKAXE, 1), "Golden Spas-12");
				event.setCancelled(true);
			}
			if(event.getCurrentItem().getType() == Material.DIAMOND_HOE && event.getCurrentItem().getItemMeta().getLore().equals(Arrays.asList(new String[] {ChatColor.AQUA + "300 Round", ChatColor.AQUA + "Machine Gun", ChatColor.AQUA + "Short-Med Range", ChatColor.GREEN + "9000 Credits"}))) {
				buy(player, 9000, new ItemStack(Material.DIAMOND_HOE), "Minigun");
				event.setCancelled(true);
			}
			if(event.getCurrentItem().getType() == Material.DIAMOND_AXE && event.getCurrentItem().getItemMeta().getLore().equals(Arrays.asList(new String[] {ChatColor.AQUA + "30 Round", ChatColor.AQUA + "Sniper Rifle", ChatColor.AQUA + "Med-Long Range", ChatColor.GREEN + "4500 Credits"}))) {
				buy(player, 4500, new ItemStack(Material.DIAMOND_AXE), "Disassembler");
				event.setCancelled(true);
			}
			if(event.getCurrentItem().getType() == Material.GOLD_SPADE && event.getCurrentItem().getItemMeta().getLore().equals(Arrays.asList(new String[] {ChatColor.AQUA + "5 Round", ChatColor.AQUA + "Pump", ChatColor.AQUA + "Med Range", ChatColor.GREEN + "2000 Credits"}))) {
				buy(player, 2000, new ItemStack(Material.GOLD_SPADE, 1), "Executioner");
				event.setCancelled(true);
			}
			if(event.getCurrentItem().getType() == Material.GOLD_PICKAXE && event.getCurrentItem().getItemMeta().getLore().equals(Arrays.asList(new String[] {ChatColor.AQUA + "25 Round", ChatColor.AQUA + "Semi-Automatic", ChatColor.AQUA + "Short Range", ChatColor.GREEN + "1500 Credits"}))) {
				buy(player, 1500, new ItemStack(Material.GOLD_PICKAXE, 1), "Flamethrower");
				event.setCancelled(true);
			}
			if(event.getCurrentItem().getType() == Material.GOLD_HOE && event.getCurrentItem().getItemMeta().getLore().equals(Arrays.asList(new String[] {ChatColor.AQUA + "30 Round", ChatColor.AQUA + "Semi-Automatic (3 Round Burst)", ChatColor.AQUA + "Medium Range", ChatColor.GREEN + "3000 Credits"}))) {
				buy(player, 3000, new ItemStack(Material.GOLD_HOE), "Famas-18");
				event.setCancelled(true);
			}
			if(event.getCurrentItem().getType() == Material.GOLD_AXE && event.getCurrentItem().getItemMeta().getLore().equals(Arrays.asList(new String[] {ChatColor.AQUA + "4 Round", ChatColor.AQUA + "High Power Sniper Rifle", ChatColor.AQUA + "Extreme Range", ChatColor.GREEN + "5000 Credits"}))) {
				buy(player, 5000, new ItemStack(Material.GOLD_AXE), "L120_Isolator");
				event.setCancelled(true);
			}
			if(event.getCurrentItem().getType() == Material.ACTIVATOR_RAIL && event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "<- Previous Inventory")) {
				player.closeInventory();
				player.chat("/shop");
				event.setCancelled(true);
			}
			if(event.getCurrentItem().getType() == Material.CLAY_BALL && event.getCurrentItem().getItemMeta().getLore().equals(Arrays.asList(new String[] { ChatColor.RED + "Ammo for Snipers!", ChatColor.GREEN + "350 Credits" }))) {
				ItemStack sniper = new ItemStack(Material.CLAY_BALL, 64);
				ItemMeta sniperb = sniper.getItemMeta();
				sniperb.setDisplayName(ChatColor.GRAY + "Sniper Ammo");
				sniper.setItemMeta(sniperb);
				
				event.setCancelled(true);
				buy(player, 350, sniper, "Sniper Ammo");
			}
			if(event.getCurrentItem().getType() == Material.FLINT && event.getCurrentItem().getItemMeta().getLore().equals(Arrays.asList(new String[] { ChatColor.RED + "Ammo for Automatics!", ChatColor.GREEN + "150 Credits"  }))) {
				ItemStack autoa = new ItemStack(Material.FLINT, 64);
				ItemMeta autoab = autoa.getItemMeta();
				autoab.setDisplayName(ChatColor.GRAY + "Automatic Ammo");
				autoa.setItemMeta(autoab);
				
				buy(player, 150, autoa, "Automatic Ammo");
				event.setCancelled(true);
			}
			if(event.getCurrentItem().getType() == Material.SEEDS && event.getCurrentItem().getItemMeta().getLore().equals(Arrays.asList(new String[] { ChatColor.RED + "Ammo for Shotguns!", ChatColor.GREEN + "100 Credits"  }))) {
				ItemStack shoty = new ItemStack(Material.SEEDS, 64);
				ItemMeta shotyb = shoty.getItemMeta();
				shotyb.setDisplayName(ChatColor.GRAY + "Shotgun Ammo");
				
				shoty.setItemMeta(shotyb);
				
				buy(player, 200, shoty, "Shotgun Ammo");
				event.setCancelled(true);
			}
			if(event.getCurrentItem().getType() == Material.GOLD_NUGGET && event.getCurrentItem().getItemMeta().getLore().equals(Arrays.asList(new String[] { ChatColor.RED + "Ammo for Pistols!", ChatColor.GREEN + "75 Credits"  }))) {
				ItemStack pistola = new ItemStack(Material.GOLD_NUGGET, 64);
				ItemMeta pistolab = pistola.getItemMeta();
				pistolab.setDisplayName(ChatColor.GRAY + "Pistol Ammo");
				pistola.setItemMeta(pistolab);
				
				buy(player, 75, pistola, "Pistol Ammo");
				event.setCancelled(true);
			}
			if(event.getCurrentItem().getType() == Material.GOLD_SWORD && event.getCurrentItem().getItemMeta().getLore().equals(Arrays.asList(new String[] {ChatColor.AQUA + "1 Round", ChatColor.AQUA + "High Damage", ChatColor.AQUA + "Med-Long Range", ChatColor.GREEN + "6000 Credits"}))) {
				buy(player, 6000, new ItemStack(Material.GOLD_SWORD, 1), "Ballistic Knife");
			}
			
			if(event.getCurrentItem().getType() == Material.ARROW && event.getCurrentItem().getItemMeta().getLore().equals(Arrays.asList(new String[] { ChatColor.RED + "Ammo for Ballistic Knife!", ChatColor.GREEN + "400 Credits" }))) {
				ItemStack arrow = new ItemStack(Material.ARROW, 64);
				ItemMeta arrowb = arrow.getItemMeta();
				arrowb.setDisplayName(ChatColor.RED + "Ballistic Knife Ammo");
				arrow.setItemMeta(arrowb);
				
				buy(player, 400, arrow, "Ballistic Knife Ammo");
				event.setCancelled(true);
			}
			
		}
		
		if(event.getInventory().getName().equals(ChatColor.BLUE + "" + ChatColor.BOLD + "Item Shop")) {
			if(event.getCurrentItem() == null || event.getSlotType().equals(SlotType.OUTSIDE)) return;
			if(event.getInventory() == null) return;
			
			event.setCancelled(true);
			
			if(!(event.getCurrentItem().hasItemMeta())) return;
			if(!(event.getCurrentItem().getItemMeta().hasLore())) return;
			
			ItemStack steak = new ItemStack(Material.INK_SACK, 1, (byte) 15);
			ItemMeta steakb = steak.getItemMeta();
			steakb.setDisplayName(ChatColor.AQUA + "Mountain Dew");
			steak.setItemMeta(steakb);
			
			ItemStack beans = new ItemStack(Material.INK_SACK, 64, (byte) 4);
			ItemMeta beansb = beans.getItemMeta();
			beansb.setDisplayName(ChatColor.AQUA + "Canned Beans");
			beans.setItemMeta(beansb);
			
			ItemStack pasta = new ItemStack(Material.INK_SACK, 64, (byte) 11);
			ItemMeta pastab = pasta.getItemMeta();
			pastab.setDisplayName(ChatColor.AQUA + "Canned Pasta");
			pasta.setItemMeta(pastab);
			
			ItemStack pepsi = new ItemStack(Material.INK_SACK, 64, (byte) 14);
			ItemMeta pepsib = pepsi.getItemMeta();
			pepsib.setDisplayName(ChatColor.AQUA + "Pepsi");
			pepsi.setItemMeta(pepsib);
			
			
			if(event.getCurrentItem().getType() == Material.INK_SACK && (byte)event.getCurrentItem().getData().getData() == 4 && event.isLeftClick() && event.getCurrentItem().getItemMeta().getLore().equals(Arrays.asList(new String[] {ChatColor.YELLOW + "Whole Stack", ChatColor.YELLOW + "0.75 Sec Cooldown", ChatColor.YELLOW + "Heals 3.5 Hearts", ChatColor.GREEN + "400 Credits"}))) {
				buy(player, 400, beans, "Canned Beans");
				event.setCancelled(true);
			}
			if(event.getCurrentItem().getType() == Material.INK_SACK && (byte)event.getCurrentItem().getData().getData() == 11 && event.isLeftClick() && event.getCurrentItem().getItemMeta().getLore().equals(Arrays.asList(new String[] {ChatColor.YELLOW + "Whole Stack", ChatColor.YELLOW + "1 Sec Cooldown", ChatColor.YELLOW + "Heals 4 Hearts", ChatColor.GREEN + "500 Credits"}))) {
				buy(player, 500, pasta, "Canned Pasta");
				event.setCancelled(true);
			}
			if(event.getCurrentItem().getType() == Material.INK_SACK && (byte)event.getCurrentItem().getData().getData() == 14 && event.isLeftClick() && event.getCurrentItem().getItemMeta().getLore().equals(Arrays.asList(new String[] {ChatColor.YELLOW + "Whole Stack", ChatColor.YELLOW+ "2 Tick Cooldown", ChatColor.YELLOW + "Heals 0.5 Hearts", ChatColor.GREEN + "120 Credits"}))) {
				buy(player, 120, pepsi, "Pepsi");
				event.setCancelled(true);
			}
			if(event.getCurrentItem().getType() == Material.INK_SACK && (byte) event.getCurrentItem().getData().getData() == 15 && event.isLeftClick() && event.getCurrentItem().getItemMeta().getLore().equals(Arrays.asList(new String[] {ChatColor.YELLOW + "Single", ChatColor.YELLOW + "1.5 Sec Cooldown", ChatColor.YELLOW + "Heals All Hearts", ChatColor.GREEN + "300 Credits"}))) {
				buy(player, 300, steak, "Mountain Dew");
				event.setCancelled(true);
			}
			if(event.getCurrentItem().getType() == Material.ACTIVATOR_RAIL && event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "<- Previous Inventory")) {
				player.closeInventory();
				player.chat("/shop");
			}
			
			ItemStack dh = new ItemStack(Material.DIAMOND_HELMET, 1);
			ItemMeta dhb = dh.getItemMeta();
			dhb.setDisplayName(ChatColor.AQUA + "Diamond Helmet");
			dh.setItemMeta(dhb);
			
			ItemStack dc = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
			ItemMeta dcb = dh.getItemMeta();
			dcb.setDisplayName(ChatColor.AQUA + "Diamond Chestplate");
			dc.setItemMeta(dcb);
			
			ItemStack dl = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
			ItemMeta dlb = dh.getItemMeta();
			dlb.setDisplayName(ChatColor.AQUA + "Diamond Leggings");
			dl.setItemMeta(dlb);
			
			ItemStack db = new ItemStack(Material.DIAMOND_BOOTS, 1);
			ItemMeta dbb = dh.getItemMeta();
			dbb.setDisplayName(ChatColor.AQUA + "Diamond Boots");
			db.setItemMeta(dbb);
			
			ItemStack xp = new ItemStack(Material.EXP_BOTTLE, 64);
			ItemMeta xpb = xp.getItemMeta();
			xpb.setDisplayName(ChatColor.AQUA + "XP Bottles");
			xp.setItemMeta(xpb);
			
			if(event.getCurrentItem().getType() == Material.DIAMOND_HELMET && event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Diamond Helmet")) {
				buy(player, 1000, dh, "Diamond Helmet");
				event.setCancelled(true);
			}
			if(event.getCurrentItem().getType() == Material.DIAMOND_CHESTPLATE && event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Diamond Chestplate")) {
				buy(player, 2000, dc, "Diamond Chestplate");
				event.setCancelled(true);
			}
			if(event.getCurrentItem().getType() == Material.DIAMOND_LEGGINGS && event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Diamond Leggings")) {
				buy(player, 1500, dl, "Diamond Leggings");
				event.setCancelled(true);
			}
			if(event.getCurrentItem().getType() == Material.DIAMOND_BOOTS && event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Diamond Boots")) {
				buy(player, 1000, db, "Diamond Boots");
				event.setCancelled(true);
			}
			if(event.getCurrentItem().getType() == Material.EXP_BOTTLE && event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "XP Bottles")) {
				buy(player, 600, xp, "XP Bottle");
				event.setCancelled(true);
			}
		}
	}

}
