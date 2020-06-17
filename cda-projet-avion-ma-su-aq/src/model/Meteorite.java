package model;

import java.awt.Rectangle;

public abstract class Meteorite {

	protected String nom;
	protected int degat;
	protected int vitesse;
	protected int positionX;
	protected int positionY;
	protected int largeur;
	protected int hauteur;

	public Meteorite(String pNom, int pDegat, int pVitesse, int pPositionX, int pPositionY, int pLargeur, int pHauteur) {
		this.nom = pNom;
		this.degat = pDegat;
		this.vitesse = pVitesse;
		this.positionX = pPositionX;
		this.positionY = pPositionY;
		this.largeur = pLargeur;
		this.hauteur = pHauteur;

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

}
