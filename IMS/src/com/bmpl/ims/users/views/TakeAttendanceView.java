package com.bmpl.ims.users.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.border.EmptyBorder;

import javax.swing.JScrollPane;

public class TakeAttendanceView extends JFrame {

	private JPanel contentPane;
	ArrayList<String> comboItems = new ArrayList<String>();
	DefaultListModel listModel1 = new DefaultListModel();
	DefaultListModel listModel2 = new DefaultListModel();

	ArrayList<String> list;

	public static void main(String[] args) {

		TakeAttendanceView frame = new TakeAttendanceView();
		frame.setVisible(true);
		Date date = new Date();
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
		// contentPane.add(list_1);

		JLabel lblChoose = new JLabel("Choose Batch :");
		lblChoose.setBounds(220, 35, 131, 15);
		contentPane.add(lblChoose);

		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("combo");
				list = new ArrayList<>();
				String batchName = (String) comboBox.getSelectedItem();
				listModel1.clear();
				listModel2.clear();
				// try {
				// list= CommonMethods.getStudents();
				list.add("n1");
				list.add("n2");
				list.add("n3");
				list.add("n4");
				list.add("n6");
				list.add("n7");
				list.add("n8");
				list.add("n9");
				list.add("n10");
				list.add("n20");
				list.add("n30");
				list.add("n11");
				list.add("n22");
				list.add("n33");
				list.add("n14");
				list.add("n25");
				list.add("n36");
				list.add("n17");
				list.add("n28");
				list.add("n39");
				System.out.println(list.size());
				int i = 1;
				if (!list.isEmpty()) {
					for (String name : list) {
						System.out.println(name + "\n");
						if (i < 10)
							listModel1.addElement(i++ + " :     " + name);
						else
							listModel1.addElement(i++ + " :   " + name);
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

		// try {
		// comboItems = CommonMethods.getBatches();
		comboItems.add("1");
		comboItems.add("2");

		if (!comboItems.isEmpty()) {
			for (String name : comboItems) {
				comboBox.addItem(name);

			}

		}

		/*
		 * } catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

		contentPane.add(comboBox);

		JList<String> list_2 = new JList<String>(listModel2);
		list_2.setBounds(525, 62, 160, 271);

		// contentPane.add(list_2);

		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				listModel2.clear();
			
				
				List<String> listCopy = list_1.getSelectedValuesList();
				for (String name : listCopy)
				
						listModel2.addElement(name);
					
					
			}
		});
		btnSelect.setBounds(281, 97, 117, 25);

		contentPane.add(btnSelect);

		JButton btnRefres = new JButton("Cancel");
		btnRefres.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				listModel2.clear();
				list_1.clearSelection();

			}
		});
		btnRefres.setBounds(281, 152, 117, 25);
		contentPane.add(btnRefres);

		JButton btnMarkPre = new JButton("Mark Present");
		btnMarkPre.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (!list_1.isSelectionEmpty()) {
					String batch_name = (String) comboBox.getSelectedItem();
					// chose students in db n mark attendance

				} else {
					JOptionPane.showMessageDialog(null, "No Student Selected ");
				}

			}
		});
		btnMarkPre.setBounds(266, 308, 139, 25);
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
}
