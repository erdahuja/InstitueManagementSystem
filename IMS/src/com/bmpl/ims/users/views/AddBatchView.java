package com.bmpl.ims.users.views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.bmpl.ims.users.dao.BatchDAO;
import com.bmpl.ims.users.dto.BatchDTO;
import com.toedter.calendar.JDateChooser;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class AddBatchView extends JFrame {

	private JTextField tnr_name;
	private JTextField Bth_name;
	private JTextField total_set;
	private JTextArea des_area;
	private JComboBox comboBox;
	private UtilDateModel model;
	private JDatePanelImpl datePanel;
	private JDatePickerImpl datePicker;
	private String selecteditem;
	private java.sql.Date sqlDate;
	public static void main(String[] args) {
	
					AddBatchView frame = new AddBatchView();
					frame.setVisible(true);
		
	}

		public AddBatchView() {
		
		//UserDTO userDto = new UserDTO();
		setTitle("AddBatch");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 479, 508);
		getContentPane().setLayout(null);
		
		JLabel lblBatchname = new JLabel("CourseName");
		lblBatchname.setLabelFor(this);
		lblBatchname.setHorizontalAlignment(SwingConstants.CENTER);
		lblBatchname.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBatchname.setBounds(41, 103, 127, 27);
		getContentPane().add(lblBatchname);
		
		JLabel label = new JLabel("BatchName");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setBounds(52, 60, 101, 27);
		getContentPane().add(label);
		
		JLabel lblTrainername = new JLabel("TotalSets");
		lblTrainername.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrainername.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTrainername.setBounds(41, 184, 109, 27);
		getContentPane().add(lblTrainername);
		
		tnr_name = new JTextField();
		tnr_name.setBounds(226, 151, 117, 20);
		getContentPane().add(tnr_name);
		tnr_name.setColumns(10);
		
		Bth_name = new JTextField();
		Bth_name.setColumns(10);
		Bth_name.setBounds(226, 65, 117, 20);
		getContentPane().add(Bth_name);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selecteditem=(String)comboBox.getSelectedItem();
			}
		});
		comboBox.setBounds(226, 108, 117, 20);
		getContentPane().add(comboBox);
		BatchDAO BatchDao = new BatchDAO();
		ArrayList<String> list=null;
		try {
			list = BatchDao.getCourse();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		for(String order: list)
		{
		comboBox.addItem(order);
		}
		
		JLabel label_1 = new JLabel("TrainerName");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_1.setBounds(51, 146, 117, 27);
		getContentPane().add(label_1);
		
		total_set = new JTextField();
		total_set.setColumns(10);
		total_set.setBounds(226, 189, 35, 20);
		getContentPane().add(total_set);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDescription.setBounds(41, 267, 125, 27);
		getContentPane().add(lblDescription);
		
		des_area = new JTextArea();
		des_area.setBounds(226, 270, 117, 122);
		getContentPane().add(des_area);
		des_area.setLineWrap(true);
		
		JButton btnAddBatch = new JButton("Add Batch");
		btnAddBatch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addbatch();
			}
		});
		btnAddBatch.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAddBatch.setBounds(73, 435, 127, 23);
		getContentPane().add(btnAddBatch);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reset();
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnReset.setBounds(229, 435, 127, 23);
		getContentPane().add(btnReset);
		
		JLabel lblBatchtime = new JLabel("Date");
		lblBatchtime.setHorizontalAlignment(SwingConstants.CENTER);
		lblBatchtime.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBatchtime.setBounds(41, 222, 77, 27);
		getContentPane().add(lblBatchtime);
		
		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
		datePicker = new JDatePickerImpl(datePanel);
		datePicker.setBounds(226, 220, 117, 20);
		getContentPane().add(datePicker);
	}
	
	public void addbatch()
	{
		BatchDTO batchdto =new BatchDTO();
		BatchDAO batchdao=new BatchDAO();
		batchdto.setBatchname(Bth_name.getText());
		batchdto.setCoursename(selecteditem);
		batchdto.setTrainername(tnr_name.getText());
		int total=Integer.parseInt(total_set.getText());
		batchdto.setTotalsets(total);
		batchdto.setDescription(des_area.getText());
		Date selectedDate = (Date) datePicker.getModel().getValue();
		sqlDate=new java.sql.Date(selectedDate.getTime());
		batchdto.setBatchstartdate(sqlDate);
		try {
			boolean isaddbatch = batchdao.addbatch(batchdto);
			if(isaddbatch)
			{
				JOptionPane.showMessageDialog(this, "Batch Created........");
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Invalid Userid or Password");
			}
		}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	  	}	
	public void Reset()
		{
		Bth_name.setText("");
		tnr_name.setText("");
		total_set.setText("");
		des_area.setText("");
		
		}
	
	}
