package me.MrZombie_II.WarZ.enums;

public class StatsVariable {
	public static enum SV {
		KILLS("kills"),
		DEATHS("deaths");
		
		private String sv;
		
		private SV(String sv) {
			this.sv = sv;
		}
		
		public String getVariableID() {
			return sv;
		}
		
	}
	
}
