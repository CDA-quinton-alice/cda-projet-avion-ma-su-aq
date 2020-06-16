package view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.MeteoriteSimple;

public class SpriteMeteor extends JPanel {

//	private Image imgMeteorSimple;
	private int positionX;
	private int positionY;
	private int width;
	private int height;

	// Test avec meteor simple
	public SpriteMeteor(MeteoriteSimple pMS) {
		this.positionX = pMS.getPositionX();
		this.positionY = pMS.getPositionY();
		this.width = MeteoriteSimple.getLargeur();
		this.height = MeteoriteSimple.getHauteur();
		this.setPreferredSize(new Dimension(this.width, this.height));
		this.setSize(new Dimension(this.width, this.height));
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(MeteoriteSimple.getImgMS(), positionX, positionY, this);
	}

	public static void main(String[] args) {

		JFrame fenetre = new JFrame();
		fenetre.setTitle("fenetre test");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setSize(800, 600);
		fenetre.setLocationRelativeTo(null);

		JPanel pan = new SpriteMeteor(new MeteoriteSimple(100, 0));
//		pan.setBackground(Color.green);
		fenetre.getContentPane().add(pan);

		
		
		fenetre.setVisible(true);
	}

}
