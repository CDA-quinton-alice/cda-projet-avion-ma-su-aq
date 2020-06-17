package model;

import java.awt.Rectangle;

public class MeteoriteSimple extends Meteorite {

	public MeteoriteSimple(int pPositionX, int pPositionY) {
		super("SIMPLE", 1, 10, pPositionX, pPositionY, 30, 30);

	}

	public void move() {
		// Meteor simple --> déplacement sur Y seulement
//		this.setPositionX(this.positionX + VITESSE);
		this.setPositionY(this.positionY + this.vitesse);

	}

	public Rectangle getBounds() {
		Rectangle vRectangle = new Rectangle(this.positionX, this.positionY, this.largeur, this.hauteur);
		return vRectangle;
	}

}
