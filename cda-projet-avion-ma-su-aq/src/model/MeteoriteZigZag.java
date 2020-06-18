package model;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class MeteoriteZigZag extends Meteorite {
	// se déplace à la même vitesse que météorite de feu 
	// se déplace en zig-zag tout en descendant
	// part un coup vers la droite et un coup vers la gauche 
	// fait autant de dégâts que la météorite de feu 
	
	// dégâts 2
	// vitesse 5
	// largeur 50
	// hauteur 50
	
	// score incrémenté de 5 lorsque l'avion arrive à en éviter une sans entrer en colision avec 
	
	boolean zig;
	private ImageIcon icoMZZ;
	private Image imgMZZ;
	
	public MeteoriteZigZag(int pPositionX, int pPositionY) {
		super("Météoroïde Zig-Zag", 2, 5, pPositionX, pPositionY, 50, 50);
		this.icoMZZ = new ImageIcon(getClass().getResource("/_ressources/ms.gif"));
		this.imgMZZ = this.icoMZZ.getImage();
		
	}

	@Override
	public void move() {
		//this.setPositionX(this.positionX+this.vitesse);
		//this.setPositionY(this.positionY+this.vitesse);
		
		if (zig) { // ça veut dire si zig est vrai 
			this.setPositionX((this.positionX+10)+this.vitesse);
			this.setPositionY((this.positionY+10)+this.vitesse);
			zig = false; // on change la valeur à chaque fois qu'on entre 
		} else { 
		this.setPositionX((this.positionX-10)+this.vitesse);
		this.setPositionY((this.positionY+10)+this.vitesse);
		zig = true; // on change la valeur à chaque fois qu'on entre
		}
	 // même vitesse que météoroïde de feu
		
	}

	@Override
	public Rectangle getBounds() {
		Rectangle vRectangle5 = new Rectangle(this.positionX, this.positionY, this.largeur, this.hauteur);
		return vRectangle5;
	}
	public Image getimgMZZ() {
		return imgMZZ;
	}
}
