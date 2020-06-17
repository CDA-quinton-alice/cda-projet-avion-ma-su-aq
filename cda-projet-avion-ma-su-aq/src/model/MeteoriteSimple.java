package model;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class MeteoriteSimple extends Meteorite {
	private String nom;
	private int degats;
	private int vitesse;
	private int largeur;
	private int hauteur;

	private ImageIcon icoMS;
	private Image imgMS;

	private int positionX;
	private int positionY;

	public MeteoriteSimple(int pPositionX, int pPositionY) {
		super("Météore Simple", 1, 10, pPositionX, pPositionY, 30, 30);
		this.icoMS = new ImageIcon(getClass().getResource("/_ressources/ms.gif"));
		this.imgMS = this.icoMS.getImage();
	}

	public void move() {
		// Meteor simple --> déplacement sur Y seulement
//		this.setPositionX(this.positionX + VITESSE);
		this.setPositionY(this.positionY + this.vitesse);

	}

	public Rectangle getBounds() {
		Rectangle vRectangle = new Rectangle(this.positionX, this.positionY, this.largeur, this.hauteur);
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

	public Image getImgMS() {
		return imgMS;
	}

	public int getLargeur() {
		return this.largeur;
	}

	public int getHauteur() {
		return this.hauteur;
	}

	public int getDegats() {
		return degats;
	}

}
