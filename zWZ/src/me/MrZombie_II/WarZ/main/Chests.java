package me.MrZombie_II.WarZ.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import me.MrZombie_II.WarZ.commands.Chest;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Chests {
	public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(StatFile());

	  public Chests() {

	    try {
	    	List<String> l = new ArrayList<String>();
	    	String s1 = Chest.locToString(new Location(Bukkit.getWorld("world"), 12, 12, 12));
	    	String s2 = Chest.locToString(new Location(Bukkit.getWorld("world"), 21, 21, 21));
	    	l.add(s1);
	    	l.add(s2);
	    cfg.set("chests", l);
	      cfg.save(StatFile());
	    }
	    catch (IOException e) {
	      e.printStackTrace();
	    }
	    try {
	      cfg.load(StatFile());
	    }
	    catch (FileNotFoundException e) {
	      e.printStackTrace();
	    }
	    catch (IOException e) {
	      e.printStackTrace();
	    }
	    catch (InvalidConfigurationException e) {
	      e.printStackTrace();
	    }
	  }

	  public static File StatFile() {
	    File file = new File("plugins/zWZ", "chests.yml");
	    return file;
	  }
}
