package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import model.Player;

public class SpriteJoueur extends JPanel implements KeyListener{
	
	private Image sprite;
	private int x;
	private int y;
	private int width;
	private int height;
	
	
	public SpriteJoueur(Image pSprite, int pX, int pY, int pWidth, int pHeight) {
		this.sprite = pSprite;
		this.x = pX;
		this.y = pY;
		this.width = pWidth;
		this.height = pHeight;
		this.setPreferredSize(new Dimension(this.width, this.height));
		this.setFocusable(true);
		this.addKeyListener(this);
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (sprite != null) {
            g.drawImage(sprite, x, y, this);
        }
    }
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		switch(keyCode) {
		case KeyEvent.VK_UP:
			if(Player.getPosY()<9) {
				Player.setPosY(0);
			}else {
				Player.setPosY(Player.getPosY()-10);
			}
			break;
		case KeyEvent.VK_DOWN:
			if(Player.getPosY()>=520) {
				Player.setPosY(520);
			}else {
				Player.setPosY(Player.getPosY()+10);
			}
			break;
		case KeyEvent.VK_LEFT:
			if(Player.getPosX()<9) {
				Player.setPosX(0);
			}else {
				Player.setPosX(Player.getPosX()-10);
			}
			break;
		case KeyEvent.VK_RIGHT:
			if(Player.getPosX()>=740) {
				Player.setPosX(740);
			}else {
				Player.setPosX(Player.getPosX()+10);
			}
			break;
		}
		this.x = Player.getPosX();
		this.y = Player.getPosY();
		this.repaint();
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
