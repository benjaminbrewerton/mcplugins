package me.MrZombie_II.WarZ.enums;

public class ZoneEnum {

	public static enum Zone {
		ONE(1),
		TWO(2),
		THREE(3),
		FOUR(4),
		OUTSKIRTS(5);
		
		private int zid;
		
		private Zone(int zid) {
			this.zid = zid;
		}
		
		public Integer getZoneID() {
			return zid;
		}
		
		public String getZoneString() {
			if(zid == 1) return "1";
			if(zid == 2) return "2";
			if(zid == 3) return "3";
			if(zid == 4) return "4";
			if(zid == 5) return "Outskirts";
			return null;
		}
	}
	
	
}
