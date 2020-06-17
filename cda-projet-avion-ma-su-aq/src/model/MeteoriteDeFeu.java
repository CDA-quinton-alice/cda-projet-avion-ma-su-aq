package model;

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
	
	private ImageIcon icoMF;
	private Image imgMF;

	public MeteoriteDeFeu(int pPositionX, int pPositionY) {
		super("Météoroïde De Feu", 2, 5,pPositionX, pPositionY, 100, 100);
	this.icoMF = new ImageIcon(getClass().getResource("/_ressources/meteoroideDeFeuSansFond.gif"));
	this.imgMF = this.icoMF.getImage();
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
	public Image getImgMF() {
		return imgMF;
	}
	
}
