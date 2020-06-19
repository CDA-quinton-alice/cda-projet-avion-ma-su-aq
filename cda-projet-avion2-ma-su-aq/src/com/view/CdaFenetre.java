package com.view;

import java.awt.BorderLayout;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.model.Player;

public class CdaFenetre extends JFrame {

	private File listeScore;
	private static CdaFenetre INSTANCE;
	private ArrayList<String> scores;
	
	private CdaFenetre() {
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
		
		lireScores();
		ecrireScores();
		
	}
	
	
	public static CdaFenetre getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new CdaFenetre();
		}
		return INSTANCE;
	}
	
	private void setupFichierScore(){
		scores = new ArrayList<>();
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
					FileWriter myWriter = new FileWriter(listeScore.getAbsoluteFile());
					myWriter.flush();
					myWriter.close();
				}
				
			}
		}catch(IOException e) {
			System.out.println("An error occurred");
			e.printStackTrace();
		}
	}
	
	public void lireScores() {
		try {
			BufferedReader r = new BufferedReader(new FileReader(listeScore.getAbsoluteFile()));
			String str = r.readLine();
			while(str != null){
				scores.add(str);
				str = r.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void ecrireScores() {
		try {
			FileWriter mfw = new FileWriter(listeScore.getAbsoluteFile());
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
			if(scores.size()>=20) {
				while(scores.size()>=20) {
					scores.remove(0);
				}
			}
			scores.add(Player.getInstance().getName()+";"+Player.getInstance().getPoints().getPoints()+";"+sdf.format(new Date()));
			scores.stream().forEach((x)->{
				try {
					mfw.write("\n"+x);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
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
