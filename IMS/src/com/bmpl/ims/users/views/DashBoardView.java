package com.bmpl.ims.users.views;

import java.awt.Image;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import com.bmpl.ims.common.utils.CommonMethods;

import java.awt.Font;

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
	private JTextArea lblWelcome ;
	DateFormat format;
	String stringTime;
	String misc;
	private JLabel lblUpdate;
	private JLabel lblFees;
	private JComboBox comboBox_1 ;
	private JFrame frame = new JFrame();

	public static void main(String[] args) throws IOException {

		new DashBoardView("admin","string2");

		
	}

	
	void loadClock(){
		
		javax.swing.Timer t = new javax.swing.Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calendar now = Calendar.getInstance();
				int h = now.get(Calendar.HOUR_OF_DAY);
				int m = now.get(Calendar.MINUTE);
				int s = now.get(Calendar.SECOND);
				int d = now.get(Calendar.DAY_OF_MONTH);
				int mo = now.get(Calendar.MONTH);
				int y = now.get(Calendar.YEAR);
				lblWelcome.setText(misc + " " + h + " :" + m + " :" + s + "\n" + "Date : " + d + " :" + mo + " :" + y);

			}
		});
		t.start();
	}
	
	public DashBoardView(String selecteditem, String userid) throws IOException {
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

		frame.setTitle("Institue Management System");

	
		
		Image img = ImageIO.read(new File("/home/deepak/Downloads/IMS/src/com/bmpl/ims/users/views/banner_CMS.jpg"));
		// format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		loadClock();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		lblFees = new JLabel("Fees");
		lblFees.setBounds(111, 488, 70, 15);
		frame.setContentPane(contentPane);
		model2 = new Vector();
		model2.addElement(new Item("UpdateCourseView", "Course"));
		model2.addElement(new Item("StudentView", "Student"));// Change key
																// after adding
															// screens
		model2.addElement(new Item("TeacherView", "Trainer"));
		model2.addElement(new Item("AddBatchView", "Batch"));

		comboBox_1 = new JComboBox(model2);
		comboBox_1.setBounds(299, 342, 124, 24);
		
		  lblUpdate = new JLabel("Update");
			lblUpdate.setBounds(111, 347, 70, 15);
			
		
		if(selecteditem.equalsIgnoreCase("admin")){
			contentPane.add(lblUpdate);
			contentPane.add(lblFees);
			contentPane.add(comboBox_1);
		}
		else{
			
		}
		

		JLabel lblAdd = new JLabel("ADD");
		lblAdd.setBounds(111, 273, 70, 15);
		contentPane.add(lblAdd);

	  
		

		JLabel lblAttendance = new JLabel("Attendance");
		lblAttendance.setBounds(111, 427, 114, 15);
		contentPane.add(lblAttendance);

		 
		

		JLabel lblFollowup = new JLabel("Follow Ups");
		lblFollowup.setBounds(111, 545, 114, 15);
		contentPane.add(lblFollowup);

		model1 = new Vector();

		model1.addElement(new Item("CourseView", "Course"));
		model1.addElement(new Item("RegistrationView", "Student"));
		model1.addElement(new Item("AddBatchView", "Batch"));
		model1.addElement(new Item("TrainerRegistration", "Trainer"));

		JComboBox comboBox = new JComboBox(model1);

		comboBox.setBounds(299, 268, 124, 24);

		contentPane.add(comboBox);

		

		

		model3 = new Vector();
		model3.addElement(new Item("TakeAttendanceView", "Take Attendance"));
		model3.addElement(new Item("AddBatchView", "View Attendance"));

		JComboBox comboBox_2 = new JComboBox(model3);
		comboBox_2.setBounds(299, 406, 124, 24);
		contentPane.add(comboBox_2);

		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(299, 480, 124, 24);
		contentPane.add(comboBox_3);

		JButton btnGo = new JButton("Go");
		btnGo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Item item = (Item) comboBox.getSelectedItem();
				System.out.println(item.getClassName());

				try {
					Class.forName("com.bmpl.ims.users.views." + item.getClassName()).newInstance();

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

		btnGo.setBounds(526, 268, 117, 25);
		contentPane.add(btnGo);

		misc = "Welcome " + userid + "\n" + "Logged in as " + selecteditem + "\n" + "Time : ";
		lblWelcome = new JTextArea(misc + stringTime);
		lblWelcome.setFont(new Font("DejaVu Serif Condensed", Font.BOLD, 14));
		lblWelcome.setBorder(BorderFactory.createEmptyBorder());
		lblWelcome.setLineWrap(true);
		lblWelcome.setEditable(false);

		lblWelcome.setBounds(1032, 134, 250, 77);
		contentPane.add(lblWelcome);

		

		JButton button = new JButton("Go");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Item item = (Item) comboBox_1.getSelectedItem();
				System.out.println(item.getClassName());

				try {
					Class.forName("com.bmpl.ims.users.views." + item.getClassName()).newInstance();

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
		button.setBounds(526, 342, 117, 25);
		contentPane.add(button);

		JButton button_1 = new JButton("Go");
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Item item = (Item) comboBox_2.getSelectedItem();
				System.out.println(item.getClassName());

				try {
					Class.forName("com.bmpl.ims.users.views." + item.getClassName()).newInstance();

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
		button_1.setBounds(526, 406, 117, 25);
		contentPane.add(button_1);

		JButton button_2 = new JButton("Go");
		button_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Item item = (Item) comboBox_3.getSelectedItem();
				System.out.println(item.getClassName());

				try {
					Class.forName("com.bmpl.ims.users.views." + item.getClassName()).newInstance();

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
		button_2.setBounds(526, 480, 117, 25);
		contentPane.add(button_2);

		JLabel lblNewLabel = new JLabel(new ImageIcon(img));
		lblNewLabel.setBounds(0, 12, 1031, 254);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Send Notice");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new SendNotice();
			}
		});
		btnNewButton.setBounds(1032, 295, 217, 25);
		contentPane.add(btnNewButton);
		frame.setVisible(true);
		
	}



}
