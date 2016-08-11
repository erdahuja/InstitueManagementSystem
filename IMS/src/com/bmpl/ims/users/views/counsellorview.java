package com.bmpl.counsellorform.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.bmpl.counsellorform.DAO.counsellorDAO;
import com.bmpl.counsellorform.DTO.counsellorDTO;

public class counsellorview extends JFrame {

	private JPanel contentPane;
	private JTextField nm;
	private JTextField ad;
	private JTextField pn;
	private JTextField qf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					counsellorview frame = new counsellorview();
					frame.setVisible(true);
				
	}

	public counsellorview() {
		setTitle("COUNSELLOR FORM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 368);
		contentPane = new JPanel();
		
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblName = new JLabel("NAME :");
		lblName.setBounds(10, 47, 46, 14);
		contentPane.add(lblName);
		
		nm = new JTextField();
		nm.setToolTipText("ENTER YOUR NAME");
		nm.setBounds(130, 44, 213, 20);
		contentPane.add(nm);
		nm.setColumns(10);
		
		JLabel lblAddress = new JLabel("ADDRESS :");
		lblAddress.setBounds(10, 103, 67, 14);
		contentPane.add(lblAddress);
		
		ad = new JTextField();
		ad.setToolTipText("ENTER YOUR PERMANENT ADDRESS");
		ad.setBounds(130, 100, 213, 20);
		contentPane.add(ad);
		ad.setColumns(10);
		
		JLabel lblPhonenumber = new JLabel(" PHONENUMBER :");
		lblPhonenumber.setBounds(10, 154, 110, 14);
		contentPane.add(lblPhonenumber);
		
		pn = new JTextField();
		pn.setToolTipText("YOUR PHONENUMBER PLEASE!!");
		pn.setBounds(130, 151, 213, 20);
		contentPane.add(pn);
		pn.setColumns(10);
		
		JLabel lblQualification = new JLabel("QUALIFICATION :");
		lblQualification.setBounds(10, 212, 96, 14);
		contentPane.add(lblQualification);
		
		qf = new JTextField();
		qf.setToolTipText("YOUR QUALIFICATION PLEASE!!");
		qf.setBounds(130, 209, 213, 20);
		contentPane.add(qf);
		qf.setColumns(10);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					try {
						dosubmit();
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			}
		});
		btnSubmit.setToolTipText("CLICK AFTER FILLING THE FORM");
		btnSubmit.setBounds(204, 282, 118, 23);
		contentPane.add(btnSubmit);
	}
	private void dosubmit() throws ClassNotFoundException, SQLException{
		counsellorDAO counsellorDAO =new counsellorDAO();
		counsellorDTO counsellorDTO = new counsellorDTO();
		counsellorDTO.setName(nm.getText());
		counsellorDTO.setAddress(ad.getText());
		counsellorDTO.setPhonenumber(pn.getText());
		counsellorDTO.setQualification(qf.getText());
		boolean isFound=counsellorDAO.counsellor(counsellorDTO);
		if(isFound)
		{
			JOptionPane.showMessageDialog(this, "Added.....");
		}
		else
		{
			JOptionPane.showMessageDialog(this, "Record Not added.....");	
		}
		}
}