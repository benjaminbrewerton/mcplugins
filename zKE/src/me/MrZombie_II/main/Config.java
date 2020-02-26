package me.MrZombie_II.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Config
{
  public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(File());

  public Config() {
	  cfg.set("Message1", "§1SG1");
	  cfg.set("Message2", "§2SG2");
	  cfg.set("Message3", "§3SG3");
	  cfg.set("Message4", "§4SG4");
    try {
      cfg.save(File());
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    try {
      cfg.load(File());
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

  public static File File() {
    File file = new File("plugins/zWE", "config.yml");
    return file;
  }
}