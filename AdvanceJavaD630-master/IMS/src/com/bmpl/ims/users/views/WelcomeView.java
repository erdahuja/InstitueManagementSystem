package com.bmpl.ims.users.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class WelcomeView extends JFrame {

	
	public static void main(String[] args) {
		
					WelcomeView frame = new WelcomeView();
					frame.setVisible(true);
				
	}

	/**
	 * Create the frame.
	 */
	public WelcomeView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
	}

}
