package me.MrZombie_II.commands;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class FK implements CommandExecutor {
	
	final ItemStack lore (ItemStack item, String[] lore)
	  {
	    ItemMeta itemMeta = item.getItemMeta();
	    itemMeta.setLore(Arrays.asList(lore));
	    item.setItemMeta(itemMeta);
	    return item;
	  }
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(commandLabel.equalsIgnoreCase("fk")) {
			Player p = (Player) sender;
			if(p.hasPermission("weed.fk")) {
				
				if(!(args.length == 2)) {
					p.sendMessage(ChatColor.RED + "Error: Incorrect Syntax: /fk <player> <kit>");
					return true;
					
				}
				
				if(args[1].equalsIgnoreCase("warz")) {
					
					Player player = Bukkit.getServer().getPlayer(args[0]);
					
					if(player == null) {
						p.sendMessage(ChatColor.RED + "Error: Player '" + args[0].toString() + "' not found!");
						
					}
					
					ItemStack sword = new ItemStack(Material.STONE_SWORD, 1);
				    ItemMeta swordmeta = sword.getItemMeta();
				    swordmeta.setDisplayName(ChatColor.YELLOW + "Stone Sword");
				    sword.setItemMeta(swordmeta);

				    ItemStack sniper = new ItemStack(Material.CLAY_BALL, 64);
				    ItemMeta snipermeta = sniper.getItemMeta();
				    snipermeta.setDisplayName(ChatColor.GRAY + "Sniper Ammo");
				    sniper.setItemMeta(snipermeta);
				    lore(sniper, new String[] { ChatColor.RED + "Ammo for Snipers!" });

				    ItemStack auto = new ItemStack(Material.FLINT, 64);
				    ItemMeta autometa = auto.getItemMeta();
				    autometa.setDisplayName(ChatColor.GRAY + "Auto Ammo");
				    auto.setItemMeta(autometa);
				    lore(auto, new String[] { ChatColor.RED + "Ammo for Auto!" });

				    ItemStack shot = new ItemStack(Material.SEEDS, 64);
				    ItemMeta shotmeta = shot.getItemMeta();
				    shotmeta.setDisplayName(ChatColor.GRAY + "Shotgun Ammo");
				    shot.setItemMeta(shotmeta);
				    lore(shot, new String[] { ChatColor.RED + "Ammo for Shotguns!" });

				    ItemStack pistol = new ItemStack(Material.GOLD_NUGGET, 64);
				    ItemMeta pistolmeta = pistol.getItemMeta();
				    pistolmeta.setDisplayName(ChatColor.GRAY + "Pistol Ammo");
				    pistol.setItemMeta(pistolmeta);
				    lore(pistol, new String[] { ChatColor.RED + "Ammo for Pistol!" });

				    ItemStack beef = new ItemStack(Material.COOKED_BEEF, 7);
				    ItemMeta beefmeta = beef.getItemMeta();
				    beefmeta.setDisplayName(ChatColor.AQUA + "Steak");
				    beef.setItemMeta(beefmeta);

				    ItemStack md = new ItemStack(Material.INK_SACK, 32, (byte) 15);
				    ItemMeta mdmeta = md.getItemMeta();
				    mdmeta.setDisplayName(ChatColor.AQUA + "Mountain Dew");
				    md.setItemMeta(mdmeta);

				    ItemStack pepsi = new ItemStack(Material.INK_SACK, 48, (byte) 14);

				    ItemMeta pepsimeta = pepsi.getItemMeta();
				    pepsimeta.setDisplayName(ChatColor.AQUA + "Pepsi");
				    pepsi.setItemMeta(pepsimeta);
				    
				    ItemStack beans = new ItemStack(Material.INK_SACK, 16, (byte) 4);
				    ItemMeta beansb = beans.getItemMeta();
				    beansb.setDisplayName(ChatColor.AQUA + "Canned Beans");
				    beans.setItemMeta(beansb);
						
						player.getInventory().clear();

				          player.getInventory().addItem(new ItemStack[] { sword });

				          player.getInventory().addItem(new ItemStack[] { new ItemStack(Material.STONE_AXE) });
				          player.getInventory().addItem(new ItemStack[] { new ItemStack(Material.STONE_HOE) });
				          player.getInventory().addItem(new ItemStack[] { new ItemStack(Material.STONE_PICKAXE) });
				          player.getInventory().addItem(new ItemStack[] { new ItemStack(Material.STONE_SPADE) });

				          player.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
				          player.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
				          player.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
				          player.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));

				          player.getInventory().addItem(new ItemStack[] { beans });
				          player.getInventory().addItem(new ItemStack[] { pepsi });
				          player.getInventory().addItem(new ItemStack[] { sniper });
				          player.getInventory().addItem(new ItemStack[] { auto });
				          player.getInventory().addItem(new ItemStack[] { auto });
				          player.getInventory().addItem(new ItemStack[] { pistol });
				          player.getInventory().addItem(new ItemStack[] { shot });


				}
				
			} else {
				
				p.sendMessage(ChatColor.RED + "Error: No Permission");
			}
			
		}
		
		
		return false;
	}

}
