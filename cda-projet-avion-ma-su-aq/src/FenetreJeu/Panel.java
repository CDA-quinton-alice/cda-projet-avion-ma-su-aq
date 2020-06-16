package FenetreJeu;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class Panel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	Image avion;
	URL url = getClass().getResource("/_ressources/xwing.png");

	public Panel() {
		JLabel etiquette = new JLabel ();
		add(etiquette);
		setVisible(true);
		Image avion;
		URL url = getClass().getResource("/_ressources/xwing.png");
		this.addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
	}
		
		}
		
	
		
		
	

