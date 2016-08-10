package com.bmpl.ims.users.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.bmpl.ims.users.dao.EnquireDAO;
import com.bmpl.ims.users.dto.EnquireDTO;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.*;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.border.BevelBorder;

public class EnquireView extends JFrame {

	private JPanel contentPane;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtAddress;
	private JTextField txtAddress_1;
	private JTextField txtMobile;
	private JTextField txtHome;
	private JTextField txtTimeSlot;
	private JTextField txtTimeSlotii;
	private JTextField txtFirstName_1;
	private JTextField txtLastName_1;
	private JTextField txtMobile_1;
	private JTextField txtOther;
	private JTextField txtEnterUniversityName;
	private JTextField txtEnterYourQualifications;
	private JTextField txtFriendOrOther;
	private JTextField txtEnterEmail;
	private String course[]={"Java", "Adv. Java", "UI", "MEAN", "C", "C++", "Php"};
	DefaultListModel<String> listModel;
	JTextArea textUpdateArea;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnquireView frame = new EnquireView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EnquireView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setSize(559,619);
		
		
		JLabel lblEnquiry = new JLabel("ENQUIRY");
		lblEnquiry.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 15));
		lblEnquiry.setBounds(248, 11, 80, 24);
		getContentPane().add(lblEnquiry);
		
		JLabel label = new JLabel("1.");
		label.setBounds(38, 55, 10, 14);
		getContentPane().add(label);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(58, 55, 101, 14);
		getContentPane().add(lblName);
		
		JLabel label_1 = new JLabel("2.");
		label_1.setBounds(40, 88, 10, 14);
		getContentPane().add(label_1);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(58, 88, 101, 14);
		getContentPane().add(lblAddress);
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(214, 52, 125, 20);
		getContentPane().add(txtFirstName);
		txtFirstName.setColumns(10);
				
		txtLastName = new JTextField();
		txtLastName.setBounds(366, 52, 125, 20);
		getContentPane().add(txtLastName);
		txtLastName.setColumns(10);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(214, 85, 277, 20);
		getContentPane().add(txtAddress);
		txtAddress.setColumns(10);
		
		txtAddress_1 = new JTextField();
		txtAddress_1.setBounds(214, 116, 277, 20);
		getContentPane().add(txtAddress_1);
		txtAddress_1.setColumns(10);
		
		JLabel label_2 = new JLabel("3.");
		label_2.setBounds(38, 150, 10, 14);
		getContentPane().add(label_2);
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setBounds(58, 150, 101, 14);
		getContentPane().add(lblContact);
		
		txtMobile = new JTextField();
		txtMobile.setBounds(214, 147, 125, 20);
		getContentPane().add(txtMobile);
		txtMobile.setColumns(10);
		
		txtHome = new JTextField();
		txtHome.setBounds(366, 147, 125, 20);
		getContentPane().add(txtHome);
		txtHome.setColumns(10);
		
		JLabel label_3 = new JLabel("5.");
		label_3.setBounds(38, 232, 10, 14);
		getContentPane().add(label_3);
		
		JLabel lblCourses = new JLabel("Courses");
		lblCourses.setBounds(58, 232, 101, 14);
		getContentPane().add(lblCourses);
		
		JLabel label_4 = new JLabel("6.");
		label_4.setBounds(38, 295, 10, 14);
		getContentPane().add(label_4);
		
		JLabel lblPreferredTime = new JLabel("Preferred \r\nTime");
		lblPreferredTime.setBounds(58, 295, 101, 14);
		getContentPane().add(lblPreferredTime);
		
		txtTimeSlot = new JTextField();
		txtTimeSlot.setBounds(214, 292, 125, 20);
		getContentPane().add(txtTimeSlot);
		txtTimeSlot.setColumns(10);
		
		txtTimeSlotii = new JTextField();
		txtTimeSlotii.setBounds(366, 292, 125, 20);
		getContentPane().add(txtTimeSlotii);
		txtTimeSlotii.setColumns(10);
		
		JLabel label_5 = new JLabel("7.");
		label_5.setBounds(38, 326, 10, 14);
		getContentPane().add(label_5);
		
		JLabel lblFname = new JLabel("F'name");
		lblFname.setBounds(58, 326, 101, 14);
		getContentPane().add(lblFname);
		
		txtFirstName_1 = new JTextField();
		txtFirstName_1.setBounds(214, 323, 125, 20);
		getContentPane().add(txtFirstName_1);
		txtFirstName_1.setColumns(10);
		
		txtLastName_1 = new JTextField();
		txtLastName_1.setBounds(366, 323, 125, 20);
		getContentPane().add(txtLastName_1);
		txtLastName_1.setColumns(10);
		
		JLabel label_6 = new JLabel("8.");
		label_6.setBounds(38, 356, 10, 14);
		getContentPane().add(label_6);
		
		JLabel lblFcontact = new JLabel("F'contact");
		lblFcontact.setBounds(58, 356, 101, 14);
		getContentPane().add(lblFcontact);
		
		txtMobile_1 = new JTextField();
		txtMobile_1.setBounds(214, 353, 125, 20);
		getContentPane().add(txtMobile_1);
		txtMobile_1.setColumns(10);
		
		txtOther = new JTextField();
		txtOther.setBounds(366, 353, 125, 20);
		getContentPane().add(txtOther);
		txtOther.setColumns(10);
		
		JLabel label_7 = new JLabel("9.");
		label_7.setBounds(38, 388, 10, 14);
		getContentPane().add(label_7);
		
		JLabel lblUniversity = new JLabel("University");
		lblUniversity.setBounds(58, 421, 101, 14);
		getContentPane().add(lblUniversity);
		
		txtEnterUniversityName = new JTextField();
		txtEnterUniversityName.setBounds(214, 418, 277, 20);
		getContentPane().add(txtEnterUniversityName);
		txtEnterUniversityName.setColumns(10);
		
		JLabel label_8 = new JLabel("10.");
		label_8.setBounds(33, 421, 26, 14);
		getContentPane().add(label_8);
		
		JLabel lblQualifications = new JLabel("Qualifications");
		lblQualifications.setBounds(58, 388, 101, 14);
		getContentPane().add(lblQualifications);
		
		txtEnterYourQualifications = new JTextField();
		txtEnterYourQualifications.setBounds(215, 385, 276, 20);
		getContentPane().add(txtEnterYourQualifications);
		txtEnterYourQualifications.setColumns(10);
		
		JLabel label_9 = new JLabel("11.");
		label_9.setBounds(33, 455, 26, 14);
		getContentPane().add(label_9);
		
		JLabel lblReferredBy = new JLabel("Referred By.");
		lblReferredBy.setBounds(58, 455, 101, 14);
		getContentPane().add(lblReferredBy);
		
		txtFriendOrOther = new JTextField();
		txtFriendOrOther.setBounds(215, 452, 276, 20);
		getContentPane().add(txtFriendOrOther);
		txtFriendOrOther.setColumns(10);
		
		JLabel label_10 = new JLabel("4.");
		label_10.setBounds(38, 184, 10, 14);
		getContentPane().add(label_10);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(58, 184, 101, 14);
		getContentPane().add(lblEmail);
		
		txtEnterEmail = new JTextField();
		txtEnterEmail.setBounds(215, 181, 276, 20);
		getContentPane().add(txtEnterEmail);
		txtEnterEmail.setColumns(10);
		
		JButton btnAddEnquiry = new JButton("Add Enquiry");
		btnAddEnquiry.setBackground(Color.LIGHT_GRAY);
		btnAddEnquiry.setBounds(227, 518, 101, 23);
		getContentPane().add(btnAddEnquiry);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(214, 212, 277, 69);
		getContentPane().add(scrollPane);
		
		JList list = new JList(course);
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setViewportView(list);
		
		/*listModel = new DefaultListModel<String>();
		
		JList<String> courseList = new JList<String>(listModel);
		courseList.setValueIsAdjusting(true);
		courseList.addListSelectionListener(new ListSelectionListener(){
			EnquireDAO enquireDAO = new EnquireDAO();
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				textUpdateArea.setVisible(true);
				textUpdateArea.setText("");
				try{
				textUpdateArea.setText(enquireDAO.getCourse());	
			}catch(Exception e){
				
				
			}
			}});
		scrollPane.setViewportView(courseList);
		//courseList.setBounds(arg0, arg1, arg2, arg3);
		//list1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		////setContentPane(contentPane);
*/		
		
		btnAddEnquiry.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				addEnquiry();
				getCurrentTimeStamp();
				EnquireView.this.setVisible(false);
				EnquireView.this.dispose();
				EnquireContactMe enquireContactMe = new EnquireContactMe();
				enquireContactMe.setVisible(true);
				
			}
			
		});
		
	}
	
	public static java.sql.Timestamp getCurrentTimeStamp() {

		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());
	}

	private void addEnquiry(){
		EnquireDAO enquireDAO = new EnquireDAO();
		EnquireDTO enquireDTO = new EnquireDTO();
		enquireDTO.setFirstName(txtFirstName.getText());
		enquireDTO.setSecondName(txtLastName.getText());
		enquireDTO.setAddress1(txtAddress.getText());
		enquireDTO.setAddress2(txtAddress_1.getText());
		enquireDTO.setEmail(txtEnterEmail.getText());
		enquireDTO.setMobileContact(txtMobile.getText());
		enquireDTO.setOtherContact(txtHome.getText());
		//enquireDTO.setCourse(course);
		enquireDTO.setSlot1(txtTimeSlot.getText());
		enquireDTO.setSlot2(txtTimeSlotii.getText());
		enquireDTO.setFatherFirstName(txtFirstName_1.getText());
		enquireDTO.setFatherSecondName(txtLastName_1.getText());
		enquireDTO.setFatherMobileContact(txtMobile_1.getText());
		enquireDTO.setFatherOtherContact(txtOther.getText());
		enquireDTO.setUniversity(txtEnterUniversityName.getText());
		enquireDTO.setQualification(txtEnterYourQualifications.getText());
		enquireDTO.setReference(txtFriendOrOther.getText());
		
	    try {
			if(enquireDAO.addEnquire(enquireDTO)){
				System.out.println(enquireDTO);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
}
