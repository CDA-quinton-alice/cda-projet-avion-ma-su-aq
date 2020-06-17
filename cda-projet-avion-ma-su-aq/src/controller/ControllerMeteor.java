package controller;

import java.util.ArrayList;
import java.util.Random;

import model.Meteorite;

public class ControllerMeteor {
	private int nbDeMeteor = 4;
	private int delay;

	private static ArrayList<Meteorite> listeMeteor;

	public enum EnumMeteor {
		NORMALE, FEU, GLACE, ICE, ZIGZAG
	};

	public ControllerMeteor() {

	}

	private EnumMeteor randomMeteor() {
		int pick = new Random().nextInt(EnumMeteor.values().length);
		return EnumMeteor.values()[pick];
	}
}
