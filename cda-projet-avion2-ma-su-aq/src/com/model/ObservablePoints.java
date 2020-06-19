package com.model;

import java.util.Observable;

import com.model.Meteorite;
import com.model.MeteoriteDeFeu;
import com.model.MeteoriteDeGlace;
import com.model.MeteoriteSimple;
import com.view.ViewPoints;


public class ObservablePoints extends Observable{
	private int points;
	
	public ObservablePoints() {
		addObserver(ViewPoints.getInstance());
		this.points = 0;
	}
	
	public int getPoints() {
		return this.points;
	}
	
	public void reset() {
		this.points = 0;
		setChanged();
		notifyObservers();
	}
	
	public void addPoints(Meteorite m) {
		if(m instanceof MeteoriteSimple) {
			points += 2;
		}else if(m instanceof MeteoriteDeGlace) {
			points += 3;
		}else if(m instanceof MeteoriteDeFeu) {
			points += 1;
		}else if(m instanceof MeteoriteIceberg) {
			points += 5;
		}else if(m instanceof MeteoriteZigZag) {
			points += 5;
		}
		
		if(points >= 999) {
			points = 999;
		}
		
		setChanged();
		notifyObservers();
	}
	
}
