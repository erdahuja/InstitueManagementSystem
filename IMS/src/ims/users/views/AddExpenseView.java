package com.bmpl.ims.users.views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.bmpl.ims.common.utils.CommonUtility;
import com.bmpl.ims.users.dao.AddExpenseDAO;
import com.bmpl.ims.users.dto.AddExpenseDTO;

public class AddExpenseView extends JFrame {

	private JPanel contentPane;
	private JTextField textCapitalLeaseCost;
	private JTextField textAdvertisingCost;
	private JTextField textBroadbandCost;
	private JTextField textStaffSalaryCost;
	private JTextField textMaintainanceCost;
	private JTextField textMiscellaneous;
	private JTextField textTotal;

	public static void main(String[] args) {
	
					AddExpenseView frame = new AddExpenseView();
					frame.setVisible(true);
			
	}

	/**
	 * Create the frame.
	 */
	public AddExpenseView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddExpense = new JLabel("ADD EXPENSE");
		lblAddExpense.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblAddExpense.setBounds(157, 11, 119, 24);
		contentPane.add(lblAddExpense);
		
		JLabel lblCapitalLeaseCost = new JLabel("CAPITAL LEASE COST");
		lblCapitalLeaseCost.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblCapitalLeaseCost.setBounds(28, 56, 152, 24);
		contentPane.add(lblCapitalLeaseCost);
		
		textCapitalLeaseCost = new JTextField();
		textCapitalLeaseCost.setBounds(200, 58, 119, 20);
		contentPane.add(textCapitalLeaseCost);
		textCapitalLeaseCost.setColumns(10);
		
		JLabel lblAdvertisementCost = new JLabel("ADVERTISING COST");
		lblAdvertisementCost.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAdvertisementCost.setBounds(28, 98, 152, 24);
		contentPane.add(lblAdvertisementCost);
		
		textAdvertisingCost = new JTextField();
		textAdvertisingCost.setBounds(200, 101, 119, 20);
		contentPane.add(textAdvertisingCost);
		textAdvertisingCost.setColumns(10);
		
		JLabel lblBroadbandCost = new JLabel("BROADBAND COST");
		lblBroadbandCost.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblBroadbandCost.setBounds(28, 141, 152, 24);
		contentPane.add(lblBroadbandCost);
		
		JLabel lblStaffSalary = new JLabel("STAFF SALARY COST");
		lblStaffSalary.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblStaffSalary.setBounds(28, 183, 152, 24);
		contentPane.add(lblStaffSalary);
		
		JLabel lblMaintainanceCost = new JLabel("MAINTAINANCE COST");
		lblMaintainanceCost.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblMaintainanceCost.setBounds(28, 230, 152, 24);
		contentPane.add(lblMaintainanceCost);
		
		JLabel lblMiscellaneous = new JLabel("MISCELLANEOUS");
		lblMiscellaneous.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblMiscellaneous.setBounds(28, 276, 152, 24);
		contentPane.add(lblMiscellaneous);
		
		textBroadbandCost = new JTextField();
		textBroadbandCost.setBounds(200, 143, 119, 20);
		contentPane.add(textBroadbandCost);
		textBroadbandCost.setColumns(10);
		
		textStaffSalaryCost = new JTextField();
		textStaffSalaryCost.setBounds(200, 185, 119, 20);
		contentPane.add(textStaffSalaryCost);
		textStaffSalaryCost.setColumns(10);
		
		textMaintainanceCost = new JTextField();
		textMaintainanceCost.setBounds(200, 232, 119, 20);
		contentPane.add(textMaintainanceCost);
		textMaintainanceCost.setColumns(10);
		
		textMiscellaneous = new JTextField();
		textMiscellaneous.setBounds(200, 278, 119, 20);
		contentPane.add(textMiscellaneous);
		textMiscellaneous.setColumns(10);
		
		textTotal = new JTextField();
		textTotal.setBounds(200, 338, 119, 20);
		contentPane.add(textTotal);
		textTotal.setColumns(10);
		
		JButton btnTotalExpense = new JButton("TOTAL");
		btnTotalExpense.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int capt_lease,advert,broadbnd,staff_sal,maintain,miscellaneous;
				int sum;
				if(textCapitalLeaseCost.getText().trim().equals("")){
					textCapitalLeaseCost.setText("0");
				
					
				}
				if(textAdvertisingCost.getText().trim().equals("")){
					textAdvertisingCost.setText("0");
					
				}
				if(textBroadbandCost.getText().trim().equals("")){
					textBroadbandCost.setText("0");
					
				}
				if(textStaffSalaryCost.getText().trim().equals("")){
					textStaffSalaryCost.setText("0");
					
				}
				if(textMaintainanceCost.getText().trim().equals("")){
					textMaintainanceCost.setText("0");
					
				}
				if(textMiscellaneous.getText().trim().equals("")){
					textMiscellaneous.setText("0");
					
				}
				
					    capt_lease=Integer.parseInt(textCapitalLeaseCost.getText());
			
				
						advert=Integer.parseInt(textAdvertisingCost.getText());
			
						broadbnd=Integer.parseInt(textBroadbandCost.getText());
				
						staff_sal=Integer.parseInt(textStaffSalaryCost.getText());
				 
						maintain=Integer.parseInt(textMaintainanceCost.getText());
			
						miscellaneous=Integer.parseInt(textMiscellaneous.getText());
				 sum=capt_lease+advert+broadbnd+staff_sal+ maintain+miscellaneous;
				 
			//String balance=	 CommonUtility.getBalance(String.valueOf(sum));
			//System.out.println(balance);
			textTotal.setText(String.valueOf(sum));
				
			}
		});
		btnTotalExpense.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnTotalExpense.setBounds(99, 337, 79, 23);
		contentPane.add(btnTotalExpense);
		
		JButton btnAddExpense = new JButton("ADD");
		btnAddExpense.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addExpense();
				Date d=new Date();
				System.out.println(d);
				
			}
		});
		btnAddExpense.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAddExpense.setBounds(176, 385, 79, 24);
		contentPane.add(btnAddExpense);
	}
	private void addExpense(){
		AddExpenseDAO addexpenseDAO=new AddExpenseDAO();
		AddExpenseDTO addExpenseDTO=new AddExpenseDTO();
		addExpenseDTO.setCapital_lease_cost(Integer.parseInt(textCapitalLeaseCost.getText()));
		addExpenseDTO.setAdvertising_cost(Integer.parseInt(textAdvertisingCost.getText()));
		addExpenseDTO.setBroadband_cost(Integer.parseInt(textBroadbandCost.getText()));
		addExpenseDTO.setStaff_salary_cost(Integer.parseInt(textStaffSalaryCost.getText()));
		addExpenseDTO.setMaintainance_cost(Integer.parseInt(textMaintainanceCost.getText()));
		addExpenseDTO.setMiscellaneous(Integer.parseInt(textMiscellaneous.getText()));
		try {
			if(addexpenseDAO.addExpense(addExpenseDTO)){
			System.out.println(addExpenseDTO);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub

	}
		}


