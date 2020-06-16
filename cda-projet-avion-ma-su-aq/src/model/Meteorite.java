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

	public Meteorite(String nom, int degat, int vitesse, int positionX, int positionY, int largeur, int hauteur) {
		this.nom = nom;
		this.degat = degat;
		this.vitesse = vitesse;
		this.positionX = positionX;
		this.positionY = positionY;
		this.largeur = largeur;
		this.hauteur = hauteur;
	}

	 abstract void move();

	public abstract Rectangle getBounds();

}
