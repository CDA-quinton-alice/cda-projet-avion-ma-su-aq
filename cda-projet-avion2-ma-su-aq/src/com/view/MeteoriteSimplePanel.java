package com.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.model.MeteoriteSimple;

public class MeteoriteSimplePanel extends JPanel implements IMeteorite{

	private final int vitesseDeplacement;
	private ImageIcon icoMS;
	private Image imgMS;
	private MeteoriteSimple m;
	
	public MeteoriteSimplePanel(int pVitesseDeplacement) {
		this.vitesseDeplacement = pVitesseDeplacement;
		this.icoMS = new ImageIcon(getClass().getResource("/_ressources/ms.gif"));
		this.imgMS = this.icoMS.getImage();

//		this.setBackground(Color.BLACK);
		this.setSize(60, 60);
		this.setOpaque(false);
		
		
		Random vRandom = new Random();
		int i = vRandom.nextInt(CentrePanel.getLargeur() - this.getWidth() - 10) + 10;
		int j = vRandom.nextInt(75);
		this.setLocation(i, 0-j);
		m = new MeteoriteSimple(i,0-j);
	}

	public int getVitesseDeplacement() {
		return vitesseDeplacement;
	}

	public MeteoriteSimple getM() {
		return this.m;
	}
	
	public void reset() {
		Random vRandom = new Random();
		int i = vRandom.nextInt(CentrePanel.getLargeur() - this.getWidth() - 10) + 10;
		int j = vRandom.nextInt(75);
		this.setLocation(i, 0-j);
		m = new MeteoriteSimple(i,0-j);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.imgMS, 0, 0, null);
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}
}
