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
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.codec.Base64.OutputStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

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
import java.util.Date;
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
				generate();
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
					
						lblBankName.setVisible(false);
						textBankName.setVisible(false);
						
					}
		    	  else{
		    		  lblChequeNum.setVisible(true);
		    		  lblBankName.setVisible(true);
		    			textChequeNum.setVisible(true);
		    			textBankName.setVisible(true);	
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
				textDueAmount.setText(rs.getString("DueAmount"));
				
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
	private void generate()
	{
		FeePaymentDTO feePaymentDTO=new FeePaymentDTO();
		Document document = new Document(PageSize.A4);
		 try
	      {
			 String s2=textStudentName.getText();
	         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(s2+".pdf"));
	         document.open();
	         Paragraph paragraph = new Paragraph();
	         paragraph.setSpacingAfter(10);
           //  paragraph.setSpacingBefore(0);
             paragraph.setAlignment(Element.ALIGN_CENTER);
            // paragraph1.setIndentationLeft(50);
           //  paragraph1.setIndentationRight(50);
	         
	   
	         Paragraph paragraph2 = new Paragraph();
	         paragraph2.setSpacingAfter(2);
             paragraph2.setSpacingBefore(12);
             paragraph2.setAlignment(Element.ALIGN_LEFT);
             paragraph2.setIndentationLeft(50);
             paragraph2.setIndentationRight(50);
             
             Chunk chunk0=new Chunk(
        	         "INSTITUTE MANAGEMENT SYSTEM");
         
             
             Paragraph paragraph3 = new Paragraph();
	         paragraph3.setSpacingAfter(2);
             paragraph3.setSpacingBefore(2);
             paragraph3.setAlignment(Element.ALIGN_LEFT);
             paragraph3.setIndentationLeft(50);
             paragraph3.setIndentationRight(50);
             
             
             Paragraph paragraph4 = new Paragraph();
	         paragraph4.setSpacingAfter(2);
             paragraph4.setSpacingBefore(4);
             paragraph4.setAlignment(Element.ALIGN_LEFT);
             paragraph4.setIndentationLeft(50);
             paragraph4.setIndentationRight(50);	
             
             Paragraph paragraph5 = new Paragraph();
	         paragraph5.setSpacingAfter(2);
             paragraph5.setSpacingBefore(2);
             paragraph5.setAlignment(Element.ALIGN_LEFT);
             paragraph5.setIndentationLeft(50);
             paragraph5.setIndentationRight(50);
             
             Paragraph paragraph6 = new Paragraph();
	         paragraph6.setSpacingAfter(0);
             paragraph6.setSpacingBefore(0);
             paragraph6.setAlignment(Element.ALIGN_LEFT);
             paragraph6.setIndentationLeft(50);
             paragraph6.setIndentationRight(50);
             
             Paragraph paragraph7 = new Paragraph();
	         paragraph7.setSpacingAfter(0);
             paragraph7.setSpacingBefore(0);
             paragraph7.setAlignment(Element.ALIGN_LEFT);
             paragraph7.setIndentationLeft(50);
             paragraph7.setIndentationRight(50);
             
             Paragraph paragraph8 = new Paragraph();
	         paragraph8.setSpacingAfter(0);
             paragraph8.setSpacingBefore(0);
             paragraph8.setAlignment(Element.ALIGN_LEFT);
             paragraph8.setIndentationLeft(50);
             paragraph8.setIndentationRight(50);
             
             Paragraph paragraph9 = new Paragraph();
	         paragraph9.setSpacingAfter(0);
             paragraph9.setSpacingBefore(0);
             paragraph9.setAlignment(Element.ALIGN_LEFT);
             paragraph9.setIndentationLeft(50);
             paragraph9.setIndentationRight(50);
             
             
             Paragraph paragraph10 = new Paragraph();
	         paragraph10.setSpacingAfter(0);
             paragraph10.setSpacingBefore(0);
             paragraph10.setAlignment(Element.ALIGN_LEFT);
             paragraph10.setIndentationLeft(50);
             paragraph10.setIndentationRight(50);
        
             
             String s1=textAdmissionnum.getText();
            
             String s3=textCourseName.getText();
             String s4=textTotalFee.getText();
             String s5=textDiscount.getText();
             String s6=textPayableAmount.getText();
             String s7=textPaidAmount.getText();
             String s8=textDueAmount.getText();
             String s9=textDate.getText();
             String s10;
             
            
         
             Chunk chunk1 = new Chunk(
                 "STUDENT ID:"+"    "+s1);
             Chunk chunk2 = new Chunk(
                     "STUDENT NAME: "+"    "+s2+"                                        ");
             Chunk chunk3 = new Chunk(
                     "COURSE NAME:"+"    "+s3+" ");
             Chunk chunk4 = new Chunk(
                     "TOTAL FEES:"+"    "+s4);
             Chunk chunk5 = new Chunk(
                     " DISCOUNT:"+"    "+s5);
             Chunk chunk6 = new Chunk(
                     "PAYABLE AMOUNT :"+"    "+s6);
             Chunk chunk7 = new Chunk(
                     " PAID AMOUNT :"+"    "+s7);
             Chunk chunk8 = new Chunk(
                     " DUE AMOUNT :"+"    "+s8);
             Chunk chunk9 = new Chunk(
                     " DATE :"+"    "+s9);
             
             paragraph.add(chunk0);
             paragraph2.add(chunk2);
             paragraph2.add(chunk1);
             paragraph3.add(chunk3);
             paragraph4.add(chunk4);
             paragraph5.add(chunk5);
             paragraph6.add(chunk6);
             paragraph7.add(chunk7);
             paragraph8.add(chunk8);
             paragraph9.add(chunk9);
             
             document.add(paragraph);
             document.add(paragraph2);
             document.add(paragraph3);
             document.add(paragraph4);
             document.add(paragraph5);
             document.add(paragraph6);
             document.add(paragraph7);
             document.add(paragraph8);
             document.add(paragraph9);
             if(comboBoxChequeNum.getSelectedItem().equals("Cash")){
            	 s10="CASH";
            	 Chunk chunk10=new Chunk("MODE OF PAYMENT:"+s10);
            	 paragraph10.add(chunk10);
            	 document.add(paragraph10);
            	 }
             else{
            	 s10="CHEQUE";
            	 Chunk chunk10=new Chunk("MODE OF PAYMENT:"+s10);
            	 paragraph10.add(chunk10);
            	 document.add(paragraph10);
                 Paragraph paragraph11 = new Paragraph();
    	         paragraph11.setSpacingAfter(0);
                 paragraph11.setSpacingBefore(0);
                 paragraph11.setAlignment(Element.ALIGN_LEFT);
                 paragraph11.setIndentationLeft(50);
                 paragraph11.setIndentationRight(50);
                 
                 Paragraph paragraph12 = new Paragraph();
    	         paragraph12.setSpacingAfter(0);
                 paragraph12.setSpacingBefore(0);
                 paragraph12.setAlignment(Element.ALIGN_LEFT);
                 paragraph12.setIndentationLeft(50);
                 paragraph12.setIndentationRight(50);
            	 
                 String s11=textChequeNum.getText();
            	 Chunk chunk11=new Chunk("CHEQUE NUMBER:"+s11);
            	 paragraph11.add(chunk11);
            	 document.add(paragraph11);
            	 
            	 String s12=textBankName.getText();
               	 Chunk chunk12=new Chunk("BANK'S NAME:"+s12);
               	 paragraph12.add(chunk12);
               	 document.add(paragraph12);
            	  }
             
	         document.close();
	         writer.close();
	      } catch (DocumentException e)
	      {
	         e.printStackTrace();
	      } catch (FileNotFoundException e)
	      {
	         e.printStackTrace();
	      }	 	

	}
	
}
