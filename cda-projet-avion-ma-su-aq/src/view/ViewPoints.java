package view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

import model.ObservablePoints;
import model.ObservableVies;
import model.Player;


public class ViewPoints extends JLabel implements Observer{
	public static ViewPoints INSTANCE = null;
	
	private ViewPoints() {
		super("Points : "+0);
		setName("points");
	}
	
	public static ViewPoints getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new ViewPoints();
		}
		return INSTANCE;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof ObservablePoints) {
			this.setText("Points : "+Player.getInstance().getPoints().getPoints());
		}
	}

	

}
