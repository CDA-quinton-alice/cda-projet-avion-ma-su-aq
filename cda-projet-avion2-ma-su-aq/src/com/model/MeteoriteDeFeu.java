package com.model;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class MeteoriteDeFeu extends Meteorite {
	
	// --> prend deux fois plus de dégâts que les météorites simples à l'impact avec
	// l'avion
	// avance moins rapidement que les premières météorites
	// on sait que la taille de la météorite de glace est entre la taille de
	// météorite simple et la taille de météorite feu
	// on sait que la taille de la météorite de glace est entre la taille de
	// météorite simple et la taille de météorite feu
	
	// dégâts 2
	// vitesse 5
	// largeur 100
	// hauteur 100 
	
	// // score incrémenté d'1 lorsque l'avion arrive à en éviter une sans entrer en colision avec

	public MeteoriteDeFeu(int pPositionX, int pPositionY) {
		super("Feu", 2, 5,pPositionX, pPositionY, 100, 100);
	
	}

	@Override
	public
	void move() {
//		this.setPositionX(this.positionX + this.vitesse);
		this.setPositionY(this.positionY + this.vitesse); // comme Météoroïde simple mais moins vite --> déplacement sur Y
														// seulement
	}
	@Override
	public Rectangle getBounds() {
		Rectangle vRectangle2 = new Rectangle(this.positionX, this.positionY, this.largeur, this.hauteur);
		return vRectangle2;
	}

	
}
