package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import controller.Collision;
import model.Meteorite;
import model.Player;

public class ViewTest extends JFrame implements ActionListener{
	SpriteJoueur player;
	ViewVies vies;
	public ViewTest() {
		JPanel c = new JPanel();
		c.setLayout(new BorderLayout());
		
		JPanel jpvies = new JPanel();
		jpvies.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		Player p = Player.getInstance();
		player = new SpriteJoueur(Player.getSprite(),Player.getPosX(),Player.getPosY(),p.getWidth(), p.getHeight());
		c.add(player, BorderLayout.CENTER);
		
		
		vies = ViewVies.getInstance();
		gc.gridx = 0;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.NORTHWEST;
        gc.insets = new Insets(2, 0, 0, 2);
        jpvies.add(vies, gc);
		c.add(vies, BorderLayout.NORTH);		

		this.setTitle("Blblb");
		this.setName("blblb");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(800,600));
		this.setPreferredSize(new Dimension(800,600));
		this.setLocationRelativeTo( null );
		this.setResizable(false);
		this.setLocation(150,150);
		this.getContentPane().add(c); 
		this.pack();
		this.setVisible(true);
		
		Timer t = new Timer(500,this);
		t.start();
	}
	
	public static void main(String args[]) {
		ViewTest vt = new ViewTest();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		vies.setText("Vies : "+Player.getVies());
		List<Meteorite> meteores = new ArrayList<>();
		
		if(Player.isAlive()) {
			for(Meteorite m : meteores) {
				if(Collision.checkCollision(m)) {
					Player.isHit();
				}
			}
		}
	}
}

