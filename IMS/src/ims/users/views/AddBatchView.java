package com.bmpl.ims.users.views;

import com.bmpl.ims.users.dao.BatchDAO;
import com.bmpl.ims.users.dto.BatchDTO;
//import com.toedter.calendar.JDateChooser;
import com.bmpl.ims.users.dto.CourseDTO;

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
	private String selecteditem1;
	private java.sql.Date sqlDate;
	private JTextField starttime;
	private JTextField endtime;
	private JComboBox comboBox1;
	 JFrame frame = new JFrame();
	
	public static void main(String[] args) {
	
					  new AddBatchView();
					
		
	}

		public AddBatchView() {
		
		setTitle("AddBatch");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 479, 605);
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
				selecteditem1=(String)comboBox.getSelectedItem();
			}
		});
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
			list = BatchDAO.getCourse();
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
		lblDescription.setBounds(43, 366, 125, 27);
		getContentPane().add(lblDescription);
		
		des_area = new JTextArea();
		des_area.setBounds(226, 369, 117, 122);
		getContentPane().add(des_area);
		des_area.setLineWrap(true);
		
		JButton btnAddBatch = new JButton("Add Batch");
		btnAddBatch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addbatch();
			}
		});
		btnAddBatch.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAddBatch.setBounds(61, 532, 127, 23);
		getContentPane().add(btnAddBatch);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reset();
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnReset.setBounds(230, 532, 127, 23);
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
		
		JLabel lblStartTime = new JLabel("Start Time");
		lblStartTime.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStartTime.setBounds(61, 265, 107, 20);
		getContentPane().add(lblStartTime);
		
		JLabel lblEndTime = new JLabel("End Time");
		lblEndTime.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEndTime.setBounds(61, 313, 107, 20);
		getContentPane().add(lblEndTime);
		
		starttime = new JTextField();
		starttime.setColumns(10);
		starttime.setBounds(226, 267, 117, 20);
		getContentPane().add(starttime);
		
		endtime = new JTextField();
		endtime.setColumns(10);
		endtime.setBounds(226, 315, 117, 20);
		getContentPane().add(endtime);
		
		frame.setVisible(true);
	}
	
	public void addbatch()
	{
		ArrayList<BatchDTO> arraybatch=new ArrayList<>();
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
		batchdto.setStarttime(starttime.getText());
		batchdto.setEndtime(endtime.getText());
		arraybatch.add(batchdto);
		try {
			boolean isaddbatch = batchdao.addbatch(arraybatch);
			if(isaddbatch)
			{
				JOptionPane.showMessageDialog(this, "Batch Added........");
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
		starttime.setText("");
		endtime.setText("");
		
		}
	}
