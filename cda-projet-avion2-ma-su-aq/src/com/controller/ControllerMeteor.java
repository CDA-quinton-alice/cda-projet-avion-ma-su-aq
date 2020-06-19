package com.controller;

import java.util.Random;

public class ControllerMeteor{

	public static enum EnumMeteor {
		NORMALE, FEU, GLACE, ICE, ZIGZAG
	};
	
	public static EnumMeteor randomMeteor() {
		int pick = new Random().nextInt(EnumMeteor.values().length);
		return EnumMeteor.values()[pick];
	}
	
}
