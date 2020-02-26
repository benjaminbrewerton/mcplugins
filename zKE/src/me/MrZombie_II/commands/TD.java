package me.MrZombie_II.commands;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class TD implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if(commandLabel.equalsIgnoreCase("td") || commandLabel.equalsIgnoreCase("transferdata")) {
			if(!(sender instanceof Player)) return true;
			
			Player player = (Player) sender;
			
			YamlConfiguration oecc = YamlConfiguration.loadConfiguration(me.MrZombie_II.main.ChestConfig.ChestFile());
			YamlConfiguration os = YamlConfiguration.loadConfiguration(me.MrZombie_II.main.Stats.StatFile());
			File f = new File(Bukkit.getServer().getPluginManager().getPlugin("zWE").getDataFolder() + File.separator + "userdata" + File.separator + player.getName() + ".yml");
			YamlConfiguration necc = YamlConfiguration.loadConfiguration(f);
			
			try {
				oecc.load(me.MrZombie_II.main.ChestConfig.ChestFile());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InvalidConfigurationException e) {
				e.printStackTrace();
			}
			
			int ok = os.getInt(player.getName() + ".kills");
			int oc = os.getInt(player.getName() + ".credits");
			int od = os.getInt(player.getName() + ".deaths");
			
			List<?> oeci = oecc.getList(player.getName() + ".ec");
			necc.set("ec", oeci);
			
			necc.set("kills", ok);
			necc.set("credits", oc);
			necc.set("deaths", od);
			
			try {
				necc.save(f);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		}
		return false;
	}

}
