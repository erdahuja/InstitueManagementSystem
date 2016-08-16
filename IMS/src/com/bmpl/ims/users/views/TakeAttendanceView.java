package com.bmpl.ims.users.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.bmpl.ims.common.utils.CommonMethods;
import com.bmpl.ims.users.dao.TakeAttendanceDAO;
import com.bmpl.ims.users.dto.TakeAttendanceDTO;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class TakeAttendanceView extends JFrame {

	private JPanel contentPane;
	ArrayList<String> comboItems = new ArrayList<String>();
	DefaultListModel listModel1 = new DefaultListModel();
	DefaultListModel listModel2 = new DefaultListModel();

	ArrayList<String> list;
	private static Date date=null;
	private JTextField takedate;
	private List<String> listCopy;
	private String batchName=null;
	private java.sql.Date sqlDate;
	public static void main(String[] args) {

		TakeAttendanceView frame = new TakeAttendanceView();
		frame.setVisible(true);
		date = new Date();
		frame.setTitle("Mark Attendance " + date.toString());

	}

	public TakeAttendanceView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 717, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lblStudents = new JLabel("Total Students");
		lblStudents.setBounds(29, 35, 139, 15);
		contentPane.add(lblStudents);

		JList<String> list_1 = new JList<String>(listModel1);
		list_1.setValueIsAdjusting(true);
		list_1.setBounds(29, 62, 160, 271);

		JLabel lblChoose = new JLabel("Choose Batch :");
		lblChoose.setBounds(220, 35, 131, 15);
		contentPane.add(lblChoose);

		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				list = new ArrayList<>();
				try {
					batchName = (String) comboBox.getSelectedItem();
				
					list=CommonMethods.getStudents(batchName);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				listModel1.clear();
				listModel2.clear();
				System.out.println(list.size());
				int i = 1;
				if (!list.isEmpty()) {
					for (String name : list) {
						System.out.println(name + "\n");
						if (i < 10)
							listModel1.addElement(name);
						else
							listModel1.addElement(name);
					}

				}

				/*
				 * } catch (SQLException e) { // TODO Auto-generated catch block
				 * e.printStackTrace(); }
				 */

				// comboBox.repaint();

			}

		});

		comboBox.setBounds(369, 30, 131, 24);
		ArrayList<String> list=null;
		try {
			list=CommonMethods.getBatches();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		for(String batchlist: list)
		{
			comboItems.add(batchlist);
		}

		if (!comboItems.isEmpty()) {
			for (String name : comboItems) {
				comboBox.addItem(name);
			}

		}
		contentPane.add(comboBox);

		JList<String> list_2 = new JList<>(listModel2);
		list_2.setBounds(525, 62, 160, 271);

		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				listModel2.clear();
				listCopy = list_1.getSelectedValuesList();
				for (String name : listCopy)		
					listModel2.addElement(name);
			}
		});
		btnSelect.setBounds(281, 97, 117, 25);

		contentPane.add(btnSelect);

		JButton btnRefres = new JButton("Cancel");
		btnRefres.setBackground(Color.WHITE);
		btnRefres.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				listModel2.clear();
				list_1.clearSelection();

			}
		});
		btnRefres.setBounds(281, 151, 122, 30);
		contentPane.add(btnRefres);

		JButton btnMarkPre = new JButton("Mark Present");
		btnMarkPre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				takeattendance();
			}
		});
		
		btnMarkPre.setBounds(281, 304, 117, 25);
		contentPane.add(btnMarkPre);

		JLabel lblSelectedStudents = new JLabel("Selected Students");
		lblSelectedStudents.setBounds(545, 35, 160, 15);
		contentPane.add(lblSelectedStudents);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 62, 160, 271);
		scrollPane.setViewportView(list_1);
		contentPane.add(scrollPane);
		
		JLabel lblSNo = new JLabel("S No.    Name");
		scrollPane.setColumnHeaderView(lblSNo);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(525, 62, 160, 271);
		scrollPane_1.setViewportView(list_2);
		contentPane.add(scrollPane_1);
		
		JLabel lblSNoNam = new JLabel("S No.  Name");
		scrollPane_1.setColumnHeaderView(lblSNoNam);

	}
	
	public void takeattendance()
	{
		TakeAttendanceDTO takeattendancedto=new TakeAttendanceDTO();
		TakeAttendanceDAO takeattendancedao=new TakeAttendanceDAO();
		takeattendancedto.setBatchname(batchName);
		takeattendancedto.setStudent(listCopy);
		Date selectedDate = date;
		sqlDate=new java.sql.Date(selectedDate.getTime());
		takeattendancedto.setDate(sqlDate);
		try{
		boolean isFound=takeattendancedao.addattendancetake(takeattendancedto);
		if(isFound)
		{
			JOptionPane.showMessageDialog(this, "Attdndance done.........");
		}
		else
		{
			JOptionPane.showMessageDialog(this, "Attendance Not Update......");
		}
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
