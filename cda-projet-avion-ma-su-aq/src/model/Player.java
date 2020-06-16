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
	private Image sprite;
	private Image explosion;
	private static Player INSTANCE = null;
	private static boolean alive;
	
	private Player() {
		URL url = getClass().getResource("/_ressources/xwing.png");
		URL url2 = getClass().getResource("/_ressources/explosion.png");
		Image tmp;
		posX = 250;
		posY = 250;
		alive = false;
		
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
	
	public boolean isAlive() {
		return alive;
	}

	public Image getSprite() {
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
