package com.model;

import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class Player {
	private static String name;
	private static int posX;
	private static int posY;
	private int width;
	private int height;
	private static Player INSTANCE = null;
	private static boolean alive;
	private static ObservableVies vies;
	private static ObservablePoints points;
	
	private Player() {
		Image tmp;
		posX = 250;
		posY = 250;
		alive = true;
		vies = new ObservableVies();
		points = new ObservablePoints();
		this.width = 50;
		this.height = 50;
	}

	public static Player getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new Player();
		}
		return INSTANCE;
	}
	
	
	
	public static String getName() {
		return name;
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
	
	public ObservablePoints getPoints() {
		return points;
	}

	public static boolean isAlive() {
		return alive;
	}

	public ObservableVies getVies() {
		return vies;
	}
	
	public static void isHit(int i) {
		vies.getHit(i);
		if(vies.isDead()) {
			setAlive(false);
		}
	}
	
	public static void addPoints(Meteorite m) {
		System.out.println("DES POINTS !");
		points.addPoints(m);
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

	public static void setName(String name) {
		Player.name = name;
	}

	public Rectangle getBounds() {
		return new Rectangle(posX,posY,width,height);
	}
}
