package com.model;

import java.awt.Color;

public enum CdaCouleur {
	Rouge(Color.RED), VERT(Color.GREEN), BLEU(Color.BLUE);

	private final Color couleur;

	private CdaCouleur(Color pCouleur) {
		this.couleur = pCouleur;
	}

	public Color getCouleur() {
		return couleur;
	}

}
