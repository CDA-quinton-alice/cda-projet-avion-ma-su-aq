package view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;


public class ViewPoints extends JLabel implements Observer{
	public static ViewPoints INSTANCE = null;
	
	private ViewPoints() {
		
	}
	public ViewPoints getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new ViewPoints();
		}
		return INSTANCE;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	

}
