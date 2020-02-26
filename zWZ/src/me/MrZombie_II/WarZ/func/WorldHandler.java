package me.MrZombie_II.WarZ.func;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class WorldHandler {
	public static WorldHandler wh = new WorldHandler();
	
	public static WorldHandler getWH() {
		return wh;
	}
	
	
	public void unloadWorld(World world) {
	    if(!world.equals(null)) {
	        Bukkit.getServer().unloadWorld(world, true);
	    }
	}
	
	public boolean deleteWorld(File path) {
	      if(path.exists()) {
	          File files[] = path.listFiles();
	          for(int i=0; i<files.length; i++) {
	              if(files[i].isDirectory()) {
	                  deleteWorld(files[i]);
	              } else {
	                  files[i].delete();
	              }
	          }
	      }
	      return(path.delete());
	}
	
	
	public void copyWorld(File source, File target){
	    try {
	        ArrayList<String> ignore = new ArrayList<String>(Arrays.asList("uid.dat", "session.dat"));
	        if(!ignore.contains(source.getName())) {
	            if(source.isDirectory()) {
	                if(!target.exists()) {
	                target.mkdirs();
	                } else {
	                	target.createNewFile();
	                }
	                String files[] = source.list();
	                for (String file : files) {
	                    File srcFile = new File(source, file);
	                    File destFile = new File(target, file);
	                    copyWorld(srcFile, destFile);
	                }
	            } else {
	                InputStream in = new FileInputStream(source);
	                OutputStream out = new FileOutputStream(target);
	                byte[] buffer = new byte[1024];
	                int length;
	                while ((length = in.read(buffer)) > 0)
	                    out.write(buffer, 0, length);
	                in.close();
	                out.close();
	            }
	        }
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
	}
	
	public void copyPlayerData() throws IOException {
		File playerdata = new File(Bukkit.getWorld("world").getWorldFolder() + File.separator + "players");
		File newdata = new File(Bukkit.getPluginManager().getPlugin("zWZ").getDataFolder() + File.separator + "temp" + File.separator + "players");
		
		if(!newdata.exists() && newdata.isDirectory()) {
			newdata.createNewFile();
		}
		
		for(File f : playerdata.listFiles()) {
			f.setReadOnly();
		}
		
        InputStream in = new FileInputStream(playerdata);
        OutputStream out = new FileOutputStream(newdata);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = in.read(buffer)) > 0)
            out.write(buffer, 0, length);
        in.close();
        out.close();
	}
	
	public void RetrieveStoredPlayerData() throws IOException {
		File newdata = new File(Bukkit.getWorld("world").getWorldFolder() + File.separator + "players");
		File playerdata = new File(Bukkit.getPluginManager().getPlugin("zWZ").getDataFolder() + File.separator + "temp" + File.separator + "players");
		
		if(!newdata.exists() && newdata.isDirectory()) {
			newdata.createNewFile();
		}
		
        InputStream in = new FileInputStream(playerdata);
        OutputStream out = new FileOutputStream(newdata);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = in.read(buffer)) > 0)
            out.write(buffer, 0, length);
        in.close();
        out.close();
	}
	
	public void deleteTempData() {
		File olddata = new File(Bukkit.getPluginManager().getPlugin("zWZ").getDataFolder() + File.separator + "temp" + File.separator + "players");
		
		 if(olddata.exists()) {
	          File files[] = olddata.listFiles();
	          for(int i=0; i<files.length; i++) {
	              if(files[i].isDirectory()) {
	                  deleteWorld(files[i]);
	              } else {
	                  files[i].delete();
	              }
	          }
	      }
	      olddata.delete();
	}
}
