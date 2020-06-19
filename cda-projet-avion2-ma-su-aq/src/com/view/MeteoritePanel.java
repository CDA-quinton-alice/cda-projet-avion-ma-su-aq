package com.view;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.controller.ControllerMeteor;
import com.controller.ControllerMeteor.EnumMeteor;
import com.model.Meteorite;
import com.model.MeteoriteDeFeu;
import com.model.MeteoriteDeGlace;
import com.model.MeteoriteSimple;
import com.model.MeteoriteZigZag;
import com.model.Player;

public class MeteoritePanel extends JPanel implements IMeteorite {

	private final int vitesseDeplacement;
	private ImageIcon icoMS;
	private Image imgMS;
	private Meteorite m;
	private boolean zag = false;
	private int nbZag = 0;

	public MeteoritePanel(int pVitesseDeplacement) {
		this.vitesseDeplacement = pVitesseDeplacement;
		EnumMeteor nm = ControllerMeteor.randomMeteor();
		switch (nm) {
		case NORMALE:
			this.icoMS = new ImageIcon(getClass().getResource("/_ressources/ms.gif"));
			this.imgMS = this.icoMS.getImage();
			this.setSize(60, 60);
			m = new MeteoriteSimple(this.getX(), this.getY());
			break;
		case FEU:
			this.icoMS = new ImageIcon(getClass().getResource("/_ressources/mFeu.gif"));
			this.imgMS = this.icoMS.getImage();
			this.setSize(150, 150);
			m = new MeteoriteDeFeu(this.getX(), this.getY());
			break;
		case GLACE:
			this.icoMS = new ImageIcon(getClass().getResource("/_ressources/glace.gif"));
			this.imgMS = this.icoMS.getImage();
			this.setSize(75, 120);
			m = new MeteoriteDeGlace(this.getX(), this.getY());
			break;
		case ICE:
			this.icoMS = new ImageIcon(getClass().getResource("/_ressources/iceberg.gif"));
			this.imgMS = this.icoMS.getImage();
			this.setSize(150, 240);
			m = new MeteoriteDeFeu(this.getX(), this.getY());
			break;
		case ZIGZAG:
			this.icoMS = new ImageIcon(getClass().getResource("/_ressources/ms.gif"));
			this.imgMS = this.icoMS.getImage();
			this.setSize(60, 60);
			m = new MeteoriteZigZag(this.getX(), this.getY());
			break;
		}

		this.setOpaque(false);

		Random vRandom = new Random();
		int i = vRandom.nextInt(CentrePanel.getLargeur() - this.getWidth() - 10) + 10;
		int j = vRandom.nextInt(75);
		this.setLocation(i, 0 - j);
	}

	public int getVitesseDeplacement() {
		return vitesseDeplacement;
	}

	public void randomMeteorite() {
		EnumMeteor nm = ControllerMeteor.randomMeteor();
		switch (nm) {
		case NORMALE:
			this.icoMS = new ImageIcon(getClass().getResource("/_ressources/ms.gif"));
			this.imgMS = this.icoMS.getImage();
			this.setSize(60, 60);
			m = new MeteoriteSimple(this.getX(), this.getY());
			break;
		case FEU:
			this.icoMS = new ImageIcon(getClass().getResource("/_ressources/mFeu.gif"));
			this.imgMS = this.icoMS.getImage();
			this.setSize(150, 150);
			m = new MeteoriteDeFeu(this.getX(), this.getY());
			break;
		case GLACE:
			this.icoMS = new ImageIcon(getClass().getResource("/_ressources/glace.gif"));
			this.imgMS = this.icoMS.getImage();
			this.setSize(75, 120);
			m = new MeteoriteDeGlace(this.getX(), this.getY());
			break;
		case ICE:
			this.icoMS = new ImageIcon(getClass().getResource("/_ressources/iceberg.gif"));
			this.imgMS = this.icoMS.getImage();
			this.setSize(150, 240);
			m = new MeteoriteDeFeu(this.getX(), this.getY());
			break;
		case ZIGZAG:
			this.icoMS = new ImageIcon(getClass().getResource("/_ressources/ms.gif"));
			this.imgMS = this.icoMS.getImage();
			this.setSize(60, 60);
			m = new MeteoriteZigZag(this.getX(), this.getY());
			break;
		}

		Player.addPoints(m);
		this.setLocation(new Random().nextInt(CentrePanel.getLargeur() - this.getWidth() - 10), this.getY());
	}

	public Meteorite getM() {
		return this.m;
	}


	public void reset() {
		Random vRandom = new Random();
		int i = vRandom.nextInt(CentrePanel.getLargeur() - this.getWidth() - 10) + 10;
		int j = vRandom.nextInt(75);
		this.setLocation(i, 0 - j);
		Player.addPoints(m);
		this.randomMeteorite();
		
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.imgMS, 0, 0, null);
	}

	@Override
	public void move() {
		if(m instanceof MeteoriteZigZag) {
			if(zag) {
				if(nbZag>=10) {
					zag = false;
					nbZag = 0;
				}else {
					this.setLocation(this.getX()+this.getVitesseDeplacement(), (this.getY() + this.getVitesseDeplacement()) % CentrePanel.getHauteur());
					nbZag++;
				}
			}else {
				if(nbZag>=10) {
					zag = true;
					nbZag = 0;
				}else {
					this.setLocation(this.getX()-this.getVitesseDeplacement(), (this.getY() + this.getVitesseDeplacement()) % CentrePanel.getHauteur());
					nbZag++;
				}
			}
		}else {
			this.setLocation(this.getX(), (this.getY() + this.getVitesseDeplacement()) % CentrePanel.getHauteur());
		}
	}
}
