package com.controller;

import java.util.ArrayList;

import com.model.Meteorite;
import com.model.MeteoriteSimple;
import com.model.Player;

public class Collision {

	public static boolean checkCollision() {
		ArrayList<MeteoriteSimple> meteorites = new ArrayList<>();
		
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
