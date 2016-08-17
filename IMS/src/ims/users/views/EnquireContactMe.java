package com.bmpl.ims.users.views;

public class EnquireContactMe extends JFrame {

	private JPanel contentPane;
	private JTextField txtContactDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnquireContactMe frame = new EnquireContactMe();
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
	public EnquireContactMe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(98, 76, 241, 35);
		lblNewLabel.setText("When would you like us to call you?");
		getContentPane().add(lblNewLabel);
		
		txtContactDate = new JTextField();
		txtContactDate.setBounds(144, 120, 97, 20);
		getContentPane().add(txtContactDate);
		txtContactDate.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(144, 161, 97, 23);
		getContentPane().add(btnSubmit);
		setSize(400,253);
		
		btnSubmit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				EnquireContactMe.this.setVisible(false);
				EnquireContactMe.this.dispose();
			}
			
		});
	}
}
