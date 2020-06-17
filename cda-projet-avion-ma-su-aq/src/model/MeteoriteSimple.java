package model;

import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class MeteoriteSimple {
	private  int degats;
	private  int vitesse;
	private  int largeur;
	private  int hauteur;

	private ImageIcon icoMS;
	private Image imgMS;

	private int positionX;
	private int positionY;

	
	
	
	
	
	public MeteoriteSimple(int positionX, int positionY) {
		this.largeur = 30;
		this.hauteur = 30;
		this.positionX = positionX;
		this.positionY = positionY;
		this.icoMS = new ImageIcon(getClass().getResource("/_ressources/ms.gif"));
		this.imgMS = this.icoMS.getImage();
	}

	

	void move() {
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

	public  Image getImgMS() {
		return imgMS;
	}

	public int getLargeur() {
		return this.largeur;
	}

	public int getHauteur() {
		return this.hauteur;
	}

}
