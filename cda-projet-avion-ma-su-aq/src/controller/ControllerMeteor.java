package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;

import model.Meteorite;
import model.MeteoriteSimple;
import view.SpriteMeteor;

public class ControllerMeteor implements ActionListener {
	private ArrayList<Meteorite> listeM = new ArrayList<>();
	private SpriteMeteor spm;
	
	
	public ControllerMeteor(ArrayList<Meteorite> pListe , SpriteMeteor pSM) {

	
	}
	
	MeteoriteSimple ms1 = new MeteoriteSimple(100, 0);
	MeteoriteSimple ms2 = new MeteoriteSimple(150, 0);
	MeteoriteSimple ms3 = new MeteoriteSimple(200, 0);
	Timer t = new Timer();

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
