package me.MrZombie_II.WarZ.api;

import me.MrZombie_II.WarZ.enums.ZoneEnum.Zone;
import me.MrZombie_II.WarZ.func.Cuboid;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;

public class ZoneUtils {
	public static ZoneUtils zu = new ZoneUtils();
	
	public static ZoneUtils getZU() {
		return zu;
	}
	
	public Cuboid[] getZoneOneList() {
		Location a1 = new Location(Bukkit.getWorld("world"), -785, 0, 1225);
		Location a2 = new Location(Bukkit.getWorld("world"), -678, 256, 1096);
		
		Location b1 = new Location(Bukkit.getWorld("world"), -971, 0, 963);
		Location b2 = new Location(Bukkit.getWorld("world"), -916, 256, 920);
		
		Location c1 = new Location(Bukkit.getWorld("world"), -352, 0, 1058);
		Location c2 = new Location(Bukkit.getWorld("world"), -410, 256, 1015);
		
		Location d1 = new Location(Bukkit.getWorld("world"), -631, 0, 800);
		Location d2 = new Location(Bukkit.getWorld("world"), -552, 256, 869);
		
		return new Cuboid[] {
				new Cuboid(a1, a2),
				new Cuboid(b1, b2),
				new Cuboid(c1, c2),
				new Cuboid(d1, d2)
		};
	}
	
	public Cuboid[] getZoneTwoList() {
		Location a1 = new Location(Bukkit.getWorld("world"), -532, 0, 600);
		Location a2 = new Location(Bukkit.getWorld("world"), -372, 256, 440);
		
		Location b1 = new Location(Bukkit.getWorld("world"), -85, 0, 786);
		Location b2 = new Location(Bukkit.getWorld("world"), 25, 256, 710);
		
		Location c1 = new Location(Bukkit.getWorld("world"), -193, 0, 530);
		Location c2 = new Location(Bukkit.getWorld("world"), -165, 256, 569);
		
		Location d1 = new Location(Bukkit.getWorld("world"), 7, 0, 516);
		Location d2 = new Location(Bukkit.getWorld("world"), 42, 256, 492);
		
		Location e1 = new Location(Bukkit.getWorld("world"), 440, 0, 937);
		Location e2 = new Location(Bukkit.getWorld("world"), 485, 256, 887);
		
		Location f1 = new Location(Bukkit.getWorld("world"), 707, 0, 902);
		Location f2 = new Location(Bukkit.getWorld("world"), 752, 256, 848);
		
		Location g1 = new Location(Bukkit.getWorld("world"), 674, 0, 830);
		Location g2 = new Location(Bukkit.getWorld("world"), 620, 256, 443);
		
		Location h1 = new Location(Bukkit.getWorld("world"), 866, 0, 309);
		Location h2 = new Location(Bukkit.getWorld("world"), 971, 256, 150);
		
		Location i1 = new Location(Bukkit.getWorld("world"), -238, 0, -783);
		Location i2 = new Location(Bukkit.getWorld("world"), -183, 256, -726);
		
		Location j1 = new Location(Bukkit.getWorld("world"), 488, 0, 154);
		Location j2 = new Location(Bukkit.getWorld("world"), 524, 256, 231);
		
		Location k1 = new Location(Bukkit.getWorld("world"), 1000, 0, 111);
		Location k2 = new Location(Bukkit.getWorld("world"), 1108, 256, 74);
		
		return new Cuboid[] {
				new Cuboid(a1, a2),
				new Cuboid(b1, b2),
				new Cuboid(c1, c2),
				new Cuboid(d1, d2),
				new Cuboid(e1, e2),
				new Cuboid(f1, f2),
				new Cuboid(g1, g2),
				new Cuboid(h1, h2),
				new Cuboid(i1, i2),
				new Cuboid(j1, j2),
				new Cuboid(k1, k2),
		};
	}
	
	public Cuboid[] getZoneThreeList() {
		Location a1 = new Location(Bukkit.getWorld("world"), 404, 0, -49);
		Location a2 = new Location(Bukkit.getWorld("world"), 619, 256, -327);
		
		Location b1 = new Location(Bukkit.getWorld("world"), 1183, 0, 106);
		Location b2 = new Location(Bukkit.getWorld("world"), 1353, 256, -301);
		
		Location c1 = new Location(Bukkit.getWorld("world"), 288, 0, -494);
		Location c2 = new Location(Bukkit.getWorld("world"), 614, 256, -656);
		
		Location d1 = new Location(Bukkit.getWorld("world"), 25, 0, -726);
		Location d2 = new Location(Bukkit.getWorld("world"), 75, 256, -663);
		
		Location e1 = new Location(Bukkit.getWorld("world"), -537, 0, -379);
		Location e2 = new Location(Bukkit.getWorld("world"), -398, 256, -476);
		
		Location f1 = new Location(Bukkit.getWorld("world"), -723, 0, -979);
		Location f2 = new Location(Bukkit.getWorld("world"), -854, 256, -878);
		
		Location g1 = new Location(Bukkit.getWorld("world"), 663, 0, -800);
		Location g2 = new Location(Bukkit.getWorld("world"), 746, 256, -902);
		
		Location h1 = new Location(Bukkit.getWorld("world"), 787, 0, -645);
		Location h2 = new Location(Bukkit.getWorld("world"), 941, 256, -482);
		
		
		return new Cuboid[] {
				new Cuboid(a1, a2),
				new Cuboid(b1, b2),
				new Cuboid(c1, c2),
				new Cuboid(d1, d2),
				new Cuboid(e1, e2),
				new Cuboid(f1, f2),
				new Cuboid(g1, g2),
				new Cuboid(h1, h2)
		};
	}

	public Cuboid[] getZoneFourList() {
		Location a1 = new Location(Bukkit.getWorld("world"), 247, 0, -1308);
		Location a2 = new Location(Bukkit.getWorld("world"), -441, 256, -844);
		
		Location b1 = new Location(Bukkit.getWorld("world"), 826, 0, -1191);
		Location b2 = new Location(Bukkit.getWorld("world"), 1016, 256, -1006);
		
		return new Cuboid[] {
				new Cuboid(a1, a2),
				new Cuboid(b1, b2)
		};
	}
	
	public Zone getPlayerZone(Player player) {
		for(Cuboid c : getZoneOneList()) {
			if(c.contains(player.getLocation())) return Zone.ONE;
		}
		
		for(Cuboid c : getZoneTwoList()) {
			if(c.contains(player.getLocation())) return Zone.TWO;
		}
		
		for(Cuboid c : getZoneThreeList()) {
			if(c.contains(player.getLocation())) return Zone.THREE;
		}
		
		for(Cuboid c : getZoneFourList()) {
			if(c.contains(player.getLocation())) return Zone.FOUR;
		}
		
		return Zone.OUTSKIRTS;
	}
	
	public Zone getChestZone(Chest cc) {
		for(Cuboid c : getZoneOneList()) {
			if(c.contains(cc.getLocation())) return Zone.ONE;
		}
		
		for(Cuboid c : getZoneTwoList()) {
			if(c.contains(cc.getLocation())) return Zone.TWO;
		}
		
		for(Cuboid c : getZoneThreeList()) {
			if(c.contains(cc.getLocation())) return Zone.THREE;
		}
		
		for(Cuboid c : getZoneFourList()) {
			if(c.contains(cc.getLocation())) return Zone.FOUR;
		}
		
		return Zone.OUTSKIRTS;
	}
}
