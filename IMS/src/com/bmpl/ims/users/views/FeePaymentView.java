package com.bmpl.ims.users.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.bmpl.ims.common.dao.CommonDAO;
import com.bmpl.ims.common.dao.CommonSQLConstants;
import com.bmpl.ims.users.dao.FeePayamentDAO;

import com.bmpl.ims.users.dao.FeePayamentDAO.function;
import com.bmpl.ims.users.dto.FeePaymentDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import java.awt.Choice;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FeePaymentView extends JFrame {

	private JPanel contentPane;
	private JTextField textAdmissionnum;
	private JTextField textStudentName;
	private JTextField textTotalFee;
	private JTextField textDiscount;
	private JTextField textCourseName;
	private JTextField textPayableAmount;
	private JTextField textPaidAmount;
	private JTextField textDueAmount;
	private JTextField textDate;
	private JTextField textChequenum;
	private JTextField textBankName;
	private JComboBox comboBoxChequeNum;
	private JLabel lblChequeNo;
	private JTextField textChequeNum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					FeePaymentView frame = new FeePaymentView();
					frame.setVisible(true);
					frame.setTitle("Fee Payment");
			
		
	}
	public void fillComboBox(){
		String sql=CommonSQLConstants.COMBOX_SQL;
		Connection con=null;
	    PreparedStatement pstmt = null;
	    ResultSet rs=null;
		
			try{
				con=CommonDAO.getConnection();
				pstmt = con.prepareStatement(sql);
				
				rs=pstmt.executeQuery();
				while(rs.next()){
			comboBoxChequeNum.addItem(rs.getString("ModeofPayment"));
				
					
				}
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("can't execute search");
			}
			
		
				
		
		
	}

	public void clock(){
		Calendar cal=new GregorianCalendar();
		int day=cal.get(Calendar.DAY_OF_MONTH);
		int month=cal.get(Calendar.MONTH);
		int year=cal.get(Calendar.YEAR);
		month=month+1;
		textDate.setText(year+"/"+month+"/"+day);
	}
	/**
	 * Create the frame.
	 */
	public FeePaymentView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 577, 654);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdmissionnum = new JLabel("Admission No :");
		lblAdmissionnum.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblAdmissionnum.setBounds(46, 52, 106, 14);
		contentPane.add(lblAdmissionnum);
		
		JLabel lblStudentname = new JLabel("Student's Name :");
		lblStudentname.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblStudentname.setBounds(46, 90, 106, 14);
		contentPane.add(lblStudentname);
		
		JLabel lblCourseName = new JLabel("Course Name :");
		lblCourseName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblCourseName.setBounds(46, 127, 106, 14);
		contentPane.add(lblCourseName);
		
		textAdmissionnum = new JTextField();
		textAdmissionnum.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textAdmissionnum.setBounds(176, 51, 113, 20);
		contentPane.add(textAdmissionnum);
		textAdmissionnum.setColumns(10);
		
		textStudentName = new JTextField();
		textStudentName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textStudentName.setBounds(176, 89, 225, 20);
		contentPane.add(textStudentName);
		textStudentName.setColumns(10);
		
		JLabel lblTotalFee = new JLabel("Total Fee :");
		lblTotalFee.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTotalFee.setBounds(46, 160, 107, 14);
		contentPane.add(lblTotalFee);
		
		JLabel lblDiscount = new JLabel("Discount :");
		lblDiscount.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDiscount.setBounds(45, 195, 107, 14);
		contentPane.add(lblDiscount);
		
		JLabel lblDate = new JLabel("Date :");
		lblDate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDate.setBounds(46, 370, 60, 14);
		contentPane.add(lblDate);
		
		textTotalFee = new JTextField();
		textTotalFee.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textTotalFee.setBounds(176, 158, 154, 20);
		contentPane.add(textTotalFee);
		textTotalFee.setColumns(10);
		
		textDiscount = new JTextField();
		textDiscount.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textDiscount.setBounds(175, 193, 132, 20);
		contentPane.add(textDiscount);
		textDiscount.setColumns(10);
		
		textCourseName = new JTextField();
		textCourseName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textCourseName.setBounds(176, 120, 201, 20);
		contentPane.add(textCourseName);
		textCourseName.setColumns(10);
		
		JLabel lblPaidAmount = new JLabel("Paid Amount :");
		lblPaidAmount.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPaidAmount.setBounds(46, 278, 106, 14);
		contentPane.add(lblPaidAmount);
		
		textPayableAmount = new JTextField();
		textPayableAmount.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textPayableAmount.setBounds(176, 232, 154, 20);
		contentPane.add(textPayableAmount);
		textPayableAmount.setColumns(10);
		
		textPaidAmount = new JTextField();
		/*textPaidAmount.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				int payable=Integer.parseInt(textPaidAmount.getText());
				int paid=Integer.parseInt(textPaidAmount.getText());
				if(paid>payable){
					JOptionPane.showMessageDialog(null,"You Cannot Pay More Than Payable Amount");
			}
			}
		});*/
		
		textPaidAmount.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textPaidAmount.setBounds(176, 276, 154, 20);
		contentPane.add(textPaidAmount);
		textPaidAmount.setColumns(10);
		
		textDueAmount = new JTextField();
		textDueAmount.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textDueAmount.setBounds(176, 319, 154, 20);
		contentPane.add(textDueAmount);
		textDueAmount.setColumns(10);
		
		textDate = new JTextField();
		textDate.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textDate.setBounds(176, 364, 131, 20);
		contentPane.add(textDate);
		textDate.setColumns(10);
		
		JLabel lblModeofPayment = new JLabel("Mode of Payment :");
		lblModeofPayment.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblModeofPayment.setBounds(46, 410, 116, 14);
		contentPane.add(lblModeofPayment);
		
		
		
		JLabel lblBankName = new JLabel("Bank's Name :");
		lblBankName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblBankName.setBounds(46, 494, 106, 14);
		contentPane.add(lblBankName);
		
		textBankName = new JTextField();
		textBankName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textBankName.setBounds(176, 491, 225, 20);
		contentPane.add(textBankName);
		textBankName.setColumns(10);
		
		JButton btnMakePayment = new JButton("Make Payment");
		btnMakePayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				feePayment();
			}
		});
		btnMakePayment.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnMakePayment.setBounds(187, 541, 143, 23);
		contentPane.add(btnMakePayment);
		
		
		JLabel lblChequeNum = new JLabel("Cheque No. :");
		lblChequeNum.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblChequeNum.setBounds(46, 451, 116, 14);
		contentPane.add(lblChequeNum);
		
		textChequeNum = new JTextField();
		textChequeNum.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textChequeNum.setBounds(176, 449, 154, 20);
		contentPane.add(textChequeNum);
		textChequeNum.setColumns(10);
		
		JButton btnSearchStudent = new JButton("Search Student");
		btnSearchStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				search();
				
				
			}
		});
		btnSearchStudent.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnSearchStudent.setBounds(351, 49, 154, 23);
		contentPane.add(btnSearchStudent);
		
		JButton btnPayableAmount = new JButton("Payable Amount ");
		btnPayableAmount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int total=Integer.parseInt(textTotalFee.getText());
				int discount=Integer.parseInt(textDiscount.getText());
				int res=total-discount;
				if(res<3000){
					JOptionPane.showMessageDialog(null, "Payable Amount Cannot Be Less Than "
							+ "3000.Check the Discount Offered to this Student ");
					textPayableAmount.setVisible(false);
				}
				else{
					textPayableAmount.setVisible(true);
				textPayableAmount.setText(String.valueOf(res));
				}
			}
		});
		btnPayableAmount.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnPayableAmount.setBounds(21, 231, 131, 23);
		contentPane.add(btnPayableAmount);
		
		JButton btnDueAmount = new JButton("Due Amount");
		btnDueAmount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int payable=Integer.parseInt(textPayableAmount.getText());
				int paid=Integer.parseInt(textPaidAmount.getText());
				int res2=payable-paid;
				if(res2<0){
					JOptionPane.showMessageDialog(null, "Paid Amount Cannot Be More Than Payable Amount");
					textDueAmount.setVisible(false);
				}
				else{
					textDueAmount.setVisible(true);
				textDueAmount.setText(String.valueOf(res2));
			}
			}
		});
		btnDueAmount.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnDueAmount.setBounds(21, 318, 113, 23);
		contentPane.add(btnDueAmount);
		
		comboBoxChequeNum = new JComboBox();
		
		comboBoxChequeNum.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent actionEvent) {
		    	  
		    	  if(comboBoxChequeNum.getSelectedItem().equals("Cash")){
		    		
		    		  lblChequeNum.setVisible(false);
		    		  
					
						textChequeNum.setVisible(false);
					
						
					}
		    	  else{
		    		  lblChequeNum.setVisible(true);
		    		  
		    			textChequeNum.setVisible(true);
		    	  }
		      }
		    });
	
		comboBoxChequeNum.setFont(new Font("Times New Roman", Font.BOLD, 13));
		comboBoxChequeNum.setBounds(176, 408, 154, 20);
		contentPane.add(comboBoxChequeNum);
		
		/*JLabel lblChequeNum = new JLabel("Cheque No. :");
		lblChequeNum.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblChequeNum.setBounds(46, 451, 116, 14);
		contentPane.add(lblChequeNum);
		
		textChequeNum = new JTextField();
		textChequeNum.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textChequeNum.setBounds(176, 449, 154, 20);
		contentPane.add(textChequeNum);
		textChequeNum.setColumns(10);*/
		clock();
		fillComboBox();
		
	}
	private void search()
	{
		FeePayamentDAO feePaymentDAO=new FeePayamentDAO();
		//FeePaymentDTO feePaymentDTO=new FeePaymentDTO();
		function f=feePaymentDAO.new function();
		ResultSet rs=null;
		String sname="StudentName";
		String cname="CourseName";
		String totalfee="TotalFee";
		String discount="Discount";
		rs=f.find(textAdmissionnum.getText());
		try{
			if(rs.next()){
				textStudentName.setText(rs.getString("StudentName"));
				textCourseName.setText(rs.getString("CourseName"));
				textTotalFee.setText(rs.getString("TotalFee"));
				textDiscount.setText(rs.getString("Discount"));
			}
			else{
				System.out.println("No Data For This Admission Number ");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	private void feePayment(){
		
		
		FeePayamentDAO feePaymentDAO=new FeePayamentDAO();
		FeePaymentDTO feePaymentDTO=new FeePaymentDTO();
		feePaymentDTO.setAdmissionNum(Integer.parseInt(textAdmissionnum.getText()));
		feePaymentDTO.setStudentName(textStudentName.getText());
		feePaymentDTO.setCourseName(textCourseName.getText());
		feePaymentDTO.setTotalFee(Integer.parseInt(textTotalFee.getText()));
		feePaymentDTO.setDiscount(Integer.parseInt(textDiscount.getText()));
		feePaymentDTO.setPayableAmount(Integer.parseInt(textPayableAmount.getText()));
		feePaymentDTO.setPaidAmount(Integer.parseInt(textPaidAmount.getText()));
		feePaymentDTO.setDueAmount(Integer.parseInt(textDueAmount.getText()));
		feePaymentDTO.setDate(textDate.getText());
		String value=comboBoxChequeNum.getSelectedItem().toString();
		feePaymentDTO.setModeofPayment(value);
		if(textChequeNum.getText()=="null"){
			feePaymentDTO.setChequeNum(textChequeNum.getText());
		}
		else{
		feePaymentDTO.setChequeNum((textChequeNum.getText()));
		}
		feePaymentDTO.setBankName(textBankName.getText());
		try{
			if(feePaymentDAO.feePayment(feePaymentDTO)){
				System.out.println(feePaymentDTO);
			}
		}catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		}
		
	
}
