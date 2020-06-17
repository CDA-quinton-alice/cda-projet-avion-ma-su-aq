package model;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public abstract class Meteorite {

	protected String nom;
	protected int degat;
	protected int vitesse;
	protected int positionX;
	protected int positionY;
	protected  int largeur;
	protected  int hauteur;
	
	protected String strImage;
	protected ImageIcon icoMeteor;
	protected Image imgMeteor;

	public Meteorite(String nom, Image pImg, int degat, int vitesse, int positionX, int positionY, int largeur,
			int hauteur) {
		this.nom = nom;
		this.degat = degat;
		this.vitesse = vitesse;
		this.positionX = positionX;
		this.positionY = positionY;
		this.largeur = largeur;
		this.hauteur = hauteur;
		
		this.icoMeteor = new ImageIcon(getClass().getResource(this.strImage));
		this.imgMeteor = this.icoMeteor.getImage();
		

	}

	abstract void move();

	public abstract Rectangle getBounds();

	public String getNom() {
		return nom;
	}

	public int getDegat() {
		return degat;
	}

	public int getVitesse() {
		return vitesse;
	}

	public int getPositionX() {
		return positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public int getLargeur() {
		return largeur;
	}

	public int getHauteur() {
		return hauteur;
	}

	public Image getImg() {
		return imgMeteor;
	}

}
