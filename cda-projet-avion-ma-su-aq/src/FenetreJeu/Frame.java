package FenetreJeu;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JLabel;

import model.Player;
import view.SpriteJoueur;



public class Frame extends JFrame {

	public Frame (String JeuBattleFront) {
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
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Frame("bonjour");
	}
}
