package com.bmpl.ims.users.views;
/*
* @author  Amit Srivastava
* @version 0.1
* @since   2016-07-04
* This is a Login Page Design 
*/

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.apache.log4j.Logger;

import com.bmpl.ims.common.utils.CommonUtility;
import com.bmpl.ims.users.dao.LoginDAO;
import com.bmpl.ims.users.dto.UserDTO;

public class LoginView extends JFrame {
	private JTextField txtUserid;
	private JPasswordField txtPwd;
	private Logger logger = Logger.getLogger(LoginView.class);

	
	public static void main(String[] args) {
					LoginView frame = new LoginView();
					frame.setVisible(true);
	
	}

	/**
	 * Create the frame.
	 */
	public LoginView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(165, 26, 67, 32);
		getContentPane().add(lblNewLabel);
		
		JLabel lblUserid = new JLabel("Userid");
		lblUserid.setBounds(32, 95, 61, 16);
		getContentPane().add(lblUserid);
		
		txtUserid = new JTextField();
		txtUserid.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		txtUserid.setBounds(118, 90, 173, 26);
		getContentPane().add(txtUserid);
		txtUserid.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(32, 158, 61, 16);
		getContentPane().add(lblPassword);
		
		txtPwd = new JPasswordField();
		txtPwd.setBounds(118, 150, 161, 32);
		getContentPane().add(txtPwd);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doLogin();
			}
		});
		btnLogin.setBounds(33, 216, 117, 29);
		getContentPane().add(btnLogin);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(174, 216, 117, 29);
		getContentPane().add(btnReset);
		
	}
	private void doLogin(){
		logger.debug("Inside the do Login Method");
		LoginDAO loginDAO = new  LoginDAO();
		UserDTO userDTO = new UserDTO();
		userDTO.setUserid(txtUserid.getText());
		userDTO.setPassword(txtPwd.getText());
		logger.debug("Setting the User Values "+userDTO);
		try {
			//boolean isFound = loginDAO.authenticateUser(userDTO);
			UserDTO userObject = loginDAO.authenticateUser(userDTO);
			//if(isFound){
			if(userObject!=null){
				System.out.println(" FOUND ::: "+userObject);
				WelcomeView welcomeView = new WelcomeView();
				welcomeView.setUserObject(userObject);
				welcomeView.setVisible(true);
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Invalid Userid or Password");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			
			//e.printStackTrace();
			logger.error(CommonUtility.getPrintStackTrace(e));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(CommonUtility.getPrintStackTrace(e));
			//e.printStackTrace();
		}
	}
}
