package me.MrZombie_II.WarZ.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.MrZombie_II.WarZ.enums.ZoneEnum.Zone;
import me.MrZombie_II.WarZ.main.Chests;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Chest;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ChestUtils {
	public static ChestUtils u = new ChestUtils();
	
	public static ChestUtils getCU() {
		return u;
	}
	
	@SuppressWarnings("deprecation")
	public ItemStack spawnItem(Material mat, int amount, DyeColor colour) {
		 return new ItemStack(mat, amount, colour.getData());
	}
	
	public ItemStack spawnItem(Material mat, int amount, byte b) {
		return new ItemStack(mat, amount, b);
	}
	
	private ItemStack getCure() {
		return spawnItem(Material.INK_SACK, 1, (byte) 2);
	}

	private ItemStack getPasta() {
		return spawnItem(Material.INK_SACK, 4, (byte) 11);
	}
	
	private ItemStack getBeans() {
		return spawnItem(Material.INK_SACK, 4, (byte) 4);
	}
	
	private ItemStack getMD() {
		return spawnItem(Material.INK_SACK, 2, (byte) 15);
	}
	
	public ItemStack[] getT1Contents() {
		return new ItemStack[] { 
				new ItemStack(Material.WOOD_SPADE, 1), 
				new ItemStack(Material.SEEDS, 6), 
				new ItemStack(Material.WOOD_AXE, 1), 
				new ItemStack(Material.WOOD_HOE, 1), 
				new ItemStack(Material.WOOD_PICKAXE, 1), 
				new ItemStack(Material.BONE, 1), 
				new ItemStack(Material.PAPER, 1), 
				new ItemStack(Material.SHEARS, 1), 
				new ItemStack(Material.SUGAR, 1), 
				getCure(),
				getPasta(),
				getBeans(),
				new ItemStack(Material.ENDER_PEARL, 8), 
				new ItemStack(Material.FLINT, 8), 
				new ItemStack(Material.CLAY_BALL, 4),
				new ItemStack(Material.WEB, 4),
				new ItemStack(Material.LEATHER_HELMET, 1),
				new ItemStack(Material.LEATHER_CHESTPLATE, 1),
				new ItemStack(Material.LEATHER_LEGGINGS, 1),
				new ItemStack(Material.LEATHER_BOOTS, 1),
				};
	}
	
	public ItemStack[] getT2Contents() {
		return new ItemStack[] { 
				new ItemStack(Material.STONE_SPADE, 1), 
				new ItemStack(Material.SEEDS, 6), 
				new ItemStack(Material.STONE_AXE, 1), 
				new ItemStack(Material.STONE_HOE, 1), 
				new ItemStack(Material.STONE_PICKAXE, 1), 
				new ItemStack(Material.BONE, 1), 
				new ItemStack(Material.PAPER, 1), 
				new ItemStack(Material.SHEARS, 1), 
				new ItemStack(Material.SUGAR, 1), 
				new ItemStack(Material.ENDER_PEARL, 8), 
				new ItemStack(Material.FLINT, 8), 
				new ItemStack(Material.CLAY_BALL, 4),
				new ItemStack(Material.WEB, 4),
				new ItemStack(Material.CHAINMAIL_HELMET, 1),
				new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1),
				new ItemStack(Material.CHAINMAIL_LEGGINGS, 1),
				new ItemStack(Material.CHAINMAIL_BOOTS, 1),
				getCure(),
				getPasta(),
				getBeans(),
				};
	}
	
	public ItemStack[] getT3Contents() {
		return new ItemStack[] { 
				new ItemStack(Material.IRON_SPADE, 1), 
				new ItemStack(Material.SEEDS, 6), 
				new ItemStack(Material.IRON_AXE, 1), 
				new ItemStack(Material.IRON_HOE, 1), 
				new ItemStack(Material.IRON_PICKAXE, 1), 
				new ItemStack(Material.BONE, 1), 
				new ItemStack(Material.PAPER, 1), 
				new ItemStack(Material.SHEARS, 1), 
				new ItemStack(Material.SUGAR, 1), 
				new ItemStack(Material.ENDER_PEARL, 8), 
				new ItemStack(Material.FLINT, 8), 
				new ItemStack(Material.CLAY_BALL, 4),
				new ItemStack(Material.WEB, 4),
				new ItemStack(Material.IRON_HELMET, 1),
				new ItemStack(Material.IRON_CHESTPLATE, 1),
				new ItemStack(Material.IRON_LEGGINGS, 1),
				new ItemStack(Material.IRON_BOOTS, 1),
				getCure(),
				getPasta(),
				getBeans(),
				new ItemStack(Material.IRON_SPADE, 1), 
				new ItemStack(Material.SEEDS, 6), 
				new ItemStack(Material.IRON_AXE, 1), 
				new ItemStack(Material.IRON_HOE, 1), 
				new ItemStack(Material.IRON_PICKAXE, 1), 
				new ItemStack(Material.BONE, 1), 
				new ItemStack(Material.PAPER, 1), 
				new ItemStack(Material.SHEARS, 1), 
				new ItemStack(Material.SUGAR, 1), 
				new ItemStack(Material.ENDER_PEARL, 8), 
				new ItemStack(Material.FLINT, 8), 
				new ItemStack(Material.CLAY_BALL, 4),
				new ItemStack(Material.WEB, 4),
				new ItemStack(Material.IRON_HELMET, 1),
				new ItemStack(Material.IRON_CHESTPLATE, 1),
				new ItemStack(Material.IRON_LEGGINGS, 1),
				new ItemStack(Material.IRON_BOOTS, 1),
				getCure(),
				getPasta(),
				getBeans(),
				getMD()
				};
	}
	
	public ItemStack[] getT4Contents() {
		return new ItemStack[] {
				new ItemStack(Material.IRON_SPADE, 1), 
				new ItemStack(Material.SEEDS, 6), 
				new ItemStack(Material.IRON_AXE, 1), 
				new ItemStack(Material.IRON_HOE, 1), 
				new ItemStack(Material.IRON_PICKAXE, 1), 
				new ItemStack(Material.BONE, 1), 
				new ItemStack(Material.PAPER, 1), 
				new ItemStack(Material.SHEARS, 1), 
				new ItemStack(Material.SUGAR, 1), 
				new ItemStack(Material.ENDER_PEARL, 8), 
				new ItemStack(Material.FLINT, 8), 
				new ItemStack(Material.CLAY_BALL, 4),
				new ItemStack(Material.WEB, 4),
				new ItemStack(Material.IRON_HELMET, 1),
				new ItemStack(Material.IRON_CHESTPLATE, 1),
				new ItemStack(Material.IRON_LEGGINGS, 1),
				new ItemStack(Material.IRON_BOOTS, 1),
				getCure(),
				getPasta(),
				getBeans(),
				new ItemStack(Material.IRON_SPADE, 1), 
				new ItemStack(Material.SEEDS, 6), 
				new ItemStack(Material.IRON_AXE, 1), 
				new ItemStack(Material.IRON_HOE, 1), 
				new ItemStack(Material.IRON_PICKAXE, 1), 
				new ItemStack(Material.BONE, 1), 
				new ItemStack(Material.PAPER, 1), 
				new ItemStack(Material.SHEARS, 1), 
				new ItemStack(Material.SUGAR, 1), 
				new ItemStack(Material.ENDER_PEARL, 8), 
				new ItemStack(Material.FLINT, 8), 
				new ItemStack(Material.CLAY_BALL, 4),
				new ItemStack(Material.WEB, 4),
				new ItemStack(Material.IRON_HELMET, 1),
				new ItemStack(Material.IRON_CHESTPLATE, 1),
				new ItemStack(Material.IRON_LEGGINGS, 1),
				new ItemStack(Material.IRON_BOOTS, 1),
				getCure(),
				getPasta(),
				getBeans(),
				new ItemStack(Material.IRON_SPADE, 1), 
				new ItemStack(Material.SEEDS, 6), 
				new ItemStack(Material.IRON_AXE, 1), 
				new ItemStack(Material.IRON_HOE, 1), 
				new ItemStack(Material.IRON_PICKAXE, 1), 
				new ItemStack(Material.BONE, 1), 
				new ItemStack(Material.PAPER, 1), 
				new ItemStack(Material.SHEARS, 1), 
				new ItemStack(Material.SUGAR, 1), 
				new ItemStack(Material.ENDER_PEARL, 8), 
				new ItemStack(Material.FLINT, 8), 
				new ItemStack(Material.CLAY_BALL, 4),
				new ItemStack(Material.WEB, 4),
				new ItemStack(Material.IRON_HELMET, 1),
				new ItemStack(Material.IRON_CHESTPLATE, 1),
				new ItemStack(Material.IRON_LEGGINGS, 1),
				new ItemStack(Material.IRON_BOOTS, 1),
				new ItemStack(Material.WOOD_SPADE, 1), 
				new ItemStack(Material.SEEDS, 6), 
				new ItemStack(Material.WOOD_AXE, 1), 
				new ItemStack(Material.WOOD_HOE, 1), 
				new ItemStack(Material.WOOD_PICKAXE, 1), 
				new ItemStack(Material.BONE, 1), 
				new ItemStack(Material.PAPER, 1), 
				new ItemStack(Material.SHEARS, 1), 
				new ItemStack(Material.SUGAR, 1), 
				new ItemStack(Material.ENDER_PEARL, 8), 
				new ItemStack(Material.FLINT, 8), 
				new ItemStack(Material.CLAY_BALL, 4),
				new ItemStack(Material.WEB, 4),
				new ItemStack(Material.LEATHER_HELMET, 1),
				new ItemStack(Material.LEATHER_CHESTPLATE, 1),
				new ItemStack(Material.LEATHER_LEGGINGS, 1),
				new ItemStack(Material.LEATHER_BOOTS, 1),
				new ItemStack(Material.STONE_SPADE, 1), 
				new ItemStack(Material.SEEDS, 6), 
				new ItemStack(Material.STONE_AXE, 1), 
				new ItemStack(Material.STONE_HOE, 1), 
				new ItemStack(Material.STONE_PICKAXE, 1), 
				new ItemStack(Material.BONE, 1), 
				new ItemStack(Material.PAPER, 1), 
				new ItemStack(Material.SHEARS, 1), 
				new ItemStack(Material.SUGAR, 1), 
				new ItemStack(Material.ENDER_PEARL, 8), 
				new ItemStack(Material.FLINT, 8), 
				new ItemStack(Material.CLAY_BALL, 4),
				new ItemStack(Material.WEB, 4),
				new ItemStack(Material.CHAINMAIL_HELMET, 1),
				new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1),
				new ItemStack(Material.CHAINMAIL_LEGGINGS, 1),
				new ItemStack(Material.CHAINMAIL_BOOTS, 1),
				new ItemStack(Material.IRON_SPADE, 1), 
				new ItemStack(Material.SEEDS, 6), 
				new ItemStack(Material.IRON_AXE, 1), 
				new ItemStack(Material.IRON_HOE, 1), 
				new ItemStack(Material.IRON_PICKAXE, 1), 
				new ItemStack(Material.BONE, 1), 
				new ItemStack(Material.PAPER, 1), 
				new ItemStack(Material.SHEARS, 1), 
				new ItemStack(Material.SUGAR, 1), 
				new ItemStack(Material.ENDER_PEARL, 8), 
				new ItemStack(Material.FLINT, 8), 
				new ItemStack(Material.CLAY_BALL, 4),
				new ItemStack(Material.WEB, 4),
				new ItemStack(Material.IRON_HELMET, 1),
				new ItemStack(Material.IRON_CHESTPLATE, 1),
				new ItemStack(Material.IRON_LEGGINGS, 1),
				new ItemStack(Material.IRON_BOOTS, 1),
				new ItemStack(Material.DIAMOND_SPADE, 1), 
				new ItemStack(Material.SEEDS, 6), 
				new ItemStack(Material.DIAMOND_AXE, 1), 
				new ItemStack(Material.DIAMOND_HOE, 1), 
				new ItemStack(Material.DIAMOND_PICKAXE, 1), 
				new ItemStack(Material.BONE, 1), 
				new ItemStack(Material.PAPER, 1), 
				new ItemStack(Material.SHEARS, 1), 
				new ItemStack(Material.SUGAR, 1), 
				new ItemStack(Material.ENDER_PEARL, 8), 
				new ItemStack(Material.FLINT, 8), 
				new ItemStack(Material.CLAY_BALL, 4),
				new ItemStack(Material.WEB, 4),
				new ItemStack(Material.DIAMOND_HELMET, 1),
				new ItemStack(Material.DIAMOND_CHESTPLATE, 1),
				new ItemStack(Material.DIAMOND_LEGGINGS, 1),
				new ItemStack(Material.DIAMOND_BOOTS, 1),
				getCure(),
				getPasta(),
				getBeans(),
				getCure(),
				getPasta(),
				getBeans(),
				getCure(),
				getPasta(),
				getBeans(),
				getMD(),
				new ItemStack(Material.GOLDEN_APPLE, 1, (byte) 1),
				};
	}
	
	
	public ItemStack[] FetchRandomizerStack(Chest c) {
		if(ZoneUtils.getZU().getChestZone(c).equals(Zone.ONE)) return getT1Contents();
		if(ZoneUtils.getZU().getChestZone(c).equals(Zone.TWO)) return getT2Contents();
		if(ZoneUtils.getZU().getChestZone(c).equals(Zone.THREE)) return getT3Contents();
		if(ZoneUtils.getZU().getChestZone(c).equals(Zone.FOUR)) return getT4Contents();
		
		return getT1Contents();
	}
	
	public List<Location> globalchests = new ArrayList<Location>();
	
	public void getChestsInWorld(World w) {
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(Chests.StatFile());
		
		List<String> l = cfg.getStringList("chests");
		
		for(String s : l) {
		Location ll = me.MrZombie_II.WarZ.commands.Chest.stringToLoc(s);
		
		if(ll.getBlock().getState() instanceof Chest) {
		globalchests.add(ll);
		}
		}
	}
	
	public boolean isDoubleChest(Chest c) {
		
		if((c.getBlock().getRelative(BlockFace.NORTH).getType() == Material.CHEST) || 
				(c.getBlock().getRelative(BlockFace.EAST).getType() == Material.CHEST)
				|| (c.getBlock().getRelative(BlockFace.SOUTH).getType() == Material.CHEST) ||
				(c.getBlock().getRelative(BlockFace.WEST).getType() == Material.CHEST)) return true;
			
		return false;
	}

	public void CreateRandomChest(World ww) {
		Bukkit.broadcastMessage(ChatColor.RED + "Chests have been refilled!");
		for(Location cc : globalchests) {
		Chest c = (Chest) cc.getBlock().getState();
		
		Inventory inv = c.getBlockInventory();
		inv.clear();
		
		ItemStack[] itemstack = FetchRandomizerStack(c);
		
		if(isDoubleChest(c)) {
			for (int i = 0; i < 2; i++) {
			ItemStack material = itemstack[new Random().nextInt(itemstack.length)];
			inv.setItem(i, material);
			}
			c.update(true);
		} else {
			for (int i = 0; i < 2; i++) {
			ItemStack material = itemstack[new Random().nextInt(itemstack.length)];
			inv.setItem(i, material);
			}
			c.update(true);
		}
		}
	}
}
