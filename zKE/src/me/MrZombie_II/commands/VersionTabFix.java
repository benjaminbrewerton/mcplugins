package me.MrZombie_II.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class VersionTabFix implements TabCompleter {
	
	public List<String> onTabComplete(CommandSender sender, Command command,
	          String alias,
	          String[] args){
	       
	    List<String> al = new ArrayList<String>();
	    al.add("dd");
	    al.add("rrf");
	        return al;     
	

	}
}
