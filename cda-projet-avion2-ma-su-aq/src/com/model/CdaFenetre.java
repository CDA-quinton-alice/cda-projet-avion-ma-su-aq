package com.model;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class CdaFenetre extends JFrame {

	public CdaFenetre() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 800);
		this.setLocationRelativeTo(null);
		this.setTitle("titre");

		this.setResizable(false);
		
		this.setLayout(new BorderLayout());

		this.getContentPane().add(new HautPanel(), BorderLayout.NORTH);
		this.getContentPane().add(new CentrePanel(), BorderLayout.CENTER);
		this.getContentPane().add(new BasPanel(), BorderLayout.SOUTH);

		this.setVisible(true);
		
	
	}
}
