package com.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.model.MeteoriteDeFeu;
import com.model.MeteoriteSimple;

public class MeteoriteFeuPanel extends JPanel {

	private final int vitesseDeplacement;
	private ImageIcon icoMS;
	private Image imgMS;
	private MeteoriteDeFeu m;
	
	public MeteoriteFeuPanel(int pVitesseDeplacement) {
		this.vitesseDeplacement = pVitesseDeplacement;
		this.icoMS = new ImageIcon(getClass().getResource("/_ressources/mFeu.gif"));
		this.imgMS = this.icoMS.getImage();

//		this.setBackground(Color.BLACK);
		this.setSize(150, 150);
		this.setOpaque(false);
		

		
		Random vRandom = new Random();
		int i = vRandom.nextInt(CentrePanel.getLargeur() - this.getWidth() - 10) + 10;
		int j = vRandom.nextInt(75);
		this.setLocation(i, 0-j);
		m = new MeteoriteDeFeu(i,0-j);
	}

	public int getVitesseDeplacement() {
		return vitesseDeplacement;
	}

	public void reset() {
		Random vRandom = new Random();
		int i = vRandom.nextInt(CentrePanel.getLargeur() - this.getWidth() - 10) + 10;
		int j = vRandom.nextInt(75);
		this.setLocation(i, 0-j);
		m = new MeteoriteDeFeu(i,0-j);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.imgMS, 0, 0, null);
	}
}
