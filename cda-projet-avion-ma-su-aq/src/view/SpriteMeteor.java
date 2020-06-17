package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import model.MeteoriteSimple;

public class SpriteMeteor extends JPanel implements ActionListener {

	private MeteoriteSimple m;
	private int positionX;
	private int positionY;
	private int width;
	private int height;
	private Random rd = new Random();

	// Test avec meteor simple
	public SpriteMeteor(MeteoriteSimple pMS) {
		this.m = pMS;
		this.positionX = pMS.getPositionX();
		this.positionY = pMS.getPositionY();
		this.width = pMS.getLargeur();
		this.height = pMS.getHauteur();
		this.setPreferredSize(new Dimension(this.width, this.height));
		this.setSize(new Dimension(this.width, this.height));
		Timer t = new Timer(20, this);
		t.start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(m.getImgMS(), m.getPositionX(), m.getPositionY(), this);
	}

	public static void main(String[] args) {

		JFrame fenetre = new JFrame();
		fenetre.setTitle("fenetre test");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setSize(800, 600);
		fenetre.setLocationRelativeTo(null);

		MeteoriteSimple ms = new MeteoriteSimple(200, 0);

		fenetre.add(new SpriteMeteor(ms));
		fenetre.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		m.move();
		this.repaint();
		System.out.println("TIC ");
	}

}
