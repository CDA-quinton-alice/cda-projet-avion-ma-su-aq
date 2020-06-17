package view;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

import model.ObservableVies;
import model.Player;

public class ViewVies extends JLabel implements Observer{
	public static ViewVies INSTANCE = null;
	
	private ViewVies() {
		super("Vies :"+5);
		setName("vies");
		
	}
	
	public static ViewVies getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new ViewVies();
		}
		return INSTANCE;
	}
	

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof ObservableVies) {
			this.setText("Vies : "+Player.getInstance().getVies().getVies());
		}
		
	}
	
}
