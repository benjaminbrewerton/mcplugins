package me.MrZombie_II.gungame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.inventory.ItemStack;

public class GunGameCore {
	
	public static GunGameCore g = new GunGameCore();
	
	public static GunGameCore getGunGame() {
		return g;
	}
	
	public List<String> ggplayers = new ArrayList<String>();
	public Map<String, String> diedby = new HashMap<String, String>();
	public Map<String, Integer> playertier = new HashMap<String, Integer>();
	public Map<String, ItemStack[]> playerinv = new HashMap<String, ItemStack[]>();
	public Map<String, ItemStack[]> playerarmour = new HashMap<String, ItemStack[]>();
	public List<String> godmode = new ArrayList<String>();

}
