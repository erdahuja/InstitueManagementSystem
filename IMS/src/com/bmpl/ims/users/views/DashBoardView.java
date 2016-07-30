package com.bmpl.ims.users.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class DashBoardView extends JFrame {

	private JPanel contentPane;

	
	public static void main(String[] args) {

		 DashBoardView frame=	 new DashBoardView();
				
				
	}

	
	
	public DashBoardView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 718, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblAdd = new JLabel("ADD");
		lblAdd.setBounds(111, 139, 70, 15);
		contentPane.add(lblAdd);
		
		JLabel lblUpdate = new JLabel("Update");
		lblUpdate.setBounds(111, 222, 70, 15);
		contentPane.add(lblUpdate);
		
		JLabel lblAttendance = new JLabel("Attendance");
		lblAttendance.setBounds(111, 300, 114, 15);
		contentPane.add(lblAttendance);
		
		JLabel lblFees = new JLabel("Fees");
		lblFees.setBounds(111, 395, 70, 15);
		contentPane.add(lblFees);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
		
				new CourseView();
				
				
			}
		});
		comboBox.setBounds(285, 134, 124, 24);
		comboBox.addItem("Course");
		contentPane.add(comboBox);
		
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(285, 217, 124, 24);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(285, 295, 124, 24);
		contentPane.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(285, 390, 140, 24);
		contentPane.add(comboBox_3);
		
		JLabel lblChooseAnOp = new JLabel("Choose an Operation");
		lblChooseAnOp.setBounds(285, 65, 240, 37);
		contentPane.add(lblChooseAnOp);
		
		JButton btnGo = new JButton("Go");
		btnGo.setBounds(292, 426, 117, 25);
		contentPane.add(btnGo);
		frame.setVisible(true);
	}
}
