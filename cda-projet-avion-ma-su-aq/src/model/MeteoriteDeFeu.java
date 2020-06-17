package model;

import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class MeteoriteDeFeu extends Meteorite {
private static Image imgMF;
private static final String NOM = "Météorite de feu";
private static final int DEGATS = 2; // --> prend deux fois plus de dégâts que les météorites simples à l'impact avec l'avion
private static final int VITESSE = 5; // avance moins rapidement que les premières météorites
private static final int LARGEUR = 100;// on sait que la taille de la météorite de glace est entre la taille de météorite simple et la taille de météorite feu
private static final int HAUTEUR = 100; // on sait que la taille de la météorite de glace est entre la taille de météorite simple et la taille de météorite feu

private int positionX;
private int positionY; 

public MeteoriteDeFeu(int pPositionX, int pPositionY) {
	super(NOM,DEGATS, VITESSE,LARGEUR,HAUTEUR, pPositionX, pPositionY);
	URL urlMeteFeu = getClass().getResource("/_ressources/meteoroideDeFeuSansFond.gif");
	Image meteoroideFeu;
	try {
		meteoroideFeu = ImageIO.read(urlMeteFeu);
		imgMF = meteoroideFeu.getScaledInstance(LARGEUR, HAUTEUR, Image.SCALE_SMOOTH);
	} catch (IOException e) {
		System.out.println(e.getMessage());
	}
	this.positionX = pPositionX;
	this.positionY = pPositionY;
}

@Override
void move() {
	this.setPositionY(this.positionY+VITESSE); // comme Météoroïde simple mais moins vite --> déplacement sur Y seulement
}

public void setPositionY(int pPositionY) {
this.positionY=pPositionY;
}

@Override
public Rectangle getBounds() {
Rectangle vRectangle2 = new Rectangle(this.positionX,this.positionY,LARGEUR,HAUTEUR);
	return vRectangle2;
}
}
