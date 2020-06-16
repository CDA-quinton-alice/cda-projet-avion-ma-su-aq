package view;

import javax.swing.JLabel;
import model.Player;

public class ViewVies extends JLabel{
	public static ViewVies INSTANCE = null;
	
	private ViewVies() {
		super("Vies : "+Player.getVies());
		setName("vies");
		
	}
	
	public static ViewVies getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new ViewVies();
		}
		return INSTANCE;
	}
	
	
	public void updateVies() {
		this.setText("Vies : "+Player.getVies());
	}
	
}
