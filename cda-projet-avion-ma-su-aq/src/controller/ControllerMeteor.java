package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import model.Meteorite;
import model.MeteoriteDeFeu;
import model.MeteoriteSimple;
import view.SpriteMeteor;

public class ControllerMeteor implements ActionListener {
	private int nbDeMeteor = 4;
	private int delay;

	private SpriteMeteor sm;

	private static ArrayList<Meteorite> listeMeteor;

	public enum EnumMeteor {
		NORMALE, FEU, GLACE, ICE, ZIGZAG
	};

	// tiutes les s --> meteor générée
	public ControllerMeteor() {
		listeMeteor = new ArrayList<>();

		
	}

	public Meteorite generateMeteor() {
		Meteorite m = null;
		if (listeMeteor.size() < nbDeMeteor) {
			EnumMeteor enumM = randomMeteor();
			if (enumM == EnumMeteor.NORMALE) {
				m = new MeteoriteSimple(new Random().nextInt(1200), 0);
				listeMeteor.add(m);
			}
			if (enumM == EnumMeteor.FEU) {
				m = new MeteoriteDeFeu(new Random().nextInt(1200), 0);
				listeMeteor.add(m);
			}
//			if (enumM == EnumMeteor.GLACE) {
//				m = new MeteoriteDeGlace(new Random().nextInt(1200), 0);
//				listeMeteor.add(m);
//			}
		}
		return m;
	}

//	Timer t = new Timer(delay , this);

	private EnumMeteor randomMeteor() {
		int pick = new Random().nextInt(EnumMeteor.values().length);
		return EnumMeteor.values()[pick];
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
}
