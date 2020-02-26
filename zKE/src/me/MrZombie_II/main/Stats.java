package me.MrZombie_II.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Stats {
	public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(StatFile());

	  public Stats() {

	    try {
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
	    File file = new File("plugins/zWE", "stats.yml");
	    return file;
	  }
}
