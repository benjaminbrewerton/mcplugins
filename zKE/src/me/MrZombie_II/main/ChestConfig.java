package me.MrZombie_II.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class ChestConfig {
	public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(ChestFile());

	  public ChestConfig() {
		  cfg.set("#", "Chest Configuration File for W33DKits");
	    try {
	      cfg.save(ChestFile());
	    }
	    catch (IOException e) {
	      e.printStackTrace();
	    }
	    try {
	      cfg.load(ChestFile());
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
	  
	  
	  public static File ChestFile() {
		    File file = new File("plugins/zWE", "chest.yml");
		    return file;
		  }
	  
	  
	  public void ReloadBan() {
		  cfg = YamlConfiguration.loadConfiguration(ChestFile());
		  
	  }
	  
	}
