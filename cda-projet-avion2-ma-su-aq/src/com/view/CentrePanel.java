package com.view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.controller.Collision;
import com.model.Player;

public class CentrePanel extends JPanel {

	private static int width = 600;
	private static int heigth = 800;

	private ImageIcon icoFond;
	private Image imgFond;
	public int xFond;
	private final int HAUTEUR_FOND = 217;

	public CentrePanel() {
//		this.setBackground(Color.BLACK);
		this.setLayout(null);
//		this.setOpaque(false);
//
		this.icoFond = new ImageIcon(getClass().getResource("/_ressources/fond.png"));
		this.imgFond = this.icoFond.getImage();
		this.xFond = heigth - HAUTEUR_FOND;

		Random vRandom = new Random();

		MeteoriteSimplePanel m1 = new MeteoriteSimplePanel(5);
		this.add(m1);

		MeteoriteFeuPanel m2 = new MeteoriteFeuPanel(2);
		this.add(m2);

		MeteoriteSimplePanel m3 = new MeteoriteSimplePanel(4);
		this.add(m3);

		MeteoriteSimplePanel m4 = new MeteoriteSimplePanel(3);
		this.add(m4);

		AvionPanel a1 = new AvionPanel();
		a1.setLocation((width / 2) - (a1.getWidth() / 2), heigth - a1.getHeight());
		this.add(a1);

		a1.setFocusable(true);

		new Thread(new Runnable() {
			public void run() {
				while (true) {
					m1.setLocation(m1.getX(), (m1.getY() + m1.getVitesseDeplacement()) % heigth);
					if (sontEnCollision(m1, a1)) {
						Player.isHit(m1.getM().getDegat());
						Player.addPoints(m1.getM());
						a1.setImgAvion(new ImageIcon(getClass().getResource("/_ressources/explosion.gif")).getImage());
					}

					m1.repaint();
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();

		new Thread(new Runnable() {
			public void run() {
				while (true) {
					m2.setLocation(m2.getX(), (m2.getY() + m2.getVitesseDeplacement()) % heigth);
//					if (sontEnCollision(m2, a1)) {
//					a1.setIcoAvion(new ImageIcon(getClass().getResource("/_ressources/explosion.gif")));
//				}
					m2.repaint();
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();

		new Thread(new Runnable() {
			public void run() {
				while (true) {
					m3.setLocation(m3.getX(), (m3.getY() + m3.getVitesseDeplacement()) % heigth);
					if (sontEnCollision(m3, a1)) {
						Player.isHit(m1.getM().getDegat());
						Player.addPoints(m1.getM());
						a1.setImgAvion(new ImageIcon(getClass().getResource("/_ressources/explosion.gif")).getImage());
					}
					m3.repaint();
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();

		new Thread(new Runnable() {
			public void run() {
				while (true) {
					m4.setLocation(m4.getX(), (m4.getY() + m4.getVitesseDeplacement()) % heigth);
					if (sontEnCollision(m4, a1)) {
						Player.isHit(m1.getM().getDegat());
						Player.addPoints(m1.getM());
						a1.setImgAvion(new ImageIcon(getClass().getResource("/_ressources/explosion.gif")).getImage());
						//Arr�ter --> pop up fin game
					}
					m4.repaint();
					try {
						Thread.sleep(40);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();

		a1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				Player p = Player.getInstance();
				int step = 5;
				if (e.getKeyCode() == KeyEvent.VK_UP && a1.getY() > 0) {
					a1.setImgAvion(new ImageIcon(getClass().getResource("/_ressources/usa.png")).getImage());
					a1.setLocation(a1.getX(), a1.getY() - step);
					p.setPosY(a1.getY()-step);
					p.setPosX(a1.getX());
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN && a1.getY() < 800 - a1.getHeight()) {
					a1.setImgAvion(new ImageIcon(getClass().getResource("/_ressources/usa-Back.png")).getImage());
					a1.setLocation(a1.getX(), a1.getY() + step);
					p.setPosY(a1.getY()+step);
					p.setPosX(a1.getX());
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT && a1.getX() < 580 - a1.getWidth()) {
					a1.setImgAvion(new ImageIcon(getClass().getResource("/_ressources/usa32-R.png")).getImage());
					a1.setLocation(a1.getX() + step, a1.getY());
					p.setPosY(a1.getY());
					p.setPosX(a1.getX()+step);
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT && a1.getX() > 0) {
					a1.setImgAvion(new ImageIcon(getClass().getResource("/_ressources/usa32-L.png")).getImage());
					a1.setLocation(a1.getX() - step, a1.getY());
					p.setPosY(a1.getY());
					p.setPosX(a1.getX()-step);
				}
			}
		});

	}

	public static int getHauteur() {
		return heigth;
	}

	public static int getLargeur() {
		return width;
	}

	private static boolean sontEnCollision(MeteoriteSimplePanel pMeteorite, AvionPanel pAvion) {
		Point mA = new Point(pMeteorite.getX(), pMeteorite.getY());
		Point mB = new Point(pMeteorite.getX() + pMeteorite.getWidth(), pMeteorite.getY());
		Point mC = new Point(pMeteorite.getX() + pMeteorite.getWidth(), pMeteorite.getY() + pMeteorite.getHeight());
		Point mD = new Point(pMeteorite.getX(), pMeteorite.getY() + pMeteorite.getHeight());

		Point aA = new Point(pAvion.getX(), pAvion.getY());
		Point aB = new Point(pAvion.getX() + pAvion.getWidth(), pAvion.getY());
		Point aC = new Point(pAvion.getX() + pAvion.getWidth(), pAvion.getY() + pAvion.getHeight());
		Point aD = new Point(pAvion.getX(), pAvion.getY() + pAvion.getHeight());

		return (mC.getX() < aB.getX() && mC.getX() > aA.getX() && mC.getY() > aA.getY() && mC.getY() < aD.getY())
				|| (mD.getX() < aB.getX() && mD.getX() > aA.getX() && mD.getY() > aA.getY() && mD.getY() < aD.getY());
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(this.imgFond, 0, 800 - this.HAUTEUR_FOND, null);
		g.drawImage(this.imgFond, 0, 800 - (this.HAUTEUR_FOND * 2), null);
		g.drawImage(this.imgFond, 0, 800 - (this.HAUTEUR_FOND * 3), null);
		g.drawImage(this.imgFond, 0, 800 - (this.HAUTEUR_FOND * 4), null);
	}

}
