package com.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class HautPanel extends JPanel {

	public HautPanel() {
		this.setBackground(Color.BLACK);

		JLabel label = new JLabel("APOLLO   CDA");

		label.setFont(new Font("Arial", Font.ITALIC, 40));
		label.setForeground(Color.YELLOW);
		label.setOpaque(false);

		this.add(label);

	}

}
