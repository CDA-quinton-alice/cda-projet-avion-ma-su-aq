package controller;

import java.util.ArrayList;

import model.Meteorite;
import model.MeteoriteSimple;
import model.Player;

public class Collision {
	
	private static ArrayList<MeteoriteSimple> test = new ArrayList<MeteoriteSimple>() {
		{
			add(new MeteoriteSimple(10,10));
		}
	};

	public static boolean checkCollision() {
		ArrayList<MeteoriteSimple> meteorites = test;
		
		for(MeteoriteSimple m : meteorites) {
			if(m.getBounds().intersects(Player.getInstance().getBounds())) {
				Player.isHit(1);
				Player.addPoints(m);
				meteorites.remove(m);
				return true; 
			}
		}
		return false;
	}
	
	public static boolean checkCollision(Meteorite m) {
		if(m.getBounds().intersects(Player.getInstance().getBounds())) {
			Player.isHit(1);
			Player.addPoints(m);
			return true; 
		}
		return false;
	}
}
