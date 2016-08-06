package com.bmpl.ims.users.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

class Item {
	private String className;
	private String showName;

	public String getClassName() {
		return className;
	}

	public String getShowName() {
		return showName;
	}

	protected Item(String className, String showName) {

		this.className = className;
		this.showName = showName;
	}

	@Override
	public String toString() {
		return showName;
	}
	
	
}

public class DashBoardView extends JFrame {

	private JPanel contentPane;
	private Vector model1;
	private Vector model2;
	private Vector model3;
	private Vector model4;

	public static void main(String[] args) {

		DashBoardView frame = new DashBoardView();
		frame.setVisible(true);

	}

	public DashBoardView() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
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

		JLabel lblFollowup = new JLabel("Follow Ups");
		lblFollowup.setBounds(111, 495, 114, 15);
		contentPane.add(lblFollowup);

		model1 = new Vector();

		model1.addElement(new Item("CourseView", "Course"));
		model1.addElement(new Item("RegistrationView", "Student"));
		model1.addElement(new Item("AddBatchView", "Batch"));

		JComboBox comboBox = new JComboBox(model1);
		
		comboBox.setBounds(285, 134, 124, 24);

		contentPane.add(comboBox);

		model2 = new Vector();
		model2.addElement(new Item("UpdateCourseView", "Course"));
		model2.addElement(new Item("StudentView", "Student"));//Change key after adding screens
		model2.addElement(new Item("AddBatchView", "Trainer"));
		model2.addElement(new Item("AddBatchView", "Batch"));
		
		JComboBox comboBox_1 = new JComboBox(model2);
		comboBox_1.setBounds(285, 217, 124, 24);
		

		contentPane.add(comboBox_1);

		model3=new Vector();
		model3.addElement(new Item("TakeAttendanceView", "Take Attendance"));
		model3.addElement(new Item("AddBatchView", "View Attendance"));
		
		JComboBox comboBox_2 = new JComboBox(model3);
		comboBox_2.setBounds(285, 295, 124, 24);
		contentPane.add(comboBox_2);

		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(285, 390, 140, 24);
		contentPane.add(comboBox_3);

		JLabel lblChooseAnOp = new JLabel("Choose an Operation");
		lblChooseAnOp.setBounds(285, 65, 240, 37);
		contentPane.add(lblChooseAnOp);

		JButton btnGo = new JButton("Go");
		btnGo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Item item=(Item)comboBox.getSelectedItem();
				System.out.println(item.getClassName());
				
				
				try {
					Class.forName("com.bmpl.ims.users.views."+item.getClassName()).newInstance();
					
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		
		btnGo.setBounds(458, 134, 117, 25);
		contentPane.add(btnGo);

		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setBounds(728, 23, 70, 15);
		contentPane.add(lblWelcome);
		
		JButton button = new JButton("Go");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Item item=(Item)comboBox_1.getSelectedItem();
				System.out.println(item.getClassName());
				
				
				try {
					Class.forName("com.bmpl.ims.users.views."+item.getClassName()).newInstance();
					
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		button.setBounds(458, 217, 117, 25);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Go");
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Item item=(Item)comboBox_2.getSelectedItem();
				System.out.println(item.getClassName());
				
				
				try {
					Class.forName("com.bmpl.ims.users.views."+item.getClassName()).newInstance();
					
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		button_1.setBounds(458, 295, 117, 25);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Go");
		button_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Item item=(Item)comboBox_3.getSelectedItem();
				System.out.println(item.getClassName());
				
				
				try {
					Class.forName("com.bmpl.ims.users.views."+item.getClassName()).newInstance();
					
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		button_2.setBounds(458, 390, 117, 25);
		contentPane.add(button_2);

	}
}
