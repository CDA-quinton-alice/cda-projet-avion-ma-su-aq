package FenetreJeu;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Image;
import java.awt.Panel;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;

import model.Player;
import view.SpriteJoueur;



public class Frame extends JFrame {
	private Image fondGalaxie;
	public Frame (String JeuBattleFront) {
		super("Frame");
		Image fondGalaxie = null;
		URL urlGalaxie = getClass().getResource("/_ressources/galaxie.jpg");
		try {
			fondGalaxie = ImageIO.read(urlGalaxie); // parce que l'image fondGalaxie ici = à l'urlGalaxie déjà déclarée au dessus
			fondGalaxie = fondGalaxie.getScaledInstance(1200, 700, Image.SCALE_SMOOTH);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		setTitle(JeuBattleFront);
		setSize(1200,700);// largeur, hauteur en px 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);// du coup on peut pas redimensionner la fenêtre et pas tout casser le jeu gniark gniark
		setLocationRelativeTo(null);//afficher la fenêtre au milieu de l'écran actif au lancement
		Panel p = new Panel();
		p.add(new JLabel("Battlefront"));
		getContentPane().add(p);// ajouter un nouveau panel/ paneau après avoir importé Panel qui hérite de JPanel
		Container conteneur = this.getContentPane();
		conteneur.setLayout(new BorderLayout(10,10));
		Player joueur = Player.getInstance();
		SpriteJoueur cocaJoueur = new SpriteJoueur(joueur.getSprite(),joueur.getPosX(),joueur.getPosY(), joueur.getWidth(), joueur.getHeight());
		conteneur.add(cocaJoueur);
		setContentPane(new ContentPane(fondGalaxie));
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Frame("Dans une galaxie lointaine, très lointaine...");
	}
}
