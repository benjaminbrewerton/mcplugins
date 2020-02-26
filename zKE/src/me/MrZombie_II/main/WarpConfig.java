package me.MrZombie_II.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class WarpConfig {
	public FileConfiguration cfg = YamlConfiguration.loadConfiguration(WarpFile());

	  public WarpConfig() {
		  cfg.set("#", "Check Configuration File for W33DKits");
	    try {
	      cfg.save(WarpFile());
	    }
	    catch (IOException e) {
	      e.printStackTrace();
	    }
	    try {
	      cfg.load(WarpFile());
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
	  
	  
	  public static File WarpFile() {
		    File file = new File("plugins/zWE", "check.yml");
		    return file;
		  }
	  
	  
	  public void ReloadCheck() throws FileNotFoundException, IOException, InvalidConfigurationException {
		  cfg.load(WarpFile());
		  
	  }
}
