package com.model;

import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import com.view.AvionPanel;
import com.view.CdaFenetre;
import com.view.CentrePanel;

public class Player {
	private static String name;
	private static int posX;
	private static int posY;
	private int width;
	private int height;
	private static AvionPanel avion;
	private static Player INSTANCE = null;
	private static boolean alive;
	private static ObservableVies vies;
	private static ObservablePoints points;
	
	private Player() {
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
			JOptionPane d = new JOptionPane();
			String lesTextes[] = {"Recommencer","Voir les scores","Quitter"};
			int retour = d.showOptionDialog(null,"Vous avez perdu", "Avion v2", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE,null,lesTextes,lesTextes[0]);
			
			if(retour == 0) {
				reset();
			}else if(retour == 1) {
				//Voir les scores
				
			}else {
				System.exit(0);
			}
		}
	}
	
	public static void reset() {
		vies.reset();
		points.reset();
		avion.reset();
	}
	
	public static void addPoints(Meteorite m) {
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

	public void addAvion(AvionPanel a1) {
		avion = a1;
		
	}
}
