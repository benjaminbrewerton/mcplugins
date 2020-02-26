package me.MrZombie_II.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class BanConfig {
	public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(BanFile());

	  public BanConfig() {
		  cfg.set("#", "Ban Configuration File for W33DKits");
	    try {
	      cfg.save(BanFile());
	    }
	    catch (IOException e) {
	      e.printStackTrace();
	    }
	    try {
	      cfg.load(BanFile());
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
	  
	  
	  public static File BanFile() {
		    File file = new File("plugins/zWE", "ban.yml");
		    return file;
		  }
	  
	  
	  public void ReloadBan() {
		  cfg = YamlConfiguration.loadConfiguration(BanFile());
		  
	  }
	  
	}
