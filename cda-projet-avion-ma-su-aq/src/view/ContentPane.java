package view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ContentPane extends JComponent {
	private Image theImage;

	public ContentPane(Image theFond) {
		theImage = theFond;
	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(theImage, 0, 0, null);
	}
}
