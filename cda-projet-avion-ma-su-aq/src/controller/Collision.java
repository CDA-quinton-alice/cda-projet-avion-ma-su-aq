package controller;

import java.awt.Rectangle;
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
				//Player.isHirt(m.getDamages());
				Player.isHit(1);
				meteorites.remove(m);
				return true; 
			}
		}
		return false;
	}
}
