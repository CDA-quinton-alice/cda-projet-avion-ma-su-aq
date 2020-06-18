package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Player;

public class FenetreFinJeu extends JFrame {

//	CardLayout c1 = new CardLayout(); --> finalement je me suis rendue compte que ça servait à rien mais je vous montre le début quand même
//	JPanel content = new JPanel(); 
//	String[] listContent = {"CARD_1", "CARD_2", "CARD_3", "CARD_4"};
//	int indice = 0;
	
	public FenetreFinJeu() {
		this.setName("Partie terminée");
		this.setSize(300, 120);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	
//		JLayeredPane card1 = new JLayeredPane();
//		card1.setBackground(Color.darkGray);
//		JLayeredPane card2 = new JLayeredPane();
//		card2.setBackground(Color.ORANGE);
//		JLayeredPane card3 = new JLayeredPane(); 
//		card3.setBackground(Color.GREEN);
		
		JPanel panelDuBoutonNouvellePartie = new JPanel();
		JButton boutonNouvellePartie = new JButton("Nouvelle Partie");
		boutonNouvellePartie.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!Player.isAlive()) { // et modifier la méthode ligne 40 dans SpriteJoueur ?
											// réflexivité ?
					
				} else {

				}
				
			}
			
		});
		
		JPanel panelDuBoutonAfficherScores = new JPanel();
		JButton boutonAfficherScores = new JButton ("Afficher Scores");
		boutonAfficherScores.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) { // du coup on convertit le fichier nom + le fichier scores puis on le recrache là avec les 
														// 20 derniers qui s'actualisent au fur et à mesure de la progression c'est ça ? Bon ma migraine s'agrave là ^^
				// TODO Auto-generated method stub 				
			}
			
		});
		
		JPanel panelDuBoutonQuitterJeu = new JPanel();
		JButton boutonQuitterJeu = new JButton ("Quitter le jeu");
		boutonQuitterJeu.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0); // je sais pas si c'est ça du tout hein à l'origine j'ai vu ça sur un addWindowsListener(new WindowsAdapter() puis la méthode override WindowsClosing(WindowsEvent e)
			}
			
		});
		
		panelDuBoutonNouvellePartie.add(boutonNouvellePartie);
		panelDuBoutonAfficherScores.add(boutonAfficherScores);
		panelDuBoutonQuitterJeu.add(boutonQuitterJeu);
		
		this.getContentPane().add(panelDuBoutonNouvellePartie, BorderLayout.NORTH);
		this.getContentPane().add(panelDuBoutonAfficherScores, BorderLayout.CENTER);
		this.getContentPane().add(panelDuBoutonQuitterJeu, BorderLayout.SOUTH);
		this.setVisible(true);
		
		
	}
	
}
