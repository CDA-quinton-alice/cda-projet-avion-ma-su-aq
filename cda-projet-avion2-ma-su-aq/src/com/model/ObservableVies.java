package com.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.Timer;

import com.view.ViewVies;

public class ObservableVies extends Observable implements ActionListener{
	private int vies;
	private boolean hit = false;
	private boolean menu = true;
	
	public ObservableVies() {
		addObserver(ViewVies.getInstance());
		this.vies = 5;
		
		Timer t  = new Timer(1000,this);
		t.start();
	}
	
	public void getHit(int i) {
		
		if(!hit) {
			vies -= i;
			this.hit = true;
			if(vies<0) {
				vies = 0;
			}
		}
		setChanged();
		notifyObservers();
		if(vies<=0 && menu) {
			Player.setAlive(false);
			Player.menuEnd();
			vies = 0;
			menu = false;
		}
	}
	
	public void reset() {
		vies = 5;
		setChanged();
		notifyObservers();
	}
	public int getVies() {
		return vies;
	}
	
	public boolean isDead() {
		return vies == 0;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.hit = false;
		
	}
}
