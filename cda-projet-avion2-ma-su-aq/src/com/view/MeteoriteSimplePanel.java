package com.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MeteoriteSimplePanel extends JPanel {

	private final int vitesseDeplacement;
	private ImageIcon icoMS;
	private Image imgMS;

	public MeteoriteSimplePanel(int pVitesseDeplacement) {
		this.vitesseDeplacement = pVitesseDeplacement;
		this.icoMS = new ImageIcon(getClass().getResource("/_ressources/ms.gif"));
		this.imgMS = this.icoMS.getImage();

//		this.setBackground(Color.BLACK);
		this.setSize(60, 60);
		this.setOpaque(false);
	}

	public int getVitesseDeplacement() {
		return vitesseDeplacement;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.imgMS, 0, 0, null);
	}
}
