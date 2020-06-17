package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Collision;
import model.Meteorite;
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
		this.setPreferredSize(new Dimension(Frame.WIDTH, Frame.HEIGHT));
		this.setFocusable(true);
		this.addKeyListener(this);
	}
	
	public boolean playerDead() {
		if(!Player.isAlive()) {
			sprite = Player.getSprite();
			this.removeKeyListener(this);
			this.repaint();
			return true;
		}
		return false;
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
	}


	@Override
	public void keyPressed(KeyEvent e) {
		if(!playerDead()) {
			System.out.println(Player.getInstance().getBounds());
			
			Collision.checkCollision();
			
			int keyCode = e.getKeyCode();
			
			switch(keyCode) {
			case KeyEvent.VK_UP:
				if(Player.getPosY() == 0) {
//					Player.setPosY(0);
					Player.isHit(1);
				}else {
					Player.setPosY(Player.getPosY()-10);
				}
				break;
			case KeyEvent.VK_DOWN:
				if(Player.getPosY()>=Frame.HEIGHT-60) {
					Player.setPosY(Frame.HEIGHT-60);
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
				if(Player.getPosX()>=Frame.WIDTH-60) {
					Player.setPosX(Frame.WIDTH-60);
				}else {
					Player.setPosX(Player.getPosX()+10);
				}
				break;
			}
			this.x = Player.getPosX();
			this.y = Player.getPosY();
			this.repaint();
		}
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
