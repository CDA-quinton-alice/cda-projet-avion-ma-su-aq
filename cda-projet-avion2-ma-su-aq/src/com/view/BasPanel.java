package com.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class BasPanel extends JPanel {

	public BasPanel() {
		this.setLayout(new BorderLayout());
		this.add(ViewVies.getInstance(), BorderLayout.WEST);
		this.add(ViewPoints.getInstance(), BorderLayout.EAST);
	}

}
