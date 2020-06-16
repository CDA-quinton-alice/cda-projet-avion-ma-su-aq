package model;

import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class MeteoriteSimple extends Meteorite {
	private static Image imgMS;
	private static final String NOM = "Metéorite Simple";
	private static final int DEGATS = 1;
	private static final int VITESSE = 10;
	private static final int LARGEUR = 50;
	private static final int HAUTEUR = 50;

	private int positionX;
	private int positionY;

	public MeteoriteSimple(int pPositionX, int pPoistionY) {
		super(NOM, DEGATS, VITESSE, LARGEUR, HAUTEUR, pPositionX, pPoistionY);
		URL url = getClass().getResource("/_ressources/meteor.gif");
		Image tempo;
		try {
			tempo = ImageIO.read(url);
			imgMS = tempo.getScaledInstance(LARGEUR, HAUTEUR, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.positionX = pPositionX;
		this.positionY = pPoistionY;
	}

	@Override
	void move() {
		//Meteor simple --> déplacement sur Y seulement
//		this.setPositionX(this.positionX + VITESSE);
		this.setPositionY(this.positionY + VITESSE);
	}

	@Override
	public Rectangle getBounds() {
		Rectangle vRectangle = new Rectangle(this.positionX, this.positionY, LARGEUR, HAUTEUR);
		return vRectangle;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public static Image getImgMS() {
		return imgMS;
	}

	public static int getLargeur() {
		return LARGEUR;
	}

	public static int getHauteur() {
		return HAUTEUR;
	}

}
