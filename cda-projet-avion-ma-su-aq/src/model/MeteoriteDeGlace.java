package model;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class MeteoriteDeGlace extends Meteorite {
	// --> prend deux fois plus de dégâts que les météorites simples à l'impact avec
		// l'avion --> dégâts identiques que ceux de la météorite de feu 
	// avance à la même vitesse que les météorites simples 
	// taille entre la taille de la météorite simple et celle de la météorite de feu 
	
	// dégâts 2
	// vitesse 10
	// largeur 75
	// hauteur 75
	
	// score incrémenté de 3 lorsque l'avion arrive à en éviter une sans entrer en colision avec
	
	private ImageIcon icoMG;
	private Image imgMG;
	
	public MeteoriteDeGlace(int pPositionX, int pPositionY) {
		super("GLACE", 2, 10, pPositionX, pPositionY, 75, 75);
		this.icoMG = new ImageIcon(getClass().getResource("/_ressources/meteoroideGlaceCutCourtetRotateSansFond.gif"));
		this.imgMG = this.icoMG.getImage();
	}
	@Override
	public void move() {
		// this.setPositionX(this.positionX + this.vitesse);
		this.setPositionY(this.positionY+this.vitesse); // de la même vitesse que Météoroïde simple
		
	}
	@Override
	public Rectangle getBounds() {
		Rectangle vRectangle3 = new Rectangle(this.positionX,this.positionY, this.largeur, this.hauteur);
		return vRectangle3;
	}
	public Image getIMgMG() {
		return imgMG;
	}
}
