package controller;

import model.Meteorite;
import model.Player;

public class Collision {
	
	public static boolean checkCollision(Meteorite m) {
		return Player.getInstance().getBounds().intersects(m.getBounds());
	}
}
