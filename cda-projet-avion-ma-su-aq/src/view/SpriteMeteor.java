package view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Meteorite;
import model.MeteoriteSimple;

public class SpriteMeteor extends JPanel {

	private MeteoriteSimple m;
	private int positionX;
	private int positionY;
	private int width;
	private int height;

	// Test avec meteor simple
//	public SpriteMeteor(MeteoriteSimple pMeteor) {
//		this.positionX = pMeteor.getPositionX();
//		this.positionY = pMeteor.getPositionY();
//		this.width = pMeteor.getLargeur();
//		this.height = pMeteor.getHauteur();
//		
//		//Redimensionner le JPanel ??
//		this.setPreferredSize(new Dimension(this.width, this.height));
//		this.setSize(new Dimension(this.width, this.height));
//	}

	public SpriteMeteor() {

	this.m = new MeteoriteSimple(200 , 200);
	
	this.setFocusable(true);
	this.requestFocusInWindow();
	
	
	}
	
	private void deplacementMeteor(Graphics g ) {
		
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(m.getImgMS(), positionX, positionY, this);
	}

	public static void main(String[] args) {

		JFrame fenetre = new JFrame();
		fenetre.setTitle("fenetre test");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setSize(800, 600);
		fenetre.setLocationRelativeTo(null);

//		JPanel pan = new SpriteMeteor(new MeteoriteSimple(100, 0));
//		pan.setBackground(Color.green);
//		fenetre.getContentPane().add(pan);

		
		
		fenetre.setVisible(true);
	}

}
