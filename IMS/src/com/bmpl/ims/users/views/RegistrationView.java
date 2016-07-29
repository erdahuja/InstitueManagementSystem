package com.bmpl.ojas.views;

import java.awt.Component;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.bmpl.ojas.DAO.RegisterDAO;
import com.bmpl.ojas.DTO.RegisterDTO;

/*
* @author  Ojaswi Wadhwa
* @version 0.1
* @since   2016-07-015
* This is a Registration Page Design 
*/

public class RegistrationView extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtPhone;
	private JTextField txtEmail;
	private JTextField txtFather;
	private JTextField txtState;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		RegistrationView frame = new RegistrationView();
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	JComboBox comboBatch;
	JComboBox comboCountry;

	public RegistrationView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 622, 499);
		contentPane = new JPanel();

		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lblName = new JLabel("Name : ");
		lblName.setBounds(10, 38, 46, 14);
		contentPane.add(lblName);

		txtName = new JTextField();
		txtName.setBounds(107, 35, 173, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);

		JLabel lblAddress = new JLabel("Address : ");
		lblAddress.setBounds(10, 96, 63, 14);
		contentPane.add(lblAddress);

		txtAddress = new JTextField();
		txtAddress.setBounds(107, 93, 173, 20);
		contentPane.add(txtAddress);
		txtAddress.setColumns(10);

		JLabel lblPhoneNumber = new JLabel("Phone number :");
		lblPhoneNumber.setBounds(10, 166, 112, 14);
		contentPane.add(lblPhoneNumber);

		txtPhone = new JTextField();
		txtPhone.setBounds(107, 163, 173, 20);
		contentPane.add(txtPhone);
		txtPhone.setColumns(10);

		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(10, 238, 46, 14);
		contentPane.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(107, 235, 173, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblCourse = new JLabel("Course :");
		lblCourse.setBounds(10, 316, 46, 14);
		contentPane.add(lblCourse);

		JCheckBox chckbxJava = new JCheckBox("Java");
		chckbxJava.setBounds(105, 312, 97, 23);
		contentPane.add(chckbxJava);

		JCheckBox chckbxUserInterface = new JCheckBox("User Interface");
		chckbxUserInterface.setBounds(204, 312, 126, 23);
		contentPane.add(chckbxUserInterface);

		JCheckBox chckbxMean = new JCheckBox("MEAN");
		chckbxMean.setBounds(344, 312, 97, 23);
		contentPane.add(chckbxMean);

		JCheckBox chckbxAndroid = new JCheckBox("Android");
		chckbxAndroid.setBounds(443, 312, 97, 23);
		contentPane.add(chckbxAndroid);

		JLabel lblFathersName = new JLabel("Father's name :");
		lblFathersName.setBounds(344, 38, 97, 14);
		contentPane.add(lblFathersName);

		txtFather = new JTextField();
		txtFather.setBounds(443, 35, 153, 20);
		contentPane.add(txtFather);
		txtFather.setColumns(10);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				doSubmit();
			}
		});
		btnSubmit.setBounds(137, 380, 89, 23);
		contentPane.add(btnSubmit);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				doReset();
			}
		});
		btnReset.setBounds(275, 380, 89, 23);
		contentPane.add(btnReset);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				doExit();
			}
		});
		btnExit.setBounds(418, 380, 89, 23);
		contentPane.add(btnExit);

		JLabel lblCountry = new JLabel("Country :");
		lblCountry.setBounds(344, 96, 46, 14);
		contentPane.add(lblCountry);

		comboCountry = new JComboBox();
		comboCountry.setBounds(443, 93, 112, 20);
		contentPane.add(comboCountry);
		comboCountry.addItem("Select your country");
		comboCountry.addItem("India");
		comboCountry.addItem("Australia");
		comboCountry.addItem("France");
		comboCountry.addItem("USA");

		JLabel lblState = new JLabel("State :");
		lblState.setBounds(344, 166, 46, 14);
		contentPane.add(lblState);

		txtState = new JTextField();
		txtState.setBounds(443, 163, 153, 20);
		contentPane.add(txtState);
		txtState.setColumns(10);

		JLabel lblBatch = new JLabel("Batch :");
		lblBatch.setBounds(344, 241, 46, 14);
		contentPane.add(lblBatch);

		comboBatch = new JComboBox();
		comboBatch.setBounds(443, 235, 112, 20);
		contentPane.add(comboBatch);
		comboBatch.addItem("Select your batch");
		comboBatch.addItem("6-7 MWF");
		comboBatch.addItem("5-6 TTS");
		comboBatch.addItem("6-8 Sat-Sun");

		JLabel lblRegistration = new JLabel("Registration");
		lblRegistration.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblRegistration.setBounds(238, -1, 126, 25);
		contentPane.add(lblRegistration);
	}

	private void doSubmit() {

		RegisterDAO registerDAO = new RegisterDAO();
		RegisterDTO registerDTO = new RegisterDTO();

		registerDTO.setName(txtName.getText());
		registerDTO.setAddress(txtAddress.getText());
		registerDTO.setState(txtState.getText());
		registerDTO.setPhone(txtPhone.getText());
		registerDTO.setMail(txtEmail.getText());
		registerDTO.setCountry(comboCountry.getSelectedItem().toString());
		registerDTO.setFname(txtFather.getText());

		try {
			registerDAO.register(registerDTO);
			System.out.println(registerDTO);
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
	}

	private void doReset() {

	}

	private void doExit() {

		System.exit(0);

	}

}
