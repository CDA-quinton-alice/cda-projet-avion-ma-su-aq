package com.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.Timer;

import com.view.ViewVies;

public class ObservableVies extends Observable implements ActionListener{
	private int vies;
	private boolean hit = false;
	
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
			setChanged();
			notifyObservers();
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
