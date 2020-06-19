package com.view;

import com.model.Meteorite;

public interface IMeteorite {

	int getX();

	int getY();

	int getVitesseDeplacement();

	void setLocation(int x, int i);

	int getWidth();

	int getHeight();

	Meteorite getM();

	void reset();

	void repaint();

	void move();
}
