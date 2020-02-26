package me.MrZombie_II.WarZ.api;

import java.util.Random;

public class MathUtil {

	public static MathUtil mu = new MathUtil();
	
	public static MathUtil getUtil() { 
		return mu;
	}
	
	public Integer getMinMaxRand(int min, int max) {
		Random rn = new Random();
	    int randomNum = rn.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
	
	public Double getMinMaxDouble(double min, double max) {
		Random rn = new Random();
	    double randomNum = rn.nextInt((int) ((max - min) + 1)) + min;
	    
	    return randomNum;
	}
	
	
}
