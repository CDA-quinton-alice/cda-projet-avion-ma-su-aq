package FenetreJeu;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class ContentPane extends JPanel {
private Image theImage;

public ContentPane(Image theFond) {
	super();
	theImage = theFond;
	}
	
public void paintComponent(Graphics g) {
	g.drawImage(theImage, 0, 0, null);
}
}
