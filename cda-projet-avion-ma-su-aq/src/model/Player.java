package model;

import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class Player {
	private static int posX;
	private static int posY;
	private int width;
	private int height;
	private static Image sprite;
	private static Image explosion;
	private static Player INSTANCE = null;
	private static boolean alive;
	private static int vies;
	
	private Player() {
		URL url = getClass().getResource("/_ressources/xwing.png");
		URL url2 = getClass().getResource("/_ressources/explosion.png");
		Image tmp;
		posX = 250;
		posY = 250;
		alive = true;
		vies = 5;
		
		try {
			tmp = ImageIO.read(url);
			sprite = tmp.getScaledInstance(50, 50, Image.SCALE_SMOOTH); 
			tmp = ImageIO.read(url2);
			explosion = tmp.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			// TODO: handle exception
		}
	}

	public static Player getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new Player();
		}
		return INSTANCE;
	}
	
	public static int getPosX() {
		return posX;
	}

	public static int getPosY() {
		return posY;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	public static boolean isAlive() {
		return alive;
	}

	public static int getVies() {
		return vies;
	}
	
	public static void isHit() {
		vies--;
		if(vies==0) {
			setAlive(false);
		}
	}
	
	public static Image getSprite() {
		if(alive) {
			return sprite;
		}else{
			return explosion;
		}
	}
	
	public static void setAlive(boolean pAlive) {
		alive = pAlive;
	}

	public static void setPosX(int pX) {
		posX = pX;
	}

	public static void setPosY(int pY) {
		posY = pY;
	}

	public Rectangle getBounds() {
		return new Rectangle(posX,posY,width,height);
	}
}
