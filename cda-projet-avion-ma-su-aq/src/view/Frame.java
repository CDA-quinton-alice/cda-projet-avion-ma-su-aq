package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import model.Player;

public class Frame extends JLayeredPane {

	private Image fondGalaxie;

	public Frame(String JeuBattleFront) {
		Image fondGalaxie = null;
		URL urlGalaxie = getClass().getResource("/_ressources/galaxie.jpg");
		try {
			fondGalaxie = ImageIO.read(urlGalaxie); // parce que l'image fondGalaxie ici = à l'urlGalaxie déjà déclarée
													// au dessus
			fondGalaxie = fondGalaxie.getScaledInstance(1200, 700, Image.SCALE_SMOOTH);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		this.setPreferredSize(new Dimension(1200,700));
		
		ContentPane p = new ContentPane(fondGalaxie);
		p.setSize(this.getPreferredSize());
		
		//Player
		Player joueur = Player.getInstance();
		SpriteJoueur cocaJoueur = new SpriteJoueur(Player.getSprite(), Player.getPosX(), Player.getPosY(),joueur.getWidth(), joueur.getHeight());
		cocaJoueur.setOpaque(false);
		cocaJoueur.setSize(this.getPreferredSize());
		
		//Vies
		ViewVies vv = ViewVies.getInstance();
		vv.setForeground(Color.WHITE);
		JPanel vies = new JPanel();
		vies.setOpaque(false);
		vies.add(vv);
		vies.setSize(100,50);
		
		
		
		//Ajout des panel
		this.add(p,JLayeredPane.DEFAULT_LAYER);
		this.add(cocaJoueur,JLayeredPane.PALETTE_LAYER);
		this.add(vies, JLayeredPane.MODAL_LAYER);

		
		
		JFrame frame = new JFrame(JeuBattleFront);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(this);
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		new Frame("BattleFront");
	}
}
