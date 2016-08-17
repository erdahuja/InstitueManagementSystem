package com.bmpl.counsellorform.view;

public class counsellorview extends JFrame {

	private JPanel contentPane;
	private JTextField nm;
	private JTextField ad;
	private JTextField qf;
	private JTextField pn;
	private String seletedRedioButton;

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
		lblName.setBounds(10, 62, 46, 14);
		contentPane.add(lblName);
		
		nm = new JTextField();
		nm.setToolTipText("ENTER YOUR NAME");
		nm.setBounds(130, 59, 213, 20);
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
		
		JLabel lblPhonenumber = new JLabel("GENDER :");
		lblPhonenumber.setBounds(10, 154, 110, 14);
		contentPane.add(lblPhonenumber);
		
		JLabel lblQualification = new JLabel("QUALIFICATION :");
		lblQualification.setBounds(10, 196, 96, 14);
		contentPane.add(lblQualification);
		
		qf = new JTextField();
		qf.setToolTipText("YOUR QUALIFICATION PLEASE!!");
		qf.setBounds(130, 193, 213, 20);
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
		
		JLabel lblPhoneNumber = new JLabel("PHONENUMBER :");
		lblPhoneNumber.setBounds(10, 235, 96, 14);
		contentPane.add(lblPhoneNumber);
		
		pn = new JTextField();
		pn.setBounds(130, 232, 213, 20);
		contentPane.add(pn);
		pn.setColumns(10);
		
		JRadioButton rdbtnMale = new JRadioButton("MALE");
		ButtonGroup btngroup=new ButtonGroup(); 
		rdbtnMale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Enumeration<AbstractButton> allRadioButton=btngroup.getElements();
				while(allRadioButton.hasMoreElements()) 
				{
				JRadioButton temp=(JRadioButton)allRadioButton.nextElement();  
		           if(temp.isSelected())  
		           {  
		        	   seletedRedioButton=temp.getText();  
		           }
				}
				}
		});
		rdbtnMale.setBounds(130, 145, 109, 23);
		contentPane.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("FEMALE");
		rdbtnFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Enumeration<AbstractButton> allRadioButton=btngroup.getElements();
				while(allRadioButton.hasMoreElements()) 
				{
				JRadioButton temp=(JRadioButton)allRadioButton.nextElement();  
		           if(temp.isSelected())  
		           {  
		        	   seletedRedioButton=temp.getText();
		           }
				}
			}
		});
		
		rdbtnFemale.setBounds(244, 145, 109, 23);
		contentPane.add(rdbtnFemale);
		
		btngroup.add(rdbtnMale);  
		btngroup.add(rdbtnFemale);
		
		JLabel lblRegistrationForm = new JLabel("REGISTRATION FORM");
		lblRegistrationForm.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		lblRegistrationForm.setBounds(187, 11, 156, 14);
		contentPane.add(lblRegistrationForm);
	}
	private void dosubmit() throws ClassNotFoundException, SQLException{
		counsellorDAO counsellorDAO =new counsellorDAO();
		counsellorDTO counsellorDTO = new counsellorDTO();
		counsellorDTO.setName(nm.getText());
		counsellorDTO.setAddress(ad.getText());
		counsellorDTO.setGender(seletedRedioButton);
		counsellorDTO.setQualification(qf.getText());
		counsellorDTO.setPhonenumber(pn.getText());
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