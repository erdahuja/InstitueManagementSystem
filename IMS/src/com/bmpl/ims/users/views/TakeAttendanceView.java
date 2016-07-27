package com.bmpl.ims.users.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import java.awt.ScrollPane;

public class TakeAttendanceView extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		
		TakeAttendanceView frame = new TakeAttendanceView();
		frame.setVisible(true);
		
	}

	
	public TakeAttendanceView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(0, 0, 200, 50);
		contentPane.add(scrollPane);
	}
}
