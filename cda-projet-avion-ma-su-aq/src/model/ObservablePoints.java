package model;

import java.util.Observable;

import view.ViewPoints;

public class ObservablePoints extends Observable{
	private int points;
	
	public ObservablePoints() {
		addObserver(ViewPoints.getInstance());
		this.points = 0;
	}
	
	public int getPoints() {
		return this.points;
	}
	
	public void addPoints(Meteorite m) {
		if(m instanceof MeteoriteSimple) {
			points += 2;
		}else if(m instanceof MeteoriteDeGlace) {
			points += 3;
		}else if(m instanceof MeteoriteDeFeu) {
			points += 1;
		}
		
		if(points >= 999) {
			points = 999;
		}
		setChanged();
		notifyObservers();
	}
	
}