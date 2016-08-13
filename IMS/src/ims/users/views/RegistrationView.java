package com.bmpl.ims.users.views;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.bmpl.ims.common.utils.CommonMethods;
import com.bmpl.ims.users.dao.RegisterDAO;
import com.bmpl.ims.users.dto.RegisterDTO;



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
	private JList<String> list1;
	private DefaultListModel<String> listModel = new DefaultListModel<String>();
	private ArrayList<String> list;
	
	private JList<String> list2;
	private DefaultListModel<String> listModel1 = new DefaultListModel<String>();
	

	private ArrayList<String> batchList;
	private JFrame frame=new JFrame();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		  new RegistrationView();
		
	}

	

	public RegistrationView() {
		
		list=new ArrayList<>();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 622, 499);
		contentPane = new JPanel();

		contentPane.setLayout(null);
		frame.setContentPane(contentPane);

		JLabel lblName = new JLabel("Name : ");
		lblName.setBounds(10, 38, 63, 14);
		contentPane.add(lblName);

		txtName = new JTextField();
		txtName.setBounds(91, 36, 173, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);

		JLabel lblAddress = new JLabel("Address : ");
		lblAddress.setBounds(10, 96, 79, 14);
		contentPane.add(lblAddress);

		txtAddress = new JTextField();
		txtAddress.setBounds(91, 94, 173, 20);
		contentPane.add(txtAddress);
		txtAddress.setColumns(10);

		JLabel lblPhoneNumber = new JLabel("Phone :");
		lblPhoneNumber.setBounds(10, 166, 112, 14);
		contentPane.add(lblPhoneNumber);

		txtPhone = new JTextField();
		txtPhone.setBounds(91, 164, 173, 20);
		contentPane.add(txtPhone);
		txtPhone.setColumns(10);

		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(10, 238, 46, 14);
		contentPane.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(91, 236, 173, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblCourse = new JLabel("Course :");
		lblCourse.setBounds(10, 316, 78, 14);
		contentPane.add(lblCourse);


		JLabel lblFathersName = new JLabel("Father's name :");
		lblFathersName.setBounds(296, 38, 111, 14);
		contentPane.add(lblFathersName);

		txtFather = new JTextField();
		txtFather.setBounds(425, 36, 153, 20);
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

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				doExit();
			}
		});
		btnExit.setBounds(418, 380, 89, 23);
		contentPane.add(btnExit);

	
		JLabel lblState = new JLabel("State :");
		lblState.setBounds(301, 96, 63, 14);
		contentPane.add(lblState);

		txtState = new JTextField();
		txtState.setBounds(425, 94, 153, 20);
		contentPane.add(txtState);
		txtState.setColumns(10);

		JLabel lblBatch = new JLabel("Batch :");
		lblBatch.setBounds(301, 241, 89, 14);
		contentPane.add(lblBatch);

		
	

		JLabel lblRegistration = new JLabel("Registration");
		lblRegistration.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblRegistration.setBounds(238, -1, 126, 25);
		contentPane.add(lblRegistration);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(433, 253, 145, 54);
		contentPane.add(scrollPane);
		frame.setVisible(true);
		

		listModel = new DefaultListModel<String>();
		 list1 = new JList<String>(listModel);
		list1.setValueIsAdjusting(true);
		list1.setBounds(91, 282, 173, 86);
		contentPane.add(list1);
		
		try {
			list = CommonMethods.getCourse();
			for (String courses : list){
				listModel.addElement(courses);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane.setBounds(425, 204, 145, 103);
		contentPane.add(scrollPane);
		frame.setVisible(true);
		
		listModel1 = new DefaultListModel<String>();
		 list2 = new JList<String>(listModel1);
		list2.setValueIsAdjusting(true);
		list2.setBounds(425, 204, 145, 103);
		contentPane.add(list2);
		
		try {
			batchList = CommonMethods.getCourse(); //change to getBatch();
			for (String batches : batchList){
				listModel1.addElement(batches);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

	private void doSubmit() {

		RegisterDAO registerDAO = new RegisterDAO();
		RegisterDTO registerDTO = new RegisterDTO();

		registerDTO.setName(txtName.getText());
		registerDTO.setAddress(txtAddress.getText());
		registerDTO.setState(txtState.getText());
		registerDTO.setPhone(txtPhone.getText());
		registerDTO.setMail(txtEmail.getText());
		
		registerDTO.setFname(txtFather.getText());

		try {
			registerDAO.register(registerDTO);
			System.out.println(registerDTO);
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
	}

	
	private void doExit() {

		System.exit(0);

	}
}
