package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import controller.Collision;
import model.Meteorite;
import model.MeteoriteSimple;
import model.Player;

public class Frame extends JLayeredPane{

	private Image fondGalaxie;
	public static final int WIDTH = 1200;
	public static final int HEIGHT = 700;
	private File listeScore;

	public Frame(String JeuBattleFront) {
		
		setupFichierScore();
		setupImage();
		demanderNom();
		this.setPreferredSize(new Dimension(1200,700));
		
		ContentPane p = new ContentPane(fondGalaxie);
		p.setSize(this.getPreferredSize());
		
		
		//Player
		Player joueur = Player.getInstance();
		SpriteJoueur joueurPan = new SpriteJoueur(Player.getSprite(), Player.getPosX(), Player.getPosY(),joueur.getWidth(), joueur.getHeight());
		joueurPan.setOpaque(false);
		joueurPan.setSize(this.getPreferredSize());
		
		//Vies
		ViewVies vv = ViewVies.getInstance();
		vv.setForeground(Color.WHITE);
		JPanel infos = new JPanel();
		infos.setLayout(new BorderLayout());
		infos.setOpaque(false);
		infos.add(vv, BorderLayout.WEST);
		infos.setSize(WIDTH,20);
		
		//Points
		ViewPoints vp = ViewPoints.getInstance();
		vp.setForeground(Color.WHITE);
		infos.add(vp, BorderLayout.EAST);
		infos.setOpaque(false);
		ecrireScores();
		
		//Ajout des panel
		this.add(p,JLayeredPane.DEFAULT_LAYER);
		this.add(joueurPan, JLayeredPane.PALETTE_LAYER);
		this.add(infos, JLayeredPane.MODAL_LAYER);
		
		JFrame frame = new JFrame(JeuBattleFront);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(this);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}
	

	private void setupFichierScore(){
		try {
			String cTemp = System.getenv("temp");
			if(cTemp.isEmpty()) {
				cTemp = System.getenv("tmp");
			}
			File dirCTemp = new File(cTemp);
			if(dirCTemp.exists()) {
				File dirScore = new File(dirCTemp.getAbsolutePath()+"\\cda-projet-avion-ma-su-aq");
				dirScore.mkdir();
				File score = new File(dirScore.getAbsolutePath()+"\\score.txt");
				
				if(score.exists()) {
					listeScore = score;
				}
				
				FileWriter myWriter = new FileWriter(listeScore.getAbsoluteFile());
				myWriter.flush();
				myWriter.write("Liste des scores ");
				myWriter.close();
				
			}
		}catch(IOException e) {
			System.out.println("An error occurred");
			e.printStackTrace();
		}
	}

	public void setupImage() {
		fondGalaxie = null;
		URL urlGalaxie = getClass().getResource("/_ressources/galaxie.jpg");
		try {
			fondGalaxie = ImageIO.read(urlGalaxie); // parce que l'image fondGalaxie ici = à l'urlGalaxie déjà déclarée
													// au dessus
			fondGalaxie = fondGalaxie.getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void ecrireScores() {
		try {
			FileWriter mfw = new FileWriter(listeScore.getAbsoluteFile(), true);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
			mfw.write("\n"+Player.getInstance().getName()+";"+Player.getInstance().getPoints().getPoints()+";"+sdf.format(new Date()));
			mfw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void demanderNom() {
		String nom = "";
		while(!nom.matches("[a-zA-Z\\s]{3,6}")) {
			nom = (String)JOptionPane.showInputDialog(
					this,
					"Entrez votre nom pour les scores :",
					"Scores",
					JOptionPane.QUESTION_MESSAGE
				);
		}
		
		Player.setName(nom);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		new Frame("BattleFront");
	}
}
