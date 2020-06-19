package com.view;

import java.awt.BorderLayout;
import java.awt.Image;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.model.Player;

public class CdaFenetre extends JFrame {

	private File listeScore;
	
	public CdaFenetre() {
		setupFichierScore();
		demanderNom();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 800);
		this.setLocationRelativeTo(null);
		this.setTitle("titre");

		this.setResizable(false);
		
		this.setLayout(new BorderLayout());

		this.getContentPane().add(new HautPanel(), BorderLayout.NORTH);
		this.getContentPane().add(new CentrePanel(), BorderLayout.CENTER);
		this.getContentPane().add(new BasPanel(), BorderLayout.SOUTH);

		this.setVisible(true);
		
		ecrireScores();
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
				}else {
					score.createNewFile();
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
}
