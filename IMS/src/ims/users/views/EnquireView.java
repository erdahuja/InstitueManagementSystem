package com.bmpl.ims.users.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import com.bmpl.ims.users.dao.EnquireDAO;
import com.bmpl.ims.users.dto.EnquireDTO;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

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
	private UtilDateModel model;
	private JDatePanelImpl datePanel;
	private JDatePickerImpl datePicker;
	private String selecteditem;
	private java.sql.Date sqlDate;
	private JTextField textField;
	JList list = new JList();
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
		setSize(603,639);
		
		
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
		txtFirstName.setBounds(248, 52, 125, 20);
		getContentPane().add(txtFirstName);
		txtFirstName.setColumns(10);
				
		txtLastName = new JTextField();
		txtLastName.setBounds(399, 52, 125, 20);
		getContentPane().add(txtLastName);
		txtLastName.setColumns(10);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(248, 85, 277, 20);
		getContentPane().add(txtAddress);
		txtAddress.setColumns(10);
		
		txtAddress_1 = new JTextField();
		txtAddress_1.setBounds(248, 116, 277, 20);
		getContentPane().add(txtAddress_1);
		txtAddress_1.setColumns(10);
		
		JLabel label_2 = new JLabel("3.");
		label_2.setBounds(38, 150, 10, 14);
		getContentPane().add(label_2);
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setBounds(58, 150, 101, 14);
		getContentPane().add(lblContact);
		
		txtMobile = new JTextField();
		txtMobile.setBounds(248, 147, 125, 20);
		getContentPane().add(txtMobile);
		txtMobile.setColumns(10);
		
		txtHome = new JTextField();
		txtHome.setBounds(399, 147, 125, 20);
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
		txtTimeSlot.setBounds(248, 292, 125, 20);
		getContentPane().add(txtTimeSlot);
		txtTimeSlot.setColumns(10);
		
		txtTimeSlotii = new JTextField();
		txtTimeSlotii.setBounds(399, 292, 125, 20);
		getContentPane().add(txtTimeSlotii);
		txtTimeSlotii.setColumns(10);
		
		JLabel label_5 = new JLabel("7.");
		label_5.setBounds(38, 326, 10, 14);
		getContentPane().add(label_5);
		
		JLabel lblFname = new JLabel("F'name");
		lblFname.setBounds(58, 326, 101, 14);
		getContentPane().add(lblFname);
		
		txtFirstName_1 = new JTextField();
		txtFirstName_1.setBounds(248, 323, 125, 20);
		getContentPane().add(txtFirstName_1);
		txtFirstName_1.setColumns(10);
		
		txtLastName_1 = new JTextField();
		txtLastName_1.setBounds(399, 323, 125, 20);
		getContentPane().add(txtLastName_1);
		txtLastName_1.setColumns(10);
		
		JLabel label_6 = new JLabel("8.");
		label_6.setBounds(38, 356, 10, 14);
		getContentPane().add(label_6);
		
		JLabel lblFcontact = new JLabel("F'contact");
		lblFcontact.setBounds(58, 356, 101, 14);
		getContentPane().add(lblFcontact);
		
		txtMobile_1 = new JTextField();
		txtMobile_1.setBounds(248, 353, 125, 20);
		getContentPane().add(txtMobile_1);
		txtMobile_1.setColumns(10);
		
		txtOther = new JTextField();
		txtOther.setBounds(399, 354, 125, 20);
		getContentPane().add(txtOther);
		txtOther.setColumns(10);
		
		JLabel label_7 = new JLabel("9.");
		label_7.setBounds(38, 388, 10, 14);
		getContentPane().add(label_7);
		
		JLabel lblUniversity = new JLabel("University");
		lblUniversity.setBounds(58, 421, 101, 14);
		getContentPane().add(lblUniversity);
		
		txtEnterUniversityName = new JTextField();
		txtEnterUniversityName.setBounds(247, 418, 277, 20);
		getContentPane().add(txtEnterUniversityName);
		txtEnterUniversityName.setColumns(10);
		
		JLabel label_8 = new JLabel("10.");
		label_8.setBounds(33, 421, 26, 14);
		getContentPane().add(label_8);
		
		JLabel lblQualifications = new JLabel("Qualifications");
		lblQualifications.setBounds(58, 388, 101, 14);
		getContentPane().add(lblQualifications);
		
		txtEnterYourQualifications = new JTextField();
		txtEnterYourQualifications.setBounds(248, 385, 276, 20);
		getContentPane().add(txtEnterYourQualifications);
		txtEnterYourQualifications.setColumns(10);
		
		JLabel label_9 = new JLabel("11.");
		label_9.setBounds(33, 455, 26, 14);
		getContentPane().add(label_9);
		
		JLabel lblReferredBy = new JLabel("Referred By.");
		lblReferredBy.setBounds(58, 455, 101, 14);
		getContentPane().add(lblReferredBy);
		
		txtFriendOrOther = new JTextField();
		txtFriendOrOther.setBounds(248, 452, 276, 20);
		getContentPane().add(txtFriendOrOther);
		txtFriendOrOther.setColumns(10);
		
		JLabel label_10 = new JLabel("4.");
		label_10.setBounds(38, 184, 10, 14);
		getContentPane().add(label_10);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(58, 184, 101, 14);
		getContentPane().add(lblEmail);
		
		txtEnterEmail = new JTextField();
		txtEnterEmail.setBounds(248, 178, 276, 20);
		getContentPane().add(txtEnterEmail);
		txtEnterEmail.setColumns(10);
		
		JButton btnAddEnquiry = new JButton("Add Enquiry");
		btnAddEnquiry.setBackground(Color.LIGHT_GRAY);
		btnAddEnquiry.setBounds(248, 543, 101, 23);
		getContentPane().add(btnAddEnquiry);
		
		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
		datePicker = new JDatePickerImpl(datePanel);
		datePicker.setBounds(248, 483, 276, 20);
		getContentPane().add(datePicker);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(247, 212, 277, 69);
		getContentPane().add(scrollPane);
		
		 try {
			list = new JList(EnquireDAO.getCourse().toArray());
			list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			scrollPane.setViewportView(list);
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		
		
		
		JLabel label_11 = new JLabel("12.");
		label_11.setBounds(33, 491, 16, 14);
		getContentPane().add(label_11);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(58, 491, 175, 14);
		getContentPane().add(lblNewLabel);
		lblNewLabel.setText("When would you like \r\nus to call you?");
		
		btnAddEnquiry.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				addEnquiry();
				getCurrentTimeStamp();
				EnquireView.this.setVisible(false);
				EnquireView.this.dispose();
				
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
//		enquireDTO.setCoursename();	
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