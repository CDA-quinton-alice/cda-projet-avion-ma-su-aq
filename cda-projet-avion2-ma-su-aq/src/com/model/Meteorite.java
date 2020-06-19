package com.model;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public abstract class Meteorite {

	protected String nom;
	protected int degat;
	protected int vitesse;
	protected int positionX;
	protected int positionY;
	protected int largeur;
	protected int hauteur;

	protected ImageIcon icoM;
	protected Image imgM;

	public Meteorite(String pNom, int pDegat, int pVitesse, int pPositionX, int pPositionY, int pLargeur,
			int pHauteur) {
		this.nom = pNom;
		this.degat = pDegat;
		this.vitesse = pVitesse;
		this.positionX = pPositionX;
		this.positionY = pPositionY;
		this.largeur = pLargeur;
		this.hauteur = pHauteur;

		switch (pNom) {
		case "SIMPLE":
			this.icoM = new ImageIcon(getClass().getResource("/_ressources/ms.gif"));
			this.imgM = this.icoM.getImage();
			break;

		case "FEU":
			this.icoM = new ImageIcon(getClass().getResource("/_ressources/meteoroideDeFeuSansFond.gif"));
			this.imgM = this.icoM.getImage();
			break;

		case "GLACE":
			this.icoM = new ImageIcon(getClass().getResource("/_ressources/meteoroideGlaceCutCourtetRotateSansFond.gif"));
			this.imgM = this.icoM.getImage();
			break;
			
		default:
			break;
		}

	}

	public abstract void move();

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

	public Image getImgM() {
		return imgM;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setDegat(int degat) {
		this.degat = degat;
	}

	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}

}
