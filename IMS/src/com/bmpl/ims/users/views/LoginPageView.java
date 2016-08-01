package com.bmpl.ims.users.views;
/*
* @author  Sunil vishkarma
* @version 0.1
* This is a Login Page Design 
*/


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.bmpl.ims.users.dao.LoginDAO;
import com.bmpl.ims.users.dto.UserDTO;

public class LoginPageView extends JFrame {
	private JTextField txtuser;
	private JPasswordField txtpassword;
	private static String selecteditem;
	private JComboBox comboBox;


	public static void main(String[] args) {
		
					LoginPageView frame = new LoginPageView();
					frame.setVisible(true);
				
	}
	public LoginPageView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 329);
		getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUsername.setBounds(71, 127, 120, 33);
		getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setBounds(71, 171, 120, 33);
		getContentPane().add(lblPassword);
		
		txtuser = new JTextField();
		txtuser.setBounds(219, 133, 137, 25);
		getContentPane().add(txtuser);
		txtuser.setColumns(10);
		
		txtpassword = new JPasswordField();
		txtpassword.setBounds(219, 176, 137, 26);
		getContentPane().add(txtpassword);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLogin.setBounds(187, 11, 66, 25);
		getContentPane().add(lblLogin);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login();
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSubmit.setBounds(118, 238, 105, 23);
		getContentPane().add(btnSubmit);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Reset();
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnReset.setBounds(251, 237, 105, 25);
		getContentPane().add(btnReset);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selecteditem=(String)comboBox.getSelectedItem();
			}
		});
		comboBox.setBounds(221, 86, 119, 25);
		getContentPane().add(comboBox);
		comboBox.addItem("Admin");
		comboBox.addItem("Student");
		comboBox.addItem("Faculty");		
		
		JLabel lblPleaseSelect = new JLabel("Please Select");
		lblPleaseSelect.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPleaseSelect.setBounds(71, 83, 120, 33);
		getContentPane().add(lblPleaseSelect);
	}
	 public void Login()
	 {

			LoginDAO loginDAO = new  LoginDAO();
			UserDTO userDTO = new UserDTO();
			userDTO.setUserid(txtuser.getText());
			userDTO.setPassword(txtpassword.getText());
			userDTO.setRole(selecteditem);
					try {
						boolean isFound = loginDAO.authenticateUser(userDTO);
						if(isFound)
						{
							if(userDTO.getRole().equalsIgnoreCase("admin"))
							{
								JOptionPane.showMessageDialog(this, "Admin selected");
							}
							if(userDTO.getRole().equalsIgnoreCase("student"))
							{
								JOptionPane.showMessageDialog(this, "student selected");
							}
							if(userDTO.getRole().equalsIgnoreCase("faculty"))
							{
								JOptionPane.showMessageDialog(this, "faculty selected");
							}
						}
				else
				{
					JOptionPane.showMessageDialog(this, "Invalid Userid or Password");
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	 }
	 public void Reset()
	 {
		 txtuser.setText("");
		 txtpassword.setText("");
	 }
}
