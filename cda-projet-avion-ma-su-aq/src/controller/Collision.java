package controller;

import java.awt.Rectangle;

public class Collision {
	
	public static boolean checkCollision(Rectangle r1, Rectangle r2) {
		return r1.intersects(r2);
	}
}
