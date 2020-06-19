package com.model;

import java.util.Observable;

import com.view.ViewVies;

public class ObservableVies extends Observable{
	private int vies;
	
	public ObservableVies() {
		addObserver(ViewVies.getInstance());
		this.vies = 5;
	}
	
	public void getHit(int i) {
		vies -= i;
		setChanged();
		notifyObservers();
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
}
