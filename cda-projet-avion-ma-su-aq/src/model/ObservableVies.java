package model;

import java.util.Observable;

import view.ViewVies;

public class ObservableVies extends Observable{
	private int vies;
	
	public ObservableVies() {
		addObserver(ViewVies.getInstance());
		this.vies = 5;
	}
	
	public void getHit() {
		vies--;
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
