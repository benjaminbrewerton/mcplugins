package me.MrZombie_II.main;

import java.util.logging.Logger;

import me.MrZombie_II.Listeners.ACListener;
import me.MrZombie_II.Listeners.BanListener;
import me.MrZombie_II.Listeners.BroadcastListener;
import me.MrZombie_II.Listeners.GUIListener;
import me.MrZombie_II.Listeners.PlayerListener;
import me.MrZombie_II.Listeners.SpawnProtListener;
import me.MrZombie_II.Listeners.StatsListener;
import me.MrZombie_II.Listeners.TagListener;
import me.MrZombie_II.commands.Afk;
import me.MrZombie_II.commands.Alerts;
import me.MrZombie_II.commands.Ban;
import me.MrZombie_II.commands.Broadcast;
import me.MrZombie_II.commands.CI;
import me.MrZombie_II.commands.CheckBan;
import me.MrZombie_II.commands.ClearChat;
import me.MrZombie_II.commands.EC;
import me.MrZombie_II.commands.FK;
import me.MrZombie_II.commands.FlySpeed;
import me.MrZombie_II.commands.GRP;
import me.MrZombie_II.commands.Gamemode;
import me.MrZombie_II.commands.Help;
import me.MrZombie_II.commands.Info;
import me.MrZombie_II.commands.Inv;
import me.MrZombie_II.commands.Kick;
import me.MrZombie_II.commands.Kits;
import me.MrZombie_II.commands.Lag;
import me.MrZombie_II.commands.Lock;
import me.MrZombie_II.commands.Msg;
import me.MrZombie_II.commands.MuteChat;
import me.MrZombie_II.commands.MutePlayer;
import me.MrZombie_II.commands.Pardon;
import me.MrZombie_II.commands.Ping;
import me.MrZombie_II.commands.Price;
import me.MrZombie_II.commands.R;
import me.MrZombie_II.commands.ReloadWho;
import me.MrZombie_II.commands.Rules;
import me.MrZombie_II.commands.SetSpawn;
import me.MrZombie_II.commands.Shop;
import me.MrZombie_II.commands.Soup;
import me.MrZombie_II.commands.Spawn;
import me.MrZombie_II.commands.Staff;
import me.MrZombie_II.commands.Suicide;
import me.MrZombie_II.commands.TP;
import me.MrZombie_II.commands.UnKick;
import me.MrZombie_II.commands.Vanish;
import me.MrZombie_II.commands.VersionTabFix;
import me.MrZombie_II.commands.WarZ;
import me.MrZombie_II.commands.Who;
import me.MrZombie_II.commands.Eco;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.defaults.VersionCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	public final Logger logger = Logger.getLogger("Minecraft");
	public static Main plugin;
	public final PlayerListener pl = new PlayerListener(this);
	public final BanListener bl = new BanListener(this);
	public final ACListener acl = new ACListener(this);
	
	@EventHandler
	public void onDisable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Has been disabled!");
		this.logger.info("Email any bugs to mrzombie_ii@hotmail.com");
		
		for(Player p : getServer().getOnlinePlayers()) {
		getServer().getPluginManager().callEvent(new InventoryCloseEvent(p.getOpenInventory()));
		
		}
		
	}
	
	@EventHandler
	public void onEnable() {
		
		if(!(getServer().getPluginManager().getPlugin("TagAPI") !=null)) {
			this.logger.info("Error: Required Dependancy [TagAPI] not found!");
			getServer().getPluginManager().disablePlugin(this);
			return;
		}
		
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Version " + pdfFile.getVersion() + ChatColor.LIGHT_PURPLE + " Has been enabled!");
		this.logger.info(ChatColor.RED + "Coded by MrZombie_II");
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(this.pl, this);
		pm.registerEvents(this.bl, this);
		pm.registerEvents(new ACListener(this), this);
		//pm.registerEvents(new StatsListener(this), this);
		//pm.registerEvents(new GUIListener(this), this);
		pm.registerEvents(new BroadcastListener(this), this);
		pm.registerEvents(new SpawnProtListener(this), this);
		pm.registerEvents(new TagListener(this), this);
		
		if (!Config.File().exists()) {
		      new Config();
		    }
		if (!BanConfig.BanFile().exists()) {
		      new BanConfig();
		    }
		if (!CheckConfig.CheckFile().exists()) {
			  new CheckConfig();
		}
		if (!Stats.StatFile().exists()) {
			  new Stats();
		}
		if(!WarpConfig.WarpFile().exists()) {
			new WarpConfig();
		}
		if(!ChestConfig.ChestFile().exists()) {
			new ChestConfig();
		}
		
		getCommand("soup").setExecutor(new Soup());
		getCommand("cc").setExecutor(new MuteChat());
		getCommand("tc").setExecutor(new ClearChat());
		//getCommand("help").setExecutor(new Help());
		//getCommand("kits").setExecutor(new Kits());
		//getCommand("rules").setExecutor(new Rules());
		//getCommand("staff").setExecutor(new Staff());
		getCommand("gm").setExecutor(new Gamemode());
		getCommand("gamemode").setExecutor(new Gamemode());
		getCommand("bc").setExecutor(new Broadcast());
		getCommand("bcast").setExecutor(new Broadcast());
		getCommand("who").setExecutor(new Who());
		getCommand("list").setExecutor(new Who());
		getCommand("kill").setExecutor(new Suicide());
		getCommand("suicide").setExecutor(new Suicide());
		getCommand("vanish").setExecutor(new Vanish());
		getCommand("v").setExecutor(new Vanish());
		//getCommand("ping").setExecutor(new Ping());
		getCommand("afk").setExecutor(new Afk());
		//getCommand("ip").setExecutor(new Info());
		//getCommand("server").setExecutor(new Info());
		getCommand("?").setExecutor(new Help());
		getCommand("ban").setExecutor(new Ban());
		getCommand("unban").setExecutor(new Pardon());
		getCommand("inv").setExecutor(new Inv());
		getCommand("fs").setExecutor(new FlySpeed());
		getCommand("flyspeed").setExecutor(new FlySpeed());
		getCommand("mute").setExecutor(new MutePlayer());
		getCommand("kick").setExecutor(new Kick());
		getCommand("uk").setExecutor(new UnKick());
		getCommand("unkick").setExecutor(new UnKick());
		getCommand("msg").setExecutor(new Msg());
		getCommand("tell").setExecutor(new Msg());
		getCommand("r").setExecutor(new R());
		getCommand("reply").setExecutor(new R());
		getCommand("setspawn").setExecutor(new SetSpawn());
		getCommand("alerts").setExecutor(new Alerts());
		getCommand("a").setExecutor(new Alerts());
		getCommand("ver").setExecutor(new Help());
		getCommand("lag").setExecutor(new Lag());
		//getCommand("warz").setExecutor(new WarZ());
		getCommand("tp").setExecutor(new TP());
		getCommand("teleport").setExecutor(new TP());
		getCommand("ci").setExecutor(new CI());
		getCommand("clear").setExecutor(new CI());
		//getCommand("stats").setExecutor(new me.MrZombie_II.commands.Stats());
		//getCommand("eco").setExecutor(new Eco());
		//getCommand("shop").setExecutor(new Shop());
		getCommand("me").setExecutor(new Lag());
		//getCommand("fk").setExecutor(new FK());
		getCommand("rw").setExecutor(new ReloadWho());
		getCommand("spawn").setExecutor(new Spawn());
		getCommand("grp").setExecutor(new GRP());
		//getCommand("pc").setExecutor(new EC());
		//getCommand("chest").setExecutor(new EC());
		getCommand("lock").setExecutor(new Lock());
		getCommand("checkban").setExecutor(new CheckBan());
		getCommand("whisper").setExecutor(new Msg());
		//getCommand("price").setExecutor(new Price());
		
	}


}
