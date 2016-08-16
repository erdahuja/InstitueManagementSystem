package com.bmpl.ims.users.views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import com.bmpl.ims.common.utils.CommonMethods;
import com.bmpl.ims.users.dao.TakeAttendanceDAO;
import com.bmpl.ims.users.dto.TakeAttendanceDTO;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import java.awt.Color;
import java.awt.SystemColor;

public class VisitAttendanceView extends JFrame {

	private String selectedbatch;
	private String selectedstudnet;
	JLabel lblStudnetname = new JLabel("Student");
	private UtilDateModel model;
	private JDatePanelImpl datePanel;
	private JDatePickerImpl datePicker;
	private UtilDateModel model1;
	private JDatePanelImpl datePanel1;
	private JDatePickerImpl datePicker1;
	private java.sql.Date sqlDate1;
	private java.sql.Date sqlDate2;
	DefaultListModel<String> listModel1 = new DefaultListModel<>();
	
	ArrayList<String> studentlist=null;
	public static void main(String[] args) {

					VisitAttendanceView frame = new VisitAttendanceView();
					frame.setVisible(true);
					
	}
	public VisitAttendanceView() {
		lblStudnetname.setVisible(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 410);
		getContentPane().setLayout(null);
		
		JLabel lblBatchname = new JLabel("BatchName");
		lblBatchname.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBatchname.setBounds(10, 33, 111, 30);
		getContentPane().add(lblBatchname);
		
		JComboBox<String> batchBox = new JComboBox<>();
		batchBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedbatch=(String)batchBox.getSelectedItem();
			}
		});
		batchBox.setBounds(118, 33, 123, 27);
		getContentPane().add(batchBox);
		ArrayList<String> list=null;
		try {
			list = CommonMethods.getBatches();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		for(String order: list)
		{
		batchBox.addItem(order);
		}
		
		
		JLabel lblStartdate = new JLabel("StartDate");
		lblStartdate.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStartdate.setBounds(265, 33, 94, 30);
		getContentPane().add(lblStartdate);
		
		JLabel lblLastname = new JLabel("LastName");
		lblLastname.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLastname.setBounds(10, 90, 111, 30);
		getContentPane().add(lblLastname);
		
		
		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
		datePicker = new JDatePickerImpl(datePanel);
		datePicker.setBounds(118, 94, 123, 27);
		getContentPane().add(datePicker);
		
		model1 = new UtilDateModel();
		datePanel1 = new JDatePanelImpl(model1);
		datePicker1 = new JDatePickerImpl(datePanel1);
		datePicker1.setBounds(386, 36, 123, 27);
		getContentPane().add(datePicker1);
		
		JButton btnNewButton = new JButton("Select Student");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			show(selectedbatch);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(97, 148, 166, 30);
		getContentPane().add(btnNewButton);
		
		lblStudnetname.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStudnetname.setBounds(265, 90, 101, 30);
		getContentPane().add(lblStudnetname);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			viewattendance();
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSubmit.setBounds(301, 148, 166, 30);
		getContentPane().add(btnSubmit);
		
		JList<String> list_1 = new JList<>(listModel1);
		list_1.setBackground(SystemColor.control);
		list_1.setBounds(97, 217, 370, 143);
		getContentPane().add(list_1);
		

	}
	public void show(String studlist)
	{
		lblStudnetname.setVisible(true);
		
		JComboBox<String> studentBox = new JComboBox<>();
		studentBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedstudnet=(String)studentBox.getSelectedItem();
			}
		});
		studentBox.setBounds(386, 90, 101, 27);
		getContentPane().add(studentBox);
		try {
			studentlist=CommonMethods.getStudents(studlist);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
			for (String name : studentlist) {
				studentBox.addItem(name);
			}
		
	}
	public void viewattendance()
	{
		StringBuilder dateString =new StringBuilder();
		TakeAttendanceDTO takeattendancedto=new TakeAttendanceDTO();
		Date selectedDate = (Date) datePicker.getModel().getValue();
		sqlDate1=new java.sql.Date(selectedDate.getTime());
		Date selectedDate2 = (Date) datePicker1.getModel().getValue();
		sqlDate2=new java.sql.Date(selectedDate2.getTime());
		takeattendancedto.setBatchname(selectedbatch);
		takeattendancedto.setSelectedstudent(selectedstudnet);
		takeattendancedto.setStartdate(sqlDate1);
		takeattendancedto.setEnddate(sqlDate2);
		
		ArrayList<TakeAttendanceDTO> list=new ArrayList<>();
	try{
		
		list=TakeAttendanceDAO.viewattendance(takeattendancedto);
		int i=0;
		if(!list.isEmpty())
		{
		for(TakeAttendanceDTO listattendance: list)
		{
			if(i==0)
			{
			dateString.append(listattendance.getDate());
			}
			else
			{
				dateString.append(", "+listattendance.getDate());
			}

			listModel1.clear();
			listModel1.addElement("Studnet:--->    "+listattendance.getSelectedstudent()+""
					+ "    BatchName:---> "+listattendance.getBatchname());
			listModel1.addElement("Present On:---> "+dateString);
			listModel1.addElement("Total Days:---> "+ ++i);
		}
		}
		else
		{
			listModel1.addElement(".......Record not Found......");
		}
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	}
}
