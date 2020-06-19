package com.model;

import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.view.AvionPanel;
import com.view.CdaFenetre;
import com.view.CentrePanel;

public class Player {
	private static boolean menu = true;
	private static String name;
	private static int posX;
	private static int posY;
	private int width;
	private int height;
	private static AvionPanel avion;
	private static Player INSTANCE = null;
	private static boolean alive;
	private static ObservableVies vies;
	private static ObservablePoints points;
	
	private Player() {
		posX = 250;
		posY = 250;
		alive = true;
		vies = new ObservableVies();
		points = new ObservablePoints();
		this.width = 50;
		this.height = 50;
	}

	public static Player getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new Player();
		}
		return INSTANCE;
	}
	
	
	
	public static String getName() {
		return name;
	}

	public static int getPosX() {
		return posX;
	}

	public static int getPosY() {
		return posY;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	public ObservablePoints getPoints() {
		return points;
	}

	public static boolean isAlive() {
		return alive;
	}

	public ObservableVies getVies() {
		return vies;
	}
	
	public static void isHit(int i) {
		vies.getHit(i);
		if(vies.isDead()) {
			setAlive(false);			
		}
	}
	
	public static void menuEnd() {
		JOptionPane d = new JOptionPane();
		String lesTextes[] = {"Recommencer","Voir les scores","Quitter"};
		int retour = d.showOptionDialog(null,"Vous avez perdu", "Avion v2", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null,lesTextes,lesTextes[0]);
		
		if(retour == 0) {
			reset();
			menu = false;
		}else if(retour == 1) {
			JFrame tableauScore = new JFrame();
			tableauScore.setSize(50,70);
			tableauScore.setLocation(CdaFenetre.getInstance().getX(), CdaFenetre.getInstance().getY());
			tableauScore.setTitle("Tableau des scores");
			JPanel panel  = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			panel.setBorder(new EmptyBorder(new Insets(50,70,50,70)));
			
			JDialog jd = new JDialog();
			
			for(String s : CdaFenetre.getScores()) {
				String str = s.split(";")[0]+" "+s.split(";")[1]+s.split(";")[2];
				panel.add(new JLabel(str));
			}
			
			tableauScore.addWindowListener(new WindowAdapter() {

				@Override
				public void windowClosing(WindowEvent arg0) {
					((Window) arg0.getComponent()).dispose();
					menuEnd();
				}
				
			});
			tableauScore.add(panel);
			tableauScore.pack();
			tableauScore.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			tableauScore.setVisible(true);
			
		}else if(retour == 2) {
			menu = false;
			System.exit(0);
		}
	}
	public static void reset() {
		vies.reset();
		points.reset();
		avion.reset();
	}
	
	public static void addPoints(Meteorite m) {
		points.addPoints(m);
	}
	
	public static void setAlive(boolean pAlive) {
		alive = pAlive;
	}

	public static void setPosX(int pX) {
		posX = pX;
	}

	public static void setPosY(int pY) {
		posY = pY;
	}

	public static void setName(String name) {
		Player.name = name;
	}

	public Rectangle getBounds() {
		return new Rectangle(posX,posY,width,height);
	}

	public void addAvion(AvionPanel a1) {
		avion = a1;
		
	}
}
