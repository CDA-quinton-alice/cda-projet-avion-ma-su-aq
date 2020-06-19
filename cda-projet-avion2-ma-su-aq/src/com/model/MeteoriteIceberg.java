package com.model;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class MeteoriteIceberg extends Meteorite {
 // possède la même image, la même vitesse et la même hauteur que Météorite de Glace
	// mais on double la largeur et les dégâts 
	
	// dégâts 4
	// vitesse 10
	// largeur 150
	// hauteur 75
	
	// // score incrémenté de 5 lorsque l'avion arrive à en éviter une sans entrer en colision avec
	
	private ImageIcon icoMI;
	private Image imgMI;
	
	public MeteoriteIceberg(int pPositionX, int pPositionY) {
		super("Météoroïde Iceberg", 4, 10, pPositionX, pPositionY, 150, 75);
		this.icoMI = new ImageIcon(getClass().getResource("/_ressources/meteoroideGlaceCutCourtetRotateSansFond.gif"));
		this.icoMI.getImage();
		
	}
	
	@Override
	public void move() {
		// this.setPositionX(this.positionX + this.vitesse);
		this.setPositionY(this.positionY+this.vitesse); // // de la même vitesse que Météoroïde de glace & Météoroïde simple
		
	}

	@Override
	public Rectangle getBounds() {
		Rectangle vRectangle4 = new Rectangle(this.positionX, this.positionY, this.largeur, this.hauteur);
		return vRectangle4;
	}
	public Image getIMgMI() {
		return imgMI;
	}
}
