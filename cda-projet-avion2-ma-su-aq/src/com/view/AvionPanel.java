package com.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class AvionPanel extends JPanel {

	private ImageIcon icoAvion;
	private Image imgAvion;
	private static int width = 89;
	private static int height = 177;
	
	public AvionPanel() {
		this.setBackground(Color.LIGHT_GRAY);
		this.setSize(width, height);
		this.icoAvion = new ImageIcon(getClass().getResource("/_ressources/usa.png"));
		this.imgAvion = this.icoAvion.getImage();
		this.setOpaque(false);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.imgAvion, 0, 0, null);
	}

	public ImageIcon getIcoAvion() {
		return icoAvion;
	}

	public Image getImgAvion() {
		return imgAvion;
	}

	public void setIcoAvion(ImageIcon icoAvion) {
		this.icoAvion = icoAvion;
	}

	public void setImgAvion(Image imgAvion) {
		this.imgAvion = imgAvion;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public static void setWidth(int width) {
		AvionPanel.width = width;
	}

	public static void setHeight(int height) {
		AvionPanel.height = height;
	}

	public void reset() {
		this.setLocation((CentrePanel.getLargeur() / 2) - (this.getWidth() / 2), CentrePanel.getHauteur() - this.getHeight());
	}
	
}
